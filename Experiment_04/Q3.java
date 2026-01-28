import java.util.Scanner;
import java.util.Arrays;

public class Q3 {
    // Objective: Find the kth smallest element in an array
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter k (to find kth smallest): ");
        int k = sc.nextInt();
        
        if (k < 1 || k > n) {
            System.out.println("Invalid value of k");
        } else {
            int result = findKthSmallest(arr, n, k);
            System.out.println(k + "th smallest element is: " + result);
        }
        
        sc.close();
    }
    
    // Function to find kth smallest element using sorting
    public static int findKthSmallest(int[] arr, int n, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }
    
    // Alternative: Using QuickSelect algorithm (more efficient)
    public static int findKthSmallestQuickSelect(int[] arr, int left, int right, int k) {
        if (k > 0 && k <= right - left + 1) {
            int pos = partition(arr, left, right);
            
            if (pos - left == k - 1) {
                return arr[pos];
            }
            if (pos - left > k - 1) {
                return findKthSmallestQuickSelect(arr, left, pos - 1, k);
            }
            return findKthSmallestQuickSelect(arr, pos + 1, right, k - pos + left - 1);
        }
        return Integer.MAX_VALUE;
    }
    
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        
        return i;
    }
}
