import java.util.ArrayList;

/**
 * UseCase12FirstAndLastBogie - Displays first and last bogie.
 */
public class UseCase12FirstAndLastBogie {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Pantry");
        bogies.add("Guard Van");

        System.out.println("First bogie: " + bogies.get(0));
        System.out.println("Last bogie: " + bogies.get(bogies.size() - 1));
    }
}
