package main;
import java.util.*;
import javax.swing.*;

public class Play {

	private Field field;
	private int turn;
	private boolean gameOver;

	public Play(){
		gameOver = false;
		int turn = 1;
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Give the amount of circles in each row"));
		Field field = new Field(amount);

		while (gameOver == false){
			PlayTurn(turn);
		}

	}



	public void PlayTurn(int i){


		ArrayList<Square> surrounded = field.checkIfSurroundend();



		if(turn == 1){
			turn = 2;
		}
		if(turn ==2){
			turn = 1;
		}

	}





}
