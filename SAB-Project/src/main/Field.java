package main;

import javax.swing.*;

public class Field {

	private int circles;
	private JPanel panel;
	
	public Field(int amountRow){
		circles = amountRow * amountRow;
		makePanel();
	}

	public void makePanel(){
		panel = new JPanel();
		//ImageIcon
		//JImage 
		
		//panel.add();
	}
	
	public JPanel getPanel(){
		return panel;
	}
}
