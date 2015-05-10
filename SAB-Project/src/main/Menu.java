package main;

import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu {

	private PictureCreateClass imageComponent;
	private Play play;
	private JButton[] buttonStorage;
<<<<<<< HEAD
	private JFrame frame;

	public Menu(JFrame frame){
		this.frame = frame;	
=======

	public Menu(){
>>>>>>> refs/remotes/origin/master
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

	public void setComponent(){
		imageComponent = new PictureCreateClass("/home/pettea/git/Project-SaB/SAB-Project/SticksAndBoxes.png");
	}

	public PictureCreateClass getComponent(){
		return imageComponent;
	}

	public void goPlay(){
		play = new Play(frame);
	}

	public Play getPlay(){
		return play;
	}

	public void exitGame(){
		System.exit(1);
	}
}
