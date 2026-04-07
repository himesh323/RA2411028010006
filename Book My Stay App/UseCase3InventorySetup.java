/**
 * UseCase3InventorySetup - Demonstrates centralized room inventory management.
 * Replaces scattered availability variables with a single HashMap-based inventory.
 *
 * @author SreesailamMouryaVeer
 * @version 3.1
 */
public class UseCase3InventorySetup {
    public static void main(String[] args) {
        RoomInventory roomInventory = new RoomInventory();

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC3            ");
        System.out.println(" Centralized Room Inventory Management  ");
        System.out.println("========================================\n");

        roomInventory.displayInventory();

        System.out.println("\nUpdating Suite Room availability to 4...\n");
        roomInventory.updateAvailability("Suite Room", 4);

        roomInventory.displayInventory();

        System.out.println("\nSingle Room availability: "
                + roomInventory.getAvailability("Single Room") + " rooms");
        System.out.println("Application terminated successfully.");
    }
}
