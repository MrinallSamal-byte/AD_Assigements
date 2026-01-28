import java.util.Scanner;

public class Q1 {
    // Objective: Implement Stack using Array
    
    static class Stack {
        private int maxSize;
        private int[] stackArray;
        private int top;
        
        public Stack(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;
        }
        
        // Push element onto stack
        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack Overflow! Cannot push " + value);
                return;
            }
            stackArray[++top] = value;
            System.out.println("Pushed: " + value);
        }
        
        // Pop element from stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop");
                return -1;
            }
            return stackArray[top--];
        }
        
        // Peek top element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return stackArray[top];
        }
        
        // Check if stack is empty
        public boolean isEmpty() {
            return (top == -1);
        }
        
        // Check if stack is full
        public boolean isFull() {
            return (top == maxSize - 1);
        }
        
        // Display stack
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println("(Top: " + stackArray[top] + ")");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();
        Stack stack = new Stack(size);
        
        System.out.println("\nStack Operations:");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Display");
        System.out.println("5. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                    
                case 2:
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped: " + popped);
                    }
                    break;
                    
                case 3:
                    int top = stack.peek();
                    if (top != -1) {
                        System.out.println("Top element: " + top);
                    }
                    break;
                    
                case 4:
                    stack.display();
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
