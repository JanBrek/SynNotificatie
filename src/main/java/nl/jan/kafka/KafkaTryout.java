package nl.jan.kafka;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
public class KafkaTryout {

    // Probeer hier je kafka meuk

    @Inject
    AdminClient admin;

    void onStartup(@Observes StartupEvent startupEvent) throws ExecutionException, InterruptedException {
        admin.createTopics(Collections.singleton(new NewTopic("newTopic", 1, (short) 1)));
        System.out.println("gevonden topics: " + admin.listTopics().names().get());
    }
}
