package nl.jan.kafka;

import io.smallrye.common.annotation.Identifier;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import nl.jan.generated.beans.Message;
import nl.jan.kafka.serialization.MessageSerializer;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Future;

@ApplicationScoped
public class KafkaHelpers {

    @Inject
    AdminClient adminClient;

    @Inject
    KafkaProducer<String, Message> notificatieProducer;

    public AdminClient getGetAdminClient(){
        return adminClient;
    }

    public CreateTopicsResult createTopic(String kafkaTopic) {
        NewTopic newTopic = new NewTopic(kafkaTopic, 1, (short) 1);
        return adminClient.createTopics(Collections.singleton(newTopic));
    }

    public Future<RecordMetadata> SendNotificatie(Message message) {
        return notificatieProducer.send(new ProducerRecord<>(message.getKanaal(), message));
    }

    @ApplicationScoped
    private static class kafkaAdminCreator{
        @Inject
        @Identifier("default-kafka-broker")
        Map<String, Object> config;

        @Produces
        AdminClient getAdmin() {
            System.out.println("----Ima make an admin!!");
            Map<String, Object> copy = new HashMap<>();
            for (Map.Entry<String, Object> entry : config.entrySet()) {
                if (AdminClientConfig.configNames().contains(entry.getKey())) {
                    copy.put(entry.getKey(), entry.getValue());
                }
            }
            return KafkaAdminClient.create(copy);
        }

        @Produces
        KafkaProducer<String, Message> getNotificatieProducer(){
            Properties properties = new Properties();
            properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG));
            properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MessageSerializer.class.getName());

            return new KafkaProducer<>(properties);
        }
    }
}
