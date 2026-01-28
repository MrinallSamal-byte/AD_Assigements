import java.util.Scanner;

public class Q7 {
    // Objective: Find the middle element of a linked list
    
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
        
        // Find middle using slow and fast pointers
        public int findMiddle() {
            if (head == null) {
                return -1;
            }
            
            Node slow = head;
            Node fast = head;
            
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            
            return slow.data;
        }
        
        // Find middle by counting
        public int findMiddleByCount() {
            if (head == null) {
                return -1;
            }
            
            int count = 0;
            Node temp = head;
            
            // Count nodes
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            
            // Find middle
            temp = head;
            for (int i = 0; i < count / 2; i++) {
                temp = temp.next;
            }
            
            return temp.data;
        }
        
        // Display the list
        public void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("NULL");
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
        
        System.out.print("Linked list: ");
        list.display();
        
        int middle = list.findMiddle();
        if (middle != -1) {
            System.out.println("Middle element: " + middle);
        } else {
            System.out.println("List is empty");
        }
        
        sc.close();
    }
}
