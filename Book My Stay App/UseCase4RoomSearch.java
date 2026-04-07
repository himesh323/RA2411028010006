/**
 * UseCase4RoomSearch - Demonstrates read-only room search and availability check.
 * Shows only available room types while preserving inventory state.
 *
 * @author SreesailamMouryaVeer
 * @version 4.1
 */
public class UseCase4RoomSearch {
    public static void main(String[] args) {
        RoomInventory roomInventory = new RoomInventory();
        RoomSearchService roomSearchService = new RoomSearchService(roomInventory);

        roomInventory.updateAvailability("Suite Room", 0);

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC4            ");
        System.out.println("   Room Search & Availability Check     ");
        System.out.println("========================================\n");

        roomSearchService.displayAvailableRooms();

        System.out.println("Inventory remains unchanged after search.");
        System.out.println("Single Room availability: "
                + roomInventory.getAvailability("Single Room") + " rooms");
        System.out.println("Suite Room availability: "
                + roomInventory.getAvailability("Suite Room") + " rooms");
        System.out.println("Application terminated successfully.");
    }
}
