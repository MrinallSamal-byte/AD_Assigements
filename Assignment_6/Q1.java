import java.util.Scanner;
import java.util.InputMismatchException;

public class Q1 {

    

    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class SinglyLinkedList {
        Node head;
        Node tail;  // Optimization: O(1) insertAtEnd instead of O(n)
        
        /**
         * Insert at beginning - O(1) time complexity
         */
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            
            // Update tail if list was empty
            if (tail == null) {
                tail = newNode;
            }
        }
        
        /**
         * Optimized insert at end - O(1) with tail pointer instead of O(n)
         */
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            
            // O(1) operation with tail pointer
            tail.next = newNode;
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
            
            // Delete head node
            if (head.data == key) {
                head = head.next;
                if (head == null) {
                    tail = null;  // List is now empty
                }
                return;
            }
            
            Node current = head;
            while (current.next != null && current.next.data != key) {
                current = current.next;
            }
            
            if (current.next != null) {
                // Update tail if deleting last node
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
            } else {
                System.out.println("Element not found");
            }
        }
        
        /**
         * Display all nodes - O(n) time complexity
         */
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
        
        /**
         * Search for element - O(n) time complexity
         */
        public boolean search(int key) {
            Node current = head;
            while (current != null) {
                if (current.data == key) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            SinglyLinkedList list = new SinglyLinkedList();
            
            System.out.println("Singly Linked List Operations:");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Display");
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
                            System.out.print("Enter value to search: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number.");
                                sc.next();
                                break;
                            }
                            int searchVal = sc.nextInt();
                            if (list.search(searchVal)) {
                                System.out.println("Element found");
                            } else {
                                System.out.println("Element not found");
                            }
                            break;
                            
                        case 5:
                            list.display();
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
