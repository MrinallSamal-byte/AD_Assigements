import java.util.Scanner;

public class Q4 {

    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            
            System.out.print("Enter the size of sorted array: ");
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
            System.out.println("Enter " + n + " elements in sorted order:");
            for (int i = 0; i < n; i++) {
                if (!sc.hasNextInt()) {
                    System.out.println("Error: Please enter valid integers.");
                    return;
                }
                arr[i] = sc.nextInt();
            }
            
            // Verify array is sorted
            if (!isSorted(arr)) {
                System.out.println("Warning: Array is not sorted. Binary search requires sorted array.");
            }
            
            System.out.print("Enter the element to search: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int key = sc.nextInt();
            
            int result = binarySearch(arr, 0, n - 1, key);
            
            if (result == -1) {
                System.out.println("Element not found in the array.");
            } else {
                System.out.println("Element found at index: " + result);
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
     * Recursive binary search with overflow protection
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to recursion stack
     */
    public static int binarySearch(int[] arr, int left, int right, int key) {
        if (arr == null || left > right) {
            return -1;
        }
        
        // Overflow-safe midpoint calculation
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == key) {
            return mid;
        }
        
        if (arr[mid] > key) {
            return binarySearch(arr, left, mid - 1, key);
        }
        
        return binarySearch(arr, mid + 1, right, key);
    }
    
    /**
     * Helper method to verify array is sorted
     */
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
