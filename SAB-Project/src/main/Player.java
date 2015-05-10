package main;

public class Player {

	private int points;
	
	public Player(){
		
	points = 0;	
		
	}
	
	public void addPoints(int p){
		int i = 0;
		while (i < p){
			points++;
		}
	}
	
	public int getPoints(){
		
		return points;
	}
	
	
}
