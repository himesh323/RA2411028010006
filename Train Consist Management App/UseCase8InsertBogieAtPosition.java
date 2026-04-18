import java.util.ArrayList;

/**
 * UseCase8InsertBogieAtPosition - Inserts a bogie at a specific index.
 */
public class UseCase8InsertBogieAtPosition {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Guard Van");

        bogies.add(2, "Pantry");
        System.out.println("Bogies after insertion: " + bogies);
    }
}
