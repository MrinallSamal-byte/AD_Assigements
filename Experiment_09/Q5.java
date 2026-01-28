import java.util.Scanner;

public class Q5 {

    
    static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    static class BinaryTree {
        Node root;
        

        public Node createFromArray(int[] arr, int index) {
            Node node = null;
            
            if (index < arr.length && arr[index] != -1) {
                node = new Node(arr[index]);
                node.left = createFromArray(arr, 2 * index + 1);
                node.right = createFromArray(arr, 2 * index + 2);
            }
            
            return node;
        }
        

        public void inorderRecursive(Node node) {
            if (node != null) {
                inorderRecursive(node.left);
                System.out.print(node.data + " ");
                inorderRecursive(node.right);
            }
        }
        

        public void inorderIterative(Node node) {
            if (node == null) return;
            
            java.util.Stack<Node> stack = new java.util.Stack<>();
            Node current = node;
            
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                
                current = stack.pop();
                System.out.print(current.data + " ");
                current = current.right;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of nodes (use -1 for null): ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        BinaryTree tree = new BinaryTree();
        tree.root = tree.createFromArray(arr, 0);
        
        System.out.print("Inorder Traversal (Recursive): ");
        tree.inorderRecursive(tree.root);
        System.out.println();
        
        System.out.print("Inorder Traversal (Iterative): ");
        tree.inorderIterative(tree.root);
        System.out.println();
        
        sc.close();
    }
}
