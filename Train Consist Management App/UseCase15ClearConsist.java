import java.util.ArrayList;

/**
 * UseCase15ClearConsist - Clears all bogies from the consist.
 */
public class UseCase15ClearConsist {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Pantry");

        System.out.println("Before clear: " + bogies);
        bogies.clear();
        System.out.println("After clear: " + bogies);
    }
}
