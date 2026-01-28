import java.util.Scanner;

public class Q2 {
    // Objective: Merge two sorted arrays into a single sorted array
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of first array: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter " + n1 + " sorted elements:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        
        System.out.print("Enter the size of second array: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter " + n2 + " sorted elements:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        
        int[] merged = mergeSortedArrays(arr1, arr2, n1, n2);
        
        System.out.print("Merged sorted array: ");
        for (int num : merged) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        sc.close();
    }
    
    // Function to merge two sorted arrays
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2, int n1, int n2) {
        int[] result = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        
        while (i < n1) {
            result[k++] = arr1[i++];
        }
        
        while (j < n2) {
            result[k++] = arr2[j++];
        }
        
        return result;
    }
}
