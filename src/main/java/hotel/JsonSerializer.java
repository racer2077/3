package hotel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class JsonSerializer {
    private JsonSerializer() {
    }

    public static String toJson(Object object) {
        List<String> parts = new ArrayList<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            JsonField annotation = field.getAnnotation(JsonField.class);
            if (annotation == null) {
                continue;
            }

            field.setAccessible(true);
            try {
                Object value = field.get(object);
                parts.add("\"" + annotation.name() + "\": " + formatValue(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Не удалось прочитать поле: " + field.getName(), e);
            }
        }

        return "{" + String.join(", ", parts) + "}";
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "\"" + value + "\"";
        }
        return String.valueOf(value);
    }
}
