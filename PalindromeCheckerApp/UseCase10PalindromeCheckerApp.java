/**
 * ==============================================================
 * MAIN CLASS - UseCase10PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 10: Case-Insensitive & Space-Ignored Palindrome
 */
public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "Never Odd Or Even";

        // Normalize: remove spaces and convert to lower case
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = isPalindrome(normalized);

        System.out.println("Input text: " + input);
        System.out.println("Normalized text: " + normalized);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }

    private static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
