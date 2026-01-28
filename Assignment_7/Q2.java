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
    
    static class Stack {
        private Node top;
        
        public Stack() {
            top = null;
        }
        

        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
            System.out.println("Pushed: " + value);
        }
        

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop");
                return -1;
            }
            int value = top.data;
            top = top.next;
            return value;
        }
        

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return top.data;
        }
        

        public boolean isEmpty() {
            return (top == null);
        }
        

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            
            System.out.print("Stack (Top to Bottom): ");
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("NULL");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        
        System.out.println("Stack Operations (Linked List):");
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
