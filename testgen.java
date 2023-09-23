import java.util.Scanner;

public class testgen {
    public static void main(String[] args) {

        // Change this to the desired password length
        System.out.println("How many length : ");
        Scanner inputLength = new Scanner(System.in);
        int length = inputLength.nextInt();
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        
        String password = passwordGenerator.generatePassword(length);
        System.out.println("Generated Password: " + password);
    }
}