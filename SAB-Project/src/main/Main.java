package main;

import javax.swing.*;

/**
 * Main Class - starts the game
 * Sets the JFrame and creates a Menu object that makes the menu
 * 
 * @author Petter Andersson & Jonas Hongisto
 */
public class Main {

	private JFrame frame;

	public static void main(String[] args){
		new Main();
	}

	public Main(){
		frame = new JFrame();
		frame.setSize(800,600);
		frame.setTitle("Sticks and Boxes");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Menu m = new Menu(frame);
		m.makeMenu();
		
	}
}
