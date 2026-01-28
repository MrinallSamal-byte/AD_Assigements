import java.util.Scanner;

public class Q6 {
    // Objective: Merge two sorted linked lists
    
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
    
    // Function to merge two sorted lists
    public static Node mergeSortedLists(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        Node merged;
        
        if (head1.data <= head2.data) {
            merged = head1;
            merged.next = mergeSortedLists(head1.next, head2);
        } else {
            merged = head2;
            merged.next = mergeSortedLists(head1, head2.next);
        }
        
        return merged;
    }
    
    // Iterative approach to merge
    public static Node mergeSortedListsIterative(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        Node dummy = new Node(0);
        Node current = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        
        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        
        System.out.print("Enter number of elements in first list: ");
        int n1 = sc.nextInt();
        System.out.println("Enter " + n1 + " sorted elements:");
        for (int i = 0; i < n1; i++) {
            list1.insertAtEnd(sc.nextInt());
        }
        
        System.out.print("Enter number of elements in second list: ");
        int n2 = sc.nextInt();
        System.out.println("Enter " + n2 + " sorted elements:");
        for (int i = 0; i < n2; i++) {
            list2.insertAtEnd(sc.nextInt());
        }
        
        System.out.print("List 1: ");
        list1.display();
        System.out.print("List 2: ");
        list2.display();
        
        LinkedList merged = new LinkedList();
        merged.head = mergeSortedLists(list1.head, list2.head);
        
        System.out.print("Merged list: ");
        merged.display();
        
        sc.close();
    }
}
