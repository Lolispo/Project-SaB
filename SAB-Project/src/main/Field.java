package main;

import javax.swing.*;

public class Field {

	private int circles;
	private PictureCreateClass imageComponent;
	private Square[][] planets;
	private int amountRow;

	public Field(int amountRow){
		amountRow = this.amountRow;
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
					new Stick(planets[i][j], planets[i][j+1]);
				}
				if(planets[i+1][j]	!= null){
					new Stick(planets[i][j], planets[i+1][j]);
				}

				if((i==0 && j == 0) || (i==0 && j==amountRow) || (i==amountRow && j == 0) || (i==amountRow && j == amountRow)){
					new Stick(planets[i][j]);
					new Stick(planets[i][j]);

				}
				while(planets[i][j].nmbSticks()<4){
					new Stick(planets[i][j]);
				}
			}
		}

		return planets;

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
