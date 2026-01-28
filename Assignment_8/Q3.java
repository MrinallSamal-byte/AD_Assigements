import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Q3 {

    
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
    

    public static int josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        System.out.println("\nElimination order:");
        

        while (queue.size() > 1) {

            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            

            int eliminated = queue.poll();
            System.out.println("Eliminated: " + eliminated);
        }
        

        return queue.poll();
    }
    

    public static int josephusRecursive(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (josephusRecursive(n - 1, k) + k - 1) % n + 1;
    }
}
