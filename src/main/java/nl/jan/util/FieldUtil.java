package nl.jan.util;

import java.lang.reflect.Field;

public class FieldUtil {

    private FieldUtil() {}

    public static <T> void updateFields(T newData, T existingData) {
        Field[] fields = existingData.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object newValue = field.get(newData);
                if (newValue != null) {
                    field.set(existingData, newValue);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
