package main; 

public class Circle {

	private Stick[] sticks; // Holds the circles adjacent sticks
	private int numberOfSticks;
	private int X;
	private int Y;
	private PictureCreateClass picture;
	private int XLength; // Size of the circle
	private int YLength;
	
	public Circle(){
		sticks = new Stick[4];
		XLength = 100;
		YLength = 100;
	}

	//Confirms that the correct amount of sticks exist
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

	/**
	 * Checks if all the surrounding sticks are visible
	 * If they are, the circle is surrounded
	 * @return
	 */
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

	/**
	 * Gives the coordinates for the circles. 
	 * If the game was adjusting to different game sizes, this algorithm would be
	 *  what would be affected since the positions of the circles decide the positions
	 *  of the sticks.
	 * @param i
	 * @param j
	 */
	public void setCoordinates(int i, int j) {
		X = 70 + 150*i;
		Y = 70 + 150*j;
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
