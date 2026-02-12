import java.util.Scanner;

public class Q1 {

    
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
        
        // Sentinel value for null nodes
        private static final int NULL_NODE = -1;
        
        /**
         * Create binary tree from array representation
         * Uses level-order (array) representation where:
         * - Element at index i has left child at 2*i+1 and right child at 2*i+2
         * - -1 represents null nodes
         * 
         * Time Complexity: O(n)
         * Space Complexity: O(h) where h is height, due to recursion stack
         */
        public Node createFromArray(int[] arr, int index) {
            if (arr == null || index >= arr.length || arr[index] == NULL_NODE) {
                return null;
            }
            
            Node node = new Node(arr[index]);
            node.left = createFromArray(arr, 2 * index + 1);
            node.right = createFromArray(arr, 2 * index + 2);
            
            return node;
        }
        
        /**
         * Inorder traversal (Left-Root-Right)
         * Time Complexity: O(n)
         * Space Complexity: O(h) for recursion stack
         */
        public void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.data + " ");
                inorder(node.right);
            }
        }
        
        /**
         * Preorder traversal (Root-Left-Right)
         * Time Complexity: O(n)
         * Space Complexity: O(h) for recursion stack
         */
        public void preorder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preorder(node.left);
                preorder(node.right);
            }
        }
        
        /**
         * Postorder traversal (Left-Right-Root)
         * Time Complexity: O(n)
         * Space Complexity: O(h) for recursion stack
         */
        public void postorder(Node node) {
            if (node != null) {
                postorder(node.left);
                postorder(node.right);
                System.out.print(node.data + " ");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            
            System.out.print("Enter number of nodes (use -1 for null): ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int n = sc.nextInt();
            
            if (n <= 0) {
                System.out.println("Error: Number of nodes must be positive.");
                return;
            }
            
            int[] arr = new int[n];
            System.out.println("Enter " + n + " values:");
            for (int i = 0; i < n; i++) {
                if (!sc.hasNextInt()) {
                    System.out.println("Error: Please enter valid integers.");
                    return;
                }
                arr[i] = sc.nextInt();
            }
            
            BinaryTree tree = new BinaryTree();
            tree.root = tree.createFromArray(arr, 0);
            
            if (tree.root == null) {
                System.out.println("Tree is empty.");
                return;
            }
            
            System.out.print("Inorder traversal: ");
            tree.inorder(tree.root);
            System.out.println();
            
            System.out.print("Preorder traversal: ");
            tree.preorder(tree.root);
            System.out.println();
            
            System.out.print("Postorder traversal: ");
            tree.postorder(tree.root);
            System.out.println();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
