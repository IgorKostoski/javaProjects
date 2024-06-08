package View;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;

public class JTextArea extends javax.swing.JTextArea{
	
	public JTextArea(String hint, int textSize, int padding) {
		super();
		setFont(new Font("Segoe UI", Font.BOLD, textSize));
		setBackground(null);
		setText(hint);
		setForeground(GUIConstants.textAreaHint);
		setBorder(BorderFactory.createEmptyBorder(padding, padding,padding,padding));
		
		addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {}

			@Override
			public void focusLost(FocusEvent e) {}
			
		});
	}
	
	
	

}
