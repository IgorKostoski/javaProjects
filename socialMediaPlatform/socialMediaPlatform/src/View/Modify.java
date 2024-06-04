package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Controller.CreateUser;
import Controller.UpdateUser;
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
		firstName.setText(user.getFirstName());
		center.add(firstName);
		JTextField lastName = new JTextField("Last Name");
		lastName.setText(user.getLastName());
		center.add(lastName);
		JTextField email = new JTextField("Email");
		email.setText(user.getEmail());
		center.add(email);
		
		JButton submit = new JButton("Submit", 45, 20);
		submit.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(firstName.isEmpty()) {
					new Alert("First Name cannot be empty", frame);
					return;
				}
				if (lastName.isEmpty()) {
					new Alert("Last Name cannot be empty", frame);
					return;
				}
				if (email.isEmpty()) {
					new Alert("Email cannot be empty", frame);
					return;
				}
				
				
				user.setFirstName(firstName.getText());
				user.setLastName(lastName.getText());
				user.setEmail(email.getText());
				
				UpdateUser update = new UpdateUser(user,database);
				
				
				if (!email.getText().equals(user.getEmail()) && update.isEmailUsed(email.getText())) {
					new Alert("This email has been used before", frame);
					return;
					
				}
				
				new UpdateUser(user, database);
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
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
