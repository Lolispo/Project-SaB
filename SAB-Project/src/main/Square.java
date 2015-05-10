package main; 

public class Square {

	private Stick[] sticks;
	private int numberOfSticks;
	private int X;
	private int Y;

	public Square(){
		sticks = new Stick[4];
	}

	public void addStick(Stick stick){
		int i = 0;
		while(sticks[i] != null){
			i++;

		}
		if(i >= sticks.length){
			return;

		}
		sticks[i] = stick;
		numberOfSticks++;
	}

	public int nmbSticks(){
		return numberOfSticks;

	}

	public boolean surrounded(){

		for(Stick stick: sticks){
			if(stick.isVisible() == false)
				return false;
		}
		return true;
	}
	
	public Stick[] getSticks(){
		return sticks;
	}

	public void setCoordinates(int i, int j) {
		X = 75+200*i;
		Y = 75+200*j;	
	}
	
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
}
