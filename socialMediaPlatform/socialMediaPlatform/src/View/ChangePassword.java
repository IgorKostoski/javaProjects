package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Model.Database;
import Model.User;

public class ChangePassword {
	
	public ChangePassword(User user, Database database) {
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(83,99,175,99));
		
		panel.add(new JLabel ("Change Password", 40, GUIConstants.black, Font.BOLD)
				,BorderLayout.NORTH);
		
		
		JPanel center = new JPanel(new GridLayout(4,1,10,10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(58,216,0,216));
		
		JTextField oldPassword = new JTextField("Old Password");
		
		
	}

}
