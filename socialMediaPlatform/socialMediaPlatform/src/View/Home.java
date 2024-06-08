package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
		
		
		frame.setVisible(true);
		frame.requestFocus();
		
	}

}
