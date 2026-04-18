import java.util.ArrayList;
import java.util.HashSet;

/**
 * UseCase13DuplicateBogiesCheck - Checks duplicate bogie names.
 */
public class UseCase13DuplicateBogiesCheck {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("General");
        bogies.add("Sleeper");

        boolean hasDuplicates = bogies.size() != new HashSet<>(bogies).size();
        System.out.println("Contains duplicate bogies: " + hasDuplicates);
    }
}
