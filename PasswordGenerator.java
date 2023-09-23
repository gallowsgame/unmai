import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator implements PasswordGeneratorInterface {

    
    private final String UpperChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LowerChar = "abcdefghijklmnopqrstuvwxyz";
    private final String Numbers = "0123456789";
    private final String Symbols = "!@#$%^&*()-_+=<>?./";
    
    @Override
    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new SecureRandom();

        String allCharacters = Symbols + UpperChar + LowerChar + Numbers + Symbols ;

        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(index));

        }

        String PS = password.toString();
        System.out.println(PS);
        return password.toString();
        
    }
}

