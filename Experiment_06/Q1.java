import java.util.Scanner;

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
        

        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        

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
        

        public void delete(int key) {
            if (head == null) return;
            
            if (head.data == key) {
                head = head.next;
                return;
            }
            
            Node current = head;
            while (current.next != null && current.next.data != key) {
                current = current.next;
            }
            
            if (current.next != null) {
                current.next = current.next.next;
            }
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
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        
        System.out.println("Singly Linked List Operations:");
        System.out.println("1. Insert at Beginning");
        System.out.println("2. Insert at End");
        System.out.println("3. Delete");
        System.out.println("4. Search");
        System.out.println("5. Display");
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
                    System.out.print("Enter value to search: ");
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
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
