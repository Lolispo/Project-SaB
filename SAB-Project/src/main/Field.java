package main;
import java.util.ArrayList;
import javax.swing.*;

public class Field {

	private int circles;
	private PictureCreateClass imageComponent;
	private Square[][] planets;
	private int amountRow;
	private ArrayList<Stick> sticks;
	private ArrayList<Square> taken;

	public Field(int amountRow){

		sticks =  new ArrayList<Stick>();
		this.amountRow = amountRow;
		circles = amountRow * amountRow;
		setComponent();
		check();
		planets = makePlanets();
	}

	public Square[][] makePlanets(){

		planets = new Square[amountRow][amountRow];
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				planets[i][j] = new Square();
			}
		}


		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				if (planets[i][j+1] != null){
					sticks.add(new Stick(planets[i][j], planets[i][j+1]));

				}
				if(planets[i+1][j]	!= null){
					sticks.add(new Stick(planets[i][j], planets[i+1][j]));
				}

				if((i==0 && j == 0) || (i==0 && j==amountRow) || (i==amountRow && j == 0) || (i==amountRow && j == amountRow)){
					sticks.add(new Stick(planets[i][j]));
					sticks.add(new Stick(planets[i][j]));

				}
				while(planets[i][j].nmbSticks()<4){
					sticks.add(new Stick(planets[i][j]));
				}
			}
		}

		return planets;

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
		imageComponent = new PictureCreateClass("/home/pettea/git/Project-SaB/SAB-Project/Universe.png");
	}

	public PictureCreateClass getComponent(){
		return imageComponent;
	}

	public void check(){
		System.out.println(imageComponent.getURL());
	}

}
