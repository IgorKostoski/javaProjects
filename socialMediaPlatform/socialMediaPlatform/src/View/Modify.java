package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Model.Database;
import Model.User;

public class Modify {
	
	
	public Modify(User user, Database database) {
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
		
		JLabel changePassword = new JLabel("Change Password",0,GUIConstants.black, Font.BOLD);
		changePassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
		changePassword.setHorizontalAlignment(JLabel.CENTER);
		
		
		panel.add(changePassword, BorderLayout.SOUTH);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.requestFocus();
		
		
	}

}
