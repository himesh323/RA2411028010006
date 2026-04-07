/**
 * ==============================================================
 * MAIN CLASS - UseCase4PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 4: Character Array Based Palindrome Check
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by converting the string into a character array and
 * comparing characters using the two-pointer technique.
 */
public class UseCase4PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "madam";
        char[] chars = input.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Input text: " + input);
        System.out.println("Character array length: " + chars.length);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}
