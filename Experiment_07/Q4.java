import java.util.Scanner;
import java.util.Stack;

public class Q4 {
    // Objective: Sort a stack using recursion
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        
        System.out.print("Stack before sorting: ");
        displayStack(stack);
        
        sortStack(stack);
        
        System.out.print("Stack after sorting: ");
        displayStack(stack);
        
        sc.close();
    }
    
    // Function to sort stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove top element
            int temp = stack.pop();
            
            // Sort remaining stack
            sortStack(stack);
            
            // Insert the removed element in sorted order
            sortedInsert(stack, temp);
        }
    }
    
    // Function to insert element in sorted order
    public static void sortedInsert(Stack<Integer> stack, int element) {
        // Base case: stack is empty or element is greater than top
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        
        // Remove top element
        int temp = stack.pop();
        
        // Recursive call
        sortedInsert(stack, element);
        
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
