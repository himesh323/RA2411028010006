/**
 * UseCase6RoomAllocationService - Demonstrates reservation confirmation and room allocation.
 * Processes queued requests, assigns unique room IDs, and updates inventory safely.
 *
 * @author SreesailamMouryaVeer
 * @version 6.1
 */
public class UseCase6RoomAllocationService {
    public static void main(String[] args) {
        RoomInventory roomInventory = new RoomInventory();
        BookingRequestQueue bookingRequestQueue = new BookingRequestQueue();
        RoomAllocationService roomAllocationService = new RoomAllocationService(roomInventory);

        bookingRequestQueue.addBookingRequest(new Reservation("Aarav", "Single Room"));
        bookingRequestQueue.addBookingRequest(new Reservation("Diya", "Double Room"));
        bookingRequestQueue.addBookingRequest(new Reservation("Vihaan", "Suite Room"));
        bookingRequestQueue.addBookingRequest(new Reservation("Ishita", "Suite Room"));
        bookingRequestQueue.addBookingRequest(new Reservation("Kabir", "Suite Room"));

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC6            ");
        System.out.println(" Reservation Confirmation & Allocation  ");
        System.out.println("========================================\n");

        roomAllocationService.processBookingRequests(bookingRequestQueue);

        System.out.println("Final Inventory State:");
        roomInventory.displayInventory();
        System.out.println();
        roomAllocationService.displayAllocatedRooms();
        System.out.println("Application terminated successfully.");
    }
}
