import java.util.Scanner;

public class Q1 {
    // Objective: Create Binary Tree from Array representation
    
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
        
        // Create binary tree from array (level order)
        public Node createFromArray(int[] arr, int index) {
            Node node = null;
            
            if (index < arr.length && arr[index] != -1) {
                node = new Node(arr[index]);
                node.left = createFromArray(arr, 2 * index + 1);
                node.right = createFromArray(arr, 2 * index + 2);
            }
            
            return node;
        }
        
        // Inorder traversal
        public void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.data + " ");
                inorder(node.right);
            }
        }
        
        // Preorder traversal
        public void preorder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preorder(node.left);
                preorder(node.right);
            }
        }
        
        // Postorder traversal
        public void postorder(Node node) {
            if (node != null) {
                postorder(node.left);
                postorder(node.right);
                System.out.print(node.data + " ");
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
        
        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();
        
        System.out.print("Preorder traversal: ");
        tree.preorder(tree.root);
        System.out.println();
        
        System.out.print("Postorder traversal: ");
        tree.postorder(tree.root);
        System.out.println();
        
        sc.close();
    }
}
