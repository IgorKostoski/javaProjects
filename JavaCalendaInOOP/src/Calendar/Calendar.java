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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Calendar extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public Calendar(int year, int month, LocalDate selectedDay, JPanel mainPanel, Database database) {
		
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		
		setLayout(new BorderLayout(30,30));
		setBorder(BorderFactory.createEmptyBorder(40,20,30,20));
		setBackground(Color.white);
		
		
		JPanel top = new JPanel(new BorderLayout(10,10));
		
		top.setBackground(null);
		
		
		JLabel date = new JLabel(LocalDate.of(year, month, 1).format(DateTimeFormatter.ofPattern("MMMM yyyy")));
		date.setHorizontalAlignment(JLabel.CENTER);
		date.setFont(new Font("Helvetica", Font.BOLD, 30));
		date.setForeground(Color.decode("#0ecf78"));
		top.add(date, BorderLayout.CENTER);
		
		
		JLabel right = new JLabel(new ImageIcon("pics/right.png"));
		right.setCursor(new Cursor(Cursor.HAND_CURSOR));
		right.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanel.removeAll();
				
				if(month != 12) {
					mainPanel.add(new Calendar(year, month+1, selectedDay, mainPanel, database));
				} else {
					mainPanel.add(new Calendar(year+1, 1, selectedDay, mainPanel, database));
				}
				mainPanel.add(new Events(selectedDay, database, mainPanel));
				mainPanel.revalidate();
		
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
			
		});
		top.add(right, BorderLayout.EAST);
		
		
		JLabel left = new JLabel(new ImageIcon("pics/left.png"));
		left.setCursor(new Cursor(Cursor.HAND_CURSOR));
		left.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanel.removeAll();
				
				if(month != 1) {
					mainPanel.add(new Calendar(year, month-1, selectedDay, mainPanel, database));
				} else {
					mainPanel.add(new Calendar(year-1, 12, selectedDay, mainPanel, database));
				}
				mainPanel.add(new Events(selectedDay, database, mainPanel));
				mainPanel.revalidate();
		
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
			
		});
		
		
		top.add(left, BorderLayout.WEST);
		
		
		add(top, BorderLayout.NORTH);
		
		
		
		
		
		JPanel days = new JPanel(new GridLayout(7,7));
		
		days.setBackground(null);
		
		Color header = Color.decode("#f90069");
		
		days.add(new DayLabel("Su", header, Color.white, false));
		days.add(new DayLabel("Mo", header, Color.white, false));
		days.add(new DayLabel("Tu", header, Color.white, false));
		days.add(new DayLabel("We", header, Color.white, false));
		days.add(new DayLabel("Th", header, Color.white, false));
		days.add(new DayLabel("Fr", header, Color.white, false));
		days.add(new DayLabel("Sa", header, Color.white, false));
		
		
		String[] weekDays = new String[] {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
				"THURSDAY","FRIDAY", "SATURDAY"};
		
		
		LocalDate firstDay = LocalDate.of(year, month, 1);
		
		int j = 0;
		
		while (!firstDay.getDayOfWeek().toString().equals(weekDays[j])) {
			days.add(new DayLabel("", Color.decode("#f0f0f0"), Color.black, false));
			j++;
		}
		
		int daysNum = YearMonth.of(year, month).lengthOfMonth();
		
		
		for (int i=1; i<= daysNum; i++) {
			
			final int day  = i;
			
			DayLabel dayLabel;
			
			if (selectedDay.getYear()== year && selectedDay.getMonthValue()== month && selectedDay.getDayOfMonth() == i) {
				
				
				dayLabel =  new DayLabel(i+"", Color.decode("#0ecf78"), Color.black, true);
			}  else if (database.hasEvent(dateFormatter.format(LocalDate.of(year, month, i)))) {
				
				dayLabel =  new DayLabel(i+"", Color.decode("#00d1e8"), Color.black, true);
				
			} else {
				
				dayLabel =  new DayLabel(i+"", Color.decode("#f0f0f0"), Color.black, true);
				
			}
			dayLabel.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					mainPanel.removeAll();
					
					LocalDate selected = LocalDate.of(year, month, day);
					
					mainPanel.add(new Calendar(year, month,selected, mainPanel, database));
					mainPanel.add(new Events(selected, database, mainPanel));
					mainPanel.revalidate();
					
					
			
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}
				
			});
			
			days.add(dayLabel);
			

	}
		
		
		for (int i=0; i< (42-(j+daysNum)); i++) {
			days.add(new DayLabel("", Color.decode("#f0f0f0"), Color.black, true));
			

	}
		
		add(days, BorderLayout.CENTER);
		
	}

}
