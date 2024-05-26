package View;

import java.awt.Font;
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

}
