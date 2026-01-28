import java.util.Scanner;

public class Q2 {
    // Objective: Update key in a Max-Priority Queue (Max Heap)
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] heap = {100, 80, 90, 70, 60, 75, 85, 50, 55};
        int n = heap.length;
        
        System.out.println("Original Max Heap:");
        printArray(heap, n);
        
        System.out.print("Enter index to update (0 to " + (n-1) + "): ");
        int index = sc.nextInt();
        
        System.out.print("Enter new value: ");
        int newValue = sc.nextInt();
        
        updateKey(heap, index, newValue, n);
        
        System.out.println("Updated Max Heap:");
        printArray(heap, n);
        
        sc.close();
    }
    
    // Function to update key in max heap
    public static void updateKey(int[] heap, int index, int newValue, int n) {
        if (index < 0 || index >= n) {
            System.out.println("Invalid index");
            return;
        }
        
        int oldValue = heap[index];
        heap[index] = newValue;
        
        if (newValue > oldValue) {
            // Bubble up
            while (index > 0 && heap[index] > heap[(index - 1) / 2]) {
                int temp = heap[index];
                heap[index] = heap[(index - 1) / 2];
                heap[(index - 1) / 2] = temp;
                index = (index - 1) / 2;
            }
        } else {
            // Bubble down
            maxHeapify(heap, n, index);
        }
    }
    
    // Function to maintain max heap property
    public static void maxHeapify(int[] heap, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && heap[left] > heap[largest]) {
            largest = left;
        }
        
        if (right < n && heap[right] > heap[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(heap, n, largest);
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
