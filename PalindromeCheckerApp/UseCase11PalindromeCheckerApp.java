/**
 * ==============================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * Encapsulates palindrome logic inside a dedicated service class
 * and exposes checkPalindrome() as the public API.
 */
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "madam";

        PalindromeChecker checker = new PalindromeChecker();
        boolean isPalindrome = checker.checkPalindrome(input);

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}

/**
 * Encapsulated palindrome service class.
 * Single Responsibility: validate palindrome.
 */
class PalindromeChecker {

    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }

        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
