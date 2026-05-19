package Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ContactFrame extends JFrame {
    private JFrame contactFrame;
    private JLabel aboutlInfoLabel, LineLabel1, LineLabel2, BitsAndBytes, developer, developerNames, developerNames2;
    private JLayeredPane overallPanel;
    private JButton back;
    private ImageIcon aboutIcon;

    public void contactFrameCode() {
        contactFrame = new JFrame("Contact");
        contactFrame.setSize(1024, 640);
        contactFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contactFrame.setResizable(false);

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
        aboutlInfoLabel = new JLabel("Contact");
        aboutlInfoLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
        aboutlInfoLabel.setForeground(new Color(0x4800A4));
        aboutlInfoLabel.setBounds(440, 30, 600, 30);
        overallPanel.add(aboutlInfoLabel, JLayeredPane.PALETTE_LAYER);

        // LineLabel1
        LineLabel1 = new JLabel("────────────────────────");
        LineLabel1.setFont(new Font("Century Gothic", Font.BOLD, 30));
        LineLabel1.setForeground(new Color(0x4800A4));
        LineLabel1.setBounds(440, 55, 800, 30);
        overallPanel.add(LineLabel1, JLayeredPane.PALETTE_LAYER);

        // LineLabel2
        LineLabel2 = new JLabel("────────────────────────");
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

        //Back button
        class backButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                contactFrame.dispose();
            }
        }

        back = new JButton("back");
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

        //Email
        JLabel email = new JLabel("Email");
        email.setFont(new Font("Century Gothic", Font.BOLD, 25));
        email.setForeground(new Color(0x888888));
        email.setVisible(true);

        JPanel emailPanel = new JPanel();
        emailPanel.setBackground(Color.white);
        emailPanel.setOpaque(false);
        emailPanel.setBounds(435, 100, 0, 0);
        emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(email);
        emailPanel.setSize(385, 50);
        overallPanel.add(emailPanel, JLayeredPane.PALETTE_LAYER);

        //Email Info
        JLabel emailInfo = new JLabel("ccsbitsandbytesofficial@gmail.com");
        emailInfo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        emailInfo.setForeground(new Color(0x888888));
        emailInfo.setVisible(true);

        JPanel emailInfoPanel = new JPanel();
        emailInfoPanel.setBackground(Color.white);
        emailInfoPanel.setOpaque(false);
        emailInfoPanel.setBounds(535, 105, 0, 0);
        emailInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        emailInfoPanel.add(emailInfo);
        emailInfoPanel.setSize(500, 50);
        overallPanel.add(emailInfoPanel, JLayeredPane.PALETTE_LAYER);


        //Facebook Page
        JLabel facebook = new JLabel("Facebook Page");
        facebook.setFont(new Font("Century Gothic", Font.BOLD, 25));
        facebook.setForeground(new Color(0x888888));
        facebook.setVisible(true);

        JPanel facebookPanel = new JPanel();
        facebookPanel.setBackground(Color.white);
        facebookPanel.setOpaque(false);
        facebookPanel.setBounds(435, 155, 0, 0);
        facebookPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        facebookPanel.add(facebook);
        facebookPanel.setSize(385, 50);
        overallPanel.add(facebookPanel, JLayeredPane.PALETTE_LAYER);

        //facebook Info Panel
        JLabel facebookInfo = new JLabel("Bits & Bytes");
        facebookInfo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        facebookInfo.setForeground(new Color(0x888888));
        facebookInfo.setVisible(true);

        JPanel facebookInfoPanel = new JPanel();
        facebookInfoPanel.setBackground(Color.white);
        facebookInfoPanel.setOpaque(false);
        facebookInfoPanel.setBounds(650, 160, 0, 0);
        facebookInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        facebookInfoPanel.add(facebookInfo);
        facebookInfoPanel.setSize(500, 50);
        overallPanel.add(facebookInfoPanel, JLayeredPane.PALETTE_LAYER);


        //Phone
        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("Century Gothic", Font.BOLD, 25));
        phone.setForeground(new Color(0x888888));
        phone.setVisible(true);

        JPanel phonePanel = new JPanel();
        phonePanel.setBackground(Color.white);
        phonePanel.setOpaque(false);
        phonePanel.setBounds(435, 210, 0, 0);
        phonePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        phonePanel.add(phone);
        phonePanel.setSize(385, 50);
        overallPanel.add(phonePanel, JLayeredPane.PALETTE_LAYER);

        //Phone Info
        JLabel phoneInfo = new JLabel("09224289430");
        phoneInfo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        phoneInfo.setForeground(new Color(0x888888));
        phoneInfo.setVisible(true);

        JPanel phoneInfoPanel = new JPanel();
        phoneInfoPanel.setBackground(Color.white);
        phoneInfoPanel.setOpaque(false);
        phoneInfoPanel.setBounds(535, 215, 0, 0);
        phoneInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        phoneInfoPanel.add(phoneInfo);
        phoneInfoPanel.setSize(500, 50);
        overallPanel.add(phoneInfoPanel, JLayeredPane.PALETTE_LAYER);


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



        contactFrame.setContentPane(overallPanel);
        contactFrame.setLocationRelativeTo(null);
        contactFrame.setVisible(true);

    }
    private ImageIcon createImageIcon(URL imageUrl) {
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } return null;
    }
}
