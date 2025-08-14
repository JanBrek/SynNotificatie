package nl.jan.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.jboss.logging.Logger;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import static org.jboss.logging.Logger.Level.ERROR;

@ApplicationScoped
public class KafkaTopicFactory {
    private static final Logger logger = Logger.getLogger(KafkaTopicFactory.class);

    private static final String KAFKA_HOST = "localhost:9093";

    public boolean createTopic(String kafkaTopic) {
        boolean isCreated = false;
        Properties config = new Properties();
        config.put("bootstrap.servers", KAFKA_HOST);

        try (AdminClient admin = AdminClient.create(config)) {
            NewTopic newTopic = new NewTopic(kafkaTopic, 1, (short) 1);
            admin.createTopics(Collections.singleton(newTopic)).all().get();
            isCreated = true;
        } catch (ExecutionException | InterruptedException e) {
            logger.log(ERROR, "Error occured creating a new topic. " + e.getMessage());
        }
        return isCreated;
    }
}
