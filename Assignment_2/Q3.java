import java.util.Scanner;

public class Q3 {

    
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
            
            System.out.print("Enter the element to search: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int key = sc.nextInt();
            
            int result = linearSearch(arr, key);
            
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
     * Optimized iterative linear search - avoids stack overflow risk
     * Time Complexity: O(n)
     * Space Complexity: O(1) - no recursion stack
     */
    public static int linearSearch(int[] arr, int key) {
        if (arr == null) {
            return -1;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
