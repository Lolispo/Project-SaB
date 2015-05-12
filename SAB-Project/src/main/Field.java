package main;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Field {

	private int circles;
	private PictureCreateClass imageComponent;
	private Square[][] planets;
	private int amountRow;
	private ArrayList<Stick> sticks;
	private ArrayList<Square> taken;
	private JFrame frame;
	private ImagePanel imageP;
	private boolean clicked;

	public Field(int amountRow, JFrame frame){
		this.frame = frame;
		taken = new ArrayList();
		setBackground();
		sticks =  new ArrayList<Stick>();
		this.amountRow = amountRow;
		circles = amountRow * amountRow;
		planets = makePlanets();
		makeSticks();
		drawSticks();
	}

	public void setBackground(){
		setComponent();
		check();

	}

	public Square[][] makePlanets(){

		//	frame.setLayout(new GridLayout(amountRow,amountRow));
		//		frame.add(new JButton("Hi"));
		Graphics g = frame.getGraphics();
		//g.setColor(Color.RED);

		frame.getContentPane().removeAll();
		imageP = new ImagePanel(new PictureCreateClass("Universe.png",0,0).getImage());
		frame.getContentPane().add(imageP);
		frame.repaint();
		frame.revalidate();

		planets = new Square[amountRow][amountRow];
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				planets[i][j] = new Square();
				planets[i][j].setCoordinates(i,j);
				//g.fillOval(planets[i][j].getX(),planets[i][j].getY(), 60, 60);
				imageP.add(new PictureCreateClass("circleFixed.png",planets[i][j].getX(),planets[i][j].getY()));				
				//frame.getContentPane().add(new PictureCreateClass("circle.png",planets[i][j].getX(), planets[i][j].getY()));
				frame.revalidate();
				frame.repaint();
			}
		}
		return planets;
	}

	public void makeSticks(){

		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				if ( (j+1) != amountRow){
					sticks.add(new Stick(planets[i][j], planets[i][j+1]));
				}
				if((i+1) != amountRow){
					sticks.add(new Stick(planets[i][j], planets[i+1][j]));
				}

				if((i==0 && j == 0) || (i==0 && j==amountRow-1) 
						|| (i==amountRow-1 && j == 0) || (i==amountRow-1 && j == amountRow-1)){
					sticks.add(new Stick(planets[i][j]));
					sticks.add(new Stick(planets[i][j]));

				}
				while(planets[i][j].nmbSticks()<4){
					sticks.add(new Stick(planets[i][j]));
				}
			}
		}
	}

	public void drawSticks(){
		Graphics g = frame.getGraphics();
		g.setColor(Color.BLUE);

		for(final Stick stick : sticks){
			Square A = stick.getA();
			Square B = stick.getB();
			if(A.getX() == B.getX() && A.getY() == B.getY()){ // Kollar sig själv
				for(Stick innerStick : A.getSticks()){
					if(innerStick.getX() != 0 && innerStick.getY() != 0){
						int localX = 0;
						int localY = 0;
						if(innerStick.getX() == A.getX()){
							localX = A.getX();
							if(A.getY() < innerStick.getY()){
								localY = A.getY() - (innerStick.getY() - A.getY()) ;
							}
							else if(A.getY() > innerStick.getY()){
								localY = A.getY() + (A.getY() - innerStick.getY());
							}
						}
						else if(innerStick.getY() == A.getY()){
							localY = A.getY();
							if(A.getX() < innerStick.getX()){
								localX = A.getX() - (innerStick.getX() - A.getX());
							}
							else if(A.getX() > innerStick.getX()){
								localX = A.getX() + (A.getX() - innerStick.getX());
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
			else if(A.getX() == B.getX()){
				stick.setX(A.getX());
				if(A.getY() < B.getY()){
					stick.setY((B.getY() - A.getY())/2 + A.getY());
				}
				else if(B.getY() < A.getY()){
					stick.setY((A.getY() - B.getY())/2 + B.getY());
				}
			}
			else if(A.getY() == B.getY()){
				stick.setY(A.getY());
				if(A.getX() < B.getX()){
					stick.setX((B.getX() - A.getX())/2 + A.getX());
				}
				else if(B.getX() < A.getX()){
					stick.setX((A.getX() - B.getX())/2 + B.getX());
				}
			}

			if(stick.getX() != 0){
				//frame.add(new PictureCreateClass("stick.png",stick.getX(), stick.getY()));
				//g.fillOval(stick.getX(), stick.getY(), 40, 40);
				if (A.getX() == stick.getX()){
					stick.saveCurrentImage(new PictureCreateClass("stickSideWays.png",stick.getX(),stick.getY()));
					imageP.add(stick.getPic());
				}
				else{
					stick.saveCurrentImage(new PictureCreateClass("stick.png",stick.getX(),stick.getY()));
					imageP.add(stick.getPic());			
				}

				frame.addMouseListener(new MouseAdapter(){
					//Hover stuff
					@Override
					public void mouseMoved(MouseEvent e){
						//87 145
						if((e.getX() >= stick.getX() && e.getX() <= (stick.getX() + stick.getXLength())) && 
								(e.getY() >= stick.getY() && e.getY() <= (stick.getY() + stick.getYLength()))){
							System.out.println("Stick: " + stick.getX() + ","+stick.getY());
						}

						//System.out.println("Entered " + e.getX() + " , " + e.getY() + " for stick: " + this.getX() + ", " + this.getY());
					}

					@Override
					public void mouseClicked(MouseEvent e){
						if((e.getX() >= stick.getX() && e.getX() <= (stick.getX() + stick.getXLength())) && 
								(e.getY() >= stick.getY() && e.getY() <= (stick.getY() + stick.getYLength()))){
							System.out.println("Stick placed!! " + stick.getX() + "," + stick.getY());
							stick.place();
							imageP.remove(stick.getPic());
							stick.saveCurrentImage(new PictureCreateClass("circleFixed.png",stick.getX(),stick.getY()));
							System.out.println(stick.isVisible());
							clicked = true;
							imageP.add(stick.getPic());
							frame.revalidate();
							frame.repaint();
							clicked = false;
						}
					}
				});//(MouseAdapter) stick);
				frame.revalidate();
				frame.repaint();
			}
		}
	}


	public ArrayList<Square> checkIfSurroundend(){
		ArrayList<Square> surroundedSquares = new ArrayList<Square>(); 
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				if(planets[i][j].surrounded()==true && taken.contains(planets[i][j]) == false){
					taken.add(planets[i][j]);
					surroundedSquares.add(planets[i][j]);
				}
			}
		}
		return surroundedSquares;

	}

	public boolean checkIfGameOver(){
		if( taken.size() == circles){
			return true;
		}
		return false;
	}

	public boolean clicked(){
		return clicked;
	}

	public void setComponent(){
		imageComponent = new PictureCreateClass("Universe.png",0,0); //"/home/pettea/git/Project-SaB/SAB-Project/"
	}

	public PictureCreateClass getComponent(){
		return imageComponent;
	}

	public void check(){
		System.out.println(imageComponent.getURL());
	}
}
