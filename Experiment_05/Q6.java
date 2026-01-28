import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class Q6 {
    // Objective: Find k largest elements in an array using heap
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter k (number of largest elements): ");
        int k = sc.nextInt();
        
        if (k < 1 || k > n) {
            System.out.println("Invalid value of k");
        } else {
            findKLargest(arr, n, k);
        }
        
        sc.close();
    }
    
    // Function to find k largest elements using min heap
    public static void findKLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add first k elements to the heap
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        
        // Process remaining elements
        for (int i = k; i < n; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        
        System.out.print(k + " largest elements: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }
    
    // Alternative approach using max heap
    public static void findKLargestMaxHeap(int[] arr, int n, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
            maxHeap.add(arr[i]);
        }
        
        System.out.print(k + " largest elements: ");
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }
}
