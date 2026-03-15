package hotel;

public class RoomServiceTest {
    public static void main(String[] args) {
        testReserveAndFreeForAnyRoomType();
        testReserveAlreadyReservedRoomThrows();
        System.out.println("All tests passed");
    }

    private static void testReserveAndFreeForAnyRoomType() {
        HotelRoomService<StandardRoom> standardService = new HotelRoomService<>();
        StandardRoom standardRoom = new StandardRoom(11, 3000);
        standardService.reserve(standardRoom);
        assert standardRoom.isReserved() : "StandardRoom should be reserved";
        standardService.free(standardRoom);
        assert !standardRoom.isReserved() : "StandardRoom should be free";

        HotelRoomService<FamilyRoom> familyService = new HotelRoomService<>();
        FamilyRoom familyRoom = new FamilyRoom(12, 6000);
        familyService.reserve(familyRoom);
        assert familyRoom.isReserved() : "FamilyRoom should be reserved";
        familyService.free(familyRoom);
        assert !familyRoom.isReserved() : "FamilyRoom should be free";
    }

    private static void testReserveAlreadyReservedRoomThrows() {
        HotelRoomService<LuxRoom> luxService = new HotelRoomService<>();
        LuxRoom luxRoom = new LuxRoom(13, 2, 9000, true);

        boolean thrown = false;
        try {
            luxService.reserve(luxRoom);
        } catch (RoomAlreadyReservedException e) {
            thrown = true;
        }

        assert thrown : "RoomAlreadyReservedException should be thrown";
    }
}
