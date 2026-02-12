import java.util.Scanner;

public class Q6 {

    // Maximum reasonable number of disks to prevent stack overflow
    private static final int MAX_DISKS = 30;
    
    // Counter for total moves
    private static int moveCount = 0;
    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            
            System.out.print("Enter the number of disks: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int n = sc.nextInt();
            
            if (n <= 0) {
                System.out.println("Error: Number of disks must be positive.");
                return;
            }
            
            if (n > MAX_DISKS) {
                System.out.println("Warning: Too many disks. This will take very long!");
                System.out.println("Maximum recommended: " + MAX_DISKS + " disks.");
                return;
            }
            
            moveCount = 0;
            System.out.println("Steps to solve Tower of Hanoi with " + n + " disk(s):");
            System.out.println("Expected moves: " + (int)(Math.pow(2, n) - 1));
            System.out.println();
            
            towerOfHanoi(n, 'A', 'C', 'B');
            
            System.out.println("\nTotal moves: " + moveCount);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
    
    /**
     * Solve Tower of Hanoi puzzle using recursion
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) due to recursion stack
     * 
     * Algorithm:
     * 1. Move n-1 disks from source to auxiliary using destination
     * 2. Move largest disk from source to destination
     * 3. Move n-1 disks from auxiliary to destination using source
     * 
     * @param n Number of disks
     * @param source Source rod
     * @param destination Destination rod
     * @param auxiliary Auxiliary rod
     */
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            moveCount++;
            System.out.println("Move " + moveCount + ": Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        
        // Move n-1 disks from source to auxiliary
        towerOfHanoi(n - 1, source, auxiliary, destination);
        
        // Move the largest disk from source to destination
        moveCount++;
        System.out.println("Move " + moveCount + ": Move disk " + n + " from rod " + source + " to rod " + destination);
        
        // Move n-1 disks from auxiliary to destination
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
}
