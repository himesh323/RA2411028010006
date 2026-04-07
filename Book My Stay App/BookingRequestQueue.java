import java.util.LinkedList;
import java.util.Queue;

/**
 * BookingRequestQueue - Manages incoming booking requests using FIFO ordering.
 * Accepts requests and preserves arrival order without allocating rooms.
 *
 * @author SreesailamMouryaVeer
 * @version 5.0
 */
public class BookingRequestQueue {
    private Queue<Reservation> reservationQueue;

    public BookingRequestQueue() {
        reservationQueue = new LinkedList<>();
    }

    public void addBookingRequest(Reservation reservation) {
        reservationQueue.offer(reservation);
    }

    public void displayQueuedRequests() {
        System.out.println("Booking Requests in Queue:");
        System.out.println("----------------------------------------");

        if (reservationQueue.isEmpty()) {
            System.out.println("No booking requests available.");
            System.out.println("----------------------------------------");
            return;
        }

        int position = 1;
        for (Reservation reservation : reservationQueue) {
            System.out.println("Request Position : " + position);
            reservation.displayReservation();
            System.out.println("----------------------------------------");
            position++;
        }
    }

    public Reservation getNextBookingRequest() {
        return reservationQueue.poll();
    }

    public boolean isEmpty() {
        return reservationQueue.isEmpty();
    }

    public int getQueueSize() {
        return reservationQueue.size();
    }
}
