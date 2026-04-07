/**
 * BookingValidator - Validates booking inputs and inventory constraints.
 * Applies fail-fast checks before any booking-related state changes.
 *
 * @author SreesailamMouryaVeer
 * @version 9.0
 */
public class BookingValidator {
    public void validateReservation(Reservation reservation, RoomInventory roomInventory)
            throws InvalidBookingException {
        if (reservation == null) {
            throw new InvalidBookingException("Reservation cannot be null.");
        }

        String guestName = reservation.getGuestName();
        String roomType = reservation.getRoomType();

        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        if (!isValidRoomType(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }

        int availability = roomInventory.getAvailability(roomType);
        if (availability <= 0) {
            throw new InvalidBookingException("No rooms available for: " + roomType);
        }
    }

    public void validateInventoryUpdate(String roomType, int newCount) throws InvalidBookingException {
        if (!isValidRoomType(roomType)) {
            throw new InvalidBookingException("Invalid room type for inventory update: " + roomType);
        }

        if (newCount < 0) {
            throw new InvalidBookingException("Inventory count cannot be negative for: " + roomType);
        }
    }

    private boolean isValidRoomType(String roomType) {
        return "Single Room".equals(roomType)
                || "Double Room".equals(roomType)
                || "Suite Room".equals(roomType);
    }
}
