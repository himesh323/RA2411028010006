/**
 * ==============================================================
 * MAIN CLASS - UseCase8PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 */
public class UseCase8PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        String input = "madam";
        Node head = buildLinkedList(input);

        boolean isPalindrome = isPalindrome(head);

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }

    private static Node buildLinkedList(String text) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < text.length(); i++) {
            Node node = new Node(text.charAt(i));
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

    private static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;
        Node secondIter = secondHalf;

        boolean result = true;
        while (secondIter != null) {
            if (firstHalf.data != secondIter.data) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondIter = secondIter.next;
        }

        // Optional restore
        slow.next = reverse(secondHalf);

        return result;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
