import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Q5 {
    // Objective: Implement Deque (Double-ended Queue) operations
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        
        System.out.println("Deque Operations:");
        System.out.println("1. Insert at Front");
        System.out.println("2. Insert at Rear");
        System.out.println("3. Delete from Front");
        System.out.println("4. Delete from Rear");
        System.out.println("5. Get Front");
        System.out.println("6. Get Rear");
        System.out.println("7. Display");
        System.out.println("8. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at front: ");
                    int val1 = sc.nextInt();
                    deque.addFirst(val1);
                    System.out.println("Inserted " + val1 + " at front");
                    break;
                    
                case 2:
                    System.out.print("Enter value to insert at rear: ");
                    int val2 = sc.nextInt();
                    deque.addLast(val2);
                    System.out.println("Inserted " + val2 + " at rear");
                    break;
                    
                case 3:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println("Deleted from front: " + deque.removeFirst());
                    }
                    break;
                    
                case 4:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println("Deleted from rear: " + deque.removeLast());
                    }
                    break;
                    
                case 5:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println("Front element: " + deque.peekFirst());
                    }
                    break;
                    
                case 6:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println("Rear element: " + deque.peekLast());
                    }
                    break;
                    
                case 7:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println("Deque: " + deque);
                    }
                    break;
                    
                case 8:
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
