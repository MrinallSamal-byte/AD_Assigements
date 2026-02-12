import java.util.Scanner;

public class Q5 {

    // Hexadecimal digits
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            
            System.out.print("Enter a decimal number: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            int decimal = sc.nextInt();
            
            if (decimal < 0) {
                System.out.println("Error: Please enter a non-negative number.");
                return;
            }
            
            String hexadecimal = decimalToHex(decimal);
            System.out.println("Hexadecimal equivalent: " + hexadecimal);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
    
    /**
     * Convert decimal to hexadecimal using recursion
     * Time Complexity: O(log n) where n is the decimal number
     * Space Complexity: O(log n) due to recursion stack
     */
    public static String decimalToHex(int decimal) {
        // Base case
        if (decimal == 0) {
            return "0";
        }
        
        return decimalToHexHelper(decimal);
    }
    
    /**
     * Helper method for recursive conversion
     */
    private static String decimalToHexHelper(int decimal) {
        if (decimal == 0) {
            return "";
        }
        
        int remainder = decimal % 16;
        
        // Use lookup table for efficiency
        char hexChar = HEX_DIGITS[remainder];
        
        return decimalToHexHelper(decimal / 16) + hexChar;
    }
}
