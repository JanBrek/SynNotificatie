package nl.jan.rest.impl;

/*import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import nl.jan.rest.KanaalResource;
import nl.jan.rest.beans.Kanaal;
import nl.jan.rest.beans.PatchedKanaal;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;*/

import jakarta.transaction.Transactional;
import nl.jan.rest.KanaalResource;
import nl.jan.rest.beans.Kanaal;
import nl.jan.rest.beans.PatchedKanaal;

import java.util.List;

public class KanaalServiceImpl implements KanaalResource {
    @Override
    public List<Kanaal> kanaal_list(String naam) {
        return  Kanaal.listAll();
    }

    @Transactional
    @Override
    public Kanaal kanaal_create(String contentType, Kanaal data) {
        data.persist();
        return data;
    }

    @Override
    public Kanaal kanaal_read(String uuid) {
        return null;
    }

    @Override
    public Kanaal kanaal_update(String contentType, String uuid, Kanaal data) {
        return null;
    }

    @Override
    public Kanaal kanaal_partial_update(String contentType, String uuid, PatchedKanaal data) {
        return null;
    }
}
/*
//@ApplicationScoped
//@WithSession
public class KanaalServiceImpl implements KanaalResource {

    private static final Logger LOG = Logger.getLogger(KanaalServiceImpl.class);

    @GET
    @Override
    public CompletionStage<List<Kanaal>> kanaal_list(String naam) {
        //LOG.info("---TST---");
        //var list2 = Kanaal.listAll();
        return CompletableFuture.supplyAsync(()->{
            return (List<Kanaal>) Kanaal.<Kanaal>listAll().subscribeAsCompletionStage();
        });
        *//*Uni<List<Kanaal>> list = Kanaal.listAll();
        return list.subscribeAsCompletionStage();*//*
        //return repository.listAll().subscribeAsCompletionStage();
        //return CompletableFuture.completedFuture(kanalen);
    }

    @Override
    public CompletionStage<Kanaal> kanaal_create(String contentType, Kanaal data) {
        Uni<Kanaal> pers= data.persist();
        return pers.subscribeAsCompletionStage();
    }

    @Override
    public CompletionStage<Kanaal> kanaal_read(String uuid) {
        //return repository.findById(uuid).subscribeAsCompletionStage();
        return null;
    }

    @Override
    public CompletionStage<Kanaal> kanaal_update(String contentType, String uuid, Kanaal data) {
        return null;
    }

    @Override
    public CompletionStage<Kanaal> kanaal_partial_update(String contentType, String uuid, PatchedKanaal data) {
        return null;
    }
}*/
