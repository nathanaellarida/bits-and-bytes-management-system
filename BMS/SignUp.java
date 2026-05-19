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

import java.text.DecimalFormat;

public class SignUp extends javax.swing.JFrame implements FileIOSignUp {
   private Path path = Paths.get("C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\users.txt");
   private String filename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\users.txt";
   private String filenamePersonalInfo = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\personalinfo";
      
   private static final String ID_FORMAT = "000";
   private static final String USERNAME_FORMAT = "                         ";
   private static final String PASSWORD_FORMAT = "                         ";
   private static final String delimiter = ",";
   private static String s = ID_FORMAT + delimiter + USERNAME_FORMAT + delimiter + PASSWORD_FORMAT + System.getProperty("line.separator");
   private static final int RECSIZE = s.length();
   
   public SignUp() {
      signupComponents();
   }
   
   private void signupComponents() {
      jPanel1 = new JPanel();
      jPanel2 = new JPanel();
      Right = new JPanel();
      jLabel1 = new JLabel();
      jLabel2 = new JLabel();
      jLabel3 = new JLabel();
      jPanel3 = new JPanel();
      jLabel4 = new JLabel();
      jLabel5 = new JLabel();
      usernameField = new JTextField();
      jLabel6 = new JLabel();
      passwordField = new JPasswordField();
      jLabel7 = new JLabel();
      confirmPasswordField = new JPasswordField();
      jLabel8 = new JLabel();
      jLabel9 = new JLabel();
      signUpButton = new JButton();
      loginButton = new JButton();
      jLabel10 = new JLabel();
      jLabel11 = new JLabel();
   
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Sign-up - Bits & Bytes Management System");
      setPreferredSize(new Dimension(1024, 640));
   
      jPanel1.setBackground(new Color(0x9F5BF5));
      jPanel1.setPreferredSize(new Dimension(1024, 640));
      jPanel1.setLayout(null);
   
      jPanel2.setBackground(new Color(0x9F5BF5));
      jPanel2.setPreferredSize(new Dimension(512, 640));
   
      String imageIconPath = "Bits&Bytes.png";
      URL imageIconUrl = getClass().getResource(imageIconPath);
      ImageIcon image = createImageIcon(imageIconUrl);
   
      jLabel1.setIcon(image);
      jLabel1.setHorizontalTextPosition(JLabel.CENTER);
   
      String image2IconPath = "welcome.png";
      URL image2IconUrl = getClass().getResource(image2IconPath);
      ImageIcon image2 = createImageIcon(image2IconUrl);
   
      //ImageIcon image2 = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Login\\Login UC.png");
      jLabel9.setIcon(image2);
   
      jLabel2.setText("WELCOME TO");
      jLabel2.setFont(new Font("Century Gothic", Font.ITALIC, 20));
      jLabel2.setForeground(Color.WHITE);
   
      jLabel3.setText("BITS & BYTES");
      jLabel3.setFont(new Font("Century Gothic", Font.BOLD, 25));
      jLabel3.setForeground(Color.WHITE);
   
      GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);


      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9)
            .addGroup(jPanel2Layout.createSequentialGroup()
               .addGap(110, 110, 110)
               .addComponent(jLabel1)
            )
            .addGroup(jPanel2Layout.createSequentialGroup()
               .addGap(125, 125, 125)
               .addComponent(jLabel2)
            )
            .addGroup(jPanel2Layout.createSequentialGroup()
               .addGap(120, 120, 120)
               .addComponent(jLabel3))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel9)
            .addGap(120, 120, 120)
            .addComponent(jLabel1)
            .addComponent(jLabel2)
            .addComponent(jLabel3)
      );
      
      jPanel1.add(jPanel2);
      jPanel2.setBounds(0, 0, 512, 640);
      
      jPanel3.setBackground(new Color(0xF4F6FF));
      jPanel3.setMinimumSize(new Dimension(512, 640));
      
      String image3IconPath = "Bits&Bytes2.png";
      URL image3IconUrl = getClass().getResource(image3IconPath);
      ImageIcon image3 = createImageIcon(image3IconUrl);
      //ImageIcon image3 = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Login\\Bits&Bytes2.png");
      jLabel11.setIcon(image3);
      
      jLabel4.setText("Welcome!");
      jLabel4.setFont(new Font("Century Gothic", Font.BOLD, 30));
      jLabel4.setForeground(Color.BLACK);
      
      jLabel10.setText("Register your account");
      jLabel10.setFont(new Font("Century Gothic", Font.ITALIC, 20));
      jLabel10.setForeground(new Color(0x898484));
      
      jLabel5.setText("Username");
      jLabel5.setBackground(Color.BLACK);
      jLabel5.setFont(new Font("Century Gothic", Font.BOLD, 18));
      
      usernameField.setFont(new Font("Century Gothic", Font.BOLD, 18));
      usernameField.setForeground(Color.BLACK);
      
      jLabel6.setText("Password");
      jLabel6.setBackground(Color.BLACK);
      jLabel6.setFont(new Font("Century Gothic", Font.BOLD, 18));
      
      passwordField.setFont(new Font("Century Gothic", Font.ITALIC, 18));
      passwordField.setForeground(Color.BLACK);
      
      jLabel7.setText("Confirm Password");
      jLabel7.setBackground(Color.BLACK);
      jLabel7.setFont(new Font("Century Gothic", Font.BOLD, 18));
      
      passwordField.setFont(new Font("Century Gothic", Font.BOLD, 18));
      passwordField.setForeground(Color.BLACK);
      
      jLabel8.setText("Already have an account?");
      jLabel8.setFont(new Font("Century Gothic", Font.ITALIC, 15));
      jLabel8.setForeground(new Color(0x898484));
      
      signUpButton.setText("Sign Up");
      signUpButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
      signUpButton.setBackground(new Color(0x9F5BF5));
      signUpButton.setForeground(Color.WHITE);
      
      loginButton.setText("Login");
      loginButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
      loginButton.setBackground(new Color(0x9F5BF5));
      loginButton.setForeground(Color.WHITE);
      
      loginButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            loginButtonActionPerformed(evt);
         }
      });
      
      GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
               .addGap(70, 70, 70)
               .addComponent(jLabel11))
            .addGroup(jPanel3Layout.createSequentialGroup()
               .addGap(85, 85, 85)
               .addComponent(jLabel4))
            .addGroup(jPanel3Layout.createSequentialGroup()
               .addGap(85, 85, 85)
               .addComponent(jLabel10)
            )
            .addGroup(jPanel3Layout.createSequentialGroup()
               .addGap(85, 85, 85)
               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                     .addComponent(jLabel5)
                     .addComponent(usernameField)
                     .addComponent(jLabel6)
                     .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                     .addComponent(jLabel7)
                     .addComponent(confirmPasswordField, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                     .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                     .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jLabel8)
                        .addGap(20)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                           .addComponent(loginButton))))
                  )
               )
            )
      
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
               .addGap(40, 40, 40)
               .addComponent(jLabel11)
               .addComponent(jLabel4)
               .addComponent(jLabel10)
               .addGap(35, 35, 35)
               .addComponent(jLabel5)
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(5, 5, 5)
               .addComponent(jLabel6)
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(5, 5, 5)
               .addComponent(jLabel7)
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(35, 35, 35)
               .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(35, 35, 35)
               .addGroup(jPanel3Layout.createParallelGroup()
                  .addComponent(jLabel8)
                  .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addContainerGap(45, Short.MAX_VALUE))
      );
      
      jPanel1.add(jPanel3);
      jPanel3.setBounds(512, 0, 512, 640);
      
      javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            )
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            )
      );
      //getAccessibleContext().setAccessibleName("SIGN UP");
      //pack();
      
      signUpButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            
            if(checkAvailableId().equals("-1")) {
               JOptionPane.showMessageDialog(null, "Maximum users has been reached!");
            }
            else if(username.equals("")) {
               JOptionPane.showMessageDialog(null, "Please enter username!");
            } else if(password.equals("")) {
               JOptionPane.showMessageDialog(null, "Please enter password!");
            } else if(confirmPassword.equals("")) {
               JOptionPane.showMessageDialog(null, "Please confirm password!");
            } else if(!password.equals(confirmPassword)) {
               JOptionPane.showMessageDialog(null, "Password does not match!");
               usernameField.setText("");
               passwordField.setText("");
               confirmPasswordField.setText("");
            } else if(searchUsernameAndPassword(username)) {
               JOptionPane.showMessageDialog(null, "Username already exists!");
            } else {
               write(username, password);
               System.out.println("IDDDDDDDDDD " + Login.id);
               savePersonalsDetailsToFile(password);
               usernameField.setText("");
               passwordField.setText("");
               confirmPasswordField.setText("");
               System.out.println("User added successfully!");
               DashBoard dashBoard = new DashBoard();
               dashBoard.dashBoard();
               dispose();
            }
         }
      });
   }
    
   private ImageIcon createImageIcon(URL imageUrl) {
      if (imageUrl != null) {
         return new ImageIcon(imageUrl);
      } 
      return null;
   }
   
   private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
      Login LoginFrame = new Login();
      LoginFrame.setVisible(true);
      LoginFrame.pack();
      LoginFrame.setLocationRelativeTo(null);
      this.dispose();
   }
   
   private JButton signUpButton;
   private JButton loginButton;
   private JLabel jLabel1;
   private JPanel Right;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JLabel jLabel6;
   private JLabel jLabel7;
   private JLabel jLabel8;
   private JLabel jLabel9;
   private JLabel jLabel10;
   private JLabel jLabel11;
   private JPanel jPanel1;
   private JPanel jPanel2;
   private JPanel jPanel3;
   private JPasswordField confirmPasswordField;
   private JTextField usernameField;
   private JTextField passwordField;

   public void createEmptyFile(String s) {
      final int NUMRECS = 100;
      try {
          OutputStream outputStr = new BufferedOutputStream(Files.newOutputStream(path, CREATE));
          BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));

          writer.write("000,.\\admin                  ,admin                    " + System.getProperty("line.separator"), 0, s.length());
          for(int count = 0; count < NUMRECS; ++count)
              writer.write(s, 0, s.length());

          writer.close();
      } catch(Exception e) {
          System.out.println(e.getMessage());
      }
   }
   
   public void write(String u, String p) {
      FileChannel fcOut = null;
      String username;
      String password;

      try {
          fcOut = (FileChannel) Files.newByteChannel(path, CREATE, WRITE);

          StringBuilder sb = new StringBuilder(u);
          sb.setLength(USERNAME_FORMAT.length());
          username = sb.toString();
          sb = new StringBuilder(p);
          sb.setLength(PASSWORD_FORMAT.length());
          password = sb.toString();
          
          Login.id = Integer.parseInt(checkAvailableId());
          String idStr = checkAvailableId();
          System.out.println(idStr + "," + u + "," + p);
          s = idStr + delimiter + username + delimiter + password + System.getProperty("line.separator");

          byte data[] = s.getBytes();
          ByteBuffer buffer = ByteBuffer.wrap(data);
          fcOut.position(Login.id * RECSIZE);
          fcOut.write(buffer);
          fcOut.close();
      } catch(InputMismatchException e) {
          System.out.println(e.getMessage());
      } catch(IOException e) {
          System.out.println(e.getMessage());
      } catch(Exception e) {
          System.out.println(e.getMessage());
      }
   }
   
   public String checkAvailableId() {
      byte[] data = s.getBytes();
      ByteBuffer buffer = ByteBuffer.wrap(data);
      FileChannel fc = null;
      int id = 1;
      String returnId = "-1";

      try {
          fc = (FileChannel) Files.newByteChannel(path, READ, WRITE);

          while(true) {
            buffer = ByteBuffer.wrap(data);
            fc.position(id * RECSIZE);
            fc.read(buffer);
            s = new String(data);
            if(s.equals(ID_FORMAT + delimiter + USERNAME_FORMAT + delimiter + PASSWORD_FORMAT + System.getProperty("line.separator"))) {
               DecimalFormat decimalFormat = new DecimalFormat("000");
               returnId = decimalFormat.format(id);
               break;
            }
            id++;
          }
          fc.close();
      } catch (IOException e) {
          System.out.println("Error message: " + e);
      }
      
      if(id > 20) {
         return "-1";
      }
      
      return returnId;
   }
   
   public boolean searchUsernameAndPassword(String searchUsername) {
      int i = 0;
      try {
         BufferedReader reader = new BufferedReader(new FileReader(filename));
         String line;
         while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            String username = details[1].trim();
            if (username.equals(searchUsername)) {
               System.out.println("Username found!");
               return true;
            }
            i++;
         }
      } catch(IOException e) {
         System.out.println(e.getMessage());
      }
      
      System.out.println("Username not found!");
      return false;
   }
   
   public void savePersonalsDetailsToFile(String password) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filenamePersonalInfo + Login.id + ".txt"));
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String returnId = decimalFormat.format(Login.id);
            System.out.println(returnId + "," + " " + "," + " " + "," + " " + "," + password + "," + " " + "," + " " + "," + " ");
            writer.write(returnId + "," + " " + "," + " " + "," + " " + "," + password + "," + " " + "," + " " + "," + " ");
            writer.close();
            System.out.println("Personal details added to personalinfo" + Login.id + ".txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}