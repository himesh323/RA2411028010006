/**
 * UseCase10BookingCancellation - Demonstrates booking cancellation and inventory rollback.
 * Cancels valid reservations safely and prevents duplicate or invalid cancellations.
 *
 * @author SreesailamMouryaVeer
 * @version 10.1
 */
public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        RoomInventory roomInventory = new RoomInventory();
        BookingHistory bookingHistory = new BookingHistory();
        CancellationService cancellationService = new CancellationService(roomInventory, bookingHistory);

        Reservation reservation1 = new Reservation("Aarav", "Single Room");
        Reservation reservation2 = new Reservation("Diya", "Suite Room");

        roomInventory.updateAvailability("Single Room", 4);
        roomInventory.updateAvailability("Suite Room", 1);

        cancellationService.registerConfirmedBooking("RES-2001", reservation1, "SR-001");
        cancellationService.registerConfirmedBooking("RES-2002", reservation2, "SU-001");

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC10           ");
        System.out.println(" Booking Cancellation & Inventory Rollback ");
        System.out.println("========================================\n");

        System.out.println("Initial Booking History:");
        bookingHistory.displayBookingHistory();

        System.out.println("Cancelling reservation RES-2002...\n");
        cancellationService.cancelBooking("RES-2002");

        System.out.println("\nAttempting duplicate cancellation for RES-2002...");
        cancellationService.cancelBooking("RES-2002");

        System.out.println("\nFinal Inventory State:");
        roomInventory.displayInventory();
        System.out.println();
        System.out.println("Updated Booking History:");
        bookingHistory.displayBookingHistory();
        cancellationService.displayRollbackStack();
        System.out.println("Application terminated successfully.");
    }
}
