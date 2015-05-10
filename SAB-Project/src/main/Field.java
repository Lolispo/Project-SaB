package main;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Field {

	private int circles;
	private PictureCreateClass imageComponent;
	private Square[][] planets;
	private int amountRow;
	private ArrayList<Stick> sticks;
	private ArrayList<Square> taken;
	private JFrame frame;
	
	public Field(int amountRow, JFrame frame){
		this.frame = frame;

		setBackground();
		sticks =  new ArrayList<Stick>();
		this.amountRow = amountRow;
		circles = amountRow * amountRow;
		planets = makePlanets();
		makeSticks();
		drawSticks();
	}
	
	public void setBackground(){
		setComponent();
		check();
		
	}

	public Square[][] makePlanets(){

		Graphics g = frame.getGraphics();
		g.setColor(Color.RED);
		
		planets = new Square[amountRow][amountRow];
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				planets[i][j] = new Square();
				g.fillOval(75+200*i, 75+200*j, 60, 60);
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
		Graphics g = frame.getGraphics();
		g.setColor(Color.BLUE);
		
		
		
	}
	
	
	public ArrayList<Square> checkIfSurroundend(){
		ArrayList<Square> surroundedSquares = new ArrayList<Square>(); 
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				if(planets[i][j].surrounded()==true);
				surroundedSquares.add(planets[i][j]);
			}
		}
		return surroundedSquares;
	}


	public void setComponent(){
		imageComponent = new PictureCreateClass("Universe.png"); //"/home/pettea/git/Project-SaB/SAB-Project/"
	}

	public PictureCreateClass getComponent(){
		return imageComponent;
	}

	public void check(){
		System.out.println(imageComponent.getURL());
	}
}
