import java.util.ArrayList;
import java.util.Collections;

/**
 * UseCase7SortBogies - Sorts bogie names alphabetically.
 */
public class UseCase7SortBogies {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("General");
        bogies.add("Pantry");

        System.out.println("Before sorting: " + bogies);
        Collections.sort(bogies);
        System.out.println("After sorting: " + bogies);
    }
}
