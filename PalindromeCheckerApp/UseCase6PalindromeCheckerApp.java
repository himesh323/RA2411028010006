import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ==============================================================
 * MAIN CLASS - UseCase6PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 6: Queue + Stack Based Palindrome Check
 *
 * Description:
 * This class validates palindrome logic by comparing
 * FIFO behavior (Queue) with LIFO behavior (Stack).
 */
public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "madam";

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Insert characters into both queue and stack
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            queue.offer(ch);   // enqueue
            stack.push(ch);    // push
        }

        boolean isPalindrome = true;

        // Compare dequeue (front) with pop (rear)
        while (!queue.isEmpty() && !stack.isEmpty()) {
            char fromQueue = queue.poll();
            char fromStack = stack.pop();

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}
