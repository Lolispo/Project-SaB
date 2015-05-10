package main;

public class Stick {

	private boolean visible;
	private boolean chosen;
	private Square A;
	private Square B;

	public Stick(Square A, Square B){
		A = this.A;
		B = this.B;
		visible = false;
		A.addStick(this);
		B.addStick(this);

	}
	public Stick(Square A){

		A = this.A;
		B = this.A;
		visible = false;

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
}
