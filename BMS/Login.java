package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame implements FileIOLogin {
   private final String filename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\users.txt";
   private String passwordFound = "";
   
   public static int id;
   
   public Login() {
      loginComponents();
      
   }

   private void loginComponents() {
      jPanel1 = new JPanel();
      Right = new JPanel();
      jLabel5 = new JLabel();
      jLabel6 = new JLabel();
      jLabel7 = new JLabel();
      Left = new JPanel();
      jLabel1 = new JLabel();
      jLabel2 = new JLabel();
      usernameField = new JTextField();
      jLabel3 = new JLabel();
      passwordField = new JPasswordField();
      LoginButton = new JButton();
      jLabel4 = new JLabel();
      SignUpButton = new JButton();
      jLabel9 = new JLabel();
      jLabel10 = new JLabel();
      jLabel11 = new JLabel();

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Login - Bits & Bytes Management System");
      setPreferredSize(new Dimension(1024, 640));

      jPanel1.setBackground(new Color(0x9F5BF5));
      jPanel1.setPreferredSize(new Dimension(1024, 640));
      jPanel1.setLayout(null);

      Right.setBackground(new Color(0x9F5BF5));
      Right.setPreferredSize(new Dimension(512, 640));

      String imageIconPath = "Bits&Bytes.png";
      URL imageIconUrl = getClass().getResource(imageIconPath);
      ImageIcon image = createImageIcon(imageIconUrl);

      //ImageIcon image = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Login\\Bits&Bytes.png");
      jLabel5.setIcon(image);
      jLabel5.setHorizontalTextPosition(JLabel.CENTER);

      String image3IconPath = "welcome.png";
      URL image3IconUrl = getClass().getResource(image3IconPath);
      ImageIcon image3 = createImageIcon(image3IconUrl);

      //ImageIcon image3 = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Login\\Login UC.png");
      jLabel11.setIcon(image3);

      jLabel6.setText("WELCOME TO");
      jLabel6.setFont(new Font("Century Gothic", Font.ITALIC, 20));
      jLabel6.setForeground(Color.WHITE);

      jLabel7.setText("BITS & BYTES");
      jLabel7.setFont(new Font("Century Gothic", Font.BOLD, 25));
      jLabel7.setForeground(Color.WHITE);

      GroupLayout rightLayout = new GroupLayout(Right);
      Right.setLayout(rightLayout);


      // Horizontal Group
      rightLayout.setHorizontalGroup(
         rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11)
            .addGroup(rightLayout.createSequentialGroup()
               .addGap(110, 110, 110)
               .addComponent(jLabel5)
            )
            .addGroup(rightLayout.createSequentialGroup()
               .addGap(125, 125, 125)
               .addComponent(jLabel6)
            )
            .addGroup(rightLayout.createSequentialGroup()
               .addGap(120, 120, 120)
               .addComponent(jLabel7)
            )
      );
      
      // Vertical Group
      rightLayout.setVerticalGroup(
         rightLayout.createSequentialGroup()
            .addComponent(jLabel11)
            .addGap(120, 120, 120)
            .addComponent(jLabel5)
            .addComponent(jLabel6)
            .addComponent(jLabel7)
      );

      jPanel1.add(Right);
      Right.setBounds(0, 0, 512, 640);
      
      Left.setBackground(new Color(0xF4F6FF));
      Left.setMinimumSize(new Dimension(512, 640));
      
      jLabel1.setText("Welcome Back,");
      jLabel1.setFont(new Font("Century Gothic", Font.BOLD, 30));
      jLabel1.setForeground(Color.BLACK);
      
      jLabel2.setText("Username");
      jLabel2.setFont(new Font("Century Gothic", Font.BOLD, 18));
      jLabel2.setBackground(Color.BLACK);
      
      usernameField.setFont(new Font("Century Gothic", Font.BOLD, 18));
      usernameField.setForeground(Color.BLACK);
      
      jLabel3.setText("Password");
      jLabel3.setBackground(Color.BLACK);
      jLabel3.setFont(new Font("Century Gothic", Font.BOLD, 18));
      
      LoginButton.setText("Login");
      LoginButton.setBackground(new Color(0x9F5BF5));
      LoginButton.setFont(new Font("Century Gothic", Font.BOLD, 18)); // NOI18N
      LoginButton.setForeground(Color.WHITE);
      
      jLabel4.setText("New User?");
      jLabel4.setFont(new Font("Century Gothic", Font.ITALIC, 15));
      jLabel4.setForeground(new Color(0x898484));
      
      SignUpButton.setText("Sign Up");
      SignUpButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
      SignUpButton.setBackground(new Color(0x9F5BF5));
      SignUpButton.setForeground(Color.WHITE);
      
      jLabel9.setText("Login to continue");
      jLabel9.setFont(new Font("Century Gothic", Font.ITALIC, 20));
      jLabel9.setForeground(new Color(0x898484));
      
      String image2IconPath = "Bits&Bytes2.png";
      URL image2IconUrl = getClass().getResource(image2IconPath);
      ImageIcon image2 = createImageIcon(image2IconUrl);
      //ImageIcon image2 = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Login\\Bits&Bytes2.png");
      jLabel10.setIcon(image2);
      jLabel10.setHorizontalTextPosition(JLabel.CENTER);
      
      SignUpButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
              SignUpButtonActionPerformed(evt);
          }
      });


      GroupLayout LeftLayout = new GroupLayout(Left);
      Left.setLayout(LeftLayout);
      
      LeftLayout.setHorizontalGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
         .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
               .addGap(70, 70, 70)
               .addComponent(jLabel10)
            )
            .addGroup(LeftLayout.createSequentialGroup()
               .addGap(85, 85, 85)
               .addComponent(jLabel1)
            )
            .addGroup(LeftLayout.createSequentialGroup()
               .addGap(85, 85, 85)
               .addComponent(jLabel9)
            )
            .addGroup(LeftLayout.createSequentialGroup()
               .addGap(85, 85, 85)
               .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                     .addComponent(jLabel2)
                     .addComponent(usernameField)
                     .addComponent(jLabel3)
                     .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                     .addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
                  .addGroup(LeftLayout.createSequentialGroup()
                     .addGap(80)
                     .addComponent(jLabel4)
                     .addGap(10)
                     .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(SignUpButton))
                  )
               )))
      );
      LeftLayout.setVerticalGroup(
         LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
               .addGap(50, 50, 50)
               .addComponent(jLabel10)
               .addComponent(jLabel1)
               .addComponent(jLabel9)
               .addGap(40, 40, 40)
               .addComponent(jLabel2)
               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
               .addGap(15, 15, 15)
               .addComponent(jLabel3)
               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
               .addGap(40, 40, 40)
               .addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
               .addGap(40, 40, 40)
               .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                  .addComponent(jLabel4)
                  .addComponent(SignUpButton))
               .addContainerGap(77, Short.MAX_VALUE))
      );
      
      jPanel1.add(Left);
      Left.setBounds(512, 0, 512, 640);
      
      GroupLayout layout = new GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
               .addGap(0, 0, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
               .addGap(0, 0, Short.MAX_VALUE))
      );
      
      //getAccessibleContext().setAccessibleName("LOGIN");
      //pack();
      
      LoginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            String username = usernameField.getText();
            String password = passwordField.getText();
      
            if (username.equals("")) {
               JOptionPane.showMessageDialog(null, "Please enter username!");
            } else if(password.equals("")) {
               JOptionPane.showMessageDialog(null, "Please enter password!");
            } else if(username.equals(".\\admin") && password.equals("admin")) {
               System.out.println("Successfully logged in as admin!");
               Admin admin = new Admin();
               admin.Admin();
               dispose();
            } else if(searchUsernameAndPassword(username)) {
               if (isCorrectPassword(password)) {
                  System.out.println("Successfully logged in as user!");
                  DashBoard dashBoard = new DashBoard();
                  dashBoard.dashBoard();
                  dispose();
               } else {
                  JOptionPane.showMessageDialog(null, "Incorrect password!");
               }
            } else {
               usernameField.setText("");
               passwordField.setText("");
               JOptionPane.showMessageDialog(null, "Username does not exist!");
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
   
   private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {
      SignUp SignUpFrame = new SignUp();
      SignUpFrame.setVisible(true);
      SignUpFrame.pack();
      SignUpFrame.setLocationRelativeTo(null);
      this.dispose();
   }
   
   private JPanel Left;
   private JPanel Right;
   private JButton LoginButton;
   private JButton SignUpButton;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JLabel jLabel6;
   private JLabel jLabel7;
   private JPanel jPanel1;
   private JLabel jLabel9;
   private JLabel jLabel10;
   private JLabel jLabel11;
   private JPasswordField passwordField;
   private JTextField usernameField;

    
   public boolean searchUsernameAndPassword(String searchUsername) {
      int i = 0;
      try {
         BufferedReader reader = new BufferedReader(new FileReader(filename));
         String line;
         while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            String username = details[1].trim();
            passwordFound = details[2].trim();
            if (username.equals(searchUsername)) {
               System.out.println("Username found!");
               id = i;
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
   
   public boolean isCorrectPassword(String enteredPassword) {
      if(enteredPassword.equals(passwordFound)) {
         System.out.println("Password is correct!");
         return true;
      } else {
         System.out.println("Password is incorrect!");
         return false;
      }
   }


}
