import java.util.Scanner;

public class Q5 {
    // Objective: Detect cycle in a Linked List (Floyd's Cycle Detection)
    
    // Node class
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class LinkedList {
        Node head;
        
        // Insert at end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            
            if (head == null) {
                head = newNode;
                return;
            }
            
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        
        // Create a cycle for testing
        public void createCycle(int pos) {
            if (head == null || pos < 0) return;
            
            Node tail = head;
            Node cycleNode = null;
            int count = 0;
            
            while (tail.next != null) {
                if (count == pos) {
                    cycleNode = tail;
                }
                tail = tail.next;
                count++;
            }
            
            if (count == pos) {
                cycleNode = tail;
            }
            
            if (cycleNode != null) {
                tail.next = cycleNode;
            }
        }
        
        // Floyd's Cycle Detection Algorithm
        public boolean detectCycle() {
            if (head == null) {
                return false;
            }
            
            Node slow = head;
            Node fast = head;
            
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                
                if (slow == fast) {
                    return true;
                }
            }
            
            return false;
        }
        
        // Display the list (without cycle)
        public void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            
            Node current = head;
            int count = 0;
            while (current != null && count < 20) {
                System.out.print(current.data + " -> ");
                current = current.next;
                count++;
            }
            System.out.println(count >= 20 ? "..." : "NULL");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.insertAtEnd(val);
        }
        
        System.out.print("Create a cycle? (1=Yes, 0=No): ");
        int createCycle = sc.nextInt();
        
        if (createCycle == 1) {
            System.out.print("Enter position to create cycle (0 to " + (n-1) + "): ");
            int pos = sc.nextInt();
            list.createCycle(pos);
        }
        
        if (list.detectCycle()) {
            System.out.println("Cycle detected in the linked list");
        } else {
            System.out.println("No cycle detected in the linked list");
        }
        
        sc.close();
    }
}
