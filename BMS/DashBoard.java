package BMS;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import javax.swing.JButton;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.text.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.InputMismatchException;
import java.nio.file.Files;

public class DashBoard implements FileIOLogbook {
   private final String filename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\logbook" + Login.id + ".txt";
   
   private final Path path = Paths.get("C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\users.txt");
      
   private static final String ID_FORMAT = "000";
   private static final String USERNAME_FORMAT = "                         ";
   private static final String PASSWORD_FORMAT = "                         ";
   private static final String delimiter = ",";
   private static String s = ID_FORMAT + delimiter + USERNAME_FORMAT + delimiter + PASSWORD_FORMAT + System.getProperty("line.separator");
   private static final int RECSIZE = s.length();
   
   private JFrame frame1;
   private JLabel label1;
   private JLabel event;
   private JLabel budget;
   private JLabel todo;
   private JPanel dashPanel;
   private JPanel bPanel;
   private JPanel panel3;
   private JButton button1;
   private JButton button2;
   private JPanel timeInPanel;
   private JPanel dtrPanel;
   private JTable dtrTable;
   private JLabel username;
   private JButton profile;
   private JButton about;
   private JButton contact;
   private JButton logoutButton;
   private JPanel buttonPanel;
   private ImageIcon dashIcon;
   
   private DefaultTableModel tableModel;
   private int lastTimeInRow = -1; // Track the last row where "Time In" was clicked
   
   public void dashBoard() {
      frame1 = new JFrame();
      
      // Load image resources using relative paths
      String dashImagePath = "dash2.png";
      String eventIconPath = "event6.png";
      String budgetIconPath = "budget6.png";
      String todoIconPath = "todo6.png";
      
      // Use the class loader to get the URL of the resource
      URL dashIconUrl = getClass().getResource(dashImagePath);
      URL eventIconUrl = getClass().getResource(eventIconPath);
      URL budgetIconUrl = getClass().getResource(budgetIconPath);
      URL todoIconUrl = getClass().getResource(todoIconPath);
      
      FlowLayout dashLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
      dashPanel = new JPanel(dashLayout);
      dashPanel.setOpaque(false); // Make dashPanel transparent
      dashPanel.setLayout(null); // Use null layout to set absolute positions
      dashPanel.setBounds(0, 0, 250, 610);
      
      // Check if the URLs are not null before creating ImageIcons
      if (dashIconUrl != null) {
          dashIcon = new ImageIcon(dashIconUrl);
          Image dashImage = dashIcon.getImage();
          Image newDash = dashImage.getScaledInstance(250, 610, Image.SCALE_SMOOTH);
          dashIcon = new ImageIcon(newDash);
      }
      
      label1 = new JLabel(dashIcon);
      label1.setBounds(0, 0, 250, 610);
      dashPanel.add(label1);
      
      JLayeredPane layeredPane = new JLayeredPane();
      layeredPane.setPreferredSize(new Dimension(250, 610));
      
      bPanel = new JPanel(new BorderLayout());
      
      // resizing image in label
      // ImageIcon dashIcon = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Dashboard\\dash2.png");
      
      username = new JLabel(searchUsername(Login.id));
      username.setForeground(Color.WHITE);
      username.setFont(new Font("Century Gothic", Font.BOLD, 23));
      username.setBounds(50, 215, 150, 30); // Set position and size
      
      profile = new JButton("Profile");
      profile.setForeground(Color.BLACK);
      profile.setFont(new Font("Century Gothic", Font.PLAIN, 18));
      profile.setFocusable(false);
      profile.setBorderPainted(false);
      profile.setBackground(new Color(0xeecafc));
      profile.setBounds(63, 290, 110, 30); // Set position and size
      
      about = new JButton("About");
      about.setForeground(Color.BLACK);
      about.setFont(new Font("Century Gothic", Font.PLAIN, 18));
      about.setFocusable(false);
      about.setBorderPainted(false);
      about.setBackground(new Color(0xf1cbfd));
      about.setBounds(63, 345, 110, 30); // Set position and size
      
      contact = new JButton("Contact");
      contact.setForeground(Color.BLACK);
      contact.setFont(new Font("Century Gothic", Font.PLAIN, 18));
      contact.setFocusable(false);
      contact.setBorderPainted(false);
      contact.setBackground(new Color(0xf4cdfc));
      contact.setBounds(63, 405, 110, 30); // Set position and size
      
      logoutButton = new JButton("Log out");
      logoutButton.setForeground(Color.BLACK);
      logoutButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
      logoutButton.setFocusable(false);
      logoutButton.setBorderPainted(false);
      logoutButton.setBackground(new Color(0xfbd0fc));
      logoutButton.setBounds(65, 535, 110, 30); // Set position and size
      
      dashPanel.add(username);
      dashPanel.add(profile);
      dashPanel.add(about);
      dashPanel.add(contact);
      dashPanel.add(logoutButton);
      
      // ActionListener for the Profile button
      profile.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              PersonalInfo personalInfo = new PersonalInfo();
              personalInfo.personalInfoCode();
              frame1.dispose();
          }
      });
      
      // ActionListener for the About button
      about.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              AboutFrame aboutFrame = new AboutFrame();
              aboutFrame.aboutFrameCode();
              frame1.dispose();
          }
      });
      
      // ActionListener for the Contact button
      contact.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              ContactFrame contactFrame = new ContactFrame();
              contactFrame.contactFrameCode();
              frame1.dispose();
          }
      });
      
      // ActionListener for the Logout button
      logoutButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Login loginFrame = new Login();
            loginFrame.setVisible(true);
            loginFrame.pack();
            loginFrame.setLocationRelativeTo(null);
            frame1.dispose();
         }
      });
       
      // Add components to the layered pane
      layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
      layeredPane.add(dashPanel, JLayeredPane.PALETTE_LAYER);
      
      // Add the layered pane to the frame
      // layeredPane.add(dashPanel, JLayeredPane.PALETTE_LAYER);
      
      // ImageIcon eventIcon = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Dashboard\\calendar fin.png");
      // ImageIcon budgetIcon = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Dashboard\\budget fin.png");
      // ImageIcon todoIcon = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\Dashboard\\to do fin.png");
      
      // Load other images and create ImageIcons as needed
      ImageIcon eventIcon = createImageIcon(eventIconUrl);
      ImageIcon budgetIcon = createImageIcon(budgetIconUrl);
      ImageIcon todoIcon = createImageIcon(todoIconUrl);
      
      label1 = new JLabel(dashIcon);
      event = new JLabel(eventIcon);
      event.setText("event");
      
      todo = new JLabel(todoIcon);
      todo.setText("todo");
      
      budget = new JLabel(budgetIcon);
      budget.setText("budget");
      
      dashPanel.add(label1);
      
      // Use a GridLayout with horizontal and vertical gaps
      JPanel componentPanel = new JPanel(new GridLayout(1, 3, 30, 0));
      componentPanel.add(event);
      componentPanel.add(budget);
      componentPanel.add(todo);
      
      bPanel.add(componentPanel, BorderLayout.PAGE_START);
      
      panel3 = new JPanel(new BorderLayout());
      panel3.setPreferredSize(new Dimension(640, 250));
      Border timeInborder = BorderFactory.createLineBorder(new Color(0x4800A4), 3);
      panel3.setBorder(timeInborder);
      panel3.setBackground(new Color(0xFFFFFF));
      
      button1 = new JButton();
      button2 = new JButton();
      button1.setPreferredSize(new Dimension(100, 30));
      button2.setPreferredSize(new Dimension(100, 30));
      button1.setHorizontalTextPosition(SwingConstants.CENTER);
      button2.setHorizontalTextPosition(SwingConstants.CENTER);
      button1.setText("Time In");
      button2.setText("Time Out");
      button1.setForeground(Color.WHITE);
      button2.setForeground(Color.WHITE);
      button1.setFont(new Font("Century Gothic", Font.BOLD, 18));
      button2.setFont(new Font("Century Gothic", Font.BOLD, 18));
      button1.setFocusable(false);
      button2.setFocusable(false);
      button1.setBackground(new Color(0xAF7EEB));
      button2.setBackground(new Color(0xAF7EEB));
      button1.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
      button2.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
      
      timeInPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 20)); // Add 10 pixels of vertical gap
      timeInPanel.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 25));
      timeInPanel.add(button1);
      timeInPanel.add(button2);
      
      dtrPanel = new JPanel(new BorderLayout());
      String[] columnNames = {"Date", "Time In", "Time Out", "Duration"};
      tableModel = new DefaultTableModel(null, columnNames);
      dtrTable = new JTable(tableModel);
      
      JScrollPane dtrScroll = new JScrollPane(dtrTable);
      Dimension scrollSize = dtrScroll.getPreferredSize();
      dtrScroll.setPreferredSize(new Dimension(scrollSize.width + 55, scrollSize.height));
      
      dtrPanel.add(dtrScroll, BorderLayout.CENTER);
      
      panel3.add(dtrPanel, BorderLayout.WEST);
      panel3.add(timeInPanel, BorderLayout.CENTER);
      
      // Set the margin at least 30 pixels from the top and bottom
      bPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
      bPanel.add(panel3, BorderLayout.SOUTH);
      
      button1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              handleTimeIn();
          }
      });
      
      button2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              handleTimeOut();
          }
      });
      
      addMouseListenerToLabel(event);
      addMouseListenerToLabel(todo);
      addMouseListenerToLabel(budget);
      
      frame1.add(dashPanel, BorderLayout.WEST);
      frame1.add(layeredPane, BorderLayout.WEST);
      frame1.add(bPanel);
      
      frame1.setSize(1024, 640);
      frame1.setTitle("Budget Planner");
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setLocationRelativeTo(null);
      frame1.setBackground(Color.WHITE);
      frame1.setVisible(true);
      
      readRecordFromFile();
   }
   
   private ImageIcon createImageIcon(URL imageUrl) {
      if (imageUrl != null) {
         return new ImageIcon(imageUrl);
      }
      return null;
   }
   
   private void handleTimeIn() {
      SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
      SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
   
      Date now = new Date();
      String dateStr = dateFormat.format(now);
      String timeInStr = timeFormat.format(now);
   
      tableModel.addRow(new String[]{dateStr, timeInStr, "", ""});
      lastTimeInRow = tableModel.getRowCount() - 1; // Update the last "Time In" row
   }
   
   private void handleTimeOut() {
      if (lastTimeInRow >= 0) {
          SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
          Date now = new Date();
   
          String timeOutStr = timeFormat.format(now);
          dtrTable.setValueAt(timeOutStr, lastTimeInRow, 2);
   
          // Calculate duration
          String dateStr = (String) tableModel.getValueAt(lastTimeInRow, 0);
          String timeInStr = (String) tableModel.getValueAt(lastTimeInRow, 1);
          long duration = calculateDuration(timeInStr, timeOutStr);
          String durationStr = formatDuration(duration);
          dtrTable.setValueAt(durationStr, lastTimeInRow, 3);
   
          //Save record to logbook.txt
          saveRecordToFile(dateStr, timeInStr, timeOutStr, durationStr);
          
          // Reset the last "Time In" row
          lastTimeInRow = -1;
      }
   }
   
   private long calculateDuration(String timeInStr, String timeOutStr) {
      try {
         SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
         Date timeIn = format.parse(timeInStr);
         Date timeOut = format.parse(timeOutStr);
         return timeOut.getTime() - timeIn.getTime();
      } catch(Exception e) {
         e.printStackTrace();
         return 0;
      }
   }
   
   private String formatDuration(long duration) {
      long hours = duration / (60 * 60 * 1000);
      long minutes = (duration % (60 * 60 * 1000)) / (60 * 1000);
      return String.format("%02d:%02d", hours, minutes);
   }
   
   private void addMouseListenerToLabel(JLabel label) {
      label.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            openNewFrame(label);
         }
      });
   }
   
   private void openNewFrame(JLabel label) {
      // Implement logic to open a new frame or program based on the clicked label
      switch (label.getText()) {
         case "event":
            openEventPlanner();
            break;
         case "todo":
            openTodoProgram();
            break;
         case "budget":
            openBudgetManager();
            break;
         default:
            System.out.println("Unknown label clicked");
      }
   }
   
   private void openEventPlanner() {
      Calendar calendar = new Calendar();
      calendar.calendarCode();
      frame1.dispose();
      System.out.println("Opening Event Planner");
   }
   
   private void openTodoProgram() {
      SwingUtilities.invokeLater(() -> new MyFrame2());
      frame1.dispose();
      System.out.println("Opening Todo Program");
   }
   
   private void openBudgetManager() {
      BudgetPlanner planner = new BudgetPlanner();
      planner.budget();
      frame1.dispose();
      System.out.println("Opening Budget Manager");
   }
   
   public void saveRecordToFile(String date, String timeIn, String timeOut, String duration) {
      try {
         FileWriter fileWriter = new FileWriter(filename, true);
         BufferedWriter writer = new BufferedWriter(fileWriter);
         writer.write(date + "," + timeIn + "," + timeOut + "," + duration);
         writer.newLine();
         writer.close();
         System.out.println("Record saved to logbook.txt successfully.");
      } catch (IOException e) {
         System.out.println("Error writing to the file: " + e.getMessage());
      }
   }
    
   public void readRecordFromFile() {
      try {
         BufferedReader reader = new BufferedReader(new FileReader(filename));
         String line;

         while((line = reader.readLine()) != null) {
            String[] details = line.split(",");

            String date = details[0].trim();
            String timeIn = details[1].trim();
            String timeOut = details[2].trim();
            String duration = details[3].trim();
         
            tableModel.addRow(new String[]{date, timeIn, timeOut, duration});
            lastTimeInRow = tableModel.getRowCount() - 1;
         }
      } catch(IOException e) {
         System.out.println("Error reading from the file: " + e.getMessage());
      }
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

}   