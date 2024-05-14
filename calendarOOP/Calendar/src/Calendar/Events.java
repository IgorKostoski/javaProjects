package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Events extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public Events() {
		
		
		setLayout(new BorderLayout(20, 20));
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(40,20,30,20));
		
		JPanel list = new JPanel(new GridLayout(4,1,10,10));
		list.setBackground(Color.white); 
		
		
		JPanel event = new  JPanel(new GridLayout(2,1));
		event.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10, 10, 10, 10),
				BorderFactory.createMatteBorder(0, 10, 0, 0, Color.black)));
		
		list.add(event);
		add(list, BorderLayout.CENTER);
		
		
		
		
	}

}
