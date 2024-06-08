package View;

import java.awt.BorderLayout;

import Model.Database;
import Model.User;

public class Home {
	
	
	public Home(User user, Database database) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		
		
		frame.setVisible(true);
		frame.requestFocus();
		
	}

}
