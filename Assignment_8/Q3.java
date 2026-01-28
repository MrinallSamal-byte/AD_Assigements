import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q3 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        
        System.out.println("Stack before reversing: " + stack);
        
        reverseStack(stack);
        
        System.out.println("Stack after reversing: " + stack);
        
        sc.close();
    }
    

    public static void reverseStack(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();
        

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
    }
    

    public static void reverseStackRecursive(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        

        int top = stack.pop();
        

        reverseStackRecursive(stack);
        

        insertAtBottom(stack, top);
    }
    

    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        
        int temp = stack.pop();
        insertAtBottom(stack, item);
        stack.push(temp);
    }
}
