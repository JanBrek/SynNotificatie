package nl.jan.rest.impl;

import jakarta.transaction.Transactional;
import nl.jan.generated.KanaalResource;
import nl.jan.generated.beans.Kanaal;
import nl.jan.generated.beans.PatchedKanaal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return Kanaal.findById(UUID.fromString(uuid));
    }

    @Transactional
    @Override
    public Kanaal kanaal_update(String contentType, String uuid, Kanaal data) {

        Kanaal foundKanaal = Kanaal.findById(UUID.fromString(uuid));

        assert foundKanaal != null;

        System.out.println(data.getId());
        data.persist();
        return data;
    }

    @Override
    public Kanaal kanaal_partial_update(String contentType, String uuid, PatchedKanaal data) {
        Kanaal foundKanaal = Kanaal.findById(UUID.fromString(uuid));

        Optional.ofNullable(data.getNaam()).ifPresent((naam) -> foundKanaal.setNaam(data.getNaam()));

        //Arrays.stream(foundKanaal.getClass().getDeclaredFields()).forEach((field) -> {Optional.ofNullable(field.g)})

        //Kanaal.update(data);

        return null;
    }
}
