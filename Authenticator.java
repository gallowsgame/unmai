import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Authenticator {

    public static boolean authenticateLogin(String user_username, String user_password) {
        try {
            FileReader fileReader = new FileReader("user_data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(user_username) && parts[1].equals(user_password)) {
                    bufferedReader.close();
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean isUsernameExists(String username) {
        try {
            FileReader fileReader = new FileReader("user_data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (/*parts.length >= 1 && */parts[0].equals(username)) {
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

    public static boolean authenticateAdmin(String admin_username, String admin_password) {
        try {
            FileReader fileReader = new FileReader("admin_data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(admin_username) && parts[1].equals(admin_password)) {
                    bufferedReader.close();
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    
}
