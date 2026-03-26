package hotel;

import java.lang.reflect.Method;

public final class DeprecatedExProcessor {
    private DeprecatedExProcessor() {
    }

    public static void process(Class<?> type) {
        if (type.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx classAnnotation = type.getAnnotation(DeprecatedEx.class);
            System.out.printf("! класс '%s' устарел – альтернатива: '%s'%n",
                    type.getSimpleName(), classAnnotation.message());
        }

        for (Method method : type.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx methodAnnotation = method.getAnnotation(DeprecatedEx.class);
                System.out.printf("! метод '%s' устарел – альтернатива: '%s'%n",
                        method.getName(), methodAnnotation.message());
            }
        }
    }
}
