import java.util.Scanner;
import java.util.Stack;

public class Q6 {
    // Objective: Check for balanced parentheses using stack
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter an expression: ");
        String expression = sc.nextLine();
        
        if (isBalanced(expression)) {
            System.out.println("Expression has balanced parentheses");
        } else {
            System.out.println("Expression has unbalanced parentheses");
        }
        
        sc.close();
    }
    
    // Function to check if parentheses are balanced
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // Stack should be empty for balanced expression
        return stack.isEmpty();
    }
}
