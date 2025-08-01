package nl.jan.rest.impl;

import jakarta.transaction.Transactional;
import nl.jan.generated.KanaalResource;
import nl.jan.generated.beans.Kanaal;
import nl.jan.generated.beans.PatchedKanaal;

import java.lang.reflect.Field;
import java.util.List;
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

        if (foundKanaal != null) {
            updateKanaal(data, foundKanaal);
        }

        return foundKanaal;
    }

    @Override
    public Kanaal kanaal_partial_update(String contentType, String uuid, PatchedKanaal data) {
        Kanaal foundKanaal = Kanaal.findById(UUID.fromString(uuid));

        if (foundKanaal != null) {
            updateKanaal(data, foundKanaal);
        }

        return foundKanaal;
    }

    private <T> void updateKanaal(T newData, T existingKanaal) {
        Field[] fields = existingKanaal.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object newValue = field.get(newData);
                if (newValue != null) {
                    field.set(existingKanaal, newValue);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
