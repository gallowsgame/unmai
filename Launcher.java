//import java.awt.*;
//import javax.swing.*;

import javax.swing.SwingUtilities;

class Launcher {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginUI();
            }
        });
    }

}