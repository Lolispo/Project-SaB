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
		Menu m = new Menu();
		
		frame.getContentPane().add(m.getComponent());
		frame.setSize(600,600);
		frame.setTitle("Sticks and Boxes");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton[] buttons = m.getButtons();
		frame.setLayout(new BorderLayout());
		
		JPanel panelButtons = new JPanel();
		for(JButton button : buttons){
			panelButtons.add(button);
		}		
		frame.add(panelButtons, BorderLayout.SOUTH);

		//frame.pack();
		frame.repaint();
		
		
		//JOptionPane.showMessageDialog(frame, "HI THERE", "Billy", 1);
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Give the amount of circles in each row"));
		Field f = new Field(amount);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(f.getComponent());
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	//	frame.repaint();
			
			
	}
	
}
