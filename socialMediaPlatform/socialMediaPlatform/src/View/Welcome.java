package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Welcome {
	
	public Welcome() {
		JFrame frame = new JFrame();
		
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(53,84,76,84));
		panel.add(new JLabel("Welcome", 40, GUIConstants.blue ,Font.BOLD), BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(6,1,10,10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(22,231,17,231));
		
		JTextField firstName = new JTextField("First Name");
		center.add(firstName);
		JTextField lastName = new JTextField("Last Name");
		center.add(lastName);
		JTextField email = new JTextField("E-Mail");
		center.add(email);
		JTextField password = new JTextField("Password");
		center.add(password);
		JTextField confirmPassword = new JTextField("Confirm Password");
		center.add(confirmPassword);
		
		
		
		
	}

}
