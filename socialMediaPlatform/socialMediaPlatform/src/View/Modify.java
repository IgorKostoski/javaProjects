package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Modify {
	
	
	public Modify() {
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(72,84,149,84));
		panel.add(new JLabel("Modify Your Profile", 40, GUIConstants.blue, Font.BOLD),
				BorderLayout.NORTH);
		JPanel center = new JPanel(new GridLayout(4,1,10,10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(50,231,17,231));
		
		JTextField firstName = new JTextField("First Name");
		center.add(firstName);
		JTextField lastName = new JTextField("Last Name");
		center.add(lastName);
		JTextField email = new JTextField("Email");
		center.add(email);
		
		JButton submit = new JButton("Submit", 45, 20);
		center.add(submit);
		panel.add(center, BorderLayout.CENTER);
		
		
	}

}
