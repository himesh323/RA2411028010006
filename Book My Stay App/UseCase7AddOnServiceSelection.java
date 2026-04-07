/**
 * UseCase7AddOnServiceSelection - Demonstrates attaching optional services to a reservation.
 * Calculates additional cost without changing booking or inventory state.
 *
 * @author SreesailamMouryaVeer
 * @version 7.1
 */
public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        AddOnServiceManager addOnServiceManager = new AddOnServiceManager();
        String reservationId = "RES-1001";

        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 1200.0);
        AddOnService spaAccess = new AddOnService("Spa Access", 1500.0);

        addOnServiceManager.addServiceToReservation(reservationId, breakfast);
        addOnServiceManager.addServiceToReservation(reservationId, airportPickup);
        addOnServiceManager.addServiceToReservation(reservationId, spaAccess);

        System.out.println("========================================");
        System.out.println("      Book My Stay App - UC7            ");
        System.out.println("      Add-On Service Selection          ");
        System.out.println("========================================\n");

        addOnServiceManager.displayReservationServices(reservationId);

        System.out.println("Core booking and inventory state remain unchanged.");
        System.out.println("Application terminated successfully.");
    }
}
