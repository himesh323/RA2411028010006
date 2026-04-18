import java.util.ArrayList;

/**
 * UseCase16CheckEmptyConsist - Checks whether the consist is empty.
 */
public class UseCase16CheckEmptyConsist {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        System.out.println("Is train consist empty? " + bogies.isEmpty());

        bogies.add("Engine");
        System.out.println("Is train consist empty after adding a bogie? " + bogies.isEmpty());
    }
}
