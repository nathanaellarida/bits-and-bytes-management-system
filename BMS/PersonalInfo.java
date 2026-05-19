package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.text.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import java.nio.file.Files;

public class PersonalInfo extends JFrame {
    private final Path path = Paths.get("C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\users.txt");
    private final String filename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\personalinfo" + Login.id + ".txt";
      
    private static final String ID_FORMAT = "000";
    private static final String USERNAME_FORMAT = "                         ";
    private static final String PASSWORD_FORMAT = "                         ";
    private static final String delimiter = ",";
    private static String s = ID_FORMAT + delimiter + USERNAME_FORMAT + delimiter + PASSWORD_FORMAT + System.getProperty("line.separator");
    private static final int RECSIZE = s.length();
    
    private String idDetail = " ";
    private String fNameDetail = " ";
    private String lNameDetail = " ";
    private String positionDetail = " ";
    private String passwordDetail = " ";
    private String emailDetail = " ";
    private String ageDetail = " ";
    private String phoneDetail = " ";
    
    private JFrame personalFrame;
    private JLabel personalInfoLabel, LineLabel1, LineLabel2;
    private JLayeredPane overallPanel;
    private JButton edit, home;

    private JLabel FnameInfo = new JLabel();
    private JLabel LnameInfo = new JLabel();
    private JLabel positionInfo = new JLabel();
    private JLabel ageInfo = new JLabel();
    private JLabel emailInfo = new JLabel();
    private JLabel phoneInfo = new JLabel();
    private ImageIcon profileIcon;

    public void updateLabels(String newFname, String newLname, String newPosition, String newAge, String newEmail, String newPhone) {
        this.FnameInfo.setText(newFname);
        this.LnameInfo.setText(newLname);
        this.positionInfo.setText(newPosition);
        this.ageInfo.setText(newAge);
        this.emailInfo.setText(newEmail);
        this.phoneInfo.setText(newPhone);
    }

    public void personalInfoCode() {
        readInfoFromFile();
        
        personalFrame = new JFrame("Personal Information");
        personalFrame.setSize(1024, 640);
        personalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        personalFrame.setResizable(false);

        String profileImageIconPath = "profilepic2.png";
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
        // Background Image
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

        //Labels of values in EditPersonalInfo
        if(!FnameInfo.getText().isEmpty()){
            FnameInfo.setText(FnameInfo.getText());
        } else {
            FnameInfo.setText(" ");
        }

        if(!LnameInfo.getText().isEmpty()) {
            LnameInfo.setText(LnameInfo.getText());
        } else {
            LnameInfo.setText(" ");
        }

        if(!positionInfo.getText().isEmpty()) {
            positionInfo.setText(positionInfo.getText());
        } else {
            positionInfo.setText(" ");
        }

        if(!ageInfo.getText().isEmpty()) {
            ageInfo.setText(ageInfo.getText());
        } else {
            ageInfo.setText(" ");
        }

        if(!emailInfo.getText().isEmpty()) {
            emailInfo.setText(emailInfo.getText());
        } else {
            emailInfo.setText(" ");
        }

        if(!phoneInfo.getText().isEmpty()) {
            phoneInfo.setText(phoneInfo.getText());
        } else {
            phoneInfo.setText(" ");
        }

        FnameInfo.setFont(new Font("Century Gothic", Font.BOLD, 18));
        FnameInfo.setForeground(new Color(0x888888));


        LnameInfo.setFont(new Font("Century Gothic", Font.BOLD, 18));
        LnameInfo.setForeground(new Color(0x888888));

        positionInfo.setFont(new Font("Century Gothic", Font.BOLD, 18));
        positionInfo.setForeground(new Color(0x888888));

        ageInfo.setFont(new Font("Century Gothic", Font.BOLD, 18));
        ageInfo.setForeground(new Color(0x888888));

        emailInfo.setFont(new Font("Century Gothic", Font.BOLD, 18));
        emailInfo.setForeground(new Color(0x888888));

        phoneInfo.setFont(new Font("Century Gothic", Font.BOLD, 18));
        phoneInfo.setForeground(new Color(0x888888));

        JLabel Fname = new JLabel("First Name           " + FnameInfo.getText());
        JLabel Lname = new JLabel("Last Name           " + LnameInfo.getText());
        JLabel position = new JLabel("Position                "+ positionInfo.getText());
        JLabel age = new JLabel("Age                      "+ ageInfo.getText());
        JLabel email = new JLabel("Email                    "+ emailInfo.getText());
        JLabel phone = new JLabel("Phone                  "+ phoneInfo.getText());

        //Fname
        Fname.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Fname.setForeground(new Color(0x888888));
        Fname.setBounds(440, 120, 512, 30);
        overallPanel.add(Fname);

        //Lname
        Lname.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Lname.setForeground(new Color(0x888888));
        Lname.setBounds(440, 175, 512, 30);
        overallPanel.add(Lname);

        //position
        position.setFont(new Font("Century Gothic", Font.BOLD, 18));
        position.setForeground(new Color(0x888888));
        position.setBounds(440, 230, 512, 30);
        overallPanel.add(position);

        //age
        age.setFont(new Font("Century Gothic", Font.BOLD, 18));
        age.setForeground(new Color(0x888888));
        age.setBounds(440, 285, 512, 30);
        overallPanel.add(age);

        //email
        email.setFont(new Font("Century Gothic", Font.BOLD, 18));
        email.setForeground(new Color(0x888888));
        email.setBounds(440, 340, 512, 30);
        overallPanel.add(email);

        //Phone
        phone.setFont(new Font("Century Gothic", Font.BOLD, 18));
        phone.setForeground(new Color(0x888888));
        phone.setBounds(440, 395, 512, 30);
        overallPanel.add(phone);

        //Username
        JLabel username = new JLabel(searchUsername(Login.id));
        username.setFont(new Font("Century Gothic", Font.BOLD, 30));
        username.setForeground(Color.white);

        //UserName and ID Panel
        JPanel usernamePanel = new JPanel();
        usernamePanel.setOpaque(false);
        usernamePanel.setBounds(0, 340, 0, 0);
        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        usernamePanel.add(username);
        usernamePanel.setSize(385, 50);
        overallPanel.add(usernamePanel, JLayeredPane.PALETTE_LAYER);

        //IdNum
        JLabel idNum = new JLabel("ID No. " + searchId(Login.id));
        idNum.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        idNum.setForeground(Color.white);

        //UserName and ID Panel
        JPanel IDPanel = new JPanel();
        IDPanel.setOpaque(false);
        IDPanel.setBounds(0, 375, 0, 0);
        IDPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        IDPanel.add(idNum);
        IDPanel.setSize(385, 50);
        overallPanel.add(IDPanel, JLayeredPane.PALETTE_LAYER);


        class editButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                EditPersonalInfo editInfo = new EditPersonalInfo(PersonalInfo.this);
                editInfo.editPersonalInfoCode();
                personalFrame.dispose();
            }
        }


        edit = new JButton("Edit");
        edit.setSize(120, 100);
        edit.setFont(new Font("Century Gothic", Font.BOLD, 20));
        edit.setForeground(new Color(0x9F5BF5));
        edit.setBackground(new Color(0xFFFFFF));
        edit.setVisible(true);
        edit.setFocusable(false);
        edit.addActionListener(new editButtonListener());

        JPanel editPanel = new JPanel();
        editPanel.setOpaque(false);
        editPanel.setBounds(0, 410, 0, 0);
        editPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        editPanel.add(edit);
        editPanel.setSize(385, 50);
        overallPanel.add(editPanel, JLayeredPane.PALETTE_LAYER);

        class HomeButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                DashBoard dashBoard = new DashBoard();
                dashBoard.dashBoard();
                personalFrame.dispose();
            }
        }

        home = new JButton("Home");
        home.setSize(100, 100);
        home.setFont(new Font("Century Gothic", Font.BOLD, 20));
        home.setForeground(new Color(0xFFFFFF));
        home.setBackground(new Color(0xFFFFFF));
        home.setVisible(true);
        home.setBounds(10, 20, 100, 30);
        home.setFocusable(false);
        home.addActionListener(new HomeButtonListener());
        home.setOpaque(false);
        home.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        overallPanel.add(home, JLayeredPane.PALETTE_LAYER);

        personalFrame.setContentPane(overallPanel);
        personalFrame.setLocationRelativeTo(null);
        personalFrame.setVisible(true);
    }
    private ImageIcon createImageIcon(URL imageUrl) {
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } return null;
    }
    
    public String searchUsername(int id) {
      byte[] data = s.getBytes();
      ByteBuffer buffer = ByteBuffer.wrap(data);
      FileChannel fc = null;
      
      String idFound = null;
      String usernameFound = null;
      String passwordFound = null;
      
      try {
          int currentId = id;
          fc = (FileChannel) Files.newByteChannel(path, StandardOpenOption.READ, StandardOpenOption.WRITE);
          buffer = ByteBuffer.wrap(data);
          fc.position(currentId * RECSIZE);
          fc.read(buffer);
          s = new String(data);
          String[] details = s.split(",");
          idFound = details[0].trim();
          usernameFound = details[1].trim();
          passwordFound = details[2].trim();
          System.out.println("ID number: " + idFound);
          System.out.println("Username: " + usernameFound);
          System.out.println("Password: " + passwordFound);
          
          fc.close();
      } catch(IOException e) {
          System.out.println("Error message: " + e);
      } catch(InputMismatchException e) {
          System.out.println(e.getMessage());
      }
      
      return usernameFound;
   }
   
   public String searchId(int id) {
      byte[] data = s.getBytes();
      ByteBuffer buffer = ByteBuffer.wrap(data);
      FileChannel fc = null;
      
      String idFound = null;
      String usernameFound = null;
      String passwordFound = null;
      
      try {
          int currentId = id;
          fc = (FileChannel) Files.newByteChannel(path, StandardOpenOption.READ, StandardOpenOption.WRITE);
          buffer = ByteBuffer.wrap(data);
          fc.position(currentId * RECSIZE);
          fc.read(buffer);
          s = new String(data);
          String[] details = s.split(",");
          idFound = details[0].trim();
          usernameFound = details[1].trim();
          passwordFound = details[2].trim();
          System.out.println("ID number: " + idFound);
          System.out.println("Username: " + usernameFound);
          System.out.println("Password: " + passwordFound);
          
          fc.close();
      } catch(IOException e) {
          System.out.println("Error message: " + e);
      } catch(InputMismatchException e) {
          System.out.println(e.getMessage());
      }
      
      return idFound;
   }
   
   public void readInfoFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                
                idDetail = details[0].trim();
                fNameDetail = details[1].trim();
                lNameDetail = details[2].trim();
                positionDetail = details[3].trim();
                passwordDetail = details[4].trim();
                emailDetail = details[5];
                ageDetail = details[6];
                phoneDetail = details[7];
                
                System.out.println(fNameDetail + "," + lNameDetail + "," + positionDetail + "," + ageDetail + "," + emailDetail + "," + phoneDetail);
                
                updateLabels(fNameDetail, lNameDetail, positionDetail, ageDetail, emailDetail, phoneDetail);
            }
        } catch(IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }
}
