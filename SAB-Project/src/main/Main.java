package main;

import javax.swing.*;
import java.awt.*;

/**
 * Skriva ut sticks, hur spara
 * Grafik:
 *  - Meny och spel bakgrund
 *  - Sticks och annat
 *  - Rita ut game (relyar på annan fix)
 * Bra Design för spel (Grid + annat?)
 * Meny knappar
 *  - Play exit
 * Sticks kopplat till grafik!
 * 
 * 
 * 
 * @author Petter & Jonas
 *
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
		frame.getContentPane().add(m.getComponent());
		frame.validate();
		frame.repaint();
		
		JButton[] buttons = m.getButtons();
		frame.setLayout(new BorderLayout());

		JPanel panelButtons = new JPanel();
		for(JButton button : buttons){
			panelButtons.add(button);
		}
		panelButtons.setBackground(Color.BLACK);
		frame.add(panelButtons, BorderLayout.SOUTH);
		//frame.add(panelButtons, BorderLayout.CENTER);
		frame.revalidate();
		frame.repaint();
	}

}
