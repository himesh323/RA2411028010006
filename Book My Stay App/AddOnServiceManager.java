import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AddOnServiceManager - Manages optional services selected for reservations.
 * Uses a reservation-to-services mapping and calculates total service cost.
 *
 * @author SreesailamMouryaVeer
 * @version 7.0
 */
public class AddOnServiceManager {
    private Map<String, List<AddOnService>> reservationServicesMap;

    public AddOnServiceManager() {
        reservationServicesMap = new HashMap<>();
    }

    public void addServiceToReservation(String reservationId, AddOnService addOnService) {
        reservationServicesMap.computeIfAbsent(reservationId, key -> new ArrayList<>()).add(addOnService);
    }

    public List<AddOnService> getServicesForReservation(String reservationId) {
        return reservationServicesMap.getOrDefault(reservationId, new ArrayList<AddOnService>());
    }

    public double calculateTotalAdditionalCost(String reservationId) {
        double totalCost = 0.0;
        List<AddOnService> services = getServicesForReservation(reservationId);

        for (AddOnService service : services) {
            totalCost += service.getServiceCost();
        }

        return totalCost;
    }

    public void displayReservationServices(String reservationId) {
        List<AddOnService> services = getServicesForReservation(reservationId);

        System.out.println("Reservation ID : " + reservationId);
        System.out.println("Selected Add-On Services:");
        System.out.println("----------------------------------------");

        if (services.isEmpty()) {
            System.out.println("No add-on services selected.");
            System.out.println("----------------------------------------");
            return;
        }

        for (AddOnService service : services) {
            service.displayServiceDetails();
            System.out.println("----------------------------------------");
        }

        System.out.println("Total Additional Cost : Rs. " + calculateTotalAdditionalCost(reservationId));
    }
}
