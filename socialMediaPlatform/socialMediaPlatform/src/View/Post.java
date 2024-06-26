package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Post extends JPanel{
	
	public Post() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(GUIConstants.white);
		setBorder(BorderFactory.createEmptyBorder(15,15,15,25));
		
		
		JPanel header = new JPanel(new BorderLayout());
		header.setBackground(null);
		
		
		JLabel author = new JLabel("User Name", 20, GUIConstants.post, Font.BOLD);
		header.add(author, BorderLayout.WEST);
		
		JLabel date = new JLabel("Thu, 0 Juni 2024", 15, GUIConstants.post, Font.PLAIN);
		header.add(date, BorderLayout.EAST);
		
		add(header);
		add(Box.createVerticalStrut(7));
		
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEADING));
		center.setBackground(null);
		JTextArea content = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Risus feugiat in ante metus dictum."
				,18,GUIConstants.post, Font.PLAIN);
		center.add(content);
		add(center);
		add(Box.createVerticalStrut(7));
		
		JPanel bottom = new JPanel(new BorderLayout());
		bottom.setBackground(null);
		
		JPanel likes = new JPanel(new FlowLayout(FlowLayout.LEFT, 13,13));
		likes.setBackground(null);
		likes.add(new javax.swing.JLabel(new ImageIcon("pics/like.png")));
		likes.add(new JLabel("0 Likes", 15, GUIConstants.textAreaHint, Font.BOLD));
		bottom.add(likes, BorderLayout.WEST);
		JLabel comments = new JLabel("0 Comments", 15, GUIConstants.textAreaHint, Font.BOLD);
		bottom.add(comments, BorderLayout.EAST);
		add(bottom);
		
		
		int height = (int) (115+content.getPreferredSize().getHeight());
		
		
		Dimension dimension = new Dimension(500, height);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);
		
		
	}

	
}
