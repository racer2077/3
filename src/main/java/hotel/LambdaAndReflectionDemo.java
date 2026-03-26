package hotel;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class LambdaAndReflectionDemo {
    private LambdaAndReflectionDemo() {
    }

    public static void run() {
        task11Printable();
        task12Predicates();
        task13StringPredicate();
        task14HeavyBoxConsumer();
        task15NumberFunction();
        task16RandomSupplier();
        task21DeprecatedEx();
        task22JsonField();
    }

    private static void task11Printable() {
        Printable printable = () -> System.out.println("Печать из Printable");
        printable.print();
    }

    private static void task12Predicates() {
        Predicate<String> notNull = value -> value != null;
        Predicate<String> notEmpty = value -> !value.isEmpty();
        Predicate<String> validString = notNull.and(notEmpty);

        String[] values = {null, "", "Java"};
        for (String value : values) {
            System.out.printf("Строка '%s' корректна: %s%n", value, validString.test(value));
        }
    }

    private static void task13StringPredicate() {
        Predicate<String> startsWithJorN = value -> value.startsWith("J") || value.startsWith("N");
        Predicate<String> endsWithA = value -> value.endsWith("A");

        Predicate<String> matcher = startsWithJorN.and(endsWithA);

        String[] testData = {"JAVA", "NIRVANA", "KOTLIN", "NODE"};
        for (String item : testData) {
            System.out.printf("Строка '%s' подходит: %s%n", item, matcher.test(item));
        }
    }

    private static void task14HeavyBoxConsumer() {
        Consumer<HeavyBox> ship = box -> System.out.println("Отгрузили ящик с весом " + box.getWeight());
        Consumer<HeavyBox> send = box -> System.out.println("Отправляем ящик с весом " + box.getWeight());

        ship.andThen(send).accept(new HeavyBox(35));
    }

    private static void task15NumberFunction() {
        Function<Integer, String> numberType = number -> {
            if (number > 0) {
                return "Положительное число";
            }
            if (number < 0) {
                return "Отрицательное число";
            }
            return "Ноль";
        };

        int[] numbers = {10, -7, 0};
        for (int number : numbers) {
            System.out.printf("%d -> %s%n", number, numberType.apply(number));
        }
    }

    private static void task16RandomSupplier() {
        Supplier<Integer> random0to10 = () -> ThreadLocalRandom.current().nextInt(0, 11);
        System.out.println("Случайное число [0..10]: " + random0to10.get());
    }

    private static void task21DeprecatedEx() {
        DeprecatedExProcessor.process(LegacyPrinter.class);
    }

    private static void task22JsonField() {
        UserProfile profile = new UserProfile("Анна", 25, true);
        String json = JsonSerializer.toJson(profile);
        System.out.println("JSON: " + json);
    }
}
