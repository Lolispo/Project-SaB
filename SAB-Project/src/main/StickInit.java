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
	
	/**
	 * Calculates the positions of the sticks
	 * 
	 */
	public void drawSticks(){
		for(final Stick stick : sticks){
			Circle A = stick.getA();
			Circle B = stick.getB();
			if(A.getX() == B.getX() && A.getY() == B.getY()){ // If both linked circles are the same
				for(Stick innerStick : A.getSticks()){
					if(innerStick.getX() != 0 && innerStick.getY() != 0){
						int localX = 0;
						int localY = 0;
						if(innerStick.getX() == A.getX()){
							localX = A.getX();
							if(A.getY() < innerStick.getY()){
								localY = A.getCentralY() - A.getYLength();
							}
							else if(A.getY() > innerStick.getY()){
								localY = A.getY() + A.getYLength();
							}
						}
						else if(innerStick.getY() == A.getY()){
							localY = A.getY();
							if(A.getX() < innerStick.getX()){
								localX = A.getCentralX() - A.getXLength();
							}
							else if(A.getX() > innerStick.getX()){
								localX = A.getX() + A.getXLength();
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
				}
				else if(B.getY() < A.getY()){
					stick.setY(B.getY() + B.getYLength());
				}
			}
			else if(A.getY() == B.getY()){
				stick.setY(A.getY());
				if(A.getX() < B.getX()){
					stick.setX(A.getX() + A.getXLength());
				}
				else if(B.getX() < A.getX()){
					stick.setX(B.getX() + B.getXLength());
				}
			}

			// If sticks positions were set, Place the sticks and add mouseadapter
			if(stick.getX() != 0){
				stick.setSideways();
				if (stick.getA().getX() == stick.getX()){
					stick.saveCurrentImage(new PictureCreateClass(URLs.PLACE_HORIZONTAL,stick.getX(),stick.getY()));
				}
				else{
					stick.saveCurrentImage(new PictureCreateClass(URLs.PLACE_VERTICAL,stick.getX(),stick.getY()));
				}
				imageP.add(stick.getPic());

				StickMouseAdapter sma = new StickMouseAdapter(stick, field);
				frame.addMouseListener(sma);
				stick.setMouseAdapter(sma);

				frame.revalidate();
				frame.repaint();
			}
		}


	}
}