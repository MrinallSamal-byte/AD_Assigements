import java.util.Scanner;

public class Q6 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of disks: ");
        int n = sc.nextInt();
        
        System.out.println("Steps to solve Tower of Hanoi:");
        towerOfHanoi(n, 'A', 'C', 'B');
        
        sc.close();
    }
    


    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        

        towerOfHanoi(n - 1, source, auxiliary, destination);
        

        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
        

        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
}
