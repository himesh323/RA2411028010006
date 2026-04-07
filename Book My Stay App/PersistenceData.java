import java.io.Serializable;

/**
 * PersistenceData - Serializable container for inventory and booking history state.
 * Used to save and restore application state during shutdown and startup.
 *
 * @author SreesailamMouryaVeer
 * @version 12.0
 */
public class PersistenceData implements Serializable {
    private RoomInventory roomInventory;
    private BookingHistory bookingHistory;

    public PersistenceData(RoomInventory roomInventory, BookingHistory bookingHistory) {
        this.roomInventory = roomInventory;
        this.bookingHistory = bookingHistory;
    }

    public RoomInventory getRoomInventory() {
        return roomInventory;
    }

    public BookingHistory getBookingHistory() {
        return bookingHistory;
    }
}
