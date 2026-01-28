import java.util.Scanner;
import java.util.PriorityQueue;

public class Q5 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        System.out.println("Priority Queue Operations:");
        System.out.println("1. Insert");
        System.out.println("2. Extract Min");
        System.out.println("3. Peek Min");
        System.out.println("4. Display");
        System.out.println("5. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = sc.nextInt();
                    pq.add(value);
                    System.out.println("Inserted " + value);
                    break;
                    
                case 2:
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is empty");
                    } else {
                        System.out.println("Extracted minimum: " + pq.poll());
                    }
                    break;
                    
                case 3:
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is empty");
                    } else {
                        System.out.println("Minimum element: " + pq.peek());
                    }
                    break;
                    
                case 4:
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is empty");
                    } else {
                        System.out.println("Priority Queue: " + pq);
                    }
                    break;
                    
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
