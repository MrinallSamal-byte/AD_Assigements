import java.util.Scanner;

public class Q6 {
    // Objective: Solve Tower of Hanoi problem using recursion
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of disks: ");
        int n = sc.nextInt();
        
        System.out.println("Steps to solve Tower of Hanoi:");
        towerOfHanoi(n, 'A', 'C', 'B');
        
        sc.close();
    }
    
    // Recursive function to solve Tower of Hanoi
    // source: Source rod, destination: Destination rod, auxiliary: Auxiliary rod
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        
        // Move n-1 disks from source to auxiliary using destination
        towerOfHanoi(n - 1, source, auxiliary, destination);
        
        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
        
        // Move n-1 disks from auxiliary to destination using source
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
}
