package main;

import java.awt.event.*;

public class Stick extends MouseAdapter{

	private boolean visible;
	private boolean chosen;
	private Square A;
	private Square B;
	private int X;
	private int Y;
	private boolean sideways;
	private int XLength;
	private int YLength;
	private PictureCreateClass picture;
	private StickMouseAdapter sma;

	public Stick(Square A, Square B) {
		this.A = A;
		this.B = B;
		visible = false;
		//System.out.println("Bug finder:\nA = " + A + "\nB = "+B);
		A.addStick(this);
		B.addStick(this);
		checkSideways();
		
	}

	public Stick(Square A){
		this.A = A;
		this.B = A;
		visible = false;
		A.addStick(this);
		checkSideways();
	}

	public void checkSideways(){
		if(sideways){
			XLength = 145;
			YLength = 87;
		}
		else{
			XLength = 87;
			YLength = 145;
		}
	}

	public void place(){
		if(!chosen){
			visible = true;
			chosen = true;
			//Graphic change
		}
	}

	public void setSideways(){
		if ((A.getX()==X)){
			sideways = true;	//Assigns true or false to the sideways field depending on the x coordinate of the A planet.
		}
		else{
			sideways =false;
		}
	}
	public boolean isVisible(){
		return visible;
	}

	public boolean sideways(){
		return sideways;	
	}

	public Square getA(){
		return A;
	}
	public Square getB(){
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
/*
	//Hover stuff
	@Override
	public void mouseMoved(MouseEvent e){
		//87 145
		if((e.getX() >= this.getX() && e.getX() <= (this.getX() + XLength)) && 
				(e.getY() >= this.getY() && e.getY() <= (this.getY() + YLength))){
			System.out.println("Stick: " + this.getX() + ","+this.getY());
		}

		//System.out.println("Entered " + e.getX() + " , " + e.getY() + " for stick: " + this.getX() + ", " + this.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e){
		if((e.getX() >= this.getX() && e.getX() <= (this.getX() + XLength)) && 
				(e.getY() >= this.getY() && e.getY() <= (this.getY() + YLength))){
			System.out.println("Stick placed!! " + this.getX() + "," + this.getY());
			place();
			System.out.println(visible);
		}
	}*/
}

