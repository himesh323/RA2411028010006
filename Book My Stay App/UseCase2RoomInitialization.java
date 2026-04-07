/**
 * UseCase2RoomInitialization - Demonstrates room initialization and static availability.
 * Introduces abstraction, inheritance, polymorphism, and encapsulation.
 *
 * @author SreesailamMouryaVeer
 * @version 2.0
 */
public class UseCase2RoomInitialization {
    public static void main(String[] args) {
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC2            ");
        System.out.println("   Basic Room Types & Availability      ");
        System.out.println("========================================\n");

        displayRoomWithAvailability(singleRoom, singleRoomAvailability);
        displayRoomWithAvailability(doubleRoom, doubleRoomAvailability);
        displayRoomWithAvailability(suiteRoom, suiteRoomAvailability);

        System.out.println("Application terminated successfully.");
    }

    private static void displayRoomWithAvailability(Room room, int availability) {
        room.displayRoomDetails();
        System.out.println("Availability   : " + availability + " rooms");
        System.out.println("----------------------------------------");
    }
}
