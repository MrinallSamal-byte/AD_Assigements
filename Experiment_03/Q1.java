import java.util.Scanner;

public class Q1 {
    // Objective: Reduce array by removing elements that satisfy certain conditions
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Remove duplicate elements
        int newSize = removeDuplicates(arr, n);
        
        System.out.print("Array after reduction: ");
        for (int i = 0; i < newSize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        sc.close();
    }
    
    // Function to remove duplicates from sorted array
    public static int removeDuplicates(int[] arr, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n - 1];
        
        return j;
    }
}
