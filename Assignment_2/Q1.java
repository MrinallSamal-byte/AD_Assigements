import java.util.Scanner;

public class Q1 {

    // Maximum factorial that fits in long (20! = 2,432,902,008,176,640,000)
    private static final int MAX_FACTORIAL = 20;
    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            
            System.out.print("Enter a number: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int n = sc.nextInt();
            
            if (n < 0) {
                System.out.println("Factorial is not defined for negative numbers.");
            } else if (n > MAX_FACTORIAL) {
                System.out.println("Error: Number too large. Maximum supported is " + MAX_FACTORIAL);
            } else {
                long result = factorial(n);
                System.out.println("Factorial of " + n + " is: " + result);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
    
    /**
     * Recursive factorial calculation with overflow protection
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to recursion stack
     */
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
