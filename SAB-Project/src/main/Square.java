package main; 

public class Square {

	private Stick[] sticks;
	private int numberOfSticks;
	private int X;
	private int Y;
	private PictureCreateClass picture;
	private int XLength;
	private int YLength;
	

	public Square(){
		sticks = new Stick[4];
		XLength = 100;
		YLength = 100;
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
		X = 70 + 150*i;//75+200*i;  Latest 100 + 150*i
		Y = 70 + 150*j;//75+200*j;	Latest 100 + 150*j
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
	
	public int getXLength(){
		return XLength;
	}
	
	public int getYLength(){
		return YLength;
	}
	
	public int getCentralX(){
		return X + (XLength / 2);
	}
	
	public int getCentralY(){
		return Y + (YLength / 2);
	}
}
