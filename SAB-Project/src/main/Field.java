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
	
	public Field(int amountRow, JFrame frame){
		this.frame = frame;

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
		g.setColor(Color.RED);
		
		planets = new Square[amountRow][amountRow];
		for(int i = 0; i < amountRow; i++){
			for(int j = 0; j<amountRow; j++){
				planets[i][j] = new Square();
				planets[i][j].setCoordinates(i,j);
				g.fillOval(planets[i][j].getX(),planets[i][j].getY(), 60, 60);
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
		
		for(Stick stick : sticks){
			stick.getA().getX();
		}
		
		
		JComponent jc = new PictureCreateClass("");
		jc.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
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
	
	


	public void setComponent(){
		imageComponent = new PictureCreateClass("Universe.png"); //"/home/pettea/git/Project-SaB/SAB-Project/"
	}

	public PictureCreateClass getComponent(){
		return imageComponent;
	}

	public void check(){
		System.out.println(imageComponent.getURL());
	}
}
