package nl.jan.kafka.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.jan.generated.beans.Message;
import org.apache.kafka.common.serialization.Serializer;
import org.jboss.logging.Logger;

import java.util.Map;

public class MessageSerializer implements Serializer<Message> {
    private static final Logger logger = Logger.getLogger(MessageSerializer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Message data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            logger.error("Unable to serialize object {}", data, e);
            return null;
        }
    }

    @Override
    public void close() {
    }
}
