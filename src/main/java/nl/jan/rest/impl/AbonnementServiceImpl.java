package nl.jan.rest.impl;

import jakarta.enterprise.context.ApplicationScoped;
import nl.jan.generated.AbonnementResource;
import nl.jan.generated.beans.Abonnement;
import nl.jan.generated.beans.PatchedAbonnement;

import java.util.List;

@ApplicationScoped
public class AbonnementServiceImpl implements AbonnementResource {
    @Override
    public List<Abonnement> abonnement_list() {
        return List.of();
    }

    @Override
    public Abonnement abonnement_create(String contentType, Abonnement data) {
        data.persist();
        return null;
    }

    @Override
    public Abonnement abonnement_read(String uuid) {
        return null;
    }

    @Override
    public Abonnement abonnement_update(String contentType, String uuid, Abonnement data) {
        return null;
    }

    @Override
    public void abonnement_delete(String uuid) {

    }

    @Override
    public Abonnement abonnement_partial_update(String contentType, String uuid, PatchedAbonnement data) {
        return null;
    }
}
