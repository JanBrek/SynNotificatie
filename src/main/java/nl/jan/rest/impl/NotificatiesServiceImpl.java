package nl.jan.rest.impl;

import jakarta.inject.Inject;
import nl.jan.generated.NotificatiesResource;
import nl.jan.generated.beans.Message;
import nl.jan.kafka.KafkaHelpers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NotificatiesServiceImpl implements NotificatiesResource {

    @Inject
    KafkaHelpers kh;

    @Override
    public Message notificaties_create(String contentType, Message data) {
        try {
            kh.SendNotificatie(data).get(10L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
