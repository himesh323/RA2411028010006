import java.util.HashSet;
import java.util.Set;

/**
 * ConcurrentBookingProcessor - Processes booking requests safely in a multi-threaded environment.
 * Synchronizes shared queue, inventory, and allocation state to prevent inconsistencies.
 *
 * @author SreesailamMouryaVeer
 * @version 11.0
 */
public class ConcurrentBookingProcessor {
    private BookingRequestQueue bookingRequestQueue;
    private RoomInventory roomInventory;
    private Set<String> allocatedRoomIds;
    private int singleRoomCounter;
    private int doubleRoomCounter;
    private int suiteRoomCounter;

    public ConcurrentBookingProcessor(BookingRequestQueue bookingRequestQueue, RoomInventory roomInventory) {
        this.bookingRequestQueue = bookingRequestQueue;
        this.roomInventory = roomInventory;
        this.allocatedRoomIds = new HashSet<>();
        this.singleRoomCounter = 0;
        this.doubleRoomCounter = 0;
        this.suiteRoomCounter = 0;
    }

    public void processRequests() {
        while (true) {
            Reservation reservation = getNextReservation();
            if (reservation == null) {
                break;
            }
            allocateRoomSafely(reservation);
        }
    }

    private Reservation getNextReservation() {
        synchronized (bookingRequestQueue) {
            if (bookingRequestQueue.isEmpty()) {
                return null;
            }
            return bookingRequestQueue.getNextBookingRequest();
        }
    }

    private void allocateRoomSafely(Reservation reservation) {
        synchronized (roomInventory) {
            String roomType = reservation.getRoomType();
            int availability = roomInventory.getAvailability(roomType);

            if (availability <= 0) {
                System.out.println(Thread.currentThread().getName() + " -> Booking failed for "
                        + reservation.getGuestName() + " (" + roomType + " not available)");
                return;
            }

            String roomId = generateUniqueRoomId(roomType);
            allocatedRoomIds.add(roomId);
            roomInventory.updateAvailability(roomType, availability - 1);

            System.out.println(Thread.currentThread().getName() + " -> Booking confirmed for "
                    + reservation.getGuestName() + " | " + roomType + " | Room ID: " + roomId);
        }
    }

    private String generateUniqueRoomId(String roomType) {
        String roomId;

        do {
            if ("Single Room".equals(roomType)) {
                singleRoomCounter++;
                roomId = "SR-" + String.format("%03d", singleRoomCounter);
            } else if ("Double Room".equals(roomType)) {
                doubleRoomCounter++;
                roomId = "DR-" + String.format("%03d", doubleRoomCounter);
            } else {
                suiteRoomCounter++;
                roomId = "SU-" + String.format("%03d", suiteRoomCounter);
            }
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }

    public void displayAllocatedRoomCount() {
        System.out.println("Total allocated room IDs: " + allocatedRoomIds.size());
    }
}
