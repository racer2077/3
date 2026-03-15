package hotel;

public class StandardRoom extends Room {
    public StandardRoom(int roomNumber, int maxPeople, int pricePerNight, boolean reserved) {
        super(roomNumber, maxPeople, pricePerNight, reserved);
    }

    public StandardRoom(int roomNumber, int pricePerNight) {
        super(roomNumber, pricePerNight);
    }
}
