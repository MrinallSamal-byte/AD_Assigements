import java.util.Scanner;

public class Q7 {

    

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
        

        public int findMiddleByCount() {
            if (head == null) {
                return -1;
            }
            
            int count = 0;
            Node temp = head;
            

            while (temp != null) {
                count++;
                temp = temp.next;
            }
            

            temp = head;
            for (int i = 0; i < count / 2; i++) {
                temp = temp.next;
            }
            
            return temp.data;
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
