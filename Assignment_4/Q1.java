import java.util.Scanner;

public class Q1 {

    /**
     * Enum for sort order types
     */
    enum SortOrder {
        ASCENDING,
        DESCENDING,
        UNSORTED
    }
    
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
            
            SortOrder order = checkSortOrder(arr);
            
            switch (order) {
                case ASCENDING:
                    System.out.println("Array is sorted in ascending order");
                    break;
                case DESCENDING:
                    System.out.println("Array is sorted in descending order");
                    break;
                case UNSORTED:
                    System.out.println("Array is not sorted");
                    break;
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
     * Optimized check for sort order - single pass O(n) instead of two passes
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static SortOrder checkSortOrder(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return SortOrder.ASCENDING; // Single element is technically sorted
        }
        
        boolean ascending = true;
        boolean descending = true;
        
        // Single pass to check both directions
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                ascending = false;
            }
            if (arr[i] < arr[i + 1]) {
                descending = false;
            }
            
            // Early exit optimization
            if (!ascending && !descending) {
                return SortOrder.UNSORTED;
            }
        }
        
        // If both are true, array has all equal elements (sorted both ways)
        if (ascending) {
            return SortOrder.ASCENDING;
        } else if (descending) {
            return SortOrder.DESCENDING;
        }
        
        return SortOrder.UNSORTED;
    }
    
    /**
     * Check if array is sorted in ascending order
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isSorted(int[] arr, int n) {
        if (arr == null || n <= 1) {
            return true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Check if array is sorted in descending order
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isSortedDescending(int[] arr, int n) {
        if (arr == null || n <= 1) {
            return true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
