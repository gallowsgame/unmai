import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RegisterFile implements RegisterInterface {
    private static final String FILE_NAME = "user_data.txt";

    @Override
    public boolean registerUser(String username, String password, String confirmpassword){

        if (username.isEmpty() || password.isEmpty() || confirmpassword.isEmpty()) 
        {
            System.out.println("Username or password can't be empty.");
            return false;
        } 
        else if (!password.equals(confirmpassword)) {
            return false;
            

        }
        else {
            try {
                
                FileWriter writer = new FileWriter(FILE_NAME, true); 
                writer.write(username + "," + password + "\n");
                writer.close();
                System.out.println("Registration successful!");
                return true;

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

    }

    public boolean isUsernameExists(String username) {
        try {
            FileReader fileReader = new FileReader("user_data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (/*parts.length >= 1 && */ parts[0].equals(username)) {
                    bufferedReader.close();
                    return true; // Username already exists
                }
            }

            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false; // Username is not found
    }

    
}
