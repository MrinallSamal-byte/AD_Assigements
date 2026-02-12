import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Q2 {
    
    // Cache for memoization - improves performance from O(2^n) to O(n)
    // Note: Not thread-safe. For multi-threaded use, replace with ConcurrentHashMap
    private static Map<Integer, Long> fibCache = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            
            System.out.print("Enter the number of terms: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int n = sc.nextInt();
            
            if (n <= 0) {
                System.out.println("Error: Please enter a positive number.");
                return;
            }
            
            System.out.print("Fibonacci Series: ");
            for (int i = 0; i < n; i++) {
                System.out.print(fibonacci(i) + " ");
            }
            System.out.println();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
    
    /**
     * Optimized Fibonacci using memoization (Dynamic Programming)
     * Time Complexity: O(n) instead of O(2^n)
     * Space Complexity: O(n) for cache
     */
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        // Check cache first
        if (fibCache.containsKey(n)) {
            return fibCache.get(n);
        }
        
        // Calculate and cache result
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        fibCache.put(n, result);
        return result;
    }
}
