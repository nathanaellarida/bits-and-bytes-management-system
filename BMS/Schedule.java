package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Schedule extends JFrame implements FileIOSchedule {
    private String filename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\schedule.txt";

    JFrame mainSched;
    JLabel event, Contests, infoLabel, eventLabel, contestLabel, dateLabel, line;
    JButton back, clearSched, confirmButton, clearButton;
    JTextField field1, field2;
    JComboBox comboBox, comboBox2, comboBox3;
    JPanel Left, Right, scrollPanel, overallPanel;
    JScrollPane scrollPane;

    private String eventName;
    private String contestName;
    private String selectedMonth;
    private String selectedDay;
    private String selectedYear;

    private List<JPanel> entryPanelsList = new ArrayList<>();

    private void createScheduleEntryPanel(String eventName, String contestsName, String month, String day, String year) {
        JPanel entryPanel = new JPanel();
        entryPanel.setLayout(new BoxLayout(entryPanel, BoxLayout.Y_AXIS));
        entryPanel.setBackground(Color.white);
        entryPanel.setBorder(new LineBorder(new Color(0x9F5BF5), 5));

        JLabel eventLabel = new JLabel("Event: " + eventName);
        JLabel contestLabel = new JLabel("Contest: " + contestsName);
        JLabel dateLabel = new JLabel("Date: " + month + " " + day + ", " + year);
        JLabel line = new JLabel("==================================================================");

        eventLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
        contestLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
        dateLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
        line.setForeground(new Color(0x9470CE));

        JButton clearSched = new JButton("Clear");
        clearSched.setPreferredSize(new Dimension(200, 100));
        clearSched.setFont(new Font("Century Gothic", Font.BOLD, 15));
        clearSched.setBackground(Color.white);
        clearSched.setForeground(new Color(0x9470CE));
        clearSched.setHorizontalAlignment(JButton.CENTER);

        entryPanel.add(eventLabel);
        entryPanel.add(contestLabel);
        entryPanel.add(dateLabel);
        entryPanel.add(line);
        entryPanel.add(clearSched);

        clearSched.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventLabel.setText("");
                contestLabel.setText("");
                dateLabel.setText("");
                line.setText("");
                clearSched.setVisible(false);

                // Remove the specific entryPanel from the list and UI
                entryPanelsList.remove(entryPanel);
                scrollPanel.remove(entryPanel);
                overallPanel.remove(entryPanel);
                
                deleteScheduleFromFile(eventName + "," + contestsName + "," + month + "," + day + "," + year);

                scrollPanel.revalidate();
                scrollPanel.repaint();
                overallPanel.revalidate();
                overallPanel.repaint();
            }
        });

        entryPanelsList.add(entryPanel);

        overallPanel.add(entryPanel);
        overallPanel.revalidate();
        overallPanel.repaint();

        scrollPanel.add(entryPanel);
        scrollPanel.revalidate();
        scrollPanel.repaint();
    }


    public void scheduleCode() {

        mainSched = new JFrame();
        mainSched.setTitle("Schedule Events");
        mainSched.setSize(1024, 640);
        mainSched.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainSched.setResizable(false);

        class SchedAction implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Calendar calendarFrame = new Calendar();
                calendarFrame.Main.setVisible(true);
                mainSched.dispose();
            }
        }

        //ImageIcon PlusImage = new ImageIcon("C:\\Users\\Virginia\\IdeaProjects\\OOP Project Code\\src\\Calendar\\back_New_OOP.png");
        back = new JButton("Back");
        back.setFont(new Font("Century Gothic", Font.BOLD, 15));
        back.setPreferredSize(new Dimension(65, 30));
        back.setBackground(Color.white);
        back.setForeground(new Color(0x9470CE));
        back.setBorder(BorderFactory.createLineBorder(new Color(0x9470CE)));
        back.setFocusable(false);
        back.addActionListener(new SchedAction());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(back);
        buttonPanel.setSize(80, 50);
        buttonPanel.setBackground(Color.white);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        mainSched.add(buttonPanel, BorderLayout.NORTH);

        JPanel jPanel1 = new JPanel();
        jPanel1.setBackground(new Color(0xccccff));
        jPanel1.setPreferredSize(new Dimension(1024, 640));
        jPanel1.setLayout(null);

        field1 = new JTextField();
        field2 = new JTextField();
        field1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        field2.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        event = new JLabel("Schedule Event");
        event.setFont(new Font("Century Gothic", Font.BOLD, 20));
        Contests = new JLabel("Contests");
        Contests.setFont(new Font("Century Gothic", Font.BOLD, 20));

        infoLabel = new JLabel();
        eventLabel = new JLabel();
        contestLabel = new JLabel();
        dateLabel = new JLabel();
        line = new JLabel();
        Left = new JPanel();
        Right = new JPanel();

        // clearSched button
        clearSched = new JButton("Clear");
        clearSched.setPreferredSize(new Dimension(200, 100));
        clearSched.setFont(new Font("Century Gothic", Font.BOLD, 15));
        clearSched.setBackground(Color.white);
        clearSched.setForeground(new Color(0x9470CE));
        clearSched.setFocusable(false);
        clearSched.setHorizontalAlignment(JButton.CENTER);
        clearSched.setVisible(false);

        //ScrollPane & ScrollPanel (AMBOTTTTT)
        scrollPanel = new JPanel();
        scrollPanel.setBackground(new Color(0xb19cd9));
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setMaximumSize(new Dimension(460, 450));
        scrollPane.setVisible(true);

        overallPanel = new JPanel();
        overallPanel.setLayout(new BoxLayout(overallPanel, BoxLayout.Y_AXIS));
        overallPanel.setBackground(Color.white);
        overallPanel.setBorder(new LineBorder(new Color(0x9F5BF5), 5));
        overallPanel.setVisible(false);
        scrollPanel.add(overallPanel);
         
        readSchedulesFromFile();
        
        //wa najud ko ka gets sa panel og scrolll
        class ButtonAction implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                try {
                    String eventName = field1.getText().trim();
                    String contestsName = field2.getText().trim();

                    if (eventName.isEmpty() && contestsName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter an Event/Contest");
                    } else if (eventName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter an Event");
                    } else if (contestsName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter a Contest");
                    } else {
                        // Process the input since both fields are filled
                        selectedMonth = (String) comboBox.getSelectedItem();
                        selectedDay = (String) comboBox2.getSelectedItem();
                        selectedYear = (String) comboBox3.getSelectedItem();

                        createScheduleEntryPanel(eventName, contestsName, selectedMonth, selectedDay, selectedYear);
                        saveScheduleToFile(eventName, contestsName, selectedMonth, selectedDay, selectedYear);

                        field1.setText("");
                        field2.setText("");
                        comboBox.setSelectedIndex(0);
                        comboBox2.setSelectedIndex(0);
                        comboBox3.setSelectedIndex(0);
                        clearSched.setVisible(true);
                    }
                } catch (Exception ex) {
                    System.out.print("Error occurred while processing the schedule!");
                }
            }
        }


        Right.add(clearSched);
        Right.add(overallPanel);

        // Add Schedule button
        confirmButton = new JButton();
        confirmButton.setPreferredSize(new Dimension(150, 100));
        confirmButton.setText("Add Schedule");
        confirmButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        confirmButton.setBackground(new Color(0x9470CE));
        confirmButton.setForeground(Color.white);
        confirmButton.setFocusable(false);
        confirmButton.setHorizontalAlignment(JButton.CENTER);
        confirmButton.addActionListener(new ButtonAction());

        JLabel BigSched = new JLabel();
        BigSched.setText("Schedule");
        BigSched.setFont(new Font("Century Gothic", Font.BOLD, 40));
        BigSched.setForeground(Color.BLACK);

        JLabel date = new JLabel();
        date.setText("Enter Date");
        date.setFont(new Font("Century Gothic", Font.BOLD, 20));

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        comboBox = new JComboBox(months);
        comboBox.setPreferredSize(new Dimension(100, 25));
        comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        comboBox2 = new JComboBox(days);
        comboBox2.setPreferredSize(new Dimension(100, 25));
        comboBox2.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        String[] years = {"2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033"};
        comboBox3 = new JComboBox(years);
        comboBox3.setPreferredSize(new Dimension(100, 25));
        comboBox3.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        JLabel currentSched = new JLabel();
        currentSched.setText("Current Schedule");
        currentSched.setFont(new Font("Century Gothic", Font.BOLD, 40));
        currentSched.setForeground(Color.WHITE);
        currentSched.setOpaque(true);

        Left.setBackground(Color.white);
        Left.setMinimumSize(new Dimension(512, 640));

        GroupLayout LeftLayout = new GroupLayout(Left);
        Left.setLayout(LeftLayout);

        LeftLayout.setHorizontalGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(BigSched)
                                .addComponent(event)
                                .addComponent(field1, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                .addComponent(Contests)
                                .addComponent(field2, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                .addComponent(date)
                                .addComponent(comboBox)
                                .addComponent(comboBox2)
                                .addComponent(comboBox3)
                                .addGroup(LeftLayout.createParallelGroup()
                                        .addComponent(confirmButton)
                                        .addComponent(confirmButton, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                )
                        ))
        );

        LeftLayout.setVerticalGroup(
                LeftLayout.createSequentialGroup()

                        .addGap(30, 30, 30)
                        .addComponent(BigSched)
                        .addGap(30, 30, 30)
                        .addComponent(event)
                        .addComponent(field1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Contests)
                        .addComponent(field2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(date)
                        .addComponent(comboBox)
                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox2)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox3)
                        .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmButton)
                        .addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        );


        class ClearAllAction implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (entryPanelsList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Current schedule is already empty");
                } else {
                    // Remove all panels from the list
                    entryPanelsList.forEach(panel -> {
                        scrollPanel.remove(panel);
                        overallPanel.remove(panel);
                    });

                    // Clear the list
                    entryPanelsList.clear();
                    deleteAllSchedulesFromFile();

                    // Refresh the UI
                    scrollPanel.revalidate();
                    scrollPanel.repaint();
                    overallPanel.revalidate();
                    overallPanel.repaint();
                }
            }
        }

        clearButton = new JButton("Clear All");
        clearButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        clearButton.setBackground(Color.white);
        clearButton.setForeground(new Color(0x9470CE));
        clearButton.setHorizontalAlignment(JButton.CENTER);
        clearButton.setFocusable(false);
        clearButton.addActionListener(new ClearAllAction());

        Right.add(clearButton);

        currentSched = new JLabel();
        currentSched.setText("Current Schedule");
        currentSched.setFont(new Font("Century Gothic", Font.BOLD, 40));
        currentSched.setForeground(Color.white);


        Right.setBackground(new Color(0xb19cd9));
        Right.setMinimumSize(new Dimension(512, 640));

        GroupLayout RightLayout = new GroupLayout(Right);
        Right.setLayout(RightLayout);

        RightLayout.setHorizontalGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(RightLayout.createSequentialGroup()
                        .addGap(80)
                        .addComponent(currentSched))
                .addGroup(RightLayout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(scrollPane))
                .addGroup(RightLayout.createSequentialGroup()
                        .addGap(85)
                        .addComponent(overallPanel))
                .addGroup(RightLayout.createSequentialGroup()
                        .addGap(200)
                        .addComponent(clearButton)
                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
        );

        RightLayout.setVerticalGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(RightLayout.createSequentialGroup()
                        .addGap(25)
                        .addComponent(currentSched))
                .addGroup(RightLayout.createSequentialGroup()
                        .addGap(85)
                        .addComponent(scrollPane))
                .addGroup(RightLayout.createSequentialGroup()
                        .addGap(130)
                        .addComponent(overallPanel))
                .addGroup(RightLayout.createSequentialGroup()
                        .addGap(550)
                        .addComponent(clearButton)
                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(Left);
        Left.setBounds(0, 0, 512, 640);
        Right.setBounds(512, 0, 512, 640);
        jPanel1.add(Right);

        GroupLayout layout = new GroupLayout(mainSched.getContentPane());
        mainSched.getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        mainSched.setLocationRelativeTo(null);
        mainSched.setVisible(true);

    }
    
    public void saveScheduleToFile(String event, String contest, String month, String day, String year) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            // Writing username and password to the file, separated by a comma
            writer.write(event + "," + contest + "," + month + "," + day + "," + year);
            writer.newLine();
            writer.close();
            System.out.println("Schedule saved to schedule.txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    
    public void readSchedulesFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while((line = reader.readLine()) != null) {
                // Splitting the line into username and password using a comma
                String[] details = line.split(",");

                // Initializing username and password variables
                String event = details[0].trim();
                String contest = details[1].trim();
                String month = details[2].trim();
                String day = details[3].trim();
                String year = details[4].trim();
                
                createScheduleEntryPanel(event, contest, month, day, year);
            }
        } catch(IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }
    
    public void deleteScheduleFromFile(String schedule) {
        
        //System.out.println(schedule);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String currentLine;
            String newList = "";

            // Copy the content to the temporary file excluding the username to delete
            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.equals(schedule)) {
                    newList += currentLine + System.lineSeparator();
                }
            }
            
            //System.out.println(newList);
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(newList);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteAllSchedulesFromFile() {
        try {
           BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
           writer.write("");
           writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}