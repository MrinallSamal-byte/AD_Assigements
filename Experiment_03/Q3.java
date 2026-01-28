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
        
        if (canBeSortedByReversing(arr, n)) {
            System.out.println("YES - Array can be sorted by reversing a sub-array");
        } else {
            System.out.println("NO - Array cannot be sorted by reversing a sub-array");
        }
        
        sc.close();
    }
    

    public static boolean canBeSortedByReversing(int[] arr, int n) {
        int[] temp = arr.clone();
        java.util.Arrays.sort(temp);
        
        int start = -1, end = -1;
        

        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                start = i;
                break;
            }
        }
        

        if (start == -1) {
            return true;
        }
        

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != temp[i]) {
                end = i;
                break;
            }
        }
        

        reverse(arr, start, end);
        

        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                return false;
            }
        }
        
        return true;
    }
    

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
