package main;

import java.awt.event.*;

public class Stick extends MouseAdapter{

	private boolean visible;
	private boolean chosen;
	private Circle A;
	private Circle B;
	private int X;
	private int Y;
	private boolean sideways;
	private int XLength;
	private int YLength;
	private PictureCreateClass picture;
	private StickMouseAdapter sma;

	/**
	 * Sticks adjacent to two circles, A and B
	 */
	public Stick(Circle A, Circle B) {
		this.A = A;
		this.B = B;
		visible = false;
		//System.out.println("Bug finder:\nA = " + A + "\nB = "+B);
		A.addStick(this);
		B.addStick(this);
	}

	/**
	 * If a stick is only adjacent to one circle
	 * @param A
	 */
	public Stick(Circle A){
		this.A = A;
		this.B = A;
		visible = false;
		A.addStick(this);
	}

	/**
	 * Tries to place a stick, if it hasn't already been placed
	 */
	public void place(){
		if(!chosen){
			visible = true;
			chosen = true;
			//Graphic change
		}
	}

	/**
	 * Sets different sizes and images for vertical and horizontal sticks
	 */
	public void setSideways(){ //Sets before printed in field
		if ((A.getX() == this.getX()) && (A.getY() != this.getY())){
			sideways = true;	//Assigns true or false to the sideways field depending on the x coordinate of the A planet.
			XLength = 100;
			YLength = 50;
		}
		else{
			sideways = false;
			XLength = 50;
			YLength = 100;
		}
	}
	
	public boolean isVisible(){
		return visible;
	}

	public boolean sideways(){
		return sideways;	
	}

	public Circle getA(){
		return A;
	}
	public Circle getB(){
		return B;
	}
	
	public void setX(int x){
		X = x;
	}
	public void setY(int y){
		Y = y;
	}

	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}

	public int getXLength(){
		return XLength;
	}

	public int getYLength(){
		return YLength;
	}

	public void saveCurrentImage(PictureCreateClass p){
		picture = p;
	}
	
	public PictureCreateClass getPic(){
		return picture;
	}
	
	public void setMouseAdapter(StickMouseAdapter sma){
		this.sma = sma;
	}
	
	public StickMouseAdapter getMouseAdapter(){
		return sma;
	}
}

