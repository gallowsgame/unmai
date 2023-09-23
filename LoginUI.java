import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

    // ประกาศ components ต่างๆที่ต้องใช้
    private JPanel panel;
    private JButton loginButton, mainregisButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    

    // 
    public LoginUI(){
        initialize();
        setComponents();
        Finally();
    }

    // set title and size
    public void initialize (){
        setTitle("Password Generator");
        setSize(500,200);
    }

    // align all components properly
    public void setComponents(){

        panel = new JPanel(new GridLayout(4,5));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        mainregisButton = new JButton("Register");

        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainregisButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        // เมื่อกด Login จะเช็คข้อมูลผู้ใช้จาก user_data.txt 
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fetch data from the fields
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
    
                // Authenticate the user using the Authenticator
                boolean loggedIn = Authenticator.authenticateLogin(username, password);
                boolean AdminloggedIN = Authenticator.authenticateAdmin(username, password);
    
                if (loggedIn) {
                    JOptionPane.showMessageDialog(LoginUI.this, "Login successful!");
                    // Add code here to perform actions after successful login
                    new GeneratePasswordUI();
                    dispose();

                } else if (AdminloggedIN) {
                    JOptionPane.showMessageDialog(LoginUI.this, "ADMIN!");

                }
                 else {
                    JOptionPane.showMessageDialog(LoginUI.this, "Login failed. Invalid username or password.");
                }
            }
        });


        // button function
        mainregisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // เมื่อ click ปุ่ม register จะ popup RegisterUI page
                new RegisterUI();
                
                // ปิดหน้าต่าง LoginUI
                dispose();
            }
        });
        
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); 
        panel.add(loginButton);
        panel.add(new JLabel()); 
        panel.add(mainregisButton);

        add(panel, BorderLayout.CENTER);


    }
    
    // 
    public void Finally (){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        
    }



    
}
