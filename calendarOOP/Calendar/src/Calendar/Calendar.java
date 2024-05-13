package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calendar extends JPanel {

    private static final long serialVersionUID = 1L;

    public Calendar(int year, int month, LocalDate selectedDay, JPanel mainPanel) {

        setLayout(new BorderLayout(30, 30));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adjust padding if needed
        setBackground(Color.white);

        JPanel top = new JPanel(new BorderLayout(10, 10));
        top.setBackground(null);

        JLabel date = new JLabel(LocalDate.of(year, month, 1).
        		format(DateTimeFormatter.ofPattern("MMMM yyyy")));
        date.setHorizontalAlignment(JLabel.CENTER);
        date.setFont(new Font("Helvetica", Font.BOLD, 30));
        date.setForeground(Color.decode("#0ecf78"));

        top.add(date, BorderLayout.CENTER);

        JLabel right = new JLabel(new ImageIcon("pics/right-arrow.png"));
        right.setCursor(new Cursor(Cursor.HAND_CURSOR));
        right.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanel.removeAll();
				if (month!=12) {
					mainPanel.add(new Calendar(year, month+1, selectedDay, mainPanel));
				} else {
					mainPanel.add(new Calendar(year+1, 1, selectedDay, mainPanel));

				}
				mainPanel.add(new Events());
				mainPanel.revalidate();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        	
        	
        });
        top.add(right, BorderLayout.EAST);

        JLabel left = new JLabel(new ImageIcon("pics/left-arrow.png"));
        left.setCursor(new Cursor(Cursor.HAND_CURSOR));
        left.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanel.removeAll();
				if (month!=1) {
					mainPanel.add(new Calendar(year, month-1, selectedDay, mainPanel));
				} else {
					mainPanel.add(new Calendar(year-1, 12, selectedDay, mainPanel));

				}
				mainPanel.add(new Events());
				mainPanel.revalidate();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        	
        	
        });
        top.add(left, BorderLayout.WEST);

        add(top, BorderLayout.NORTH);

        JPanel days = new JPanel(new GridLayout(7, 7));
        days.setBackground(null); // Set a default background for readability

        Color header = Color.pink;
        days.add(new DayLabel("Su", header, Color.white, false));
        days.add(new DayLabel("Mo", header, Color.white, false));
        days.add(new DayLabel("Tu", header, Color.white, false));
        days.add(new DayLabel("We", header, Color.white, false));
        days.add(new DayLabel("Th", header, Color.white, false));
        days.add(new DayLabel("Fr", header, Color.white, false));
        days.add(new DayLabel("Sa", header, Color.white, false));

        String[] weekDays = new String[]{"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY",
                "FRIDAY", "SATURDAY"};

        LocalDate firstDay = LocalDate.of(year, month, 1);

        int j = 0;

        while (!firstDay.getDayOfWeek().toString().equals(weekDays[j])) {
            days.add(new DayLabel("", Color.white, Color.black, false));
            j++;
        }

        int daysNum = YearMonth.of(year, month).lengthOfMonth();

        for (int i = 1; i <= daysNum; i++) { // Use <= to include all days
        	
        	DayLabel dayLabel;
        	if (selectedDay.getYear()== year && selectedDay.getMonthValue()== month && selectedDay.getDayOfMonth()== i ) {
        		dayLabel = new DayLabel(i+"", Color.white, Color.blue, true);
        	} else if (i%5==0) {
        		dayLabel = new DayLabel(i+"", Color.yellow, Color.red, true);
        	} else {
        		dayLabel = new DayLabel(i+"", Color.decode("#f0f0f0"), Color.gray, true);
        	}
        	
            days.add(dayLabel);
        }

        for (int i = daysNum + j; i < 42; i++) {
            days.add(new DayLabel("", Color.black, Color.white, true));
        }

        add(days, BorderLayout.CENTER);

    }
}
