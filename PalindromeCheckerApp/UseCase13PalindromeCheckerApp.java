public class UseCase13PalindromeCheckerApp {

    // Approach 1: Using StringBuilder reverse
    static boolean reverseMethod(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    // Approach 2: Two-pointer technique
    static boolean twoPointerMethod(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Approach 3: Recursive method
    static boolean recursiveMethod(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return recursiveMethod(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String[] testCases = {"racecar", "hello", "A man a plan a canal Panama", "madam", "world"};

        System.out.println("=== UC13: Performance Comparison ===\n");
        System.out.printf("%-35s %-15s %-15s %-15s%n", "Input", "Reverse(ns)", "TwoPointer(ns)", "Recursive(ns)");
        System.out.println("-".repeat(80));

        for (String input : testCases) {
            String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            // Measure Reverse Method
            long start1 = System.nanoTime();
            boolean r1 = reverseMethod(input);
            long time1 = System.nanoTime() - start1;

            // Measure Two-Pointer Method
            long start2 = System.nanoTime();
            boolean r2 = twoPointerMethod(input);
            long time2 = System.nanoTime() - start2;

            // Measure Recursive Method
            long start3 = System.nanoTime();
            boolean r3 = recursiveMethod(cleaned, 0, cleaned.length() - 1);
            long time3 = System.nanoTime() - start3;

            System.out.printf("%-35s %-15d %-15d %-15d%n", input, time1, time2, time3);
        }

        System.out.println("\n✔ Performance comparison complete.");
    }
}
