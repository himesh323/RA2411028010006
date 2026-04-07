/**
 * UseCase8BookingHistoryReport - Demonstrates booking history storage and reporting.
 * Stores confirmed reservations in order and generates a read-only summary report.
 *
 * @author SreesailamMouryaVeer
 * @version 8.1
 */
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        BookingHistory bookingHistory = new BookingHistory();
        BookingReportService bookingReportService = new BookingReportService(bookingHistory);

        bookingHistory.addConfirmedReservation(new Reservation("Aarav", "Single Room"));
        bookingHistory.addConfirmedReservation(new Reservation("Diya", "Double Room"));
        bookingHistory.addConfirmedReservation(new Reservation("Vihaan", "Suite Room"));
        bookingHistory.addConfirmedReservation(new Reservation("Ishita", "Suite Room"));

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC8            ");
        System.out.println("     Booking History & Reporting        ");
        System.out.println("========================================\n");

        bookingHistory.displayBookingHistory();
        bookingReportService.generateSummaryReport();

        System.out.println("Reporting completed without modifying booking history.");
        System.out.println("Application terminated successfully.");
    }
}
