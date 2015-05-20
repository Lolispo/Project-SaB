package main;

import javax.swing.*;
import java.util.*;

public class StickInit {

	private JFrame frame;
	private ArrayList<Stick> sticks;
	private ImagePanel imageP;
	private Field field;
	
	public StickInit(JFrame frame, ArrayList<Stick> sticks, ImagePanel imageP, Field field){
		this.frame = frame;
		this.sticks = sticks;
		this.imageP = imageP;
		this.field = field;
		drawSticks();
	}
	
	public void drawSticks(){
		for(final Stick stick : sticks){
			Circle A = stick.getA();
			Circle B = stick.getB();
			if(A.getX() == B.getX() && A.getY() == B.getY()){ // Kollar sig själv
				for(Stick innerStick : A.getSticks()){
					if(innerStick.getX() != 0 && innerStick.getY() != 0){
						int localX = 0;
						int localY = 0;
						if(innerStick.getX() == A.getX()){
							localX = A.getX();
							if(A.getY() < innerStick.getY()){
								/*
						System.out.println("Setting up stuff:\n" +
						"Circle coordinates: "+A.getX() + "," + A.getY() + " (" 
									+ A.getCentralX()+","+A.getCentralY()+")\n"
									+ "(Innerstick = "+innerStick.getY()+")");
								 */
								localY = A.getCentralY() - A.getYLength();
								//System.out.println("localX o Y = " + localX + "," + localY);

								//localY = A.getY() - (innerStick.getY() - A.getY()) ;
							}
							else if(A.getY() > innerStick.getY()){
								localY = A.getY() + A.getYLength();
								//localY = A.getY() + (A.getY() - innerStick.getY());
							}
						}
						else if(innerStick.getY() == A.getY()){
							localY = A.getY();
							if(A.getX() < innerStick.getX()){
								localX = A.getCentralX() - A.getXLength();
								//localX = A.getX() - (innerStick.getX() - A.getX());
							}
							else if(A.getX() > innerStick.getX()){
								localX = A.getX() + A.getXLength();
								//localX = A.getX() + (A.getX() - innerStick.getX());
							}
						}
						boolean alreadyExists = false;
						for(Stick moreInnerStick : A.getSticks()){
							if(moreInnerStick.getX() == localX && moreInnerStick.getY() == localY){
								alreadyExists = true;
								break;
							}
						}
						if(!alreadyExists){ // Om den inte finns
							stick.setX(localX);
							stick.setY(localY);
							break;
						}
					}
				}
			}
			else if(A.getX() == B.getX()){ // Other sticks between planets
				stick.setX(A.getX());
				if(A.getY() < B.getY()){
					stick.setY(A.getY() + A.getYLength());
					//stick.setY((B.getY() - A.getY())/2 + A.getY());
				}
				else if(B.getY() < A.getY()){
					stick.setY(B.getY() + B.getYLength());
					//stick.setY((A.getY() - B.getY())/2 + B.getY());
				}
			}
			else if(A.getY() == B.getY()){
				stick.setY(A.getY());
				if(A.getX() < B.getX()){
					stick.setX(A.getX() + A.getXLength());
					//stick.setX((B.getX() - A.getX())/2 + A.getX());
				}
				else if(B.getX() < A.getX()){
					stick.setX(B.getX() + B.getXLength());
					//stick.setX((A.getX() - B.getX())/2 + B.getX());
				}
			}

			if(stick.getX() != 0){
				stick.setSideways();
				if (stick.getA().getX() == stick.getX()){
					stick.saveCurrentImage(new PictureCreateClass(URLs.PLACE_HORIZONTAL,stick.getX(),stick.getY()));
				}
				else{
					stick.saveCurrentImage(new PictureCreateClass(URLs.PLACE_VERTICAL,stick.getX(),stick.getY()));
				}
				imageP.add(stick.getPic());

				//		StickMouseAdapter sma = new 

				StickMouseAdapter sma = new StickMouseAdapter(stick, field);
				frame.addMouseListener(sma);
				stick.setMouseAdapter(sma);

				frame.revalidate();
				frame.repaint();
			}
		}


	}
}