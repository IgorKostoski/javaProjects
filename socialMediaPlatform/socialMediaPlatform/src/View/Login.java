package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Login {
	
	public Login() {
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(115, 0, 182, 0));
		
		JLabel title = new JLabel("Login", 40, GUIConstants.blue, Font.BOLD);
		title.setHorizontalAlignment(JLabel.CENTER);
		panel.add(title, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(3,1,10,10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(34,315,17,315));
		
		JTextField email = new JTextField("Email");
		center.add(email);
		JTextField password = new JTextField("Password");
		center.add(password);
		JButton login = new JButton("Login", 45,20);
		login.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		
		center.add(login);
		
		panel.add(center, BorderLayout.CENTER);
		
		JLabel createAcc = new JLabel("Dont have an account? Create new one", 20, GUIConstants.black, Font.BOLD);
		
		createAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		createAcc.setHorizontalAlignment(JLabel.CENTER);
		panel.add(createAcc, BorderLayout.SOUTH);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.requestFocus();
		
		
		
	}

}
