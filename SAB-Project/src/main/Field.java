package main;

import javax.swing.*;

public class Field {

	private int circles;
	private JPanel panel;
	private Square[] planets;
	private int amountRow;

	public Field(int amountRow){
		amountRow = this.amountRow;
		circles = amountRow * amountRow;
		makePanel();
		
		planets = makePlanets(circles);
		

	}
	
	public Square[] makePlanets(int circles){
		
		planets = new Square[circles];
		
		int connectedSticks =(amountRow-1)*amountRow*2;
		int unConnectedSticks = (amountRow+1)^2 -connectedSticks;
		
		Square[] fourConnects = new Square[(amountRow-1)^2]; 
		Square[] threeConnects = new Square [circles - (amountRow-1)^2 - 4];
		Square[] twoConnects = new Square[4];

		for(int i = 0; i<fourConnects.length; i++){
			fourConnects[i] = new Square();
		}
		
		for(int i = 0; i<threeConnects.length; i++){
			threeConnects[i] = new Square();
		}
		for(int i = 0; i<twoConnects.length; i++){
			twoConnects[i] = new Square();
		}
		
		
		
		
		return planets;
		
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
