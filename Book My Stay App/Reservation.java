/**
 * Reservation - Represents a guest's booking request.
 * Captures the guest name and requested room type.
 *
 * @author SreesailamMouryaVeer
 * @version 5.0
 */
import java.io.Serializable;

public class Reservation implements Serializable {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
    }
}
