package View;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Alert {
	
	public Alert(String content, JFrame parent) {
		
		JFrame frame = new JFrame();
		frame.setSize(430, 170);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel panel = new JPanel(new BorderLayout(5,5));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15 ,15));
		panel.setBackground(GUIConstants.white);
		
		JLabel title = new JLabel("Alert", 24, GUIConstants.blue, Font.BOLD);
		title.setHorizontalAlignment(JLabel.CENTER);
		panel.add(title, BorderLayout.NORTH);
		
		
	}

}
