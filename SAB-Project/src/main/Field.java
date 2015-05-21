package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Field {

	private int amountCircles;
	private Circle[][] planets;
	private int amountRow;
	private ArrayList<Stick> sticks;
	private ArrayList<Circle> taken;
	private JFrame frame;
	private ImagePanel imageP;
	private boolean clicked;
	private Player[] players;
	private int currentPlayer;
	private JLabel[] scoreLabel;
	private JPanel panel;
	private JLabel turnLabel;
	private JLabel planetLabel;
	
	public Field(int amountRow, JFrame frame, Player[] playerArr){
		this.frame = frame;
		players = playerArr;
		taken = new ArrayList<Circle>();
		sticks =  new ArrayList<Stick>();
		this.amountRow = amountRow;
		amountCircles = amountRow * amountRow;
		scoreLabel = new JLabel[players.length];
		currentPlayer = randomStartPlayer(players.length);
		turnLabel = new JLabel();
		planetLabel = new JLabel();
		
		setBackground(); // Sets background
		planets = createCircles(); // Adds circles
		makeSticks(); // Makes sticks
		drawSticks(); // Draw sticks

	}
	
	/**
	 * Sets up the background of the field together with the score to the right.
	 */
	public void setBackground(){
		frame.getContentPane().removeAll();
		imageP = new ImagePanel(new PictureCreateClass(URLs.BACKGROUND,0,0).getImage());
		frame.getContentPane().add(imageP);
		frame.getContentPane().setPreferredSize(new Dimension(800,600));
		
		JPanel outside = new JPanel();
		panel = new JPanel();

		outside.setLayout(new BoxLayout(outside, BoxLayout.LINE_AXIS));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)); //new GridLayout());
		outside.add(Box.createHorizontalStrut(550));
		outside.add(panel);
		panel.setBackground(Color.BLACK);
		panel.add(turnLabel);
		panel.add(planetLabel);
		panel.add(Box.createVerticalStrut(20));

		for(int i = 0; i < scoreLabel.length; i++){
			String score = players[i].getName()+": "+players[i].getPoints()+" points";
			scoreLabel[i] = new JLabel(score);
			scoreLabel[i].setFont(new Font("Serif", Font.BOLD, 20));
			scoreLabel[i].setForeground(Color.WHITE);
			panel.add(scoreLabel[i]);
			panel.add(Box.createVerticalStrut(5));
		}
		showPlayerTurn();
		printScores();
		imageP.add(outside);
		frame.repaint();
		frame.revalidate();
	}

	public Circle[][] createCircles(){
		CircleCreator circle = new CircleCreator(amountRow,frame,imageP);
		return circle.makeCircles();
	}

	/**
	 * Creates the sticks so they can later be given coordinates and drawn
	 */
	public void makeSticks(){

		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				if ( (j+1) != amountRow){
					sticks.add(new Stick(planets[i][j], planets[i][j+1]));
				}
				if((i+1) != amountRow){
					sticks.add(new Stick(planets[i][j], planets[i+1][j]));
				}

				if((i==0 && j == 0) || (i==0 && j==amountRow-1) 
						|| (i==amountRow-1 && j == 0) || (i==amountRow-1 && j == amountRow-1)){
					sticks.add(new Stick(planets[i][j]));
					sticks.add(new Stick(planets[i][j]));
				}
				while(planets[i][j].nmbSticks()<4){
					sticks.add(new Stick(planets[i][j]));
				}
			}
		}
	}

	public void drawSticks(){
		new StickInit(frame,sticks,imageP,this);
	}

	/**
	 * Checks all the circles if they are all surrounded.
	 * If they are, update their graphics
	 * @return
	 */
	public ArrayList<Circle> checkIfSurroundend(){
		ArrayList<Circle> surroundedCircles = new ArrayList<Circle>(); 
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				if(planets[i][j].surrounded()==true && taken.contains(planets[i][j]) == false){
					taken.add(planets[i][j]);
					surroundedCircles.add(planets[i][j]);
					imageP.remove(planets[i][j].getPic());
					planets[i][j].saveCurrentImage(new PictureCreateClass(players[currentPlayer].getURL(),
							planets[i][j].getX(),planets[i][j].getY()));
					imageP.add(planets[i][j].getPic());
					frame.revalidate();
					frame.repaint();
				}
			}
		}
		return surroundedCircles;
	}

	/**
	 * Returns true when amount of circles == the amount of circles taken
	 * @return
	 */
	public boolean checkIfGameOver(){
		if( taken.size() == amountCircles){
			return true;
		}
		return false;
	}

	public boolean clicked(){
		return clicked;
	}

	/**
	 * Updates the graphics with placing the correct stick
	 * @param stick that was clicked
	 */
	public void clickUpdate(Stick stick){
		imageP.remove(stick.getPic());
		if (stick.getA().getX() == stick.getX()){
			if(currentPlayer == 0){
				stick.saveCurrentImage(new PictureCreateClass(URLs.STICK_HORIZONTAL1,stick.getX(),stick.getY()));
			}
			else if (currentPlayer == 1){
				stick.saveCurrentImage(new PictureCreateClass(URLs.STICK_HORIZONTAL2,stick.getX(),stick.getY()));
			}
			else if(currentPlayer == 2){
				stick.saveCurrentImage(new PictureCreateClass(URLs.STICK_HORIZONTAL3,stick.getX(),stick.getY()));
			}
			else if(currentPlayer == 3){
				stick.saveCurrentImage(new PictureCreateClass(URLs.STICK_HORIZONTAL4,stick.getX(),stick.getY()));
			}
		}
		else{
			if(currentPlayer == 0){
				stick.saveCurrentImage(new PictureCreateClass(URLs.STICK_VERTICAL1,stick.getX(),stick.getY()));
			}
			else if(currentPlayer == 1){
				stick.saveCurrentImage(new PictureCreateClass(URLs.STICK_VERTICAL2,stick.getX(),stick.getY()));
			}
			else if(currentPlayer == 2){
				stick.saveCurrentImage(new PictureCreateClass(URLs.STICK_VERTICAL3,stick.getX(),stick.getY()));
			}
			else if(currentPlayer == 3){
				stick.saveCurrentImage(new PictureCreateClass(URLs.STICK_VERTICAL4,stick.getX(),stick.getY()));
			}
		}
		imageP.add(stick.getPic());
		frame.revalidate();
		frame.repaint();
		frame.removeMouseListener(stick.getMouseAdapter());
	}

	/**
	 * Change player when a turn was made and no points were achieved
	 * If it's the last player, go to player 1
	 */
	public void changePlayer(){
		if(currentPlayer == players.length-1){
			currentPlayer = 0;
		}
		else{
			currentPlayer++;
		}
		showPlayerTurn();
	}

	public void addPoints(int points){
		players[currentPlayer].addPoints(points);
		printScores();
	}

	public void showPlayerTurn(){ // Updates scores
		String labelText = "<html><font color='white'>Current turn: <font color='" + 
				players[currentPlayer].getColor()+"'>" + 
				players[currentPlayer].getName() + "</font></html>";
		turnLabel.setText(labelText);
		turnLabel.setFont(new Font("Serif", Font.BOLD, 30));
		turnLabel.setForeground(Color.WHITE);
		PictureCreateClass miniPlanet = new PictureCreateClass(players[currentPlayer].getURL(),700,700);
		Image image =  miniPlanet.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(image);
		planetLabel.setIcon(icon);
	}

	public void repaintVictory(){ // If a winner is found
		new VictoryScreen(frame,imageP,players);
	}

	public void printScores(){	// Updates scores	
		for(int i = 0; i < scoreLabel.length; i++){
			String score = players[i].getName()+": "+players[i].getPoints()+" points";
			scoreLabel[i].setText(score);
		}
	}

	public int getAmountRow(){
		return amountRow;
	}
	
	public int randomStartPlayer(int playerAmount){
		Random r = new Random();
		return r.nextInt(playerAmount);
	}
}
