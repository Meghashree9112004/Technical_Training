import java.util.*;

class ListNode {
    int val;
    ListNode next;

    // Constructor
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthNode {
    
    // Function to remove the nth node from end of list
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // Dummy node for edge cases
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove nth node from end
        second.next = second.next.next;

        return dummy.next;
    }

    // Function to create a linked list from user input
    public static ListNode createLinkedList(Scanner scanner) {
        System.out.print("Enter the number of elements in the linked list: ");
        int size = scanner.nextInt();
        
        if (size == 0) return null; // Edge case: empty list

        System.out.println("Enter the elements of the linked list:");
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        for (int i = 1; i < size; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }
        
        return head;
    }

    // Function to convert linked list to list format for printing
    public static List<Integer> linkedListToList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create linked list from user input
        ListNode head = createLinkedList(scanner);

        // Input n value
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        // Remove nth node from end
        head = removeNthFromEnd(head, n);

        // Print the output
        System.out.println("Output: " + linkedListToList(head));

        scanner.close();
    }
}
