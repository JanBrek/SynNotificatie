package nl.jan.rest.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import nl.jan.generated.AbonnementResource;
import nl.jan.generated.beans.Abonnement;
import nl.jan.generated.beans.FilterGroup;
import nl.jan.generated.beans.PatchedAbonnement;
import nl.jan.kafka.KafkaHelpers;
import nl.jan.util.FieldUtil;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class AbonnementServiceImpl implements AbonnementResource {

    @Inject
    KafkaHelpers kh;

    @Override
    @Transactional
    public List<Abonnement> abonnement_list() {
        Abonnement.listAll();
        return List.of();
    }

    @Override
    public Abonnement abonnement_create(String contentType, Abonnement data) {
        data.persist();
        return data;
    }

    @Override
    public Abonnement abonnement_read(String uuid) {
        return Abonnement.findById(UUID.fromString(uuid));
    }

    @Override
    public Abonnement abonnement_update(String contentType, String uuid, Abonnement data) {
        Abonnement foundAbonnement = Abonnement.findById(UUID.fromString(uuid));

        // Updaten van kanaal naam als topic naam gaan we niet supporten
        // TODO; Momenteel gedraagd deze zich als patch. Moet een volwaardige overschrijving worden.
        if (foundAbonnement != null) {
            FieldUtil.updateFields(data, foundAbonnement);
        }

        return foundAbonnement;
    }

    @Override
    public void abonnement_delete(String uuid) {

    }

    @Override
    public Abonnement abonnement_partial_update(String contentType, String uuid, PatchedAbonnement data) {
        return null;
    }
}
