package main;

import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu {
	
	private BufferedImage background;
	private PictureCreateClass pcc;
	
	
	public Menu(){
		setWindow();
	}
	
	public void setWindow(){
		pcc = new PictureCreateClass();
		background = pcc.getImage();
	}
	
	public BufferedImage getWindow(){
		return background;
	}
	
	public PictureCreateClass getComponent(){
		return pcc;
	}
	
}
