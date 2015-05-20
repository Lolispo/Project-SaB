package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class VictoryScreen {
	
	private JFrame frame;
	private ImagePanel imageP;
	private Player[] players;
	
	public VictoryScreen(JFrame frame, ImagePanel imageP, Player[] players){
		this.frame = frame;
		this.imageP = imageP;
		this.players = players;
		setUp();
	}
	
	public void setUp(){
		frame.getContentPane().remove(imageP);
		imageP = new ImagePanel(new PictureCreateClass(URLs.EXIT_SCREEN,0,0).getImage());
		frame.getContentPane().add(imageP, BorderLayout.CENTER);
		StringBuilder winningPlayerName = new StringBuilder();
		winningPlayerName.append(players[0].getName());
		int leadingScore = players[0].getPoints();
		for(int i = 1; i < players.length; i++){
			if(players[i].getPoints() == leadingScore){
				winningPlayerName.append(" and " + players[i].getName());
			}
			else if(players[i].getPoints() > leadingScore){
				winningPlayerName = new StringBuilder();
				winningPlayerName.append(players[i].getName());
				leadingScore = players[i].getPoints();
			}
		}
		JLabel winner = new JLabel("<html><font color='white'>Winner is <font color='yellow'>" + 
				winningPlayerName.toString() + "!</font></html>");
		winner.setForeground(Color.WHITE);
		winner.setFont(new Font("Serif", Font.BOLD, 30));
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.LINE_AXIS));
		tempPanel.add(Box.createHorizontalStrut(200));
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel,BoxLayout.PAGE_AXIS));
		innerPanel.setOpaque(false);
		innerPanel.add(winner);
				
		JButton Rematch = new JButton("Rematch");
		JButton Exit = new JButton("Exit");
		Dimension d = new Dimension(100,20);	
		Rematch.setSize(d);
		Rematch.setMinimumSize(d);
		Rematch.setMaximumSize(d);
		Rematch.setPreferredSize(d);
		Rematch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new PlayerStatsScreen(frame);
			}
		});
		Exit.setSize(d);
		Exit.setMinimumSize(d);
		Exit.setMaximumSize(d);
		Exit.setPreferredSize(d);
		Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
		
		innerPanel.add(Rematch);
		innerPanel.add(Box.createVerticalStrut(5));
		innerPanel.add(Exit);
		
		tempPanel.add(innerPanel);
		
		imageP.add(tempPanel);
		frame.revalidate();
		frame.repaint();

	}
}
