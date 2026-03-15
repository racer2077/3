package hotel;

import java.util.Random;

public abstract class Room {
    private static final Random RANDOM = new Random();

    private final int roomNumber;
    private final int maxPeople;
    private final int pricePerNight;
    private boolean reserved;

    protected Room(int roomNumber, int maxPeople, int pricePerNight, boolean reserved) {
        this.roomNumber = roomNumber;
        this.maxPeople = maxPeople;
        this.pricePerNight = pricePerNight;
        this.reserved = reserved;
    }

    protected Room(int roomNumber, int pricePerNight) {
        this(roomNumber, 1 + RANDOM.nextInt(4), pricePerNight, false);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "roomNumber=" + roomNumber +
                ", maxPeople=" + maxPeople +
                ", pricePerNight=" + pricePerNight +
                ", reserved=" + reserved +
                '}';
    }
}
