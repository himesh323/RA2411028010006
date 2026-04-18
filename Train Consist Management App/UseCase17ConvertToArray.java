import java.util.ArrayList;
import java.util.Arrays;

/**
 * UseCase17ConvertToArray - Converts bogie list to array.
 */
public class UseCase17ConvertToArray {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Pantry");

        String[] bogieArray = bogies.toArray(new String[0]);
        System.out.println("Bogie array: " + Arrays.toString(bogieArray));
    }
}
