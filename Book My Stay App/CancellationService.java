import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * CancellationService - Handles cancellation of confirmed bookings and rollback.
 * Restores inventory, updates booking records, and tracks released room IDs.
 *
 * @author SreesailamMouryaVeer
 * @version 10.0
 */
public class CancellationService {
    private RoomInventory roomInventory;
    private BookingHistory bookingHistory;
    private Map<String, Reservation> activeReservations;
    private Map<String, String> allocatedRoomIdsByReservation;
    private Stack<String> releasedRoomIds;

    public CancellationService(RoomInventory roomInventory, BookingHistory bookingHistory) {
        this.roomInventory = roomInventory;
        this.bookingHistory = bookingHistory;
        this.activeReservations = new HashMap<>();
        this.allocatedRoomIdsByReservation = new HashMap<>();
        this.releasedRoomIds = new Stack<>();
    }

    public void registerConfirmedBooking(String reservationId, Reservation reservation, String allocatedRoomId) {
        activeReservations.put(reservationId, reservation);
        allocatedRoomIdsByReservation.put(reservationId, allocatedRoomId);
        bookingHistory.addConfirmedReservation(reservation);
    }

    public void cancelBooking(String reservationId) {
        if (!activeReservations.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation not found for ID " + reservationId);
            return;
        }

        Reservation reservation = activeReservations.remove(reservationId);
        String releasedRoomId = allocatedRoomIdsByReservation.remove(reservationId);
        releasedRoomIds.push(releasedRoomId);

        String roomType = reservation.getRoomType();
        int currentAvailability = roomInventory.getAvailability(roomType);
        roomInventory.updateAvailability(roomType, currentAvailability + 1);

        bookingHistory.getConfirmedReservations().remove(reservation);

        System.out.println("Cancellation successful for reservation ID " + reservationId);
        System.out.println("Released Room ID : " + releasedRoomId);
        System.out.println("Restored " + roomType + " availability to " + roomInventory.getAvailability(roomType));
    }

    public void displayRollbackStack() {
        System.out.println("Released Room IDs (Rollback Stack): " + releasedRoomIds);
    }
}
