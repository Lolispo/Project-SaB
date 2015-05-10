package main;

import javax.swing.*;

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
		
		frame.setContentPane(m.getComponent());
		frame.setSize(600,600);
		frame.setTitle("Sticks and Boxes");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.pack();
		frame.repaint();
		
		//JOptionPane.showMessageDialog(frame, "HI THERE", "Billy", 1);
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Give the amount of circles in each row"));
		Field f = new Field(amount);
		JPanel contentPane = (JPanel) frame.getContentPane();
		JPanel j = new JPanel();
		j.add(f.getComponent());
		
		contentPane.removeAll();
		contentPane.add(j);
		contentPane.revalidate(); 
		contentPane.repaint();
//		frame.setContentPane(f.getComponent());
	//	frame.repaint();
	}
	
}
