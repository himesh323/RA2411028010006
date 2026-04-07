import java.util.List;

/**
 * BookingReportService - Generates read-only summaries from booking history.
 * Produces reports without modifying stored booking data.
 *
 * @author SreesailamMouryaVeer
 * @version 8.0
 */
public class BookingReportService {
    private BookingHistory bookingHistory;

    public BookingReportService(BookingHistory bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    public void generateSummaryReport() {
        List<Reservation> reservations = bookingHistory.getConfirmedReservations();

        System.out.println("Booking Summary Report:");
        System.out.println("----------------------------------------");
        System.out.println("Total Confirmed Reservations : " + reservations.size());

        int singleRoomCount = 0;
        int doubleRoomCount = 0;
        int suiteRoomCount = 0;

        for (Reservation reservation : reservations) {
            String roomType = reservation.getRoomType();

            if ("Single Room".equals(roomType)) {
                singleRoomCount++;
            } else if ("Double Room".equals(roomType)) {
                doubleRoomCount++;
            } else if ("Suite Room".equals(roomType)) {
                suiteRoomCount++;
            }
        }

        System.out.println("Single Room Bookings : " + singleRoomCount);
        System.out.println("Double Room Bookings : " + doubleRoomCount);
        System.out.println("Suite Room Bookings  : " + suiteRoomCount);
        System.out.println("----------------------------------------");
    }
}
