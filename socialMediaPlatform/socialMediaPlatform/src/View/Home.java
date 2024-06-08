package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

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
		profile.add(new JLabel(user.getName(),19, GUIConstants.black, Font.BOLD));
		sideBar.add(profile);
		sideBar.add(Box.createVerticalStrut(3));
		
		
		
		
		
		
		frame.getContentPane().add(sideBar, BorderLayout.WEST);
		frame.setVisible(true);
		frame.requestFocus();
		
	}

}
