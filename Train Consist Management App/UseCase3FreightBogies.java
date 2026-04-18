import java.util.ArrayList;

/**
 * UseCase3FreightBogies - Manages freight bogies in the train consist.
 */
public class UseCase3FreightBogies {
    public static void main(String[] args) {
        ArrayList<String> freightBogies = new ArrayList<>();

        freightBogies.add("Coal Wagon");
        freightBogies.add("Container Wagon");
        freightBogies.add("Oil Tanker");

        System.out.println("Freight bogies: " + freightBogies);
        freightBogies.remove("Oil Tanker");
        System.out.println("After removal: " + freightBogies);
    }
}
