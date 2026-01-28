import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q7 {

    
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
    

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
    

    public static void reverseQueueRecursive(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        

        int front = queue.poll();
        

        reverseQueueRecursive(queue);
        

        queue.add(front);
    }
}
