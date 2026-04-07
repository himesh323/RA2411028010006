/**
 * ==============================================================
 * MAIN CLASS - UseCase9PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 9: Recursive Palindrome Checker
 */
public class UseCase9PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "madam";
        boolean isPalindrome = isPalindromeRecursive(input, 0, input.length() - 1);

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        // Base condition
        if (left >= right) {
            return true;
        }

        // Mismatch condition
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        // Recursive call moving inward
        return isPalindromeRecursive(text, left + 1, right - 1);
    }
}
