package View;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class SideButton extends JPanel{
	
	public SideButton(String text, String pic) {
		super(new FlowLayout(FlowLayout.LEFT, 10, 10));
		setMaximumSize(new Dimension(182, 50));
	}

}
