package main;

public class URLs {
	
	public static String BACKGROUND = "Universe.png"; // 1000x1000
	public static String DEFAULT_CIRCLE = "planet4.png"; // 100x100
	public static String PLACE_HORIZONTAL = "LandingArea.png"; // 100x50 
	public static String PLACE_VERTICAL = "LandingAreaShifted.png"; // 50x100
	public static String STICK_VERTICAL = "mainShip.png"; // 50x100
	public static String STICK_HORIZONTAL= "mainShipShift.png"; // 100x50
	public static String EXIT_SCREEN = "Exterminatus.png"; // too big
	public static String[] CIRCLES = {"planet1.png", "planet2.png", "planet3.png", "planet5.png"}; // 100x100
	public static final int AMOUNT_PLANETS = 4;
	public static final String[] COLORS = {"red", "green", "blue", "purple"};
	
	public static void changeTheme(String choice){
		switch(choice){
		case "Space":
			BACKGROUND = "Universe.png";
			DEFAULT_CIRCLE = "planet4.png";
			PLACE_HORIZONTAL = "LandingArea.png";
			PLACE_VERTICAL = "LandingAreaShifted.png";
			STICK_VERTICAL = "mainShip.png";
			STICK_HORIZONTAL= "mainShipShift.png";
			EXIT_SCREEN = "Exterminatus.png";
			String[] temp = {"planet1.png", "planet2.png", "planet3.png", "planet5.png"};
			CIRCLES = temp;
			break;
		case "Other":
			
			break;
		}
	}
}
