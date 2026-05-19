package BMS;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class BudgetPlanner implements ActionListener {
   private final String budgetFilename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\budget.txt";
   private final String foodFilename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\food.txt";
   private final String eventFilename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\event.txt";
   private final String otherFilename = "C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\other.txt";
   
   private FileIOBudgetPlanner budgetIO = new FileIOBudgetExpenses(budgetFilename);
   private FileIOBudgetPlanner foodIO = new FileIOFoodExpenses(foodFilename);
   private FileIOBudgetPlanner eventIO = new FileIOEventExpenses(eventFilename);
   private FileIOBudgetPlanner otherIO = new FileIOOtherExpenses(otherFilename);
   
   private double budgetPrice = budgetIO.readFromFile();
   private double foodPrice = foodIO.readFromFile();
   private double eventPrice = eventIO.readFromFile();
   private double otherPrice = otherIO.readFromFile();
   

   private DecimalFormat decimalFormat = new DecimalFormat("#.00");

   public void budget() {
      frame1 = new JFrame();
      FlowLayout frameLayout = new FlowLayout(FlowLayout.CENTER);
      frame1.setLayout(frameLayout);
      FlowLayout panel8Layout = new FlowLayout(FlowLayout.CENTER, 190, 20);
      panel1 = new JPanel(panel8Layout);
      
      panel1.setPreferredSize(new Dimension(1024, 100));
      panel1.setBackground(new Color(0xAF7EEB));
      frame1.add(panel1);
      
      String backIconPath = "back.png";
      URL backIconUrl = getClass().getResource(backIconPath);
      ImageIcon back = createImageIcon(backIconUrl);
      
      //ImageIcon back = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\BudgetPlanner\\back.png");
      backButton = new JButton(back);
      backButton.setSize(30, 60);
      backButton.setFocusable(false);
      backButton.setBorderPainted(false);
      backButton.setBackground(Color.WHITE);
      panel1.add(backButton);
      
      panel8 = new JPanel();
      panel8.setPreferredSize(new Dimension(300, 60));
      panel8.setBackground(Color.WHITE);
      panel1.add(panel8);
      
      label5 = new JLabel();
      panel9 = new JPanel();
      label5.setText("Budget Planner");
      label5.setFont(new Font("", Font.BOLD, 30));
      label5.setForeground(Color.BLACK);
      panel9.add(label5, new FlowLayout(FlowLayout.CENTER, 20, 0));
      
      String foodIconPath = "food5.png";
      URL foodIconUrl = getClass().getResource(foodIconPath);
      ImageIcon food = createImageIcon(foodIconUrl);
      
      String eventIconPath = "event5.png";
      URL eventIconUrl = getClass().getResource(eventIconPath);
      ImageIcon event = createImageIcon(eventIconUrl);
      
      String othersIconPath = "other5.png";
      URL othersIconUrl = getClass().getResource(othersIconPath);
      ImageIcon others = createImageIcon(othersIconUrl);
      
      //ImageIcon food = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\BudgetPlanner\\food3.png");
      //ImageIcon event = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\BudgetPlanner\\event3.png");
      // others = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\BudgetPlanner\\other3.png");
      
      label2 = new JLabel(food);
      label3 = new JLabel(event);
      label4 = new JLabel(others);
      
      String plusIconPath = "plus4.png";
      URL plusIconUrl = getClass().getResource(plusIconPath);
      ImageIcon plus = createImageIcon(plusIconUrl);
      
      //ImageIcon plus = new ImageIcon("D:\\practice intellij\\Bits and Bytes Management System\\src\\BudgetPlanner\\plus3.png");
      foodButton = new JButton(plus);
      eventButton = new JButton(plus);
      otherButton = new JButton(plus);
      addButton = new JButton();
      
      foodButton.setSize(40, 40);
      eventButton.setSize(40, 40);
      otherButton.setSize(40, 40);
      addButton.setSize(200, 40);
      addButton.setText("Add");
      addButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
      
      foodButton.setFocusable(false);
      eventButton.setFocusable(false);
      otherButton.setFocusable(false);
      addButton.setFocusable(false);
      
      foodButton.setBorderPainted(false);
      eventButton.setBorderPainted(false);
      otherButton.setBorderPainted(false);
      addButton.setBorderPainted(false);
      
      foodButton.addActionListener(this);
      eventButton.addActionListener(this);
      otherButton.addActionListener(this);
      addButton.addActionListener(this);
      
      foodButton.setBackground(new Color(0xD9CFF6));
      eventButton.setBackground(new Color(0xD9CFF6));
      otherButton.setBackground(new Color(0xD9CFF6));
      addButton.setBackground(Color.WHITE);
      
      FlowLayout panel2Layout = new FlowLayout(FlowLayout.CENTER, 50, 0); // Adjust the horizontal gap to a suitable value (e.g., 50)
      panel2 = new JPanel(panel2Layout);
      panel2.add(label2);
      panel2.add(label3);
      panel2.add(label4);
      
      FlowLayout panel3Layout = new FlowLayout(FlowLayout.CENTER, 228, 10);
      panel3 = new JPanel(panel3Layout);
      panel3.add(foodButton);
      panel3.add(eventButton);
      panel3.add(otherButton);
      panel1.add(addButton);
      
      panel4 = new JPanel();
      panel4.setPreferredSize(new Dimension(230, 50));
      panel4.setBackground(Color.WHITE);
      
      panel5 = new JPanel();
      panel5.setPreferredSize(new Dimension(230, 50));
      panel5.setBackground(Color.WHITE);
      
      panel6 = new JPanel();
      panel6.setPreferredSize(new Dimension(230, 50));
      panel6.setBackground(Color.WHITE);
      
      Border panelBorder = BorderFactory.createLineBorder(new Color(0xAD85DF), 3);
      panel4.setBorder(panelBorder);
      panel5.setBorder(panelBorder);
      panel6.setBorder(panelBorder);
      
      FlowLayout panel7Layout = new FlowLayout(FlowLayout.CENTER, 70, 10);
      panel7 = new JPanel(panel7Layout);
      panel7.add(panel4);
      panel7.add(panel5);
      panel7.add(panel6);
      
      foodLabel = new JLabel("Php " + foodPrice);
      foodLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
      panel4.add(foodLabel);
      
      eventLabel = new JLabel("Php " + eventPrice);
      eventLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
      panel5.add(eventLabel);
      
      otherLabel = new JLabel("Php " + otherPrice);
      otherLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
      panel6.add(otherLabel);
      
      budgetLabel = new JLabel("Php " + budgetPrice);
      budgetLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
      panel8.add(budgetLabel);
      
      frame1.add(panel9);
      frame1.add(panel2);
      frame1.add(panel3);
      frame1.add(panel7);
      //frame1.add(panel4);
      frame1.setSize(1024, 640);
      frame1.setResizable(false);
      frame1.setTitle("Budget Planner");
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setLocationRelativeTo(null);
      frame1.setBackground(Color.WHITE);
      frame1.setVisible(true);
      
      backButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            DashBoard dashBoard = new DashBoard();
            dashBoard.dashBoard();
            frame1.dispose();
        }
      });
   }
   
   private JFrame frame1;
   private JPanel panel1;
   private JPanel panel2;
   private JPanel panel3;
   private JPanel panel4;
   private JPanel panel5;
   private JPanel panel6;
   private JPanel panel7;
   private JPanel panel8;
   private JPanel panel9;
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private JLabel label4;
   private JLabel label5;
   private JLabel foodLabel;
   private JLabel eventLabel;
   private JLabel otherLabel;
   private JLabel budgetLabel;
   private JButton foodButton;
   private JButton eventButton;
   private JButton otherButton;
   private JButton addButton;
   private JButton backButton;
   
   @Override
   public void actionPerformed(ActionEvent e) {
      String prompt;
      DecimalFormat decimalFormat = new DecimalFormat("0.00");
      if (e.getSource() == addButton) {
         try {
            prompt = JOptionPane.showInputDialog("Enter Budget Price: ");
            double newBudgetPrice = Double.parseDouble(prompt);
   
            if (newBudgetPrice < 0) {
               JOptionPane.showMessageDialog(null, "Invalid input. Please enter a non-negative budget.");
            } else {
               this.budgetPrice += newBudgetPrice;
               budgetIO.writeToFile(Double.toString(budgetPrice));
               //JOptionPane.showMessageDialog(null, "You have added Php " + decimalFormat.format(newBudgetPrice) + " to Total Budget Price");
               budgetLabel.setText("Php " + decimalFormat.format(this.budgetPrice));
            }
         } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid budget.");
         }
      } else {
         if (this.budgetPrice == 0) {
            JOptionPane.showMessageDialog(null, "The budget is empty. Please enter a budget first.");
         } else {
            try {
               prompt = JOptionPane.showInputDialog(getInputDialogMessage(e));
               double expensePrice = Double.parseDouble(prompt);
               if (expensePrice < 0) {
                  JOptionPane.showMessageDialog(null, "Invalid input. Please enter a non-negative amount.");
               } else if (expensePrice > this.budgetPrice) {
                  JOptionPane.showMessageDialog(null, "The entered price exceeds the budget.");
               } else {
                  expenseToFile(e, expensePrice);
                  updateExpenseLabel(e, expensePrice);
               }
            } catch (NumberFormatException exc) {
               JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid amount.");
            }
         }
      }
   }
   
   private void updateExpenseLabel(ActionEvent e, double expensePrice) {
      String labelText = "";
      JLabel expenseLabel = null;
      if (e.getSource() == foodButton) {
         labelText = "Food: ";
         expenseLabel = foodLabel;
         this.foodPrice += expensePrice;
      } else if (e.getSource() == eventButton) {
         labelText = "Event: ";
         expenseLabel = eventLabel;
         this.eventPrice += expensePrice;
      } else if (e.getSource() == otherButton) {
         labelText = "Other: ";
         expenseLabel = otherLabel;
         this.otherPrice += expensePrice;
      }
      expenseLabel.setText(labelText + "Php " + decimalFormat.format(getAccumulatedExpenseValue(e)));
      this.budgetPrice -= expensePrice;
      budgetIO.writeToFile(Double.toString(budgetPrice));
      DecimalFormat decimalFormat = new DecimalFormat("0.00");
      budgetLabel.setText("Php " + decimalFormat.format(this.budgetPrice));
   }
   
   private double getAccumulatedExpenseValue(ActionEvent e) {
      if (e.getSource() == foodButton) {
         return this.foodPrice;
      } else if (e.getSource() == eventButton) {
         return this.eventPrice;
      } else if (e.getSource() == otherButton) {
         return this.otherPrice;
      }
      return 0.0;
   }
   
   private String getInputDialogMessage(ActionEvent e) {
      if (e.getSource() == foodButton) {
         return "Enter price for Food and Snacks: ";
      } else if (e.getSource() == eventButton) {
         return "Enter price for Event Expenses: ";
      } else if (e.getSource() == otherButton) {
         return "Enter price for Other Expenses: ";
      }
      return "";
   }
   
   private ImageIcon createImageIcon(URL imageUrl) {
      if (imageUrl != null) {
         return new ImageIcon(imageUrl);
      }
      return null;
   }
   
   private void expenseToFile(ActionEvent e, double amount) {
      if(e.getSource() == foodButton) {
         double foodAmount = foodIO.readFromFile();
         foodAmount += amount;
         foodIO.writeToFile(Double.toString(foodAmount));
      } else if(eventButton == eventButton) {
         double eventAmount = eventIO.readFromFile();
         eventAmount += amount;
         eventIO.writeToFile(Double.toString(eventAmount));
      } else if(e.getSource() == otherButton) {
         double otherAmount = otherIO.readFromFile();
         otherAmount += amount;
         otherIO.writeToFile(Double.toString(otherAmount));
      }
   }
}