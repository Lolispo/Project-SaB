package main;
import java.util.*;
import javax.swing.*;

public class Play {

	private Player playerOne;
	private Player playerTwo;
	private Field field;
	private Player turn;
	private JFrame frame;
	private boolean gameOver;

	public Play(JFrame frame){
		this.frame = frame;
		gameOver = false;
		turn = playerOne;
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Give the amount of circles in each row"));
		field = new Field(amount, frame);
		while (gameOver == false){
			PlayTurn(turn);
		}
	}

	public void PlayTurn(Player currentPlayer){
		field.checkIfSurroundend().size();
		currentPlayer.addPoints(field.checkIfSurroundend().size());
		
		if(turn == playerOne){
			turn = playerTwo;
		}
		
		else {
			turn = playerOne;
		}
	}
}
