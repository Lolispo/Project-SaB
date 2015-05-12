package main; 

public class Square {

	private Stick[] sticks;
	private int numberOfSticks;
	private int X;
	private int Y;
	private PictureCreateClass picture;

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
		X = 100 + 150*i;//75+200*i;
		Y = 100 + 150*j;//75+200*j;	
	}
	
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
	public void saveCurrentImage(PictureCreateClass p){
		picture = p;
	}
	
	public PictureCreateClass getPic(){
		return picture;
	}
}
