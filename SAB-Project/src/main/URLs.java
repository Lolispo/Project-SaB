package main;

public class URLs {
	
	public static String MENU = "SticksMain.png"; // 800x600
	public static String BACKGROUND = "Universe.png"; // 1000x1000
	public static String DEFAULT_CIRCLE = "planet4.png"; // 100x100
	public static String PLACE_HORIZONTAL = "LandingArea.png"; // 100x50 
	public static String PLACE_VERTICAL = "LandingAreaShifted.png"; // 50x100
	public static String STICK_VERTICAL1 = "mainShip.png"; // 50x100
	public static String STICK_HORIZONTAL1= "mainShipShift.png"; // 100x50
	public static String STICK_VERTICAL2 = "stick2.png"; // 50x100
	public static String STICK_HORIZONTAL2= "stick2SideWays.png"; // 100x50
	public static String STICK_VERTICAL3 = "ship2.png"; // 50x100
	public static String STICK_HORIZONTAL3= "ship2Shift.png"; // 100x50
	public static String STICK_VERTICAL4 = "ship4.png";
	public static String STICK_HORIZONTAL4 = "ship4Sideways.png";
	public static String EXIT_SCREEN = "endScreen.png"; // 800x600
	public static String[] CIRCLES = {"planet1.png", "planet2.png", "planet3.png", "planet5.png"}; // 100x100
	public static final int AMOUNT_PLANETS = 4;
	public static final String[] COLORS = {"red", "green", "blue", "purple"};
	
	public static String[] THEMES = {"Space", "Original"};	
	
	public static int currentTheme = 0;
	
	
	public static void changeTheme(String choice){
		switch(choice){
		case "Space":
			MENU = "SticksMain.png";
			BACKGROUND = "Universe.png";
			DEFAULT_CIRCLE = "planet4.png";
			PLACE_HORIZONTAL = "LandingArea.png";
			PLACE_VERTICAL = "LandingAreaShifted.png";
			STICK_VERTICAL1 = "mainShip.png";
			STICK_HORIZONTAL1 = "mainShipShift.png";
			STICK_VERTICAL2 = "stick2.png";
			STICK_HORIZONTAL2 = "stick2SideWays.png"; 
			STICK_VERTICAL3 = "ship2.png";
			STICK_HORIZONTAL3 = "ship2Shift.png";
			STICK_VERTICAL4 = "ship4.png";
			STICK_HORIZONTAL4 = "ship4Sideways.png";
			
			EXIT_SCREEN = "endScreen.png";
			String[] temp = {"planet1.png", "planet2.png", "planet3.png", "planet5.png"};
			CIRCLES = temp;
			currentTheme = 0;
			break;
		case "Original":
			MENU = "OSticksMenu.png";
			BACKGROUND = "Obakgrund.png";
			DEFAULT_CIRCLE = "Obox2.png";
			PLACE_HORIZONTAL = "LandingArea.png";
			PLACE_VERTICAL = "LandingAreaShifted.png";
			STICK_VERTICAL1 = "ObranchVerti.png";
			STICK_HORIZONTAL1 = "ObranchHori.png";
			STICK_VERTICAL2 = "ObranchVerti.png";
			STICK_HORIZONTAL2 = "ObranchHori.png";
			STICK_VERTICAL3 = "ObranchVerti.png";
			STICK_HORIZONTAL3 = "ObranchHori.png";
			STICK_VERTICAL4 = "ObranchVerti.png";
			STICK_HORIZONTAL4 = "ObranchHori.png";
			
			EXIT_SCREEN = "Oend.png";
			String[] temp2 = {"Obox.png", "Obox.png", "Obox.png", "Obox.png"};
			CIRCLES = temp2;
			currentTheme = 1;
			break;
		}
	}
}
