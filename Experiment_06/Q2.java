import java.util.Scanner;

public class Q2 {
    // Objective: Implement Doubly Linked List operations
    
    // Node class
    static class Node {
        int data;
        Node prev;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    static class DoublyLinkedList {
        Node head;
        
        // Insert at beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            
            if (head != null) {
                head.prev = newNode;
            }
            newNode.next = head;
            head = newNode;
        }
        
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
            newNode.prev = current;
        }
        
        // Delete a node by value
        public void delete(int key) {
            if (head == null) return;
            
            Node current = head;
            
            // Find the node to delete
            while (current != null && current.data != key) {
                current = current.next;
            }
            
            if (current == null) return;
            
            // If node to delete is head
            if (current == head) {
                head = current.next;
            }
            
            // Change next only if not last node
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            
            // Change prev only if not first node
            if (current.prev != null) {
                current.prev.next = current.next;
            }
        }
        
        // Display forward
        public void displayForward() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            
            Node current = head;
            System.out.print("Forward: NULL <-> ");
            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.next;
            }
            System.out.println("NULL");
        }
        
        // Display backward
        public void displayBackward() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            
            System.out.print("Backward: NULL <-> ");
            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.prev;
            }
            System.out.println("NULL");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        
        System.out.println("Doubly Linked List Operations:");
        System.out.println("1. Insert at Beginning");
        System.out.println("2. Insert at End");
        System.out.println("3. Delete");
        System.out.println("4. Display Forward");
        System.out.println("5. Display Backward");
        System.out.println("6. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int val1 = sc.nextInt();
                    list.insertAtBeginning(val1);
                    break;
                    
                case 2:
                    System.out.print("Enter value: ");
                    int val2 = sc.nextInt();
                    list.insertAtEnd(val2);
                    break;
                    
                case 3:
                    System.out.print("Enter value to delete: ");
                    int delVal = sc.nextInt();
                    list.delete(delVal);
                    break;
                    
                case 4:
                    list.displayForward();
                    break;
                    
                case 5:
                    list.displayBackward();
                    break;
                    
                case 6:
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
