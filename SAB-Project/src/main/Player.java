package main;

public class Player {
	private String name;
	private int points; 
	private String URL; // The personal circle
	private String HTMLcolor; // Color of the text
	
	public Player(){
		points = 0;	
	}

	public void addPoints(int p){
		int i = 0;
		while (i < p){
			points++;
			i++;
		}
	}

	public int getPoints(){
		return points;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setURL(String URL){
		this.URL = URL;
	}
	
	public String getURL(){
		return URL;
	}

	public void setColor(String color){
		this.HTMLcolor = color;
	}
	
	public String getColor(){
		return HTMLcolor;
	}
}
