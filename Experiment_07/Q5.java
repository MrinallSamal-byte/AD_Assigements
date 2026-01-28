import java.util.Scanner;
import java.util.Stack;

public class Q5 {
    // Objective: Reverse a stack using recursion
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        
        System.out.print("Stack before reversing: ");
        displayStack(stack);
        
        reverseStack(stack);
        
        System.out.print("Stack after reversing: ");
        displayStack(stack);
        
        sc.close();
    }
    
    // Function to reverse stack
    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove bottom element
            int temp = stack.pop();
            
            // Reverse the remaining stack
            reverseStack(stack);
            
            // Insert the removed element at bottom
            insertAtBottom(stack, temp);
        }
    }
    
    // Function to insert element at bottom of stack
    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        
        // Remove top element
        int temp = stack.pop();
        
        // Recursive call
        insertAtBottom(stack, element);
        
        // Put back the removed element
        stack.push(temp);
    }
    
    // Helper function to display stack
    public static void displayStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.println(stack);
    }
}
