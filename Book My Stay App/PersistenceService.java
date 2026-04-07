import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * PersistenceService - Saves and restores booking and inventory state to a file.
 * Handles missing or corrupted persistence files gracefully.
 *
 * @author SreesailamMouryaVeer
 * @version 12.0
 */
public class PersistenceService {
    public void saveState(String fileName, RoomInventory roomInventory, BookingHistory bookingHistory) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            PersistenceData persistenceData = new PersistenceData(roomInventory, bookingHistory);
            outputStream.writeObject(persistenceData);
            System.out.println("System state saved successfully to " + fileName);
        } catch (IOException exception) {
            System.out.println("Failed to save system state: " + exception.getMessage());
        }
    }

    public PersistenceData loadState(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object storedObject = inputStream.readObject();
            if (storedObject instanceof PersistenceData) {
                System.out.println("System state loaded successfully from " + fileName);
                return (PersistenceData) storedObject;
            }
        } catch (IOException exception) {
            System.out.println("Persistence file unavailable or unreadable. Starting with safe default state.");
        } catch (ClassNotFoundException exception) {
            System.out.println("Persistence data is corrupted or incompatible. Starting with safe default state.");
        }

        return new PersistenceData(new RoomInventory(), new BookingHistory());
    }
}
