import java.util.ArrayList;

/**
 * UseCase2PassengerBogies - Demonstrates dynamic insertion and removal
 * of passenger bogies using ArrayList operations.
 *
 * @author SreesailamMouryaVeer
 * @version 2.0
 */
public class UseCase2PassengerBogies {
    public static void main(String[] args) {
        ArrayList<String> passengerBogies = new ArrayList<String>();

        System.out.println("==============================================");
        System.out.println("=== Train Consist Management App - UC2 =======");
        System.out.println("==============================================");

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Passenger bogies after insertion: " + passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("Passenger bogies after removing AC Chair: " + passengerBogies);

        boolean isSleeperAvailable = passengerBogies.contains("Sleeper");
        System.out.println("Does Sleeper bogie exist? " + isSleeperAvailable);

        System.out.println("Final passenger bogie list: " + passengerBogies);
        System.out.println("Program continues...");
    }
}
