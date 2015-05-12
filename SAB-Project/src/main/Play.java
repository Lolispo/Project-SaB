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
	private Player[] players;
	
	public Play(JFrame frame, Player[] players){
		this.players = players;
		this.frame = frame;
		gameOver = false;
		//turnPlayer = playerOne;
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Give the amount of circles in each row"));
		field = new Field(amount, frame, players);
	}
}
