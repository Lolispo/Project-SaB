package main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerStatsScreen {

	private JFrame frame;
	private JFrame tempFrame;
	private ImagePanel imageP;
	private JPanel panel;
	private int amountPlayers;
	private Player[] players;
	
	public PlayerStatsScreen(JFrame frame){
		this.frame = frame;
		amountPlayers = Integer.parseInt(JOptionPane.showInputDialog("Give the amount of players"));
		
		tempFrame = new JFrame();
		tempFrame.setSize(150, 200);
		tempFrame.setTitle("Sticks and Boxes");
		tempFrame.setVisible(true);
		tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tempFrame.setResizable(false);
		
		tempFrame.setBackground(Color.BLACK);
		//tempFrame.getContentPane().removeAll();
		//imageP = new ImagePanel(new PictureCreateClass("Universe.png",0,0).getImage());
		//tempFrame.getContentPane().add(imageP);
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		tempFrame.add(panel);
		tempFrame.revalidate();
		tempFrame.repaint();
		setInfo();
	}
	
	public void setInfo(){
		final JTextField[] text = new JTextField[amountPlayers];
		for(int i = 0; i < amountPlayers; i++){
			JLabel name = new JLabel("Name: ");
			text[i] = new JTextField("               ");
			panel.add(name);
			panel.add(text[i]);
		}
		JButton done = new JButton("Done");
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int amount = getAmountPlayers();
				players = new Player[amount];
				for(int i = 0; i < amount; i++){
					players[i] = new Player();
					players[i].setName(text[i].getText());	
				}
				tempFrame.setVisible(false);
				new Play(frame, players);
			}
		});
		panel.add(done,BorderLayout.SOUTH);
		
		frame.revalidate();
		frame.repaint();
	}
	
	
	
	public Player getPlayer(int i){
		return players[i];
	}
	
	public int getAmountPlayers(){
		return amountPlayers;
	}
}
