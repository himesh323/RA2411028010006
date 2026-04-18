import java.util.ArrayList;
import java.util.Collections;

/**
 * UseCase6ReverseConsist - Reverses the order of bogies.
 */
public class UseCase6ReverseConsist {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("General");
        bogies.add("Guard Van");

        System.out.println("Before reverse: " + bogies);
        Collections.reverse(bogies);
        System.out.println("After reverse: " + bogies);
    }
}
