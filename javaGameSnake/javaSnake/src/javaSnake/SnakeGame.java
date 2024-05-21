package javaSnake;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random.*;
import javax.swing.*;

public class SnakeGame extends JPanel{
	
	int boardWith;
	int boardHeight;
	
	SnakeGame(int boardWidth, int boardHeight) {
		
		this.boardWith = boardWidth;
		this.boardHeight = boardHeight;
		
		setPreferredSize(new Dimension(this.boardWith, this.boardHeight));
		setBackground(Color.black);
	}
}
