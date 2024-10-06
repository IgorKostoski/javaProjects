package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calendar extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public Calendar() {
		
		
		setLayout(new BorderLayout(30,30));
		setBorder(BorderFactory.createEmptyBorder(40,20,30,20));
		
		setBackground(Color.blue);
		
		
		JPanel top = new JPanel(new BorderLayout(10,10));
		top.setBackground(null);
		
		JLabel date = new JLabel("October 2024");
		date.setHorizontalAlignment(JLabel.CENTER);
		date.setFont(new Font("Helvetica", Font.BOLD, 30));
		
		
		add(top, BorderLayout.NORTH);
		
	}

}
