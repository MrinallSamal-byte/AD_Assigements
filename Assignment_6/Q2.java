import java.util.Scanner;
import java.util.InputMismatchException;

public class Q2 {

    

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
        Node tail;  // Optimization: O(1) insertAtEnd and displayBackward
        
        /**
         * Insert at beginning - O(1) time complexity
         */
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            
            if (head == null) {
                head = tail = newNode;
                return;
            }
            
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        
        /**
         * Optimized insert at end - O(1) with tail pointer instead of O(n)
         */
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            
            if (head == null) {
                head = tail = newNode;
                return;
            }
            
            // O(1) operation with tail pointer
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        /**
         * Delete node by value - O(n) time complexity
         */
        public void delete(int key) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            
            Node current = head;
            
            // Find the node to delete
            while (current != null && current.data != key) {
                current = current.next;
            }
            
            if (current == null) {
                System.out.println("Element not found");
                return;
            }
            
            // Update head if deleting first node
            if (current == head) {
                head = current.next;
            }
            
            // Update tail if deleting last node
            if (current == tail) {
                tail = current.prev;
            }
            
            // Update next node's prev pointer
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            
            // Update previous node's next pointer
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            
            System.out.println("Element " + key + " deleted");
        }
        
        /**
         * Display all nodes forward - O(n) time complexity
         */
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
        
        /**
         * Optimized display backward - O(n) using tail pointer
         * No need to traverse to end first
         */
        public void displayBackward() {
            if (tail == null) {
                System.out.println("List is empty");
                return;
            }
            
            Node current = tail;
            System.out.print("Backward: NULL <-> ");
            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.prev;
            }
            System.out.println("NULL");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            DoublyLinkedList list = new DoublyLinkedList();
            
            System.out.println("Doubly Linked List Operations:");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete");
            System.out.println("4. Display Forward");
            System.out.println("5. Display Backward");
            System.out.println("6. Exit");
            
            boolean running = true;
            while (running) {
                try {
                    System.out.print("\nEnter your choice: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next(); // Clear invalid input
                        continue;
                    }
                    int choice = sc.nextInt();
                    
                    switch (choice) {
                        case 1:
                            System.out.print("Enter value: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number.");
                                sc.next();
                                break;
                            }
                            int val1 = sc.nextInt();
                            list.insertAtBeginning(val1);
                            System.out.println("Element inserted at beginning");
                            break;
                            
                        case 2:
                            System.out.print("Enter value: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number.");
                                sc.next();
                                break;
                            }
                            int val2 = sc.nextInt();
                            list.insertAtEnd(val2);
                            System.out.println("Element inserted at end");
                            break;
                            
                        case 3:
                            System.out.print("Enter value to delete: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number.");
                                sc.next();
                                break;
                            }
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
                            running = false;
                            break;
                            
                        default:
                            System.out.println("Invalid choice. Please enter 1-6.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input format");
                    sc.next(); // Clear the invalid input
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
