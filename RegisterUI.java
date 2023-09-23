import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RegisterUI extends JFrame {

    private JPanel panel;
    private JButton regisButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public RegisterUI() {
        initialize();
        setComponents();
        finalizeUI();
    }

    private void initialize() {
        setTitle("Register");
        setSize(340, 150);
    }

    private void setComponents() {
        panel = new JPanel(new FlowLayout());

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);

        regisButton = new JButton("Register");
        regisButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        regisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fetch data from the fields
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmpassword = new String(confirmPasswordField.getPassword());
        
                // Check if username, password, or confirm password is blank
                if (username.isBlank() || password.isBlank() || confirmpassword.isBlank()) {
                    JOptionPane.showMessageDialog(RegisterUI.this, "Username or password cannot be blank.");
                } else if (!password.equals(confirmpassword)) {
                    JOptionPane.showMessageDialog(RegisterUI.this, "Password and confirm password do not match.");
                } else {
                    // Check if the username already exists
                    RegisterFile userdata = new RegisterFile();
                    if (userdata.isUsernameExists(username)) {
                        JOptionPane.showMessageDialog(RegisterUI.this, "Username already exists. Please choose another one.");
                    } else {
                        // Proceed with registration
                        userdata.registerUser(username, password, confirmpassword);
                        JOptionPane.showMessageDialog(RegisterUI.this, "Registration successful!");
                        new LoginUI();
                        dispose();
                    }
                }
            }
        });
        
                

       /*  regisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Open the registration page (Create an instance of RegisterUI)
                new LoginUI();
                // Close the current login page (optional)
                dispose();
            }
        });*/

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Confirm Password:"));
        panel.add(confirmPasswordField);
        panel.add(regisButton);

        add(panel, BorderLayout.CENTER);
    }

    private void finalizeUI() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}