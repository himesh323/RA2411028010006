import java.util.ArrayList;
import java.util.List;

/**
 * RoomSearchService - Provides read-only room search functionality.
 * Retrieves room details and availability without modifying inventory state.
 *
 * @author SreesailamMouryaVeer
 * @version 4.0
 */
public class RoomSearchService {
    private RoomInventory roomInventory;

    public RoomSearchService(RoomInventory roomInventory) {
        this.roomInventory = roomInventory;
    }

    public void displayAvailableRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        System.out.println("Available Rooms:");
        System.out.println("----------------------------------------");

        for (Room room : rooms) {
            int availability = roomInventory.getAvailability(room.getRoomType());

            if (availability > 0) {
                room.displayRoomDetails();
                System.out.println("Availability   : " + availability + " rooms");
                System.out.println("----------------------------------------");
            }
        }
    }
}
