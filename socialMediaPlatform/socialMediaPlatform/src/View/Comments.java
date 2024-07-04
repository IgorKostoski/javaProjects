package View;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Controller.CreateComment;
import Model.Database;
import Model.User;

public class Comments {
	
	public Comments(User user, Model.Post post, Database database) {
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(null);
		
		panel.add(new Post(user, post, database, frame));
		panel.add(Box.createVerticalStrut(7));
		
		JPanel newComment = new JPanel(new BorderLayout());
		newComment.setBackground(GUIConstants.white);
		
		Dimension dimension = new Dimension(500,58);
		newComment.setPreferredSize(dimension);
		newComment.setMaximumSize(dimension);
		newComment.setMinimumSize(dimension);
		newComment.setBorder(BorderFactory.createEmptyBorder(10,10,10,15));
		
		
		JTextArea commentIn = new JTextArea("Type a comment", 18,5);
		newComment.add(new JScrollPane(commentIn), BorderLayout.CENTER);
		
		JButton commentBtn = new JButton("Post", 35, 16);
		commentBtn.setPreferredSize(new Dimension(81,37));
		commentBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(commentIn.isEmpty()) {
					new Alert("Cannot publish empty comment", frame);
					return;
				}
				Model.Comment c = new Model.Comment(commentIn.getText(), user);
				
				if (new CreateComment(c, post, user, database).commented()) {
					new Alert("Comment published successfully", frame);
					
					panel.add(new Comment(c));
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
		newComment.add(commentBtn, BorderLayout.EAST);
		
		panel.add(newComment);
		panel.add(Box.createVerticalStrut(7));
		
		
		for (int i=0;i<10;i++) {
			panel.add(new Comment());
			panel.add(Box.createVerticalStrut(7));
		}
		
		
		
		
		
		frame.getContentPane().add(new JScrollPane(panel));
		frame.setVisible(true);
		frame.requestFocus();
		
		
	}

}
