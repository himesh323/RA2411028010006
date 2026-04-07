import java.util.ArrayList;
import java.util.List;

/**
 * UseCase1TrainConsistApp - Initializes the Train Consist Management App
 * and displays the initial train consist summary.
 *
 * @author SreesailamMouryaVeer
 * @version 1.0
 */
public class UseCase1TrainConsistApp {
    public static void main(String[] args) {
        List<String> trainConsist = new ArrayList<>();

        System.out.println("====================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("====================================");
        System.out.println("Train consist initialized successfully.");
        System.out.println("Initial bogie count: " + trainConsist.size());
        System.out.println("Program continues...");
    }
}
