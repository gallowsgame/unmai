import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratePasswordUI extends JFrame implements ChangeListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JSlider slider;
    private JButton generateButton;
    private JTextField generatedPassword;

    public GeneratePasswordUI() {
        Initialize();
        setComponents();
        Finally();
    }

    public void Initialize() {
        setTitle("Generate Password");
        setSize(400, 300);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 2000, 1);
        slider.setPreferredSize(new Dimension(200, 50));
        slider.addChangeListener(this);
    }

    public void setComponents() {
        panel = new JPanel();
        label = new JLabel();
        generatedPassword = new JTextField(20);
        generateButton = new JButton("Generate!");

        panel.setLayout(new FlowLayout());

        panel.add(slider);
        panel.add(generateButton);
        panel.add(label);
        panel.add(generatedPassword);

        add(panel);

        label.setText("Password Length: " + slider.getValue());

        // Add ActionListener for the "Generate!" button

       // public void actionPerformed(ActionListener)
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int passwordLength = slider.getValue();
                PasswordGenerator passwordGenerator = new PasswordGenerator();
                String generated = passwordGenerator.generatePassword(passwordLength);
                
                if (passwordLength == 0) {
                    JOptionPane.showMessageDialog(GeneratePasswordUI.this, "No Password Generated");

                }
                // Append a new line to the generated password
                generated += "\n";
                
                generatedPassword.setText(generated);
            }
        });

    }

    public void Finally() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("Password Length: " + slider.getValue());
    }

}
