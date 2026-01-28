import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Q2 {
    // Objective: Find maximum in sliding window using Deque
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter window size: ");
        int k = sc.nextInt();
        
        if (k <= 0 || k > n) {
            System.out.println("Invalid window size");
        } else {
            int[] result = maxSlidingWindow(arr, k);
            
            System.out.print("Maximum in each sliding window: ");
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
    
    // Function to find maximum in sliding window
    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        // Process first window
        for (int i = 0; i < k; i++) {
            // Remove elements from rear while current element is greater
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        // Process remaining elements
        for (int i = k; i < n; i++) {
            // Maximum of previous window
            result[i - k] = arr[deque.peekFirst()];
            
            // Remove elements outside current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            
            // Remove elements from rear while current element is greater
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            
            deque.addLast(i);
        }
        
        // Maximum of last window
        result[n - k] = arr[deque.peekFirst()];
        
        return result;
    }
}
