import java.util.Scanner;
import java.util.HashSet;

public class Q4 {
    // Objective: Detect duplicate elements in an array
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        if (hasDuplicates(arr, n)) {
            System.out.println("Array contains duplicate elements");
            printDuplicates(arr, n);
        } else {
            System.out.println("Array does not contain duplicate elements");
        }
        
        sc.close();
    }
    
    // Function to check if array has duplicates
    public static boolean hasDuplicates(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }
        
        return false;
    }
    
    // Function to print all duplicate elements
    public static void printDuplicates(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                duplicates.add(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }
        
        System.out.print("Duplicate elements: ");
        for (int num : duplicates) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
