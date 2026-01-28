import java.util.Scanner;
import java.util.Stack;

public class Q7 {
    // Objective: Evaluate postfix expression using stack
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a postfix expression (space-separated): ");
        String expression = sc.nextLine();
        
        int result = evaluatePostfix(expression);
        System.out.println("Result: " + result);
        
        sc.close();
    }
    
    // Function to evaluate postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            // If token is an operator
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    System.out.println("Invalid expression");
                    return 0;
                }
                
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token);
                stack.push(result);
            }
            // If token is an operand
            else {
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid token: " + token);
                    return 0;
                }
            }
        }
        
        if (stack.size() != 1) {
            System.out.println("Invalid expression");
            return 0;
        }
        
        return stack.pop();
    }
    
    // Function to check if token is an operator
    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }
    
    // Function to perform operation
    public static int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    System.out.println("Division by zero");
                    return 0;
                }
                return operand1 / operand2;
            default:
                return 0;
        }
    }
}
