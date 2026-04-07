import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * RoomAllocationService - Confirms reservations by allocating unique room IDs.
 * Prevents double-booking and synchronizes inventory during allocation.
 *
 * @author SreesailamMouryaVeer
 * @version 6.0
 */
public class RoomAllocationService {
    private RoomInventory roomInventory;
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> allocatedRoomsByType;
    private Map<String, Integer> roomTypeCounters;

    public RoomAllocationService(RoomInventory roomInventory) {
        this.roomInventory = roomInventory;
        this.allocatedRoomIds = new HashSet<>();
        this.allocatedRoomsByType = new HashMap<>();
        this.roomTypeCounters = new HashMap<>();
    }

    public void processBookingRequests(BookingRequestQueue bookingRequestQueue) {
        while (!bookingRequestQueue.isEmpty()) {
            Reservation reservation = bookingRequestQueue.getNextBookingRequest();
            confirmReservation(reservation);
            System.out.println("----------------------------------------");
        }
    }

    public void confirmReservation(Reservation reservation) {
        String roomType = reservation.getRoomType();
        int currentAvailability = roomInventory.getAvailability(roomType);

        System.out.println("Processing reservation for " + reservation.getGuestName()
                + " requesting " + roomType);

        if (currentAvailability <= 0) {
            System.out.println("Reservation failed: No rooms available for " + roomType);
            return;
        }

        String roomId = generateUniqueRoomId(roomType);
        allocatedRoomIds.add(roomId);
        allocatedRoomsByType.computeIfAbsent(roomType, key -> new HashSet<>()).add(roomId);
        roomInventory.updateAvailability(roomType, currentAvailability - 1);

        System.out.println("Reservation confirmed for " + reservation.getGuestName());
        System.out.println("Allocated Room ID : " + roomId);
        System.out.println("Remaining " + roomType + " availability: "
                + roomInventory.getAvailability(roomType));
    }

    private String generateUniqueRoomId(String roomType) {
        String prefix = getRoomTypePrefix(roomType);
        int nextNumber = roomTypeCounters.getOrDefault(roomType, 0) + 1;
        String roomId = prefix + String.format("%03d", nextNumber);

        while (allocatedRoomIds.contains(roomId)) {
            nextNumber++;
            roomId = prefix + String.format("%03d", nextNumber);
        }

        roomTypeCounters.put(roomType, nextNumber);
        return roomId;
    }

    private String getRoomTypePrefix(String roomType) {
        if ("Single Room".equals(roomType)) {
            return "SR-";
        } else if ("Double Room".equals(roomType)) {
            return "DR-";
        } else if ("Suite Room".equals(roomType)) {
            return "SU-";
        }
        return "RM-";
    }

    public void displayAllocatedRooms() {
        System.out.println("Allocated Rooms by Type:");
        for (Map.Entry<String, Set<String>> entry : allocatedRoomsByType.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
