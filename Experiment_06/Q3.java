import java.util.Scanner;
import java.util.LinkedList;

public class Q3 {

    
    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;
        
        @SuppressWarnings("unchecked")
        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        

        public void addEdge(int src, int dest) {
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
        

        public void addDirectedEdge(int src, int dest) {
            adjList[src].add(dest);
        }
        

        public void display() {
            System.out.println("\nAdjacency List:");
            for (int i = 0; i < vertices; i++) {
                System.out.print("Vertex " + i + ": ");
                for (Integer node : adjList[i]) {
                    System.out.print(node + " -> ");
                }
                System.out.println("NULL");
            }
        }
        

        public int getDegree(int vertex) {
            return adjList[vertex].size();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        
        Graph graph = new Graph(vertices);
        
        System.out.println("\nGraph Operations:");
        System.out.println("1. Add Edge (Undirected)");
        System.out.println("2. Add Edge (Directed)");
        System.out.println("3. Display Graph");
        System.out.println("4. Get Degree");
        System.out.println("5. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter source vertex: ");
                    int src1 = sc.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int dest1 = sc.nextInt();
                    if (src1 >= 0 && src1 < vertices && dest1 >= 0 && dest1 < vertices) {
                        graph.addEdge(src1, dest1);
                        System.out.println("Edge added");
                    } else {
                        System.out.println("Invalid vertices");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter source vertex: ");
                    int src2 = sc.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int dest2 = sc.nextInt();
                    if (src2 >= 0 && src2 < vertices && dest2 >= 0 && dest2 < vertices) {
                        graph.addDirectedEdge(src2, dest2);
                        System.out.println("Directed edge added");
                    } else {
                        System.out.println("Invalid vertices");
                    }
                    break;
                    
                case 3:
                    graph.display();
                    break;
                    
                case 4:
                    System.out.print("Enter vertex: ");
                    int vertex = sc.nextInt();
                    if (vertex >= 0 && vertex < vertices) {
                        System.out.println("Degree of vertex " + vertex + ": " + graph.getDegree(vertex));
                    } else {
                        System.out.println("Invalid vertex");
                    }
                    break;
                    
                case 5:
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
