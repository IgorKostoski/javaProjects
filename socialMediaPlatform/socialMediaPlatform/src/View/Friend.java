package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		addFriend.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		right.add(addFriend);
		
		JLabel remove = new JLabel("Remove", 16, GUIConstants.blue,Font.BOLD);
		remove.setCursor(new Cursor(Cursor.HAND_CURSOR));
		remove.setVisible(false);
		
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		remove.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
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
