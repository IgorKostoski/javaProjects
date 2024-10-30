package Calendar;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JFrame frame = new JFrame("Calendar");
		
		frame.setSize(900, 500);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		
		
		JPanel mainPanel = new JPanel(new GridLayout(1,2,0,0));
		
		
		
		mainPanel.add(new Calendar(2024, 11));
		mainPanel.add(new Events());
	
		
		
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		

	}

}