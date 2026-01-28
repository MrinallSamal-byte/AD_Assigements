import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Q7 {
    // Objective: Level-order traversal and advanced tree operations
    
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
        
        // Level-order traversal (Breadth-First Search)
        public void levelOrder(Node node) {
            if (node == null) return;
            
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        
        // Search for a value in tree
        public boolean search(Node node, int key) {
            if (node == null) {
                return false;
            }
            
            if (node.data == key) {
                return true;
            }
            
            return search(node.left, key) || search(node.right, key);
        }
        
        // Find maximum value in tree
        public int findMax(Node node) {
            if (node == null) {
                return Integer.MIN_VALUE;
            }
            
            int max = node.data;
            int leftMax = findMax(node.left);
            int rightMax = findMax(node.right);
            
            if (leftMax > max) {
                max = leftMax;
            }
            if (rightMax > max) {
                max = rightMax;
            }
            
            return max;
        }
        
        // Find minimum value in tree
        public int findMin(Node node) {
            if (node == null) {
                return Integer.MAX_VALUE;
            }
            
            int min = node.data;
            int leftMin = findMin(node.left);
            int rightMin = findMin(node.right);
            
            if (leftMin < min) {
                min = leftMin;
            }
            if (rightMin < min) {
                min = rightMin;
            }
            
            return min;
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
        
        System.out.print("Level-order traversal: ");
        tree.levelOrder(tree.root);
        System.out.println();
        
        System.out.print("Enter value to search: ");
        int key = sc.nextInt();
        if (tree.search(tree.root, key)) {
            System.out.println("Value " + key + " found in tree");
        } else {
            System.out.println("Value " + key + " not found in tree");
        }
        
        System.out.println("Maximum value: " + tree.findMax(tree.root));
        System.out.println("Minimum value: " + tree.findMin(tree.root));
        
        sc.close();
    }
}
