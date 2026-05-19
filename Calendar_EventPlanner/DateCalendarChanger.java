import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class DateCalendarChanger extends DefaultTableCellRenderer {
    private int currentYear;
    private int currentMonth;
    private int currentDay;

    public DateCalendarChanger(int currentYear, int currentMonth, int currentDay) {
        this.currentYear = currentYear;
        this.currentMonth = currentMonth;
        this.currentDay = currentDay;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null && !value.toString().isEmpty()) {
            int day = Integer.parseInt(value.toString());
            if (currentYear == Calendar.currentYear && currentMonth == Calendar.currentMonth && day == Calendar.currentDay) {
                setBackground(new Color(0xb19cd9));
                setForeground(Color.WHITE);
                setFont(new Font("Cormorant Italic", Font.BOLD | Font.ITALIC, 30));
            } else {
                setBackground(table.getBackground());
                setForeground(Color.BLACK);
                setFont(new Font("Century Gothic", Font.PLAIN, 20));
            }

            setHorizontalAlignment(JLabel.CENTER);
        }

        return cell;
    }
}
