package javaSnake;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random.*;
import javax.swing.*;

public class SnakeGame extends JPanel{
	
	private class Tile {
		int x;
		int y;
		
		Tile(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	int boardWith;
	int boardHeight;
	int tileSize = 25;
	
	SnakeGame(int boardWidth, int boardHeight) {
		
		this.boardWith = boardWidth;
		this.boardHeight = boardHeight;
		
		setPreferredSize(new Dimension(this.boardWith, this.boardHeight));
		setBackground(Color.black);
	}
}
