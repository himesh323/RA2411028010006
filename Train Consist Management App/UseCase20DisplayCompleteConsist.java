import java.util.ArrayList;

/**
 * UseCase20DisplayCompleteConsist - Displays the complete train consist summary.
 */
public class UseCase20DisplayCompleteConsist {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("Pantry");
        bogies.add("Guard Van");

        System.out.println("Complete train consist: " + bogies);
        System.out.println("Total number of bogies: " + bogies.size());
    }
}
