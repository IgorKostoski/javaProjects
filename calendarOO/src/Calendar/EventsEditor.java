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

public class EventsEditor {
	
	
	public EventsEditor() {
		
		
		JFrame frame = new JFrame("Calendar");
		frame.setSize(700,350);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		
		
		
		JPanel mainPanel = new JPanel(new BorderLayout(20,20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(40,20,20,20));
		mainPanel.setBackground(Color.white);
		
		
		JPanel center  = new JPanel(new GridLayout(3,2,20,20));
		center.setBackground(Color.white);
		
		JLabel l1 = new JLabel("Title: ");
		l1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		l1.setHorizontalAlignment(JLabel.CENTER);
		center.add(l1);
		
		JTextField title = new JTextField();
		title.setFont(new Font("Helvetica", Font.PLAIN, 20));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel l2 = new JLabel("Time: ");
		l2.setFont(new Font("Helvetica", Font.PLAIN, 20));
		l2.setHorizontalAlignment(JLabel.CENTER);
		center.add(l2);
		
		JLabel l3 = new JLabel("Description: ");
		l3.setFont(new Font("Helvetica", Font.PLAIN, 20));
		l3.setHorizontalAlignment(JLabel.CENTER);
		center.add(l3);


		
		
		frame.setVisible(true);
		
	
				
				
	}

}
