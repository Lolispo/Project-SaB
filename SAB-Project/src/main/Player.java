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
			i++;
		}
	}

	public int getPoints(){

		return points;
	}

}
