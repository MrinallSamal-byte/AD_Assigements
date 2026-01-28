import java.util.Scanner;

public class Q1 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        if (isSorted(arr, n)) {
            System.out.println("Array is sorted in ascending order");
        } else if (isSortedDescending(arr, n)) {
            System.out.println("Array is sorted in descending order");
        } else {
            System.out.println("Array is not sorted");
        }
        
        sc.close();
    }
    

    public static boolean isSorted(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    

    public static boolean isSortedDescending(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
