package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


import javax.swing.BorderFactory;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Friend extends JPanel{
	

	public Friend() {

		setLayout(new BorderLayout());
		setBackground(GUIConstants.white);
		setBorder(BorderFactory.createEmptyBorder(15,15,15,25));
		
		JLabel author = new JLabel("User Name", 20, GUIConstants.post, Font.BOLD);
		add(author, BorderLayout.WEST);
	
		
		
		
		
		
		JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		right.setBackground(null);
		
		
		JButton addFriend = new JButton("Post", 35,16);
		addFriend.setPreferredSize(new Dimension(81,37));
		right.add(addFriend);
		
		JLabel remove = new JLabel("Remove", 16, GUIConstants.blue,Font.BOLD);
		right.add(remove);
		
		
		add(right);
		
		
		Dimension dimension = new Dimension(500, 90);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);
		
		
	}
}
