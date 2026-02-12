import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Q1 {

    /**
     * Circular Queue implementation using array
     * Efficient implementation with circular indexing
     */
    static class Queue {
        private int maxSize;
        private int[] queueArray;
        private int front;
        private int rear;
        private int currentSize;
        
        public Queue(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Queue size must be positive");
            }
            maxSize = size;
            queueArray = new int[maxSize];
            front = 0;
            rear = -1;
            currentSize = 0;
        }
        
        /**
         * Enqueue element - O(1) time complexity
         */
        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue Overflow! Cannot enqueue " + value);
                return;
            }
            rear = (rear + 1) % maxSize;  // Circular increment
            queueArray[rear] = value;
            currentSize++;
            System.out.println("Enqueued: " + value);
        }
        
        /**
         * Dequeue element - O(1) time complexity
         * @throws NoSuchElementException if queue is empty
         */
        public int dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue Underflow! Cannot dequeue from empty queue");
            }
            int value = queueArray[front];
            front = (front + 1) % maxSize;  // Circular increment
            currentSize--;
            return value;
        }
        
        /**
         * Peek at front element - O(1) time complexity
         * @throws NoSuchElementException if queue is empty
         */
        public int peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return queueArray[front];
        }
        
        /**
         * Check if queue is empty - O(1)
         */
        public boolean isEmpty() {
            return (currentSize == 0);
        }
        
        /**
         * Check if queue is full - O(1)
         */
        public boolean isFull() {
            return (currentSize == maxSize);
        }
        
        /**
         * Display all queue elements - O(n)
         */
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            
            System.out.print("Queue (front to rear): ");
            int count = 0;
            int index = front;
            while (count < currentSize) {
                System.out.print(queueArray[index] + " ");
                index = (index + 1) % maxSize;
                count++;
            }
            System.out.println();
        }
        
        /**
         * Get current size of queue
         */
        public int size() {
            return currentSize;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            
            System.out.print("Enter queue size: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int size = sc.nextInt();
            
            if (size <= 0) {
                System.out.println("Error: Queue size must be positive.");
                return;
            }
            
            Queue queue = new Queue(size);
            
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            
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
                            System.out.print("Enter value to enqueue: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number.");
                                sc.next();
                                break;
                            }
                            int value = sc.nextInt();
                            queue.enqueue(value);
                            break;
                            
                        case 2:
                            try {
                                int dequeued = queue.dequeue();
                                System.out.println("Dequeued: " + dequeued);
                            } catch (NoSuchElementException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                            
                        case 3:
                            try {
                                int frontElement = queue.peek();
                                System.out.println("Front element: " + frontElement);
                            } catch (NoSuchElementException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                            
                        case 4:
                            queue.display();
                            break;
                            
                        case 5:
                            running = false;
                            break;
                            
                        default:
                            System.out.println("Invalid choice. Please enter 1-5.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input format");
                    sc.next(); // Clear the invalid input
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
