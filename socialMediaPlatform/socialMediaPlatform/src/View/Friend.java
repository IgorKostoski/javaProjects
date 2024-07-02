package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


import javax.swing.BorderFactory;

import javax.swing.JPanel;

import Model.User;



@SuppressWarnings("serial")
public class Friend extends JPanel{
	

	public Friend(User mainUser, User u) {

		setLayout(new BorderLayout());
		setBackground(GUIConstants.white);
		setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
		
		JLabel author = new JLabel(u.getName(), 20, GUIConstants.post, Font.BOLD);
		add(author, BorderLayout.WEST);
	
		
		
		
		
		
		JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		right.setBackground(null);
		
		
		JButton addFriend = new JButton("Add", 35,16);
		addFriend.setPreferredSize(new Dimension(81,37));
		addFriend.setVisible(false);
		right.add(addFriend);
		
		JLabel remove = new JLabel("Remove", 16, GUIConstants.blue,Font.BOLD);
		remove.setCursor(new Cursor(Cursor.HAND_CURSOR));
		remove.setVisible(false);
		
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		right.add(remove);
		
		
		if(mainUser.isFriend(u)) {
			addFriend.setVisible(false);
			remove.setVisible(true);
		} else {
			addFriend.setVisible(true);
			remove.setVisible(false);
			
			
		}
		
		
		add(right);
		
		
		
		
		Dimension dimension = new Dimension(500, 67);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);
		
		
	}
}
