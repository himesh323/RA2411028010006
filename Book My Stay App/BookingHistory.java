import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * BookingHistory - Stores confirmed reservations in insertion order.
 * Maintains an in-memory audit trail for later review and reporting.
 *
 * @author SreesailamMouryaVeer
 * @version 8.0
 */
public class BookingHistory implements Serializable {
    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    public void addConfirmedReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }

    public void displayBookingHistory() {
        System.out.println("Booking History:");
        System.out.println("----------------------------------------");

        if (confirmedReservations.isEmpty()) {
            System.out.println("No confirmed reservations available.");
            System.out.println("----------------------------------------");
            return;
        }

        int bookingNumber = 1;
        for (Reservation reservation : confirmedReservations) {
            System.out.println("Booking Number : " + bookingNumber);
            reservation.displayReservation();
            System.out.println("----------------------------------------");
            bookingNumber++;
        }
    }
}
