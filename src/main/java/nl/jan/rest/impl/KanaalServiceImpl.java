package nl.jan.rest.impl;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import nl.jan.rest.KanaalResource;
import nl.jan.rest.beans.Kanaal;
import nl.jan.rest.beans.PatchedKanaal;

import javax.annotation.processing.Completion;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CopyOnWriteArrayList;

import org.jboss.logging.Logger;

public class KanaalServiceImpl implements KanaalResource {

    private static final Logger LOG = Logger.getLogger(KanaalServiceImpl.class);

    static Kanaal k = new Kanaal();

    static {
        k.setNaam("test");
        k.setUrl(URI.create("http://localhostt"));
    }

    private static List<Kanaal> kanalen = new CopyOnWriteArrayList<>(Arrays.asList(k));

    @Override
    public CompletionStage<List<Kanaal>> kanaal_list(String naam) {
        LOG.info("---TST---");
        return CompletableFuture.completedFuture(kanalen);
    }

    @Override
    public CompletionStage<Kanaal> kanaal_create(String contentType, Kanaal data) {
        return CompletableFuture.supplyAsync(() -> {kanalen.add(data); LOG.info("Adding..."); return data;});
    }

    @Override
    public CompletionStage<Kanaal> kanaal_read(String uuid) {
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
}
