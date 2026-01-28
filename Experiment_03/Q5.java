import java.util.Scanner;

public class Q5 {
    // Objective: Find the maximum sum subarray (Kadane's Algorithm)
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int maxSum = maxSubarraySum(arr, n);
        System.out.println("Maximum subarray sum: " + maxSum);
        
        sc.close();
    }
    
    // Kadane's Algorithm to find maximum subarray sum
    public static int maxSubarraySum(int[] arr, int n) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        
        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}
