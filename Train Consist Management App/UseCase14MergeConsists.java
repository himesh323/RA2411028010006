import java.util.ArrayList;

/**
 * UseCase14MergeConsists - Merges two train consists.
 */
public class UseCase14MergeConsists {
    public static void main(String[] args) {
        ArrayList<String> consistA = new ArrayList<>();
        ArrayList<String> consistB = new ArrayList<>();

        consistA.add("Engine");
        consistA.add("Sleeper");

        consistB.add("Pantry");
        consistB.add("Guard Van");

        consistA.addAll(consistB);
        System.out.println("Merged consist: " + consistA);
    }
}
