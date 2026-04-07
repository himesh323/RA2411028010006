import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * ==============================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 */
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "madam";

        // Inject strategy at runtime
        PalindromeStrategy strategy = new StackStrategy();
        PalindromeService service = new PalindromeService(strategy);

        boolean stackResult = service.checkPalindrome(input);

        // Change strategy dynamically
        service.setStrategy(new DequeStrategy());
        boolean dequeResult = service.checkPalindrome(input);

        System.out.println("Input text: " + input);
        System.out.println("StackStrategy result: " + stackResult);
        System.out.println("DequeStrategy result: " + dequeResult);
    }
}

/** Strategy interface */
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

/** Context/service class */
class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        if (strategy == null || input == null) {
            return false;
        }
        return strategy.isPalindrome(input);
    }
}

/** Stack-based strategy (LIFO) */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/** Deque-based strategy (front/rear compare) */
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}
