package nl.jan.kafka;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import nl.jan.generated.beans.Kanaal;
import nl.jan.generated.beans.Message;
import nl.jan.rest.impl.KanaalServiceImpl;
import nl.jan.rest.impl.NotificatiesServiceImpl;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
public class KafkaTryout {
    private static final Logger log = LoggerFactory.getLogger(KafkaTryout.class);

    @Inject
    AdminClient admin;

    @Inject
    KanaalServiceImpl kanaalService;

    @Inject
    NotificatiesServiceImpl notificatiesService;

    @Inject KafkaHelpers kh;

    // Klaar maken van wat testdata
    private static String ZAKEN_KANAAL = "zaken";

    void onStartup(@Observes StartupEvent startupEvent) throws URISyntaxException {
        Kanaal k = new Kanaal();
        k.setNaam(ZAKEN_KANAAL);
        k.setFilters(Collections.emptyList());
        k.setDocumentatieLink(new URI("https://www.syntouch.nl"));
        kanaalService.kanaal_create(null, k);
        log.info("Kanaal 'zaken' created!");

        Message m = new Message();
        m.setKanaal(ZAKEN_KANAAL);
        m.setHoofdObject(new URI("https://www.syntouch.nl/OS_EC_Rulezz"));
        m.setResource("zaak");
        m.setResourceUrl(new URI("https://www.syntouch.nl/OS_EC_Rulezz"));
        m.setActie("create");
        m.setAanmaakdatum(new Date());
        // TODO kenmerken
        // m.setKenmerken();
        notificatiesService.notificaties_create(null, m);
        log.info("Notificatie created!");

        log.info("Reading topic to see if we succeeded");
        KafkaConsumer<String, Message> consumer = kh.getTopicConsumer(ZAKEN_KANAAL);
        kh.LogFullMessageTopic(consumer);
    }

    private void createTopic() throws ExecutionException, InterruptedException {
        admin.createTopics(Collections.singleton(new NewTopic("newTopic", 1, (short) 1)));
        log.info("gevonden topics: {}", admin.listTopics().names().get());
    }
}
