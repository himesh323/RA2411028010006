/**
 * UseCase5BookingRequestQueue - Demonstrates booking request intake using a FIFO queue.
 * Stores guest booking requests fairly without mutating inventory.
 *
 * @author SreesailamMouryaVeer
 * @version 5.1
 */
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        BookingRequestQueue bookingRequestQueue = new BookingRequestQueue();

        Reservation reservation1 = new Reservation("Aarav", "Single Room");
        Reservation reservation2 = new Reservation("Diya", "Double Room");
        Reservation reservation3 = new Reservation("Vihaan", "Suite Room");

        bookingRequestQueue.addBookingRequest(reservation1);
        bookingRequestQueue.addBookingRequest(reservation2);
        bookingRequestQueue.addBookingRequest(reservation3);

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC5            ");
        System.out.println(" Booking Request Queue (FIFO Ordering)  ");
        System.out.println("========================================\n");

        bookingRequestQueue.displayQueuedRequests();

        System.out.println("Total queued requests: " + bookingRequestQueue.getQueueSize());
        System.out.println("No room allocation performed at this stage.");
        System.out.println("Application terminated successfully.");
    }
}
