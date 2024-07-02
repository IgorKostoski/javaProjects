package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Controller.CreatePost;
import Model.Database;
import Model.User;

public class Home {
	
	
	public Home(User user, Database database) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());

		JPanel sideBar = new JPanel();
		sideBar.setBackground(GUIConstants.white);
		Dimension sideBarDime = new Dimension(182,1000);
		sideBar.setPreferredSize(sideBarDime);
		sideBar.setMaximumSize(sideBarDime);
		sideBar.setMinimumSize(sideBarDime);
		sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
		sideBar.add(Box.createVerticalStrut(10));
		
		JPanel profile = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		profile.setMaximumSize(new Dimension(182,50));
		profile.setBackground(GUIConstants.white);
		profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		profile.add(new JLabel(user.getName(),19, GUIConstants.black, Font.BOLD));
		profile.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new Modify(user, database);
				frame.dispose();
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
		sideBar.add(profile);
		sideBar.add(Box.createVerticalStrut(3));
		sideBar.add(new SideButton("Posts", "myposts", user, database));
		sideBar.add(Box.createVerticalStrut(3));
		sideBar.add(new SideButton("Comments", "mycomments", user, database));
		sideBar.add(Box.createVerticalStrut(3));
		sideBar.add(new SideButton("Likes", "mylikes", user, database));
		sideBar.add(Box.createVerticalStrut(3));
		sideBar.add(new SideButton("Friends", "friends", user, database));
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(null);
		
		JPanel header = new JPanel(new BorderLayout());
		header.setBackground(GUIConstants.white);
		
		Dimension dimension = new Dimension(500, 159);
		header.setPreferredSize(dimension);
		header.setMaximumSize(dimension);
		header.setMinimumSize(dimension);
		header.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
		
		JPanel north = new JPanel(new BorderLayout());
		north.setBackground(null);
		north.add(new JLabel("Home", 20, GUIConstants.black, Font.BOLD)
				,BorderLayout.WEST);
		header.add(north, BorderLayout.NORTH);
		
		
		JTextArea postIn = new JTextArea("Share your thoughts..." ,18, 20);
		header.add(new JScrollPane(postIn), BorderLayout.CENTER);
		
		JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		south.setBackground(null);
		
		JButton postBtn = new JButton("Post", 35,16);
		postBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (postIn.isEmpty()) {
					new Alert("Cannot publish Empty post",frame);
					return;
				}
				Model.Post post = new Model.Post(postIn.getText(), user);
				if (new CreatePost(post,database).posted() ) {
					new Alert("Posted succesffully", frame);
					postIn.setText("");
				}
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
		postBtn.setPreferredSize(new Dimension(81,37));
		south.add(postBtn);
		header.add(south, BorderLayout.SOUTH);
		
		panel.add(header);
		panel.add(Box.createVerticalStrut(7));
		panel.add(new Post());
		
		
		for (int i=0; i<10; i++) {
			panel.add(Box.createVerticalStrut(7));
			panel.add(new Post());
			
		}
		
		frame.getContentPane().add(new JScrollPane(panel), BorderLayout.CENTER);	
		frame.getContentPane().add(Box.createHorizontalStrut(182), BorderLayout.EAST);
		
		
		
		
		
		
		
		frame.getContentPane().add(sideBar, BorderLayout.WEST);
		frame.setVisible(true);
		frame.requestFocus();
		
	}

}
