package hotel;

public abstract class ProRoom extends Room {
    protected ProRoom(int roomNumber, int maxPeople, int pricePerNight, boolean reserved) {
        super(roomNumber, maxPeople, pricePerNight, reserved);
    }

    protected ProRoom(int roomNumber, int pricePerNight) {
        super(roomNumber, pricePerNight);
    }
}
