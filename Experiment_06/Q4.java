import java.util.Scanner;

public class Q4 {

    

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
        

        public void reverseIterative() {
            Node prev = null;
            Node current = head;
            Node next = null;
            
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
        

        public Node reverseRecursive(Node node) {
            if (node == null || node.next == null) {
                return node;
            }
            
            Node rest = reverseRecursive(node.next);
            node.next.next = node;
            node.next = null;
            
            return rest;
        }
        
        public void reverseRecursiveWrapper() {
            head = reverseRecursive(head);
        }
        

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
        
        System.out.print("Original list: ");
        list.display();
        
        System.out.println("\n1. Reverse Iteratively");
        System.out.println("2. Reverse Recursively");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        
        if (choice == 1) {
            list.reverseIterative();
        } else if (choice == 2) {
            list.reverseRecursiveWrapper();
        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }
        
        System.out.print("Reversed list: ");
        list.display();
        
        sc.close();
    }
}
