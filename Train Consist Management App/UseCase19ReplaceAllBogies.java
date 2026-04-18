import java.util.ArrayList;

/**
 * UseCase19ReplaceAllBogies - Replaces all bogie names with uppercase values.
 */
public class UseCase19ReplaceAllBogies {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Pantry");

        bogies.replaceAll(String::toUpperCase);
        System.out.println("Updated bogies: " + bogies);
    }
}
