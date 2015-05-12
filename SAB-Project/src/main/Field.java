package main;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Field {

	private int circles;
	private Square[][] planets;
	private int amountRow;
	private ArrayList<Stick> sticks;
	private ArrayList<Square> taken;
	private JFrame frame;
	private ImagePanel imageP;
	private boolean clicked;
	private Player[] players;
	private int currentPlayer;
	private JLabel[] scoreLabel;
	private JPanel panel;
	private JLabel turnLabel;

	public Field(int amountRow, JFrame frame, Player[] playerArr){
		this.frame = frame;
		currentPlayer = 0;
		players = playerArr;
		taken = new ArrayList<Square>();
		sticks =  new ArrayList<Stick>();
		this.amountRow = amountRow;
		circles = amountRow * amountRow;
		scoreLabel = new JLabel[players.length];
		turnLabel = new JLabel();

		setBackground();
		planets = makePlanets();
		makeSticks();
		drawSticks();

	}

	public void setBackground(){
		frame.getContentPane().removeAll();
		imageP = new ImagePanel(new PictureCreateClass("Universe.png",0,0).getImage());
		frame.getContentPane().add(imageP, BorderLayout.CENTER);
		panel = new JPanel();
		panel.add(turnLabel);
		for(int i = 0; i < scoreLabel.length; i++){
			String score = players[i].getName()+": "+players[i].getPoints()+" points";
			scoreLabel[i] = new JLabel(score);
			panel.add(scoreLabel[i]);
		}
		showPlayerTurn();
		printScores();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.repaint();
		frame.revalidate();
	}

	public Square[][] makePlanets(){

		planets = new Square[amountRow][amountRow];
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				planets[i][j] = new Square();
				planets[i][j].setCoordinates(i,j);
				planets[i][j].saveCurrentImage(new PictureCreateClass("circleFixed.png",planets[i][j].getX(),planets[i][j].getY()));
				imageP.add(planets[i][j].getPic());					
				frame.revalidate();
				frame.repaint();
			}
		}
		return planets;
	}

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

		for(final Stick stick : sticks){
			Square A = stick.getA();
			Square B = stick.getB();
			if(A.getX() == B.getX() && A.getY() == B.getY()){ // Kollar sig själv
				for(Stick innerStick : A.getSticks()){
					if(innerStick.getX() != 0 && innerStick.getY() != 0){
						int localX = 0;
						int localY = 0;
						if(innerStick.getX() == A.getX()){
							localX = A.getX();
							if(A.getY() < innerStick.getY()){
								localY = A.getY() - (innerStick.getY() - A.getY()) ;
							}
							else if(A.getY() > innerStick.getY()){
								localY = A.getY() + (A.getY() - innerStick.getY());
							}
						}
						else if(innerStick.getY() == A.getY()){
							localY = A.getY();
							if(A.getX() < innerStick.getX()){
								localX = A.getX() - (innerStick.getX() - A.getX());
							}
							else if(A.getX() > innerStick.getX()){
								localX = A.getX() + (A.getX() - innerStick.getX());
							}
						}
						boolean alreadyExists = false;
						for(Stick moreInnerStick : A.getSticks()){
							if(moreInnerStick.getX() == localX && moreInnerStick.getY() == localY){
								alreadyExists = true;
								break;
							}
						}
						if(!alreadyExists){ // Om den inte finns
							stick.setX(localX);
							stick.setY(localY);
							break;
						}
					}
				}
			}
			else if(A.getX() == B.getX()){
				stick.setX(A.getX());
				if(A.getY() < B.getY()){
					stick.setY((B.getY() - A.getY())/2 + A.getY());
				}
				else if(B.getY() < A.getY()){
					stick.setY((A.getY() - B.getY())/2 + B.getY());
				}
			}
			else if(A.getY() == B.getY()){
				stick.setY(A.getY());
				if(A.getX() < B.getX()){
					stick.setX((B.getX() - A.getX())/2 + A.getX());
				}
				else if(B.getX() < A.getX()){
					stick.setX((A.getX() - B.getX())/2 + B.getX());
				}
			}

			if(stick.getX() != 0){

				stick.saveCurrentImage(new PictureCreateClass("YTriangle.png",stick.getX(),stick.getY()));
				imageP.add(stick.getPic());
				StickMouseAdapter sma = new StickMouseAdapter(stick, this);
				frame.addMouseListener(sma);
				stick.setMouseAdapter(sma);


				frame.revalidate();
				frame.repaint();
			}
		}
	}


	public ArrayList<Square> checkIfSurroundend(){
		ArrayList<Square> surroundedSquares = new ArrayList<Square>(); 
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				if(planets[i][j].surrounded()==true && taken.contains(planets[i][j]) == false){
					taken.add(planets[i][j]);
					surroundedSquares.add(planets[i][j]);
					imageP.remove(planets[i][j].getPic());
					planets[i][j].saveCurrentImage(new PictureCreateClass("Explosion.png",planets[i][j].getX(),planets[i][j].getY()));
					imageP.add(planets[i][j].getPic());					
					frame.revalidate();
					frame.repaint();
				}
			}
		}
		return surroundedSquares;

	}

	public boolean checkIfGameOver(){
		if( taken.size() == circles){
			return true;
		}
		return false;
	}

	public boolean clicked(){
		return clicked;
	}

	public void clickUpdate(Stick stick){
		imageP.remove(stick.getPic());
		if (stick.getA().getX() == stick.getX()){
			stick.saveCurrentImage(new PictureCreateClass("stickSideWays.png",stick.getX(),stick.getY()));
			imageP.add(stick.getPic());
		}
		else{
			stick.saveCurrentImage(new PictureCreateClass("stick.png",stick.getX(),stick.getY()));
			imageP.add(stick.getPic());			
		}
		imageP.add(stick.getPic());
		frame.revalidate();
		frame.repaint();
		frame.removeMouseListener(stick.getMouseAdapter());
	}

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

	public void showPlayerTurn(){
		turnLabel.setText("Current turn: " + players[currentPlayer].getName());
	}

	public void printScores(){		
		for(int i = 0; i < scoreLabel.length; i++){
			String score = players[i].getName()+": "+players[i].getPoints()+" points";
			scoreLabel[i].setText(score);
		}
	}
}
