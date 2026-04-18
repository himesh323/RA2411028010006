import java.util.ArrayList;

/**
 * UseCase10UpdateBogie - Updates a bogie name in the consist.
 */
public class UseCase10UpdateBogie {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("General");
        bogies.add("Chair Car");

        System.out.println("Before update: " + bogies);
        bogies.set(1, "AC Chair");
        System.out.println("After update: " + bogies);
    }
}
