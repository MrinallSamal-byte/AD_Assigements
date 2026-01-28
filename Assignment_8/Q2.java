import java.util.Scanner;

public class Q2 {

    
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class Queue {
        private Node front;
        private Node rear;
        private int size;
        
        public Queue() {
            front = null;
            rear = null;
            size = 0;
        }
        

        public void enqueue(int value) {
            Node newNode = new Node(value);
            
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            
            size++;
            System.out.println("Enqueued: " + value);
        }
        

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow! Cannot dequeue");
                return -1;
            }
            
            int value = front.data;
            front = front.next;
            
            if (front == null) {
                rear = null;
            }
            
            size--;
            return value;
        }
        

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }
        

        public boolean isEmpty() {
            return (front == null);
        }
        

        public int size() {
            return size;
        }
        

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            
            System.out.print("Queue: ");
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        
        System.out.println("Queue Operations (Linked List):");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek");
        System.out.println("4. Display");
        System.out.println("5. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                    break;
                    
                case 2:
                    int dequeued = queue.dequeue();
                    if (dequeued != -1) {
                        System.out.println("Dequeued: " + dequeued);
                    }
                    break;
                    
                case 3:
                    int front = queue.peek();
                    if (front != -1) {
                        System.out.println("Front element: " + front);
                    }
                    break;
                    
                case 4:
                    queue.display();
                    break;
                    
                case 5:
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
