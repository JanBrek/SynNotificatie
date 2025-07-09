package nl.jan.kafka;

import io.smallrye.reactive.messaging.kafka.KafkaAdmin;
import nl.jan.rest.impl.KanaalServiceImpl;
import org.jboss.logging.Logger;

public class KafkaTopicFactory {
    private static Logger logger = Logger.getLogger(KafkaTopicFactory.class);

    private KafkaAdmin kafkaAdmin;

    /*public KafkaTopicFactory(KafkaAdmin kafkaAdmin){
        this.kafkaAdmin=kafkaAdmin;
    }*/

    public boolean createTopic(String kafkaTopic){

        boolean topicCreated=false;

        try{
           /* NewTopic newTopic=TopicBuilder.name(kafkaTopic).partitions(3)
                    .compact()
                    .build();
            this.kafkaAdmin.createOrModifyTopics(newTopic);*/
            topicCreated=true;
        }catch(Exception e){
            logger.error("Failed to create topic "+kafkaTopic+" "+e);
        }

        return topicCreated;
    }
}
