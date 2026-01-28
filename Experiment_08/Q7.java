import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q7 {
    // Objective: Reverse a queue using stack
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        
        System.out.println("Queue before reversing: " + queue);
        
        reverseQueue(queue);
        
        System.out.println("Queue after reversing: " + queue);
        
        sc.close();
    }
    
    // Function to reverse queue using stack
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        
        // Push all elements from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        
        // Pop all elements from stack and enqueue to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
    
    // Alternative recursive approach
    public static void reverseQueueRecursive(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        
        // Remove front element
        int front = queue.poll();
        
        // Reverse remaining queue
        reverseQueueRecursive(queue);
        
        // Add the removed element at rear
        queue.add(front);
    }
}
