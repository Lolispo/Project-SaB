package main;
import java.util.*;
import javax.swing.*;

public class Play {

	private Player playerOne;
	private Player playerTwo;
	private Field field;
	private Player turnPlayer;
	private JFrame frame;
	private boolean gameOver;

	public Play(JFrame frame){
		playerOne = new Player();
		playerTwo = new Player();
		this.frame = frame;
		gameOver = false;
		turnPlayer = playerOne;
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Give the amount of circles in each row"));
		field = new Field(amount, frame);
		while (gameOver == false){
			PlayTurn(turnPlayer);
		}
		//Display a game over screen!
		//Rematch and return to main menu.
	}

	public void PlayTurn(Player turnPlayer){
		
		turnPlayer.play(field);
		gameOver = field.checkIfGameOver();
		System.out.println(turnPlayer.getPoints());
		if(turnPlayer == playerOne){
			turnPlayer = playerTwo;
		}
		
		else {
			turnPlayer = playerOne;
		}
		
	}
}
