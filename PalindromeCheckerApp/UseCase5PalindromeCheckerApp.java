import java.util.Stack;

/**
 * ==============================================================
 * MAIN CLASS - UseCase5PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 5: Stack-Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by pushing each character into a stack and then
 * popping to build the reversed string.
 */
public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "madam";
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Pop characters to create reversed text
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        boolean isPalindrome = input.equals(reversed);

        System.out.println("Input text: " + input);
        System.out.println("Reversed text using stack: " + reversed);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}
