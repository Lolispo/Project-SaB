package main;

import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu {

	private PictureCreateClass imageComponent;
	private Play play;
	private JButton[] buttonStorage;
	private JFrame frame;

	public Menu(JFrame frame){
		this.frame = frame;	
		setComponent();
		buttonStorage = new JButton[3];
		makeButtons();
	}

	public void makeButtons(){
		JButton play = new JButton("Play");
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				goPlay();
			}
		});
		JButton options = new JButton("Options");
		options.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				options();
			}
		});
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				exitGame();
			}
		});

		buttonStorage[0] = play;
		buttonStorage[1] = options;
		buttonStorage[2] = exit;		
	}

	public JButton[] getButtons(){
		return buttonStorage;
	}

	public void setComponent(){ //SticksAndBoxes.png
		imageComponent = new PictureCreateClass("Sticks800.png",0,0); //"/home/pettea/git/Project-SaB/SAB-Project/"
	}

	public PictureCreateClass getComponent(){
		return imageComponent;
	}

	public void goPlay(){
		new PlayerStatsScreen(frame);
	}

	public void options(){
		frame.getContentPane().removeAll();
		frame.setContentPane(new PictureCreateClass("Universe.png",0,0));
		frame.revalidate();
		frame.repaint();		
	}

	public void exitGame(){
		System.exit(1);
	}
}
