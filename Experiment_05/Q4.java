import java.util.Scanner;

public class Q4 {
    // Objective: Build a min heap from an array
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Array before building min heap: ");
        printArray(arr, n);
        
        buildMinHeap(arr, n);
        
        System.out.print("Array after building min heap: ");
        printArray(arr, n);
        
        sc.close();
    }
    
    // Function to build a min heap
    public static void buildMinHeap(int[] arr, int n) {
        // Start from last internal node and heapify all nodes
        for (int i = (n / 2) - 1; i >= 0; i--) {
            minHeapify(arr, n, i);
        }
    }
    
    // Function to maintain min heap property
    public static void minHeapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            
            minHeapify(arr, n, smallest);
        }
    }
    
    // Helper function to print array
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
