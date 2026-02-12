import java.util.Scanner;

public class Q1 {


    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            
            System.out.print("Enter the size of array: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int n = sc.nextInt();
            
            if (n <= 0) {
                System.out.println("Error: Array size must be positive.");
                return;
            }
            
            int[] A = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                if (!sc.hasNextInt()) {
                    System.out.println("Error: Please enter valid integers.");
                    return;
                }
                A[i] = sc.nextInt();
            }
            
            if (isMinHeap(A)) {
                System.out.println("Output: YES - Array represents a valid Min-Heap"); 
            } else {
                System.out.println("Output: NO - Array does not represent a valid Min-Heap");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    /**
     * Check if array represents a valid min-heap
     * Time Complexity: O(n) - visits each internal node once
     * Space Complexity: O(1)
     * 
     * Min-heap property: parent <= both children
     * For node at index i:
     *   - Left child: 2*i + 1
     *   - Right child: 2*i + 2
     */
    public static boolean isMinHeap(int[] A) {
        if (A == null || A.length == 0) {
            return true; // Empty array is trivially a min-heap
        }
        
        int n = A.length;
        
        // Check all internal nodes (nodes that have at least one child)
        // Last internal node is at index (n-2)/2
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            
            // Check left child (always exists for internal nodes)
            if (leftChildIndex < n && A[leftChildIndex] < A[i]) {
                return false;
            }
            
            // Check right child (may not exist)
            if (rightChildIndex < n && A[rightChildIndex] < A[i]) {
                return false;
            }
        }
        return true;
    }
}
