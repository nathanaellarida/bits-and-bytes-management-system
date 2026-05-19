package PersonalInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.net.URL;

public class EditPersonalInfo extends JFrame {
    private PersonalInfo personalInfo;
    private JFrame personalFrame;
    private ImageIcon profileImage;
    private JLabel personalInfoLabel, LineLabel1, LineLabel2;
    private JLayeredPane overallPanel;
    private JButton save, changePass, back;
    private ImageIcon profileIcon;

    public EditPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void editPersonalInfoCode() {
        personalFrame = new JFrame("Personal Information");
        personalFrame.setSize(1024, 640);
        personalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        personalFrame.setResizable(false);

        String profileImageIconPath = "profilepic1.png";
        URL profileImageIconUrl = getClass().getResource(profileImageIconPath);


        // Create a custom JLayeredPane to draw the background image
        overallPanel = new JLayeredPane();
        overallPanel.setLayout(null);
        overallPanel.setPreferredSize(new Dimension(1024, 640));

        if(profileImageIconUrl != null){
            profileIcon = new ImageIcon(profileImageIconUrl);
            Image profileImage = profileIcon.getImage();
            Image newDash = profileImage.getScaledInstance(1024, 640, Image.SCALE_SMOOTH);
            profileIcon = new ImageIcon(newDash);
        }

        // Add components to the layered pane with different layers
        JLabel backgroundImageLabel = new JLabel(profileIcon);
        backgroundImageLabel.setBounds(0, 0, 1024, 640);
        overallPanel.add(backgroundImageLabel, JLayeredPane.DEFAULT_LAYER);

        // Personal Information Label
        personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
        personalInfoLabel.setForeground(new Color(0x4800A4));
        personalInfoLabel.setBounds(440, 30, 600, 30);
        overallPanel.add(personalInfoLabel, JLayeredPane.PALETTE_LAYER);

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

        JLabel Fname = new JLabel("First Name");
        JLabel Lname = new JLabel("Last Name");
        JLabel position = new JLabel("Position");
        JLabel age = new JLabel("Age");
        JLabel email = new JLabel("Email");
        JLabel phone = new JLabel("Phone");

        JTextField FnameField = new JTextField();
        JTextField LnameField = new JTextField();
        JTextField positionField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        //Fname
        Fname.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Fname.setForeground(new Color(0x888888));
        Fname.setBounds(440, 120, 512, 30);
        overallPanel.add(Fname);

        //FnameField
        FnameField.setText("    Enter First Name");
        FnameField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        FnameField.setForeground(new Color(0x888888));
        FnameField.setBounds(580, 120, 380, 40);
        FnameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                FnameField.setText("");
                FnameField.removeKeyListener(this);
            }
        });
        overallPanel.add(FnameField);

        //Lname
        Lname.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Lname.setForeground(new Color(0x888888));
        Lname.setBounds(440, 175, 512, 30);
        overallPanel.add(Lname);

        //LnameField
        LnameField.setText("    Enter Last Name");
        LnameField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        LnameField.setForeground(new Color(0x888888));
        LnameField.setBounds(580, 175, 380, 40);
        LnameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                LnameField.setText("");
                LnameField.removeKeyListener(this);
            }
        });
        overallPanel.add(LnameField);

        //position
        position.setFont(new Font("Century Gothic", Font.BOLD, 18));
        position.setForeground(new Color(0x888888));
        position.setBounds(440, 230, 512, 30);
        overallPanel.add(position);

        //positionField
        positionField.setText("    Enter Position");
        positionField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        positionField.setForeground(new Color(0x888888));
        positionField.setBounds(580, 230, 380, 40);
        positionField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                positionField.setText("");
                positionField.removeKeyListener(this);
            }
        });
        overallPanel.add(positionField);

        //age
        age.setFont(new Font("Century Gothic", Font.BOLD, 18));
        age.setForeground(new Color(0x888888));
        age.setBounds(440, 285, 512, 30);
        overallPanel.add(age);

        //ageField
        ageField.setText("    Enter Age");
        ageField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ageField.setForeground(new Color(0x888888));
        ageField.setBounds(580, 285, 380, 40);
        ageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                ageField.setText("");
                ageField.removeKeyListener(this);
            }
        });
        overallPanel.add(ageField);

        //email
        email.setFont(new Font("Century Gothic", Font.BOLD, 18));
        email.setForeground(new Color(0x888888));
        email.setBounds(440, 340, 512, 30);
        overallPanel.add(email);

        //emailField
        emailField.setText("    Enter Email");
        emailField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        emailField.setForeground(new Color(0x888888));
        emailField.setBounds(580, 340, 380, 40);
        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                emailField.setText("");
                emailField.removeKeyListener(this);
            }
        });
        overallPanel.add(emailField);

        //Phone
        phone.setFont(new Font("Century Gothic", Font.BOLD, 18));
        phone.setForeground(new Color(0x888888));
        phone.setBounds(440, 395, 512, 30);
        overallPanel.add(phone);

        //phoneField
        phoneField.setText("    Enter Phone Number");
        phoneField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        phoneField.setForeground(new Color(0x888888));
        phoneField.setBounds(580, 395, 380, 40);
        phoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                phoneField.setText("");
                phoneField.removeKeyListener(this);
            }
        });
        overallPanel.add(phoneField);

        //Username
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Century Gothic", Font.BOLD, 30));
        username.setForeground(Color.white);

        //UserName and ID Panel
        JPanel usernamePanel = new JPanel();
        usernamePanel.setOpaque(false);
        usernamePanel.setBounds(0, 320, 0, 0);
        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        usernamePanel.add(username);
        usernamePanel.setSize(385, 50);
        overallPanel.add(usernamePanel, JLayeredPane.PALETTE_LAYER);

        //IdNum
        JLabel idNum = new JLabel("ID No. ");
        idNum.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        idNum.setForeground(Color.white);

        //UserName and ID Panel
        JPanel IDPanel = new JPanel();
        IDPanel.setOpaque(false);
        IDPanel.setBounds(0, 360, 0, 0);
        IDPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        IDPanel.add(idNum);
        IDPanel.setSize(385, 50);
        overallPanel.add(IDPanel, JLayeredPane.PALETTE_LAYER);

        //changePass Button
        class changePassListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String newPass = JOptionPane.showInputDialog(null, "Enter New Password:");
                String newPassChoice = JOptionPane.showInputDialog(null, "Confirm Password?");
                if(newPassChoice.equals(newPass)){
                    JOptionPane.showMessageDialog(null, "Password Successfully Changed");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password");
                }

            }
        }

        changePass = new JButton("Change Password");
        changePass.setSize(100, 100);
        changePass.setFont(new Font("Century Gothic", Font.BOLD, 20));
        changePass.setForeground(new Color(0x9F5BF5));
        changePass.setBackground(new Color(0xFFFFFF));
        changePass.setVisible(true);
        changePass.setFocusable(false);
        changePass.addActionListener(new changePassListener());

        JPanel changePassPanel = new JPanel();
        changePassPanel.setOpaque(false);
        changePassPanel.setBounds(0, 410, 0, 0);
        changePassPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        changePassPanel.add(changePass);
        changePassPanel.setSize(385, 50);
        overallPanel.add(changePassPanel, JLayeredPane.PALETTE_LAYER);


        class saveButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String newFname = FnameField.getText();
                String newLname = LnameField.getText();
                String newPosition = positionField.getText();
                String newAge = ageField.getText();
                String newEmail = emailField.getText();
                String newPhone = phoneField.getText();

                personalInfo.updateLabels(newFname, newLname, newPosition, newAge, newEmail, newPhone);
                personalInfo.personalInfoCode();
                personalFrame.dispose();
            }
        }


        save = new JButton("Save");
            save.setSize(100, 100);
            save.setFont(new Font("Century Gothic", Font.BOLD, 20));
            save.setForeground(Color.white);
            save.setBackground(new Color(0x9F5BF5));
            save.setVisible(true);
            save.setBounds(650, 530, 100, 35);
            save.setFocusable(false);
            save.addActionListener(new saveButtonListener());
        overallPanel.add(save);


        //Back Button
        class BackButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                PersonalInfo saveInfo = new PersonalInfo();
                saveInfo.personalInfoCode();
                personalFrame.dispose();
            }
        }

        back = new JButton("Back");
        back.setSize(100, 100);
        back.setFont(new Font("Century Gothic", Font.BOLD, 20));
        back.setForeground(new Color(0xFFFFFF));
        back.setBackground(new Color(0xFFFFFF));
        back.setVisible(true);
        back.setBounds(10, 20, 95, 30);
        back.setFocusable(false);
        back.addActionListener(new BackButtonListener());
        back.setOpaque(false);
        back.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        overallPanel.add(back, JLayeredPane.PALETTE_LAYER);

        personalFrame.setContentPane(overallPanel);
        personalFrame.setLocationRelativeTo(null);
        personalFrame.setVisible(true);
    }
    private ImageIcon createImageIcon(URL imageUrl) {
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } return null;
    }
}
