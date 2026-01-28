import java.util.Scanner;

public class Q3 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();
        
        int result = linearSearch(arr, n, key);
        
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
        
        sc.close();
    }
    

    public static int linearSearch(int[] arr, int n, int key) {
        if (n == 0) {
            return -1;
        }
        if (arr[n - 1] == key) {
            return n - 1;
        }
        return linearSearch(arr, n - 1, key);
    }
}
