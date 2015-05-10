package main; 

public class Square {

	private Stick[] sticks;
	private int numberOfSticks;

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
}
