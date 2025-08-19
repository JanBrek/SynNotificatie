package nl.jan.kafka;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.reactive.messaging.kafka.KafkaClientService;
import io.smallrye.reactive.messaging.kafka.KafkaProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

@ApplicationScoped
public class KafkaTryout {

    @Inject
    AdminClient getAdmin;

    @Inject
    KafkaClientService clientService;

    void onStartup(@Observes StartupEvent startupEvent) throws ExecutionException, InterruptedException {
        CreateTopicsResult tr =  getAdmin.createTopics(Collections.singleton(new NewTopic("newTopic", 1, (short) 1)));

        System.out.println("gevonden topics: " + getAdmin.listTopics().names().get());

        System.out.println("prodChannels: " + clientService.getProducerChannels());

        //lientService.`

        KafkaProducer<String, Double> producer = clientService.getProducer("newTopic");
        producer.runOnSendingThread((Function<Producer<String, Double>, Object>) client -> client.send(new ProducerRecord<>("prices", 2.4)))
                .await().indefinitely();
    }
}
