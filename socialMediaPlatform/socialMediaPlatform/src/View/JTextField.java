package View;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;

public class JTextField extends javax.swing.JTextField{
	
	private Shape shape;
	private String hint;
	
	
	public JTextField(String hint) {
		
		super();
		this.hint = hint;
		
		setFont(new Font("Segoue UI", Font.BOLD,20));
		setOpaque(false);
		setText(hint);
		setForeground(GUIConstants.textFieldHint);
		setBorder(BorderFactory.createEmptyBorder(TOP, 20, BOTTOM, 20));
		
		
		addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(getText().equals("")) {
					setText(hint);
					setForeground(GUIConstants.red);
					
				}
				
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
				if(getText().equals("")) {
					setText(hint);
					setForeground(GUIConstants.textFieldHint);
					
				}
				
				
			}
			
			
			
		});
		
		
	}
	
	//for rounded corners
	
	protected void paintComponent(Graphics g) {
		
		g.setColor(GUIConstants.white);
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 45, 45);
		super.paintComponent(g);
		
	}
	
	//for rounded border
	protected void paintBorder(Graphics g) {
		g.setColor(GUIConstants.red);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 45, 45);
		
	}

}
