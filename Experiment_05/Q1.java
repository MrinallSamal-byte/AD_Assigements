import java.util.Scanner;

public class Q1 {

    
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 7, 4, 6, 5, 8};
        
        if (isMinHeap(A)) {
            System.out.println("Output: YES"); 
        } else {
            System.out.println("Output: NO");
        }
    }

    public static boolean isMinHeap(int[] A) {
        int n = A.length;

        for (int i = 0; i <= (n - 2) / 2; i++) {

            if (A[2 * i + 1] < A[i]) {
                return false;
            }

            if (2 * i + 2 < n && A[2 * i + 2] < A[i]) {
                return false;
            }
        }
        return true;
    }
}
