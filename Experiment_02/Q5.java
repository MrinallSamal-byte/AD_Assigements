import java.util.Scanner;

public class Q5 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();
        
        String hexadecimal = decimalToHex(decimal);
        System.out.println("Hexadecimal equivalent: " + hexadecimal);
        
        sc.close();
    }
    

    public static String decimalToHex(int decimal) {
        if (decimal == 0) {
            return "";
        }
        
        int remainder = decimal % 16;
        char hexChar;
        
        if (remainder < 10) {
            hexChar = (char) (remainder + '0');
        } else {
            hexChar = (char) (remainder - 10 + 'A');
        }
        
        return decimalToHex(decimal / 16) + hexChar;
    }
}
