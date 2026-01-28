import java.util.Scanner;
import java.util.Stack;

public class Q4 {

    
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
    

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {

            int temp = stack.pop();
            

            sortStack(stack);
            

            sortedInsert(stack, temp);
        }
    }
    

    public static void sortedInsert(Stack<Integer> stack, int element) {

        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        

        int temp = stack.pop();
        

        sortedInsert(stack, element);
        

        stack.push(temp);
    }
    

    public static void displayStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.println(stack);
    }
}
