import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * RoomInventory - Centralized inventory manager for room availability.
 * Uses a HashMap as the single source of truth for room counts.
 *
 * @author SreesailamMouryaVeer
 * @version 3.0
 */
public class RoomInventory implements Serializable {
    private Map<String, Integer> availabilityMap;

    public RoomInventory() {
        availabilityMap = new HashMap<>();
        availabilityMap.put("Single Room", 5);
        availabilityMap.put("Double Room", 3);
        availabilityMap.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        Integer count = availabilityMap.get(roomType);
        return count != null ? count : 0;
    }

    public void updateAvailability(String roomType, int newCount) {
        if (newCount >= 0) {
            availabilityMap.put(roomType, newCount);
        }
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : availabilityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " rooms available");
        }
    }
}
