import java.util.Scanner;
import java.util.Stack;

public class Q5 {

    
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
    

    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {

            int temp = stack.pop();
            

            reverseStack(stack);
            

            insertAtBottom(stack, temp);
        }
    }
    

    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        

        int temp = stack.pop();
        

        insertAtBottom(stack, element);
        

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
