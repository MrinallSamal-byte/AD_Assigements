import java.util.Scanner;

public class Q3 {
    // Objective: Implement Pre-order Traversal (Root -> Left -> Right)
    
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
        
        // Insert nodes
        public Node insert(Node node, int data) {
            if (node == null) {
                return new Node(data);
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Insert " + data + " to left of " + node.data + "? (1=Yes, 0=No): ");
            int choice = sc.nextInt();
            
            if (choice == 1) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
            
            return node;
        }
        
        // Preorder traversal (Recursive)
        public void preorderRecursive(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preorderRecursive(node.left);
                preorderRecursive(node.right);
            }
        }
        
        // Preorder traversal (Iterative)
        public void preorderIterative(Node node) {
            if (node == null) return;
            
            java.util.Stack<Node> stack = new java.util.Stack<>();
            stack.push(node);
            
            while (!stack.isEmpty()) {
                Node current = stack.pop();
                System.out.print(current.data + " ");
                
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        
        System.out.print("Enter root value: ");
        int rootValue = sc.nextInt();
        tree.root = new Node(rootValue);
        
        System.out.print("Enter number of additional nodes: ");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            tree.insert(tree.root, value);
        }
        
        System.out.print("Preorder Traversal (Recursive): ");
        tree.preorderRecursive(tree.root);
        System.out.println();
        
        System.out.print("Preorder Traversal (Iterative): ");
        tree.preorderIterative(tree.root);
        System.out.println();
        
        sc.close();
    }
}
