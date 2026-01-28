import java.util.Scanner;

public class Q4 {

    
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
        

        public void postorderRecursive(Node node) {
            if (node != null) {
                postorderRecursive(node.left);
                postorderRecursive(node.right);
                System.out.print(node.data + " ");
            }
        }
        

        public void postorderIterative(Node node) {
            if (node == null) return;
            
            java.util.Stack<Node> stack1 = new java.util.Stack<>();
            java.util.Stack<Node> stack2 = new java.util.Stack<>();
            
            stack1.push(node);
            
            while (!stack1.isEmpty()) {
                Node current = stack1.pop();
                stack2.push(current);
                
                if (current.left != null) {
                    stack1.push(current.left);
                }
                if (current.right != null) {
                    stack1.push(current.right);
                }
            }
            
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().data + " ");
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
        
        System.out.print("Postorder Traversal (Recursive): ");
        tree.postorderRecursive(tree.root);
        System.out.println();
        
        System.out.print("Postorder Traversal (Iterative): ");
        tree.postorderIterative(tree.root);
        System.out.println();
        
        sc.close();
    }
}
