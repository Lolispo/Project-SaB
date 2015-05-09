package main;

import javax.swing.*;

public class Main {

	private JFrame frame;
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		frame = new JFrame();
		//JOptionPane.showMessageDialog(frame, "HI THERE", "Billy", 1);
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Give the amount of circles in each row"));
		Field f = new Field(amount);
		
	}
	
}
