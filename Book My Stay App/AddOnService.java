/**
 * AddOnService - Represents an optional service attached to a reservation.
 * Stores the service name and its additional cost.
 *
 * @author SreesailamMouryaVeer
 * @version 7.0
 */
public class AddOnService {
    private String serviceName;
    private double serviceCost;

    public AddOnService(String serviceName, double serviceCost) {
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void displayServiceDetails() {
        System.out.println("Service Name : " + serviceName);
        System.out.println("Service Cost : Rs. " + serviceCost);
    }
}
