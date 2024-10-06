package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Calendar extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public Calendar() {
		
		
		setLayout(new BorderLayout(30,30));
		setBorder(BorderFactory.createEmptyBorder(40,20,30,20));
		
		setBackground(Color.white);
		
		
		JPanel top = new JPanel(new BorderLayout(10,10));
		top.setBackground(null);
		
		JLabel date = new JLabel("October 2024");
		date.setHorizontalAlignment(JLabel.CENTER);
		date.setFont(new Font("Helvetica", Font.BOLD, 30));
		date.setForeground(Color.decode("#0ecf78"));
		top.add(date, BorderLayout.CENTER);
		
		JLabel left = new JLabel(new ImageIcon("pics/right.png"));
		left.setCursor(new Cursor(Cursor.HAND_CURSOR));
		top.add(left, BorderLayout.EAST);
		
		JLabel right = new JLabel(new ImageIcon("pics/left.png"));
		left.setCursor(new Cursor(Cursor.HAND_CURSOR));
		top.add(right, BorderLayout.WEST);
		
		
		
		
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
		
		for (int i=0; i<42; i++) {
			days.add(new DayLabel(i+"", Color.decode("#f0f0f0"), Color.black, true));
			
		}
		
		add(days, BorderLayout.CENTER);
		
		
	}

}
