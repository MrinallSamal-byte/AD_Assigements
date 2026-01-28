import java.util.Scanner;
import java.util.Stack;

public class Q3 {
    // Objective: Insert element in sorted order in a stack
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.print("Enter number of initial elements: ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " elements in sorted order (bottom to top):");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        
        System.out.print("Stack before insertion: ");
        displayStack(stack);
        
        System.out.print("Enter element to insert: ");
        int element = sc.nextInt();
        
        sortedInsert(stack, element);
        
        System.out.print("Stack after sorted insertion: ");
        displayStack(stack);
        
        sc.close();
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
