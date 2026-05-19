package Admin;

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

public class Admin extends JFrame {

    private JTable jTable1;
    private JButton jButtonImport;
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
        jButtonImport = new JButton();
        jButtonImport.setText("View Accounts");
        jButtonImport.setFocusable(false);
        jButtonImport.setFont(new Font("Century Gothic", Font.BOLD, 18));
        jButtonImport.setForeground(Color.WHITE);
        jButtonImport.setBounds(315, 540, 180, 35);
        jButtonImport.setBackground(new Color(0xAF7EEB));

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
        frame.add(jButtonImport, BorderLayout.NORTH);
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
        jButtonImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonImportActionPerformed(evt);
            }
        });

        // Add action listener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
    }


    private void jButtonImportActionPerformed(ActionEvent evt) {
        String filePath = "C:\\Users\\Jhoanne\\Documents\\account info.txt";
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(",");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setColumnIdentifiers(columnsName);

            // Clear existing data from the table
            model.setRowCount(0);

            // get lines from txt file
            Object[] tableLines = br.lines().toArray();

            // extract data from lines
            // set data to jtable model
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }

        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void deleteButtonActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();

        // Create a list to store selected rows
        List<Integer> selectedRows = new ArrayList<>();

        // Create checkboxes for each row (assuming the first column contains the ID)
        JCheckBox[] checkboxes = new JCheckBox[rowCount];
        JPanel checkboxPanel = new JPanel(new GridLayout(0, 1));

        for (int i = 0; i < rowCount; i++) {
            checkboxes[i] = new JCheckBox(model.getValueAt(i, 0).toString()); // Assuming the ID is in the first column
            checkboxPanel.add(checkboxes[i]);
        }

        // Show the checkboxes in a JOptionPane
        int option = JOptionPane.showConfirmDialog(null, checkboxPanel,
                "Select rows to delete", JOptionPane.OK_CANCEL_OPTION);

        // Check which checkboxes are selected
        if (option == JOptionPane.OK_OPTION) {
            for (int i = 0; i < rowCount; i++) {
                if (checkboxes[i].isSelected()) {
                    selectedRows.add(i);
                }
            }

            // Delete selected rows
            deleteRows(selectedRows);
        }
    }


    private void deleteRows(List<Integer> rowsToDelete) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Iterate over the rows in reverse order to avoid index issues
        for (int i = rowsToDelete.size() - 1; i >= 0; i--) {
            int rowIndex = rowsToDelete.get(i);

            // Get the ID of the row to be deleted
            String userId = model.getValueAt(rowIndex, 0).toString();

            // Remove the row from the table
            model.removeRow(rowIndex);

            // Update the text file
            updateTextFile(userId);
        }
    }

    private void updateTextFile(String userId) {
        try {
            String filePath = "C:\\Users\\Jhoanne\\Documents\\account info.txt";
            File inputFile = new File(filePath);
            File tempFile = new File("tempFile.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String currentLine;

                while ((currentLine = reader.readLine()) != null) {
                    // Assuming ID is in the first column, check if the line contains the user ID to be deleted
                    if (!currentLine.startsWith(userId + ",")) {
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }
                }
            } // This try-with-resources block will automatically close the readers

            // Delete the original file and rename the temp file to the original filename
            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Error renaming temp file to original file");
                }
            } else {
                System.out.println("Error deleting original file");
            }

        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

