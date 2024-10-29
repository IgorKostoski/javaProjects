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
		
		
		JLabel date = new JLabel("November 2024");
		date.setHorizontalAlignment(JLabel.CENTER);
		date.setFont(new Font("Helvetica", Font.BOLD, 30));
		date.setForeground(Color.decode("#0ecf78"));
		top.add(date, BorderLayout.CENTER);
		
		
		JLabel right = new JLabel(new ImageIcon("pics/right.png"));
		right.setCursor(new Cursor(Cursor.HAND_CURSOR));
		top.add(right, BorderLayout.EAST);
		
		
		JLabel left = new JLabel(new ImageIcon("pics/left.png"));
		left.setCursor(new Cursor(Cursor.HAND_CURSOR));
		top.add(left, BorderLayout.WEST);
		
		
		add(top, BorderLayout.NORTH);
		
		
		
		
		
		JPanel days = new JPanel(new GridLayout(7,7));
		
		days.setBackground(null);
		
		for (int i=0; i< 49; i++) {
			JLabel lb = new JLabel(i+"");
			lb.setHorizontalAlignment(JLabel.CENTER);
			lb.setFont(new Font("Helvetica", Font.PLAIN, 20));
			lb.setOpaque(true);
			lb.setBackground(Color.decode("#f0f0f0"));
			lb.setForeground(Color.black);
			
			days.add(lb);

	}
		
		add(days, BorderLayout.CENTER);
		
	}

}
