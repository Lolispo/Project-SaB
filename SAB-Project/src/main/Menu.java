package main;

import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu {
	
	private PictureCreateClass imageComponent;
	
	
	public Menu(){
		setComponent();
	}
	
	public void setComponent(){
		imageComponent = new PictureCreateClass("/home/pettea/git/Project-SaB/SAB-Project/SticksAndBoxes.png");
	}
	
	public PictureCreateClass getComponent(){
		return imageComponent;
	}
	
}
