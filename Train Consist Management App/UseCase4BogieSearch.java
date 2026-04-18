import java.util.ArrayList;

/**
 * UseCase4BogieSearch - Searches for a bogie in the consist.
 */
public class UseCase4BogieSearch {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("General");
        bogies.add("Pantry");

        String searchBogie = "Pantry";
        if (bogies.contains(searchBogie)) {
            System.out.println(searchBogie + " bogie found in the consist.");
        } else {
            System.out.println(searchBogie + " bogie not found.");
        }
    }
}
