package BMS;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LoadingScreen screen = new LoadingScreen();
        screen.loadingScreen();
        Login loginFrame = new Login();
        //ImageIcon image = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Login\\Bits&Bytes2.png");
        //loginFrame.setIconImage(image.getImage());
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }
}
