package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventEditor {
	
	public EventEditor() {
		
		
		JFrame frame = new JFrame("Calendar");
		
		frame.setSize(700, 350);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		
		
		JPanel mainPanel = new JPanel(new BorderLayout(20,20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(40,20,20,20));
		mainPanel.setBackground(Color.white);
		
		
		JPanel center = new JPanel(new GridLayout(3,2,20,20));
		center.setBackground(Color.white);
		
		
		JLabel l1 = new JLabel("Title: ");
		l1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		l1.setHorizontalAlignment(JLabel.CENTER);
		center.add(l1);
		
		JTextField title = new JTextField();
		title.setFont(new Font("Helvetica", Font.PLAIN, 20));
		title.setHorizontalAlignment(JLabel.CENTER);
		center.add(title);
		
		
		JLabel l2 = new JLabel("Time: ");
		l2.setFont(new Font("Helvetica", Font.PLAIN, 20));
		l2.setHorizontalAlignment(JLabel.CENTER);
		center.add(l2);
		
		JTextField time = new JTextField();
		time.setFont(new Font("Helvetica", Font.PLAIN, 20));
		time.setHorizontalAlignment(JLabel.CENTER);
		center.add(time);
		
		
		
		
		JLabel l3 = new JLabel("Descripiton: ");
		l3.setFont(new Font("Helvetica", Font.PLAIN, 20));
		l3.setHorizontalAlignment(JLabel.CENTER);
		center.add(l3);
		
		JTextField description = new JTextField();
		description.setFont(new Font("Helvetica", Font.PLAIN, 20));
		description.setHorizontalAlignment(JLabel.CENTER);
		center.add(description);
		
		
		
		
		
		
		
		
		frame.setVisible(true);
	}

}
