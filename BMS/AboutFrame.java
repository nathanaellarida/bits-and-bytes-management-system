package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class AboutFrame extends JFrame {
    private JFrame aboutFrame;
    private JLabel aboutlInfoLabel, LineLabel1, LineLabel2, BitsAndBytes, developer, developerNames, developerNames2;
    private JLayeredPane overallPanel;
    private JButton back;
    private ImageIcon aboutIcon;

    public void aboutFrameCode() {
        aboutFrame = new JFrame("About");
        aboutFrame.setSize(1024, 640);
        aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutFrame.setResizable(false);

        String profileImageIconPath = "About.png";
        URL profileImageIconUrl = getClass().getResource(profileImageIconPath);

        overallPanel = new JLayeredPane();
        overallPanel.setLayout(null);
        overallPanel.setPreferredSize(new Dimension(1024, 640));

        if(profileImageIconUrl != null){
            aboutIcon = new ImageIcon(profileImageIconUrl);
            Image aboutImage = aboutIcon.getImage();
            Image newDash = aboutImage.getScaledInstance(1024, 640, Image.SCALE_SMOOTH);
            aboutIcon = new ImageIcon(newDash);
        }

        JLabel backgroundImageLabel = new JLabel(aboutIcon);
        backgroundImageLabel.setBounds(0, 0, 1024, 640);
        overallPanel.add(backgroundImageLabel, JLayeredPane.DEFAULT_LAYER);

        JLabel aboutImageLabel = new JLabel(aboutIcon);
        aboutImageLabel.setBounds(0, 0, 1024, 640);
        overallPanel.add(aboutImageLabel, JLayeredPane.DEFAULT_LAYER);

        //About  Label
        aboutlInfoLabel = new JLabel("About");
        aboutlInfoLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
        aboutlInfoLabel.setForeground(new Color(0x4800A4));
        aboutlInfoLabel.setBounds(440, 30, 600, 30);
        overallPanel.add(aboutlInfoLabel, JLayeredPane.PALETTE_LAYER);

        // LineLabel1
        LineLabel1 = new JLabel("——————————————————");
        LineLabel1.setFont(new Font("Century Gothic", Font.BOLD, 30));
        LineLabel1.setForeground(new Color(0x4800A4));
        LineLabel1.setBounds(440, 55, 800, 30);
        overallPanel.add(LineLabel1, JLayeredPane.PALETTE_LAYER);

        // LineLabel2
        LineLabel2 = new JLabel("——————————————————");
        LineLabel2.setFont(new Font("Century Gothic", Font.BOLD, 30));
        LineLabel2.setForeground(new Color(0x4800A4));
        LineLabel2.setBounds(440, 480, 800, 30);
        overallPanel.add(LineLabel2, JLayeredPane.PALETTE_LAYER);

        //Bits & Bytes Label
        BitsAndBytes = new JLabel("Bits & Bytes");
        BitsAndBytes.setFont(new Font("Century Gothic", Font.BOLD, 35));
        BitsAndBytes.setForeground(new Color(0xFFFFFF));
        BitsAndBytes.setVisible(true);

        JPanel BBPanel = new JPanel();
        BBPanel.setOpaque(false);
        BBPanel.setBounds(0, 370, 0, 0);
        BBPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        BBPanel.add(BitsAndBytes);
        BBPanel.setSize(385, 50);
        overallPanel.add(BBPanel, JLayeredPane.PALETTE_LAYER);

        JLabel line1 = new JLabel("Welcome to the Bits & Bytes Management System,");
        line1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line1.setForeground(new Color(0x888888));
        line1.setVisible(true);
        line1.setBounds(440, 100, 900, 30);
        overallPanel.add(line1, JLayeredPane.PALETTE_LAYER);

        JLabel line2 = new JLabel("the dedicated platform for the official publication of");
        line2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line2.setForeground(new Color(0x888888));
        line2.setVisible(true);
        line2.setBounds(440, 135, 900, 30);
        overallPanel.add(line2, JLayeredPane.PALETTE_LAYER);

        JLabel line3 = new JLabel("the College of Computer Studies at the University of");
        line3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line3.setForeground(new Color(0x888888));
        line3.setVisible(true);
        line3.setBounds(440, 165, 900, 30);
        overallPanel.add(line3, JLayeredPane.PALETTE_LAYER);

        JLabel line4 = new JLabel("Cebu Lapu-Lapu and Mandaue. Here, our streamlined");
        line4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line4.setForeground(new Color(0x888888));
        line4.setVisible(true);
        line4.setBounds(440, 195, 900, 30);
        overallPanel.add(line4, JLayeredPane.PALETTE_LAYER);

        JLabel line5 = new JLabel("system equips Bits & Bytes members with user-friendly");
        line5.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line5.setForeground(new Color(0x888888));
        line5.setVisible(true);
        line5.setBounds(440, 225, 900, 30);
        overallPanel.add(line5, JLayeredPane.PALETTE_LAYER);

        JLabel line6 = new JLabel("tools, covering a range of essential tasks such as event");
        line6.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line6.setForeground(new Color(0x888888));
        line6.setVisible(true);
        line6.setBounds(440, 255, 900, 30);
        overallPanel.add(line6, JLayeredPane.PALETTE_LAYER);

        JLabel line7 = new JLabel("planning, scheduling, budget management, to-do lists,");
        line7.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line7.setForeground(new Color(0x888888));
        line7.setVisible(true);
        line7.setBounds(440, 285, 900, 30);
        overallPanel.add(line7, JLayeredPane.PALETTE_LAYER);

        JLabel line8 = new JLabel("and attendance tracking. Made for optimal efficiency,");
        line8.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line8.setForeground(new Color(0x888888));
        line8.setVisible(true);
        line8.setBounds(440, 315, 900, 30);
        overallPanel.add(line8, JLayeredPane.PALETTE_LAYER);

        JLabel line9 = new JLabel("our system is committed to ensuring the seamless");
        line9.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line9.setForeground(new Color(0x888888));
        line9.setVisible(true);
        line9.setBounds(440, 345, 900, 30);
        overallPanel.add(line9, JLayeredPane.PALETTE_LAYER);

        JLabel line10 = new JLabel("execution of vital organizational functions within");
        line10.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line10.setForeground(new Color(0x888888));
        line10.setVisible(true);
        line10.setBounds(440, 375, 900, 30);
        overallPanel.add(line10, JLayeredPane.PALETTE_LAYER);

        JLabel line11 = new JLabel("the Bits & Bytes community.");
        line11.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        line11.setForeground(new Color(0x888888));
        line11.setVisible(true);
        line11.setBounds(440, 405, 900, 30);
        overallPanel.add(line11, JLayeredPane.PALETTE_LAYER);



        //Back button
        class backButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                DashBoard dashBoard = new DashBoard();
                dashBoard.dashBoard();
                aboutFrame.dispose();
            }
        }

        back = new JButton("Back");
        back.setSize(120, 100);
        back.setFont(new Font("Century Gothic", Font.BOLD, 20));
        back.setForeground(new Color(0x9F5BF5));
        back.setBackground(new Color(0xFFFFFF));
        back.setVisible(true);
        back.setFocusable(false);
        back.addActionListener(new backButtonListener());

        JPanel backPanel = new JPanel();
        backPanel.setOpaque(false);
        backPanel.setBounds(0, 450, 0, 0);
        backPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        backPanel.add(back);
        backPanel.setSize(385, 50);
        overallPanel.add(backPanel, JLayeredPane.PALETTE_LAYER);

        //developer Label
        developer = new JLabel("Developed by");
        developer.setFont(new Font("Century Gothic", Font.BOLD, 13));
        developer.setForeground(new Color(0x888888));
        developer.setVisible(true);

        JPanel developerPanel = new JPanel();
        developerPanel.setBackground(Color.red);
        developerPanel.setOpaque(false);
        developerPanel.setBounds(500, 510, 0, 0);
        developerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        developerPanel.add(developer);
        developerPanel.setSize(385, 50);
        overallPanel.add(developerPanel, JLayeredPane.PALETTE_LAYER);
















        //Developer Names 1
        developerNames = new JLabel("Larida, Nathanael L.       Wamsley, Jhoanne Claire M");
        developerNames.setFont(new Font("Century Gothic", Font.BOLD, 13));
        developerNames.setForeground(new Color(0x888888));
        developerNames.setVisible(true);

        JPanel developerNamesPanel = new JPanel();
        developerNamesPanel.setBackground(Color.red);
        developerNamesPanel.setOpaque(false);
        developerNamesPanel.setBounds(500, 535, 0, 0);
        developerNamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        developerNamesPanel.add(developerNames);
        developerNamesPanel.setSize(385, 50);
        overallPanel.add(developerNamesPanel, JLayeredPane.PALETTE_LAYER);

        //Developer Names 2
        developerNames2 = new JLabel("Villadolid, Lowela O.       Wamsley, Virginia May M.");
        developerNames2.setFont(new Font("Century Gothic", Font.BOLD, 13));
        developerNames2.setForeground(new Color(0x888888));
        developerNames2.setVisible(true);

        JPanel developerNames2Panel = new JPanel();
        developerNames2Panel.setBackground(Color.red);
        developerNames2Panel.setOpaque(false);
        developerNames2Panel.setBounds(500, 555, 0, 0);
        developerNames2Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        developerNames2Panel.add(developerNames2);
        developerNames2Panel.setSize(385, 50);
        overallPanel.add(developerNames2Panel, JLayeredPane.PALETTE_LAYER);



        aboutFrame.setContentPane(overallPanel);
        aboutFrame.setLocationRelativeTo(null);
        aboutFrame.setVisible(true);

    }
    private ImageIcon createImageIcon(URL imageUrl) {
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } return null;
    }
}
