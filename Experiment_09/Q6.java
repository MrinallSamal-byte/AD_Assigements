import java.util.Scanner;

public class Q6 {
    // Objective: Calculate number of leaf nodes in a binary tree
    
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
        
        // Create binary tree from array
        public Node createFromArray(int[] arr, int index) {
            Node node = null;
            
            if (index < arr.length && arr[index] != -1) {
                node = new Node(arr[index]);
                node.left = createFromArray(arr, 2 * index + 1);
                node.right = createFromArray(arr, 2 * index + 2);
            }
            
            return node;
        }
        
        // Count leaf nodes
        public int countLeafNodes(Node node) {
            if (node == null) {
                return 0;
            }
            
            if (node.left == null && node.right == null) {
                return 1;
            }
            
            return countLeafNodes(node.left) + countLeafNodes(node.right);
        }
        
        // Count total nodes
        public int countTotalNodes(Node node) {
            if (node == null) {
                return 0;
            }
            
            return 1 + countTotalNodes(node.left) + countTotalNodes(node.right);
        }
        
        // Count internal nodes (non-leaf nodes)
        public int countInternalNodes(Node node) {
            if (node == null || (node.left == null && node.right == null)) {
                return 0;
            }
            
            return 1 + countInternalNodes(node.left) + countInternalNodes(node.right);
        }
        
        // Calculate height of tree
        public int height(Node node) {
            if (node == null) {
                return 0;
            }
            
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            
            return Math.max(leftHeight, rightHeight) + 1;
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
        
        System.out.println("Total nodes: " + tree.countTotalNodes(tree.root));
        System.out.println("Leaf nodes: " + tree.countLeafNodes(tree.root));
        System.out.println("Internal nodes: " + tree.countInternalNodes(tree.root));
        System.out.println("Height of tree: " + tree.height(tree.root));
        
        sc.close();
    }
}
