package main;

import javax.swing.*;

public class Main {

	private JFrame frame;
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		frame = new JFrame();
		Menu m = new Menu();
		
		frame.setContentPane(m.getComponent());
		
		frame.setSize(400,400);
		frame.setTitle("Sticks and Boxes");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.pack();
		frame.repaint();
		
		//JOptionPane.showMessageDialog(frame, "HI THERE", "Billy", 1);
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Give the amount of circles in each row"));
		Field f = new Field(amount);
		
	}
	
}
