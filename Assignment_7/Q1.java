import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Q1 {

    
    static class Stack {
        private int maxSize;
        private int[] stackArray;
        private int top;
        
        public Stack(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Stack size must be positive");
            }
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;
        }
        
        /**
         * Push element onto stack - O(1) time complexity
         */
        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack Overflow! Cannot push " + value);
                return;
            }
            stackArray[++top] = value;
            System.out.println("Pushed: " + value);
        }
        
        /**
         * Pop element from stack - O(1) time complexity
         * @throws NoSuchElementException if stack is empty
         */
        public int pop() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack Underflow! Cannot pop from empty stack");
            }
            return stackArray[top--];
        }
        
        /**
         * Peek at top element without removing - O(1) time complexity
         * @throws NoSuchElementException if stack is empty
         */
        public int peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return stackArray[top];
        }
        
        /**
         * Check if stack is empty - O(1) time complexity
         */
        public boolean isEmpty() {
            return (top == -1);
        }
        
        /**
         * Check if stack is full - O(1) time complexity
         */
        public boolean isFull() {
            return (top == maxSize - 1);
        }
        
        /**
         * Display all stack elements - O(n) time complexity
         */
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            
            System.out.print("Stack (bottom to top): ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println("← Top");
        }
        
        /**
         * Get current size of stack
         */
        public int size() {
            return top + 1;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            
            System.out.print("Enter stack size: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int size = sc.nextInt();
            
            if (size <= 0) {
                System.out.println("Error: Stack size must be positive.");
                return;
            }
            
            Stack stack = new Stack(size);
            
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
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
                            System.out.print("Enter value to push: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number.");
                                sc.next();
                                break;
                            }
                            int value = sc.nextInt();
                            stack.push(value);
                            break;
                            
                        case 2:
                            try {
                                int popped = stack.pop();
                                System.out.println("Popped: " + popped);
                            } catch (NoSuchElementException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                            
                        case 3:
                            try {
                                int topElement = stack.peek();
                                System.out.println("Top element: " + topElement);
                            } catch (NoSuchElementException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                            
                        case 4:
                            stack.display();
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
