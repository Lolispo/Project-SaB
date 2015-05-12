package main;

import java.awt.event.*;

public class StickMouseAdapter extends MouseAdapter{

	private Stick stick;
	private Field field;
	
	public StickMouseAdapter(Stick stick, Field field){
		this.stick = stick;
	}
		
	
	@Override
	public void mouseMoved(MouseEvent e){
		if((e.getX() >= stick.getX() && e.getX() <= (stick.getX() + stick.getXLength())) && 
				(e.getY() >= stick.getY() && e.getY() <= (stick.getY() + stick.getYLength()))){
			System.out.println("Stick: " + stick.getX() + ","+stick.getY());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e){
		if((e.getX() >= stick.getX() && e.getX() <= (stick.getX() + stick.getXLength())) && 
				(e.getY() >= stick.getY() && e.getY() <= (stick.getY() + stick.getYLength()))){
			System.out.println("Stick placed!! " + stick.getX() + "," + stick.getY());
			stick.place();
			stick.saveCurrentImage(new PictureCreateClass("circleFixed.png",stick.getX(),stick.getY()));
			System.out.println(stick.isVisible());
			field.clickUpdate(stick, this);
		}
	}
}
