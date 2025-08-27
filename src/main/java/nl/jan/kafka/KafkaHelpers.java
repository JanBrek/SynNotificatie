package nl.jan.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import nl.jan.generated.beans.Message;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.Future;

@ApplicationScoped
public class KafkaHelpers {
    private static final Logger log = LoggerFactory.getLogger(KafkaHelpers.class);

    @Inject
    KafkaBeanCreator creator;

    @Inject
    AdminClient adminClient;

    @Inject
    KafkaProducer<String, Message> notificatieProducer;

    /*@Inject
    KafkaConsumer<String, Message> notificatieConsumer;*/

    public void createTopic(String kafkaTopic) {
        NewTopic newTopic = new NewTopic(kafkaTopic, 1, (short) 1);
        adminClient.createTopics(Collections.singleton(newTopic));
    }

    public Future<RecordMetadata> sendNotification(Message message) {
        return notificatieProducer.send(new ProducerRecord<>(message.getKanaal(), message));
    }


    public KafkaConsumer<String, Message> getTopicConsumer(String topic) {
        /*synchronized(notificatieConsumer) {
            notificatieConsumer.subscribe(Collections.singletonList(topic));
        }
        return notificatieConsumer;*/
        KafkaConsumer<String, Message> consumer =  creator.getNotificatieConsumer();
        consumer.subscribe(Collections.singletonList(topic));
        return consumer;
    }

    public void LogFullMessageTopic(KafkaConsumer<String, Message> consumer) {
        boolean isRunning = true;
        while (isRunning) {
            ConsumerRecords<String, Message> records =
                    consumer.poll(Duration.ofMillis(100));

            if (records.isEmpty()) {
                isRunning = false;
            }

            for (ConsumerRecord<String, Message> record : records) {
                log.info("Key: {}, Value: {}", record.key(), record.value());
                log.info("Partition: {}, Offset: {}", record.partition(), record.offset());
            }
        }
    }

}
