package hotel;

public class LuxRoom extends ProRoom {
    public LuxRoom(int roomNumber, int maxPeople, int pricePerNight, boolean reserved) {
        super(roomNumber, maxPeople, pricePerNight, reserved);
    }

    public LuxRoom(int roomNumber, int pricePerNight) {
        super(roomNumber, pricePerNight);
    }
}
