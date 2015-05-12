package main;

import javax.swing.*;
import java.awt.*;

public class PlayerStatsScreen {

	private JFrame frame;
	private ImagePanel imageP;
	private JPanel panel;
	
	public PlayerStatsScreen(JFrame frame){
		this.frame = frame;
		frame.getContentPane().removeAll();
		imageP = new ImagePanel(new PictureCreateClass("Universe.png",0,0).getImage());
		frame.getContentPane().add(imageP);
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		frame.repaint();
		frame.revalidate();
	}
	
	public void setInfo(){
		JTextField name = new JTextField("Name");
		panel.add(name);
		
	}
	
}
