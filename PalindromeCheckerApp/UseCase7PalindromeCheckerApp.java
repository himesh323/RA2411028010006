import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ==============================================================
 * MAIN CLASS - UseCase7PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 7: Deque-Based Optimized Palindrome Checker
 *
 * Description:
 * This class checks palindrome by storing characters in a deque
 * and comparing front and rear elements directly.
 */
public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "madam";
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear until deque has 0 or 1 element
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}
