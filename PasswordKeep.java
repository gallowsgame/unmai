import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PasswordKeep {
    
    private Map<String, String> userPasswords;

    public PasswordKeep() {
        userPasswords = new HashMap<>();
        loadUserPasswordsFromFile(); // Load existing data from the file (if any)
    }

    public void addUserPassword(String username, String password) {
        userPasswords.put(username, password);
        saveUserPasswordsToFile(); // Save the updated data to the file
    }

    public String getPasswordForUser(String username) {
        return userPasswords.get(username);
    }

    private void loadUserPasswordsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("userpassgen.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    userPasswords.put(username, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUserPasswordsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userpassgen.txt"))) {
            for (Map.Entry<String, String> entry : userPasswords.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
