package main;

public class Stick {

	private boolean visible;
	private boolean chosen;
	private Square A;
	private Square B;
	private int X;
	private int Y;

	public Stick(Square A, Square B){
		this.A = A;
		this.B = B;
		visible = false;
		//System.out.println("Bug finder:\nA = " + A + "\nB = "+B);
		A.addStick(this);
		B.addStick(this);

	}
	public Stick(Square A){

		this.A = A;
		this.B = A;
		visible = false;
		A.addStick(this);
	}
//heyhey
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
}

