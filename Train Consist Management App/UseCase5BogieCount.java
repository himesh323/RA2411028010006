import java.util.ArrayList;

/**
 * UseCase5BogieCount - Counts total bogies in the consist.
 */
public class UseCase5BogieCount {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("General");
        bogies.add("AC Chair");
        bogies.add("Pantry");

        System.out.println("Total bogies in consist: " + bogies.size());
    }
}
