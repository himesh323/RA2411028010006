import java.util.ArrayList;

/**
 * UseCase11IterateBogies - Iterates through all bogies.
 */
public class UseCase11IterateBogies {
    public static void main(String[] args) {
        ArrayList<String> bogies = new ArrayList<>();
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Pantry");
        bogies.add("Guard Van");

        System.out.println("Train consist bogies:");
        for (String bogie : bogies) {
            System.out.println(bogie);
        }
    }
}
