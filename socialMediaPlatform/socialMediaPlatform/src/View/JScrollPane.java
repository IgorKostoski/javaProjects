package View;

import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.Dimension;

import javax.swing.JButton;

public class JScrollPane extends javax.swing.JScrollPane{
	
	public JScrollPane(JComponent component) {
		super(component);
		setBackground(null);
		getViewport().setBackground(null);
		setBorder(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(null);
		scrollBar.setBorder(null);
		scrollBar.setUI(new BasicScrollBarUI() {
			
			
			
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor =  GUIConstants.textAreaHint;
				
				
			}
			
			//to hide the arrows of scroll bar
			
			@Override
			protected JButton createDecreaseButton(int orientation) {
				return createZeroButton();
			}
			
			protected JButton createIncraseButton(int orientation) {
				return createZeroButton();
			}
			
			private JButton createZeroButton() {
				JButton btn = new JButton();
				btn.setPreferredSize(new Dimension(0,0));
				btn.setMaximumSize(new Dimension(0,0));
				btn.setMinimumSize(new Dimension(0,0));
				return btn;
				
			}
			
		});
		
		
	}
	

}
