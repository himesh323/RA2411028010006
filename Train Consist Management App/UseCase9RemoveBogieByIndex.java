import java.util.ArrayList;

/**
 * UseCase9RemoveBogieByIndex - Removes a bogie by index.
 */
public class UseCase9RemoveBogieByIndex {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Pantry");
        bogies.add("Guard Van");

        System.out.println("Before removal: " + bogies);
        bogies.remove(2);
        System.out.println("After removal: " + bogies);
    }
}
