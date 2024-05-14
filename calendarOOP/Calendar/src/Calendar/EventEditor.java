package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventEditor {
	public EventEditor() {
		
		
		JFrame frame = new JFrame("Calendar");
		frame.setSize(700,350);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		JPanel mainPanel = new JPanel(new BorderLayout(20,20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(40,20,20,20));
		mainPanel.setBackground(Color.white);
		
		JPanel center = new JPanel(new GridLayout(3,2,20,20));
		center.setBackground(Color.white);
		
		
		
		
		frame.setVisible(true);
	}

}
