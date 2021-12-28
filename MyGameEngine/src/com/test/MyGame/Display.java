package com.test.MyGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class Display extends JFrame{

	private Canvas canvas;
	private JPanel p;
	Display(int WIDTH, int HEIGHT){

		setTitle("My Game");
		setVisible(true);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		canvas.setFocusable(false);

		add(canvas);
		pack();
		setLocationRelativeTo(null);

	}
}
