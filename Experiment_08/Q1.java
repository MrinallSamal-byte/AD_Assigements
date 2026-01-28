import java.util.Scanner;

public class Q1 {

    
    static class Queue {
        private int maxSize;
        private int[] queueArray;
        private int front;
        private int rear;
        private int currentSize;
        
        public Queue(int size) {
            maxSize = size;
            queueArray = new int[maxSize];
            front = 0;
            rear = -1;
            currentSize = 0;
        }
        

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue Overflow! Cannot enqueue " + value);
                return;
            }
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            currentSize++;
            System.out.println("Enqueued: " + value);
        }
        

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow! Cannot dequeue");
                return -1;
            }
            int value = queueArray[front];
            front = (front + 1) % maxSize;
            currentSize--;
            return value;
        }
        

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return queueArray[front];
        }
        

        public boolean isEmpty() {
            return (currentSize == 0);
        }
        

        public boolean isFull() {
            return (currentSize == maxSize);
        }
        

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            
            System.out.print("Queue: ");
            int count = 0;
            int index = front;
            while (count < currentSize) {
                System.out.print(queueArray[index] + " ");
                index = (index + 1) % maxSize;
                count++;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter queue size: ");
        int size = sc.nextInt();
        Queue queue = new Queue(size);
        
        System.out.println("\nQueue Operations:");
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
