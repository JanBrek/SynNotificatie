package nl.jan.rest.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import nl.jan.generated.KanaalResource;
import nl.jan.generated.beans.*;
import nl.jan.kafka.KafkaHelpers;
import nl.jan.kafka.serialization.MessageSerializer;
import nl.jan.util.FieldUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class KanaalServiceImpl implements KanaalResource {
    private static final Logger log = LoggerFactory.getLogger(KanaalServiceImpl.class);

    @Inject
    KafkaHelpers kh;
    HttpClient client = HttpClient.newHttpClient();

    ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    @Override
    public List<Kanaal> kanaal_list(String naam) {
        return Kanaal.listAll();
    }

    @Transactional
    @Override
    public Kanaal kanaal_create(String contentType, Kanaal data) {
        data.persist();
        kh.createTopic(data.getNaam());
        executor.submit(createNewKanaalConsumer(data.getNaam()));
        return data;
    }

    @Override
    public Kanaal kanaal_read(String uuid) {
        return Kanaal.findById(UUID.fromString(uuid));
    }

    @Transactional
    @Override
    public Kanaal kanaal_update(String contentType, String uuid, Kanaal data) {
        Kanaal foundKanaal = Kanaal.findById(UUID.fromString(uuid));

        // Updaten van kanaal naam als topic naam gaan we niet supporten
        // TODO; Momenteel gedraagd deze zich als patch. Moet een volwaardige overschrijving worden.
        if (foundKanaal != null) {
            FieldUtil.updateFields(data, foundKanaal);
        }

        return foundKanaal;
    }

    @Override
    public Kanaal kanaal_partial_update(String contentType, String uuid, PatchedKanaal data) {
        Kanaal foundKanaal = Kanaal.findById(UUID.fromString(uuid));

        if (foundKanaal != null) {
            FieldUtil.updateFields(data, foundKanaal);
        }

        return foundKanaal;
    }

    private Runnable createNewKanaalConsumer(String kanaal) {
        KafkaConsumer<String, Message> consumer = kh.getTopicConsumer(kanaal);
        return () -> {
            while (true) {
                ConsumerRecords<String, Message> records =
                        consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, Message> record : records) {
                    List<Abonnement> abonnementen = Abonnement.listAll();
                    abonnementen.forEach(abonnement -> {
                        for (FilterGroup fg : abonnement.getKanalen()) {
                            if (fg.getNaam().equals(kanaal)) {
                                // Eigenlijk verdere filtering op basis van fg.getFilters()
                                // Maar dat skippen we even

                                //Dus Nu kunnen we de notificatie doorzetten
                                //rest.send
                                try {
                                    HttpRequest request = HttpRequest.newBuilder()
                                            .uri(abonnement.getUrl()).header("Authorization", abonnement.getAuth())
                                            .POST(HttpRequest.BodyPublishers.ofByteArray((new ObjectMapper()).writeValueAsBytes(record.value())))
                                            .build();
                                    client.send(request, HttpResponse.BodyHandlers.ofString());

                                } catch (IOException | InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    });
                    log.info("Key: {}, Value: {}", record.key(), record.value());
                    log.info("Partition: {}, Offset: {}", record.partition(), record.offset());
                }
            }
        };
    }
}

