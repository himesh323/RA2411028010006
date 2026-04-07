/**
 * UseCase11ConcurrentBookingSimulation - Demonstrates thread-safe concurrent booking processing.
 * Uses synchronized access to protect shared queue and inventory state.
 *
 * @author SreesailamMouryaVeer
 * @version 11.1
 */
public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        BookingRequestQueue bookingRequestQueue = new BookingRequestQueue();
        RoomInventory roomInventory = new RoomInventory();

        roomInventory.updateAvailability("Single Room", 2);
        roomInventory.updateAvailability("Double Room", 2);
        roomInventory.updateAvailability("Suite Room", 1);

        bookingRequestQueue.addBookingRequest(new Reservation("Aarav", "Single Room"));
        bookingRequestQueue.addBookingRequest(new Reservation("Diya", "Single Room"));
        bookingRequestQueue.addBookingRequest(new Reservation("Vihaan", "Double Room"));
        bookingRequestQueue.addBookingRequest(new Reservation("Ishita", "Double Room"));
        bookingRequestQueue.addBookingRequest(new Reservation("Kabir", "Suite Room"));
        bookingRequestQueue.addBookingRequest(new Reservation("Meera", "Suite Room"));

        ConcurrentBookingProcessor processor = new ConcurrentBookingProcessor(bookingRequestQueue, roomInventory);

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                processor.processRequests();
            }
        }, "Thread-1");

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                processor.processRequests();
            }
        }, "Thread-2");

        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                processor.processRequests();
            }
        }, "Thread-3");

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC11           ");
        System.out.println("  Concurrent Booking Simulation         ");
        System.out.println("========================================\n");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException exception) {
            System.out.println("Thread interruption occurred: " + exception.getMessage());
        }

        System.out.println("\nFinal Inventory State:");
        roomInventory.displayInventory();
        processor.displayAllocatedRoomCount();
        System.out.println("Application terminated successfully.");
    }
}
