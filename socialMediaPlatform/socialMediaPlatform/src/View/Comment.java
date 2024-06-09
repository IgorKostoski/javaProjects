package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Comment extends JPanel{
	

	public Comment() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(GUIConstants.white);
		setBorder(BorderFactory.createEmptyBorder(15,15,15,25));
		
		JPanel header  = new JPanel(new BorderLayout());
		header.setBackground(null);
		
		JLabel author = new JLabel("User Name", 20, GUIConstants.post, Font.BOLD);
		header.add(author, BorderLayout.WEST);
		add(header);
		
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEADING));
		center.setBackground(null);
		JTextArea  content = new JTextArea("\"Lorem ipsum dolor sit amet, \","
				,18, GUIConstants.post, Font.PLAIN);
		center.add(content);
		add(center);
		
		JPanel bottom = new JPanel(new BorderLayout());
		bottom.setBackground(null);
		bottom.add(new JLabel("Thu, 0 Jun 2024", 15, GUIConstants.post, Font.PLAIN), BorderLayout.EAST);
		add(bottom);
		
		int height = (int) (90 + content.getPreferredSize().getHeight());
		
		Dimension dimension = new Dimension();
	}
}
