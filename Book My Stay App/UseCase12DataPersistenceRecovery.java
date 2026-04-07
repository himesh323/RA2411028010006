/**
 * UseCase12DataPersistenceRecovery - Demonstrates saving and restoring booking and inventory state.
 * Uses serialization-based file persistence to recover state after restart.
 *
 * @author SreesailamMouryaVeer
 * @version 12.1
 */
public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {
        String fileName = "bookmystay_state.ser";
        PersistenceService persistenceService = new PersistenceService();

        RoomInventory roomInventory = new RoomInventory();
        BookingHistory bookingHistory = new BookingHistory();

        roomInventory.updateAvailability("Single Room", 4);
        roomInventory.updateAvailability("Double Room", 2);
        roomInventory.updateAvailability("Suite Room", 1);

        bookingHistory.addConfirmedReservation(new Reservation("Aarav", "Single Room"));
        bookingHistory.addConfirmedReservation(new Reservation("Diya", "Suite Room"));

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC12           ");
        System.out.println("   Data Persistence & System Recovery   ");
        System.out.println("========================================\n");

        System.out.println("Saving current system state...\n");
        persistenceService.saveState(fileName, roomInventory, bookingHistory);

        System.out.println("\nSimulating system restart...\n");

        PersistenceData restoredData = persistenceService.loadState(fileName);
        RoomInventory restoredInventory = restoredData.getRoomInventory();
        BookingHistory restoredHistory = restoredData.getBookingHistory();

        System.out.println("\nRecovered Inventory State:");
        restoredInventory.displayInventory();
        System.out.println();
        System.out.println("Recovered Booking History:");
        restoredHistory.displayBookingHistory();
        System.out.println("System resumed safely after recovery.");
        System.out.println("Application terminated successfully.");
    }
}
