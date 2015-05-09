package main; 

public class Square {

	private Stick[] sticks;


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
	}
}
