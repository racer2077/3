package hotel;

public class FamilyRoom extends ProRoom {
    public FamilyRoom(int roomNumber, int maxPeople, int pricePerNight, boolean reserved) {
        super(roomNumber, maxPeople, pricePerNight, reserved);
    }

    public FamilyRoom(int roomNumber, int pricePerNight) {
        super(roomNumber, pricePerNight);
    }
}
