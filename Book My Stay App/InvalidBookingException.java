/**
 * InvalidBookingException - Custom exception for invalid booking scenarios.
 * Used to report validation failures with clear domain-specific messages.
 *
 * @author SreesailamMouryaVeer
 * @version 9.0
 */
public class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}
