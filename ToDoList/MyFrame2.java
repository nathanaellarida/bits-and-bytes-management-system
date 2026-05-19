package ToDoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import java.awt.event.*;

public class MyFrame2 extends JFrame implements ActionListener {
    //private String filename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\todo";
    private String filename = "todo";
    private JPanel panel1;
    private JLabel label;
    private JPanel currentPanel;
    private JButton backButton;
    private JPanel panel2;
    //private JTextField //taskField;

    public MyFrame2() {
        label = new JLabel();
        label.setText("TO DO LIST");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Century Gothic", Font.BOLD, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(1024, 72));
        label.setBackground((Color.decode("#AF7EEB")));
        label.setOpaque(true);

        JPanel backAndComboPanel = new JPanel(new BorderLayout());
        backAndComboPanel.setBackground(new Color(0xAF7EEB));

        backButton = new JButton("Back");
        backButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.decode("#AF7EEB"));
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        panel1 = createDayPanel(); // Create a single day panel

        backAndComboPanel.add(backButton, BorderLayout.WEST);
        backAndComboPanel.setPreferredSize(new Dimension(100, 50));
        backAndComboPanel.setOpaque(false);
        backAndComboPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 15, 0));

        label.setLayout(new BorderLayout());
        label.add(backAndComboPanel, BorderLayout.SOUTH);

        // Setting up the frame layout
        this.getContentPane().setBackground(new Color(0xE3E9FF));
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.NORTH);
        this.add(panel1, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 640);
        this.setLocationRelativeTo(null);

        currentPanel = panel1;
        add(currentPanel, BorderLayout.CENTER);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createDayPanel() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setPreferredSize(new Dimension(1024, 640));
        panel1.setBackground(new Color(0xE3E9FF));

        JPanel tasksPanel = new JPanel();
        tasksPanel.setLayout(new BorderLayout());
        tasksPanel.setBackground(new Color(0xE3E9FF));

        panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, (Color.decode("#9F5BF5"))));
        panel2.setBackground(Color.WHITE);

        JButton addTask = new JButton("New Task");
        addTask.setForeground(new Color(0x9F5BF5));
        addTask.setBackground(Color.WHITE);
        addTask.setFocusable(false);
        addTask.setPreferredSize(new Dimension(150, 35));
        addTask.setFont(new Font("Century Gothic", Font.BOLD, 20));
        addTask.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0x9F5BF5)));
        
        addTask.addActionListener(e -> {
            String task = JOptionPane.showInputDialog("Enter task");
            saveTaskToFile(task);
            
            JPanel taskComponentPanel = new JPanel();
            taskComponentPanel.setBackground(Color.white);

            JCheckBox checkBox = new JCheckBox();
            checkBox.setOpaque(false);
            
            JLabel taskLabel = new JLabel();
            taskLabel.setPreferredSize(new Dimension(600, 35));
            taskLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
            taskLabel.setForeground(Color.BLACK);
            taskLabel.setText(task);
            
            ////taskField = new JTextField(30);
            ////taskField.setPreferredSize(new Dimension(600, 35));
            ////taskField.setFont(new Font("Century Gothic", Font.PLAIN, 15));

            JButton deleteButton = new JButton("Delete");
            deleteButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
            deleteButton.setForeground(new Color(0x9F5BF5));
            deleteButton.setBackground(Color.white);
            deleteButton.setPreferredSize(new Dimension(80, 35));
            deleteButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0x9F5BF5)));
            
            deleteButton.addActionListener(deleteEvent -> {
                System.out.println(taskLabel.getText());
                deleteTaskFromFile(taskLabel.getText());
                panel2.remove(taskComponentPanel);
                panel2.revalidate();
                panel2.repaint();
            });

            checkBox.addActionListener(checkEvent -> {
                if (checkBox.isSelected()) {
                    //taskField.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 15));
                    //taskField.setForeground(Color.RED);
                    //taskField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.RED));
                    taskLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                    taskLabel.setForeground(Color.LIGHT_GRAY);
                    writeCheckToFile(taskLabel.getText(), "true");
                } else {
                    //taskField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                    //taskField.setForeground(Color.BLACK);
                    //taskField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                    taskLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                    taskLabel.setForeground(Color.BLACK);
                    writeCheckToFile(taskLabel.getText(), "false");
                }
            });

            taskComponentPanel.add(checkBox);
            //taskComponentPanel.add(//taskField);
            taskComponentPanel.add(taskLabel);
            taskComponentPanel.add(deleteButton);

            panel2.add(taskComponentPanel);
            panel2.revalidate();
            panel2.repaint();
        });
         
        readTasksFromFile();
        
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        tasksPanel.add(scrollPane, BorderLayout.CENTER);
        tasksPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 10, 100));

        JPanel newPanel = new JPanel();
        newPanel.setPreferredSize(new Dimension(80, 65));
        newPanel.setOpaque(false);
        newPanel.add(addTask);

        panel1.add(tasksPanel, BorderLayout.CENTER);
        panel1.add(newPanel, BorderLayout.SOUTH);

        return panel1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentPanel != null && e.getSource() == backButton) {
            disposeFrame();
        }
    }

    private void disposeFrame() {
        //DashBoard dashBoard = new DashBoard();
        //dashBoard.dashBoard();
        this.dispose();
    }
    
    public void saveTaskToFile(String task) {
        System.out.println(task);
        try {
            FileWriter fileWriter = new FileWriter(filename + Login.id + ".txt", true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(task + ",false");
            writer.newLine();
            writer.close();
            System.out.println("Task saved to todo" + Login.id + ".txt successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
    
    public void deleteTaskFromFile(String task) {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename + Login.id + ".txt"));
            String currentLine;
            String newList = "";

            while ((currentLine = reader.readLine()) != null) {
                String[] details = currentLine.split(",");
                String foundTask = details[0].trim();
                if (!foundTask.equals(task)) {
                    newList += currentLine + System.lineSeparator();
                }
            }
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename + Login.id + ".txt"));
            writer.write(newList);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeCheckToFile(String task, String check) {
         System.out.println(task + check);
         try {
            BufferedReader reader = new BufferedReader(new FileReader(filename + Login.id + ".txt"));
            String currentLine;
            String newList = "";

            while ((currentLine = reader.readLine()) != null) {
               String[] details = currentLine.split(",");
               String foundTask = details[0].trim();
                if (!foundTask.equals(task)) {
                    newList += currentLine + System.lineSeparator();
                } else {
                  newList += task + "," + check + System.lineSeparator();
                }
            }
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename + Login.id + ".txt"));
            writer.write(newList);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readTasksFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename + Login.id + ".txt"));
            String line;

            while((line = reader.readLine()) != null) {
                  String[] details = line.split(",");
                  String task = details[0].trim();
                  String check = details[1].trim();
                  JPanel taskComponentPanel = new JPanel();
                  taskComponentPanel.setBackground(Color.white);
      
                  JCheckBox checkBox = new JCheckBox();
                  checkBox.setOpaque(false);
                  
                  JLabel taskLabel = new JLabel();
                  taskLabel.setPreferredSize(new Dimension(600, 35));
                  taskLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                  taskLabel.setForeground(Color.BLACK);
                  taskLabel.setText(task);
      
                  JButton deleteButton = new JButton("Delete");
                  deleteButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
                  deleteButton.setForeground(new Color(0x9F5BF5));
                  deleteButton.setBackground(Color.white);
                  deleteButton.setPreferredSize(new Dimension(80, 35));
                  deleteButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0x9F5BF5)));
                  
                  deleteButton.addActionListener(deleteEvent -> {
                      System.out.println(taskLabel.getText());
                      deleteTaskFromFile(taskLabel.getText());
                      panel2.remove(taskComponentPanel);
                      panel2.revalidate();
                      panel2.repaint();
                  });
      
                  checkBox.addActionListener(checkEvent -> {
                      if (checkBox.isSelected()) {
                          taskLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                          taskLabel.setForeground(Color.LIGHT_GRAY);
                          writeCheckToFile(taskLabel.getText(), "true");
                      } else {
                          taskLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                          taskLabel.setForeground(Color.BLACK);
                          writeCheckToFile(taskLabel.getText(), "false");
                      }
                  });
                  
                  if(check.equals("true")) {
                          checkBox.setSelected(true);
                          taskLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                          taskLabel.setForeground(Color.LIGHT_GRAY);
                      } else {
                          taskLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                          taskLabel.setForeground(Color.BLACK);
                  }
                      
                  taskComponentPanel.add(checkBox);
                  taskComponentPanel.add(taskLabel);
                  taskComponentPanel.add(deleteButton);
      
                  panel2.add(taskComponentPanel);
                  panel2.revalidate();
                  panel2.repaint();
            }
        } catch(IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }
}