package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Player {

	private int points;

	public Player(){

		points = 0;	

	}

	public void addPoints(int p){
		int i = 0;
		while (i < p){
			points++;
		}
	}

	public int getPoints(){

		return points;
	}


	public void play(Field field){
		boolean endTurn = false;
			while(endTurn == false){

			while(field.clicked() == false){
			}

			int a = field.checkIfSurroundend().size();
			if(a==0){
				endTurn = true;
			}
			addPoints(a);
		}
	}
}
