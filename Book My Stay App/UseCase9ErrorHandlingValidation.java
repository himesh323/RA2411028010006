/**
 * UseCase9ErrorHandlingValidation - Demonstrates validation and graceful error handling.
 * Detects invalid inputs early, protects system state, and keeps the application stable.
 *
 * @author SreesailamMouryaVeer
 * @version 9.1
 */
public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        RoomInventory roomInventory = new RoomInventory();
        BookingValidator bookingValidator = new BookingValidator();

        Reservation validReservation = new Reservation("Aarav", "Single Room");
        Reservation invalidRoomReservation = new Reservation("Diya", "Deluxe Room");
        Reservation emptyGuestReservation = new Reservation("", "Suite Room");

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC9            ");
        System.out.println("     Error Handling & Validation        ");
        System.out.println("========================================\n");

        processReservation(validReservation, roomInventory, bookingValidator);
        processReservation(invalidRoomReservation, roomInventory, bookingValidator);
        processReservation(emptyGuestReservation, roomInventory, bookingValidator);

        try {
            bookingValidator.validateInventoryUpdate("Suite Room", -1);
        } catch (InvalidBookingException exception) {
            System.out.println("Inventory Validation Error: " + exception.getMessage());
        }

        System.out.println("\nFinal Inventory State:");
        roomInventory.displayInventory();
        System.out.println("Application terminated successfully.");
    }

    private static void processReservation(Reservation reservation,
                                           RoomInventory roomInventory,
                                           BookingValidator bookingValidator) {
        try {
            bookingValidator.validateReservation(reservation, roomInventory);
            System.out.println("Reservation validated successfully for "
                    + reservation.getGuestName() + " -> " + reservation.getRoomType());
        } catch (InvalidBookingException exception) {
            System.out.println("Validation Error: " + exception.getMessage());
        }
    }
}
