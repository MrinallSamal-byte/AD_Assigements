import java.util.Scanner;
import java.util.Arrays;

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
            
            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                if (!sc.hasNextInt()) {
                    System.out.println("Error: Please enter valid integers.");
                    return;
                }
                arr[i] = sc.nextInt();
            }
            
            // Sort array first for efficient duplicate removal
            Arrays.sort(arr);
            
            int newSize = removeDuplicates(arr, n);
            
            System.out.print("Array after removing duplicates: ");
            for (int i = 0; i < newSize; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("Original size: " + n + ", New size: " + newSize);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
    
    /**
     * Remove duplicates from sorted array in-place
     * Time Complexity: O(n)
     * Space Complexity: O(1) - modifies array in-place
     * 
     * Note: Requires sorted array as input
     */
    public static int removeDuplicates(int[] arr, int n) {
        if (arr == null) {
            return 0;
        }
        
        if (n == 0 || n == 1) {
            return n;
        }
        
        // Two-pointer technique: j tracks position for unique elements
        int writeIndex = 0;
        
        // Compare consecutive elements
        for (int readIndex = 0; readIndex < n - 1; readIndex++) {
            if (arr[readIndex] != arr[readIndex + 1]) {
                arr[writeIndex++] = arr[readIndex];
            }
        }
        
        // Add last element (always unique from its predecessor if we reach here)
        arr[writeIndex++] = arr[n - 1];
        
        return writeIndex;
    }
}
