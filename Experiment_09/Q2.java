import java.util.Scanner;

public class Q2 {

    
    static class ListNode {
        int data;
        ListNode next;
        
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class TreeNode {
        int data;
        TreeNode left, right;
        
        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    static class BinaryTree {
        ListNode head;
        TreeNode root;
        

        public void insertInList(int data) {
            ListNode newNode = new ListNode(data);
            
            if (head == null) {
                head = newNode;
                return;
            }
            
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        

        public TreeNode createTreeFromList() {
            if (head == null) return null;
            
            java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
            root = new TreeNode(head.data);
            queue.add(root);
            
            ListNode current = head.next;
            
            while (current != null) {
                TreeNode parent = queue.poll();
                

                if (current != null && current.data != -1) {
                    parent.left = new TreeNode(current.data);
                    queue.add(parent.left);
                }
                current = (current != null) ? current.next : null;
                

                if (current != null && current.data != -1) {
                    parent.right = new TreeNode(current.data);
                    queue.add(parent.right);
                }
                current = (current != null) ? current.next : null;
            }
            
            return root;
        }
        

        public void inorder(TreeNode node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.data + " ");
                inorder(node.right);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        
        System.out.print("Enter number of nodes (use -1 for null): ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            tree.insertInList(sc.nextInt());
        }
        
        tree.createTreeFromList();
        
        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();
        
        sc.close();
    }
}
