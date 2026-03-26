package hotel;

@DeprecatedEx(message = "Используйте ModernPrinter")
public class LegacyPrinter {

    @DeprecatedEx(message = "Используйте printModern()")
    public void printLegacy() {
        System.out.println("Старый способ печати");
    }

    public void printModern() {
        System.out.println("Новый способ печати");
    }
}
