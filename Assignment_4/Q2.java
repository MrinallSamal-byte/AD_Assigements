import java.util.Scanner;
import java.util.Arrays;

public class Q2 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the target difference: ");
        int diff = sc.nextInt();
        
        if (findPairWithDifference(arr, n, diff)) {
            System.out.println("Pair with difference " + diff + " exists");
        } else {
            System.out.println("No pair with difference " + diff + " exists");
        }
        
        sc.close();
    }
    

    public static boolean findPairWithDifference(int[] arr, int n, int diff) {
        Arrays.sort(arr);
        
        int i = 0, j = 1;
        
        while (i < n && j < n) {
            if (i != j && arr[j] - arr[i] == diff) {
                System.out.println("Pair found: (" + arr[i] + ", " + arr[j] + ")");
                return true;
            } else if (arr[j] - arr[i] < diff) {
                j++;
            } else {
                i++;
            }
        }
        
        return false;
    }
}
