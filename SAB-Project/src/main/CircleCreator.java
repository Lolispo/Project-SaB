package main;

import javax.swing.*;

public class CircleCreator {

	private int amountRow; 
	private ImagePanel imageP;
	private JFrame frame;

	public CircleCreator(int amountRow, JFrame frame, ImagePanel imageP){
		this.amountRow = amountRow;
		this.imageP = imageP;
		this.frame = frame;
	}

	/**
	 * Makes the circles, in a primitive 2d array
	 * Sets the coordinates and adds it to the frame
	 * @return
	 */
	public Circle[][] makeCircles(){
		Circle[][] planets = new Circle[amountRow][amountRow];
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				planets[i][j] = new Circle();
				planets[i][j].setCoordinates(i,j);
				planets[i][j].saveCurrentImage(new PictureCreateClass(URLs.DEFAULT_CIRCLE,planets[i][j].getX(),planets[i][j].getY()));
				imageP.add(planets[i][j].getPic());					
				frame.revalidate();
				frame.repaint();
			}
		}
		return planets;
	}
}