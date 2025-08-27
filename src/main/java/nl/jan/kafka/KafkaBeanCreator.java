package nl.jan.kafka;

import io.smallrye.common.annotation.Identifier;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import nl.jan.generated.beans.Message;
import nl.jan.kafka.serialization.MessageDeserializer;
import nl.jan.kafka.serialization.MessageSerializer;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

@ApplicationScoped
public class KafkaBeanCreator {

    private static final Logger log = LoggerFactory.getLogger(KafkaBeanCreator.class);

    @Inject
    @Identifier("default-kafka-broker")
    Map<String, Object> config;

    @Produces
    AdminClient getAdmin() {
        log.info("Setting up Kafka AdminClient");
        Map<String, Object> copy = new HashMap<>();
        for (Map.Entry<String, Object> entry : config.entrySet()) {
            if (AdminClientConfig.configNames().contains(entry.getKey())) {
                copy.put(entry.getKey(), entry.getValue());
            }
        }
        return KafkaAdminClient.create(copy);
    }

    @Produces
    KafkaProducer<String, Message> getNotificatieProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG));
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MessageSerializer.class.getName());

        return new KafkaProducer<>(properties);
    }

    //@Produces
    KafkaConsumer<String, Message> getNotificatieConsumer() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG));
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MessageDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "FullConsumer" + new Random().nextInt(1000));
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return new KafkaConsumer<>(properties);
    }
}
