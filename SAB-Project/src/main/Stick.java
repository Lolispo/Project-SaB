package main;

public class Stick {

	private boolean visible;
	private boolean chosen;
	
	
	public Stick(){
		visible = false;
	}
	
	public void place(){
		if(!chosen){
			visible = true;
			chosen = true;
			//Graphic change
		}
	}
}
