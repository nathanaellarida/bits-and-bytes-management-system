package BMS;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Calendar extends JFrame {
    static JLabel Month, Year;
    static JButton Prev, Next, SchedButton, homeButton;
    static JTable CalendarTable;
    static JComboBox<String> actionYear;
    static JFrame Main;
    static DefaultTableModel mCalendarTable;
    static JScrollPane sCalendarTable;
    static JPanel pnlCalendar, homeButtonPanel, buttonPanel;
    static int thisYear, thisMonth, thisDay, currentYear, currentMonth, currentDay;
    static ImageIcon image1, image2;
    public void calendarCode() {

        Main = new JFrame("Bits & Bytes Calendar");
        Main.setSize(1024, 640);
        Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Month = new JLabel("January", JLabel.CENTER);
        Month.setFont(new Font("Century Gothic", Font.BOLD, 35));
        Month.setForeground(Color.white);
        Month.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        Year = new JLabel();
        JPanel yearPanel = new JPanel();
        yearPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        class SchedAction implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Schedule scheduleFrame = new Schedule();
                scheduleFrame.scheduleCode();
                Main.dispose();
            }
        }

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(0xb19cd9));

        class HomeAction implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                DashBoard dashBoard = new DashBoard();
                dashBoard.dashBoard();
                Main.dispose();
            }
        }

        homeButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        homeButtonPanel.setBackground(new Color(0xb19cd9));
        
        homeButton = new JButton("Home");
        homeButton.setPreferredSize(new Dimension(80, 30));
        homeButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(new Color(0xb19cd9));
        homeButton.addActionListener(new HomeAction());
        homeButton.setOpaque(false);
        homeButton.setFocusable(false);
        homeButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        
        homeButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 810));

        SchedButton = new JButton("Add");
        SchedButton.setPreferredSize(new Dimension(75, 30));
        SchedButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
        SchedButton.setBackground(new Color(0xb19cd9));
        SchedButton.setForeground(new Color(0xFFFFFF));
        SchedButton.setOpaque(false);
        SchedButton.setFocusable(false);
        SchedButton.addActionListener(new SchedAction());
        SchedButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // Adjust the right margin

        homeButtonPanel.add(homeButton);
        buttonPanel.add(homeButtonPanel);
        buttonPanel.add(SchedButton);
        Main.add(buttonPanel, BorderLayout.NORTH);

        actionYear = new JComboBox<>();

        try {

            String image1IconPath = "previous_point_arrow_image.png";
            URL image1IconUrl = getClass().getResource(image1IconPath);
            ImageIcon image1 = createImageIcon(image1IconUrl);

            //image1 = new ImageIcon("C:\\Users\\Virginia\\IdeaProjects\\OOP Project Code\\src\\Calendar\\previous_point_arrow_image.png");

            String image2IconPath = "next_point_arrow_image.png";
            URL image2IconUrl = getClass().getResource(image2IconPath);
            ImageIcon image2 = createImageIcon(image2IconUrl);

            //image2 = new ImageIcon("C:\\Users\\Virginia\\IdeaProjects\\OOP Project Code\\src\\Calendar\\next_point_arrow_image.png");
            Prev = new JButton(image1);
            Prev.setBackground(new Color(0xeeeeee));
            Prev.setFocusable(false);
            Prev.setBorderPainted(false);
            Next = new JButton(image2);
            Next.setBackground(new Color(0xeeeeee));
            Next.setBorderPainted(false);
            Next.setFocusable(false);
        } catch (Exception e) {
            System.out.print("Image does not exist");
        }

        mCalendarTable = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        CalendarTable = new JTable(mCalendarTable);

        sCalendarTable = new JScrollPane(CalendarTable);
        pnlCalendar = new JPanel(new BorderLayout());

        pnlCalendar.setBorder(new MatteBorder(0, 15, 15, 15, new Color(0xb19cd9)));
        pnlCalendar.setBackground(new Color(0x9F5BF5));

        Prev.addActionListener(new PrevAction());
        Next.addActionListener(new NextAction());
        actionYear.addActionListener(new ActionYearSelection());

        pnlCalendar.add(Month, BorderLayout.NORTH);
        pnlCalendar.add(sCalendarTable, BorderLayout.CENTER);
        pnlCalendar.add(Year, BorderLayout.SOUTH);
        pnlCalendar.add(actionYear, BorderLayout.SOUTH);

        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(Prev);
        btnPanel.add(Next);
        pnlCalendar.add(btnPanel, BorderLayout.SOUTH);

        Main.add(pnlCalendar);

        Main.setResizable(false);
        Main.setLocationRelativeTo(null);
        Main.setVisible(true);

        java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
        thisDay = cal.get(java.util.GregorianCalendar.DAY_OF_MONTH);
        thisMonth = cal.get(java.util.GregorianCalendar.MONTH);
        thisYear = cal.get(java.util.GregorianCalendar.YEAR);
        currentMonth = thisMonth;
        currentYear = thisYear;
        currentDay = thisDay;

        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String header : headers) {
            mCalendarTable.addColumn(header);
        }
        JTableHeader tableHeader = CalendarTable.getTableHeader();
        tableHeader.setFont(new Font("Century Gothic", Font.BOLD, 18));

        CalendarTable.setRowHeight(63);
        mCalendarTable.setColumnCount(7);
        mCalendarTable.setRowCount(6);
        EmptyBorder border = new EmptyBorder(10, 10, 10, 10);
        sCalendarTable.setBorder(border);
        sCalendarTable.setBackground(Color.WHITE);

        for (int i = currentYear; i <= currentYear; i++) {
            actionYear.addItem(String.valueOf(i));
        }
    }

    private static void refreshCalendar(int month, int year) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                mCalendarTable.setValueAt("", i, j);
            }
        }

        LocalDate firstDayOfMonth = LocalDate.of(year, month + 1, 1);
        int dayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();
        int daysInMonth = firstDayOfMonth.lengthOfMonth();
        int dayCounter = 1;

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        CalendarTable.setDefaultRenderer(Object.class, centerRenderer);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (dayCounter == 1 && j < dayOfWeek - 1) {
                    CalendarTable.setValueAt("", i, j);
                } else if (dayCounter > daysInMonth) {
                    CalendarTable.setValueAt("", i, j);
                } else {
                    DateCalendarChanger customRenderer = new DateCalendarChanger(currentYear, currentMonth, dayCounter);
                    CalendarTable.getColumnModel().getColumn(j).setCellRenderer(customRenderer);
                    CalendarTable.setValueAt(dayCounter, i, j);
                    dayCounter++;
                }
            }
        }

        String monthName = firstDayOfMonth.format(DateTimeFormatter.ofPattern("MMMM", Locale.US));
        Month.setText(monthName + " " + year);
    }

    public static void refreshCalendarPublic(int month, int year) {
        refreshCalendar(month, year);
    }

    static class PrevAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentMonth == 0) {
                currentMonth = 11;
                currentYear -= 1;
            } else {
                currentMonth -= 1;
            }
            refreshCalendarPublic(currentMonth, currentYear);
        }
    }

    static class NextAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentMonth == 11) {
                currentMonth = 0;
                currentYear += 1;
            } else {
                currentMonth += 1;
            }
            refreshCalendarPublic(currentMonth, currentYear);
        }
    }

    static class ActionYearSelection implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object selectedItem = actionYear.getSelectedItem();
            if (selectedItem != null && selectedItem instanceof String) {
                String selectedYearString = (String) selectedItem;
                int selectedYear = Integer.parseInt(selectedYearString);
                currentYear = selectedYear;
                refreshCalendar(currentMonth, currentYear);
            }
        }
    }
    private ImageIcon createImageIcon(URL imageUrl) {
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } return null;
    }
}
