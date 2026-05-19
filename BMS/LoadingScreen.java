package BMS;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LoadingScreen {

    public void loadingScreen() throws InterruptedException {
        JFrame frame = new JFrame("Loading Screen");
        frame.setUndecorated(true);
        frame.setSize(1024, 640);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        jLabel1 = new JLabel();

        String loadingIconPath = "SplashScreen.png";
        URL loadingIconURL = getClass().getResource(loadingIconPath);
        ImageIcon image1 = createImageIcon(loadingIconURL);

        jLabel1.setIcon(image1);

        frame.add(jLabel1);
        frame.pack();
        Thread.sleep(2500);
        frame.dispose();

    }
    private ImageIcon createImageIcon(URL imageUrl) {
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        }
        return null;
    }
    private JLabel jLabel1;
    private JPanel jPanel1;
}




