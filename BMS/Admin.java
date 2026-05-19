package BMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.text.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import java.nio.file.Files;

import java.text.DecimalFormat;

import java.util.Arrays;
import java.util.List;

public class Admin extends JFrame {
    private final String filename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\personalinfo";
    private final String filenameLogbook = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\logbook";
    private final String filenameToDo = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\todo";
    private static final Path path = Paths.get("C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\users.txt");
    
      
    private static final String ID_FORMAT = "000";
    private static final String USERNAME_FORMAT = "                         ";
    private static final String PASSWORD_FORMAT = "                         ";
    private static final String delimiter = ",";
    private static String s = ID_FORMAT + delimiter + USERNAME_FORMAT + delimiter + PASSWORD_FORMAT + System.getProperty("line.separator");
    private static final int RECSIZE = s.length();
    
    public String[] idNumbers = new String[21];
    List<String> stringList;

    private JTable jTable1;
    private JButton viewButton;
    private JButton logOutButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton deleteButton;

    public void Admin() {
        initializeComponents();
    }
    private void initializeComponents() {
        JFrame frame = new JFrame();

        // Create components
        viewButton = new JButton();
        viewButton.setText("View Accounts");
        viewButton.setFocusable(false);
        viewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
        viewButton.setForeground(Color.WHITE);
        viewButton.setBounds(315, 540, 180, 35);
        viewButton.setBackground(new Color(0xAF7EEB));

        deleteButton = new JButton();
        deleteButton.setText("Delete Account");
        deleteButton.setFocusable(false);
        deleteButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBounds(515, 540, 180, 35);
        deleteButton.setBackground(new Color(0xAF7EEB));

        jTable1 = new JTable();
        jTable1.setPreferredScrollableViewportSize(new Dimension(900, 430));

        // Create and configure panel3
        panel3 = new JPanel();
        panel3.setBackground(Color.WHITE);
        panel3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add the JScrollPane (with the JTable) to panel3
        panel3.add(new JScrollPane(jTable1));

        // Set layout for the frame
        frame.setLayout(new BorderLayout());
        // Add components to the frame
        frame.add(viewButton, BorderLayout.NORTH);
        frame.add(deleteButton, BorderLayout.NORTH);
        frame.add(panel3, BorderLayout.CENTER);

        // Create and configure panel1
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(1024, 60));
        panel1.setBackground(new Color(0xAF7EEB));

        // Use FlowLayout with left alignment for panel1
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

        logOutButton = new JButton();
        logOutButton.setText("Log out");
        logOutButton.setFocusable(false);
        logOutButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        logOutButton.setForeground(Color.BLACK);
        logOutButton.setBackground(Color.WHITE);

        panel1.add(logOutButton);

        // Create and configure panel2
        panel2 = new JPanel();
        panel2.setBackground(new Color(0xAF7EEB));
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 240, 0, 0));

        JLabel adminText = new JLabel();
        adminText.setText("ADMIN");
        adminText.setFont(new Font("Century Gothic", Font.BOLD, 35));
        adminText.setForeground(Color.WHITE);
        panel2.add(adminText);

        panel1.add(panel2);

        // Configure the frame
        frame.add(panel1, BorderLayout.NORTH);
        frame.setSize(1024, 640);
        frame.setResizable(false);
        frame.setTitle("ADMIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);

        // Add action listener to the import button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        // Add action listener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login loginFrame = new Login();
                loginFrame.setVisible(true);
                loginFrame.pack();
                loginFrame.setLocationRelativeTo(null);
                frame.dispose();
            }
        });
    }

    private void viewButtonActionPerformed(ActionEvent evt) {
        try {

            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            String[] columnsName = {"ID", "First Name", "Last Name", "Position", "Password", "Email", "Age", "Phone"};
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setColumnIdentifiers(columnsName);

            // Clear existing data from the table
            model.setRowCount(0);

            // get lines from txt file
            for(int i = 1; i <= 20; i++) {
               BufferedReader reader = new BufferedReader(new FileReader(filename + i + ".txt"));
               String line;
               if((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if(!details[0].isBlank()) {
                  idNumbers[i] = details[0];
                  model.addRow(details);
                }
              }
            }
            stringList = Arrays.asList(idNumbers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void deleteButtonActionPerformed(ActionEvent evt) {
      String deleteId = "000";
      System.out.println(stringList);
      while(!stringList.contains(deleteId)) {
         deleteId = JOptionPane.showInputDialog(null, "Enter an ID number to delete");
         System.out.println(deleteId);
         if(!stringList.contains(deleteId)) {
            JOptionPane.showMessageDialog(null, "ID number not found!");
         } else {
            break;
         }
      }
      
      deleteFromUsersFile(Integer.parseInt(deleteId));
      deletePersonalDetails(Integer.parseInt(deleteId));
      deleteLogbook(Integer.parseInt(deleteId));
      deleteToDo(Integer.parseInt(deleteId));
      
      try {

            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            String[] columnsName = {"ID", "First Name", "Last Name", "Position", "Password", "Email", "Age", "Phone"};
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setColumnIdentifiers(columnsName);

            // Clear existing data from the table
            model.setRowCount(0);

            // get lines from txt file
            for(int i = 1; i <= 20; i++) {
               BufferedReader reader = new BufferedReader(new FileReader(filename + i + ".txt"));
               String line;
               if((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if(!details[0].isBlank()) {
                  idNumbers[i] = details[0];
                  model.addRow(details);
                }
              }
            }
            stringList = Arrays.asList(idNumbers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteFromUsersFile(int idToDelete) {
      FileChannel fcOut = null;
      System.out.println(idToDelete);
      try {
          fcOut = (FileChannel) Files.newByteChannel(path, CREATE, WRITE);
          
          s = ID_FORMAT + delimiter + USERNAME_FORMAT + delimiter + PASSWORD_FORMAT + System.getProperty("line.separator");

          byte data[] = s.getBytes();
          ByteBuffer buffer = ByteBuffer.wrap(data);
          fcOut.position(idToDelete * RECSIZE);
          fcOut.write(buffer);
          fcOut.close();
      } catch(InputMismatchException e) {
          System.out.println("Error message: " + e);
      } catch(IOException e) {
          System.out.println("Error message: " + e);
      } catch(Exception e) {
          System.out.println("Error message: " + e);
      }
   }
   
   public void deletePersonalDetails(int idToDelete) {
      try {
         FileWriter fileWriter = new FileWriter(filename + idToDelete + ".txt");
         BufferedWriter writer = new BufferedWriter(fileWriter);
         writer.write(" , , , , , , , ");
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public void deleteLogbook(int idToDelete) {
      try {
         FileWriter fileWriter = new FileWriter(filenameLogbook + idToDelete + ".txt");
         BufferedWriter writer = new BufferedWriter(fileWriter);
         writer.write("");
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public void deleteToDo(int idToDelete) {
      try {
         FileWriter fileWriter = new FileWriter(filenameToDo + idToDelete + ".txt");
         BufferedWriter writer = new BufferedWriter(fileWriter);
         writer.write("");
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
    
    
}

