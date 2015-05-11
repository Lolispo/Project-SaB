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

	public Stick(Square A, Square B) {
		this.A = A;
		this.B = B;
		visible = false;
		//System.out.println("Bug finder:\nA = " + A + "\nB = "+B);
		A.addStick(this);
		B.addStick(this);
		sideways = (A.getX()==X);	//Assigns true or false to the sideways field depending on the x coordinate of the A planet.
		if(sideways){
			XLength = 145;
			YLength = 87;
		}
		else{
			XLength = 87;
			YLength = 145;
		}

	}
	public Stick(Square A){

		this.A = A;
		this.B = A;
		visible = false;
		A.addStick(this);
	}

	public void place(){
		if(!chosen){
			visible = true;
			chosen = true;
			//Graphic change
		}
	}
	public boolean isVisible(){
		return visible;
	}

	public boolean sideways(){
		return  sideways;	
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
	//Hover stuff
	@Override
	public void mouseEntered(MouseEvent e){
		//87 145
		if((e.getX() >= this.getX() && e.getX() <= (this.getX() + XLength)) && 
				(e.getY() >= this.getY() && e.getY() <= (this.getY() + YLength))){
			System.out.println("Stick: " + this.getX() + ","+this.getY());
		}

		//System.out.println("Entered " + e.getX() + " , " + e.getY() + " for stick: " + this.getX() + ", " + this.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e){
		System.out.println("Stick placed!!");
		place();
		System.out.println(visible);
	}
}

