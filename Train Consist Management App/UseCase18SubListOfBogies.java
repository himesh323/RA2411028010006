import java.util.ArrayList;
import java.util.List;

/**
 * UseCase18SubListOfBogies - Creates a sublist from the consist.
 */
public class UseCase18SubListOfBogies {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("Pantry");
        bogies.add("Guard Van");

        List<String> middleBogies = bogies.subList(1, 4);
        System.out.println("Sublist of bogies: " + middleBogies);
    }
}
