package hotel;

public class Main {
    public static void main(String[] args) {
        RoomService<StandardRoom> standardRoomService = new HotelRoomService<>();
        StandardRoom standardRoom = new StandardRoom(101, 2, 3500, false);

        RoomService<FamilyRoom> familyRoomService = new HotelRoomService<>();
        FamilyRoom familyRoom = new FamilyRoom(201, 4, 7000, false);

        RoomService<LuxRoom> luxRoomService = new HotelRoomService<>();
        LuxRoom luxRoom = new LuxRoom(301, 2, 12000, false);

        standardRoomService.clean(standardRoom);
        standardRoomService.reserve(standardRoom);
        standardRoomService.free(standardRoom);

        familyRoomService.clean(familyRoom);
        familyRoomService.reserve(familyRoom);

        luxRoomService.clean(luxRoom);
        luxRoomService.reserve(luxRoom);

        try {
            luxRoomService.reserve(luxRoom);
        } catch (RoomAlreadyReservedException e) {
            System.out.println("Поймана ошибка: " + e.getMessage());
        }

        System.out.println(standardRoom);
        System.out.println(familyRoom);
        System.out.println(luxRoom);
    }
}
