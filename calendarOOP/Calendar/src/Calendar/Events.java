package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Events extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public Events(LocalDate date, Database database, JPanel mainPanel) {
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		ArrayList<Event> events = database.getEvents(dateFormatter.format(date));
		
		
		setLayout(new BorderLayout(20, 20));
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(40,20,30,20));
		
		int rows = 4;
		
		if (events.size()>4) rows = events.size();
		
		JPanel list = new JPanel(new GridLayout(4,1,10,10));
		list.setBackground(Color.white); 
		
		JScrollPane sp= new JScrollPane(list);
		
		
		for (int i=0; i<events.size(); i++) {
			
			final int j = i;
			JPanel event = new  JPanel(new GridLayout(2,1));
			event.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createEmptyBorder(10, 10, 10, 10),
					BorderFactory.createMatteBorder(0, 10, 0, 0, Color.black)));
			
			event.setBackground(Color.white);
			event.setCursor(new Cursor(Cursor.HAND_CURSOR));
			event.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					new EventEditor(events.get(j), database, mainPanel);
				}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}

				@Override
				public void mouseEntered(MouseEvent e) {}

				@Override
				public void mouseExited(MouseEvent e) {}
				
			});
			
			
			

			JLabel title = new JLabel(events.get(i).getTitle());
			title.setBorder(BorderFactory.createEmptyBorder(0,15,0,15));
			title.setFont(new Font("Halvetica",Font.PLAIN, 18 ));
			title.setForeground(Color.black);
			event.add(title);
			
			
			JLabel time = new JLabel(events.get(i).getDateTimeToString());
			time.setBorder(BorderFactory.createEmptyBorder(5,15,4,15));
			time.setFont(new Font("Halvetica",Font.PLAIN, 14 ));
			time.setForeground(Color.DARK_GRAY);
			event.add(time);
			
			list.add(event);
		}
		add(sp, BorderLayout.CENTER);
		
		JButton newEvent = new JButton("New");
		newEvent.setFont(new Font("Helvetica", Font.PLAIN,20));
		newEvent.setBackground(Color.CYAN);
		newEvent.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(newEvent, BorderLayout.SOUTH);
		
		
		
		
		
		
		
	}

}
