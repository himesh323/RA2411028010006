/**
 * ==============================================================
 * MAIN CLASS - UseCase2PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 2: Hardcoded Palindrome Validation
 *
 * Description:
 * This class demonstrates basic palindrome validation
 * using a hardcoded string value.
 *
 * At this stage, the application:
 * - Stores a predefined string
 * - Compares characters from both ends
 * - Determines whether the string is a palindrome
 * - Displays the result on the console
 */
public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {
        String inputText = "madam";
        boolean isPalindrome = true;

        int left = 0;
        int right = inputText.length() - 1;

        while (left < right) {
            if (inputText.charAt(left) != inputText.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Input text: " + inputText);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}
