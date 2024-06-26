package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class CustomView {
	
	public CustomView() {
		JFrame frame = new JFrame();
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(null);
		
		JPanel header = new JPanel(new BorderLayout());
		header.setBackground(GUIConstants.white);
		Dimension dimension = new Dimension(500, 50);
		
		header.setPreferredSize(dimension);
		header.setMaximumSize(dimension);
		header.setMinimumSize(dimension);
		
		header.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
		
		
		JPanel north = new JPanel(new BorderLayout());
		north.setBackground(null);
		north.add(new JLabel("My Comments", 20, GUIConstants.black, Font.BOLD),
				BorderLayout.WEST);
		javax.swing.JLabel home = new  javax.swing.JLabel (new ImageIcon("pics/home.png"));
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		north.add(home, BorderLayout.EAST);
		header.add(north, BorderLayout.NORTH);
		
		panel.add(header);
		panel.add(Box.createVerticalStrut(7));
		
		panel.add(new Post());
		
		for (int i=0;i<10;i++) {
			panel.add(Box.createVerticalStrut(7));
			if(i%2==0){
				panel.add(new Post());
				} else {
					panel.add(new Comment());
				}
			}
		
		frame.getContentPane().add(new JScrollPane(panel));
		frame.setVisible(true);
		frame.requestFocus();
	}

}
