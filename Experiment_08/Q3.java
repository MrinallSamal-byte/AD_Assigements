import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Q3 {
    // Objective: Solve Josephus problem using Queue
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of people (n): ");
        int n = sc.nextInt();
        
        System.out.print("Enter counting step (k): ");
        int k = sc.nextInt();
        
        int survivor = josephus(n, k);
        System.out.println("The survivor is at position: " + survivor);
        
        sc.close();
    }
    
    // Function to solve Josephus problem using queue
    public static int josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all people to queue (1 to n)
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        System.out.println("\nElimination order:");
        
        // Eliminate people until one remains
        while (queue.size() > 1) {
            // Move k-1 people from front to back
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            
            // Eliminate the kth person
            int eliminated = queue.poll();
            System.out.println("Eliminated: " + eliminated);
        }
        
        // Return the survivor
        return queue.poll();
    }
    
    // Alternative recursive approach
    public static int josephusRecursive(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (josephusRecursive(n - 1, k) + k - 1) % n + 1;
    }
}
