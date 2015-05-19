package main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PlayerStatsScreen {

	private JFrame frame;
	private JFrame tempFrame;
	private ImagePanel imageP;
	private JPanel outerPanel;
	private JPanel panel;
	private int amountPlayers;
	private Player[] players;
	private String[] URLs;
	private static final int AMOUNT_PLANETS = 4;
	private JTextField[] text; //final

	public PlayerStatsScreen(JFrame frame){
		this.frame = frame;

		String[] numberList = {"2","3","4"};
		frame.getContentPane().removeAll();
		//frame.setContentPane(new PictureCreateClass("Universe.png",0,0));
		outerPanel = new JPanel();		
		outerPanel.setLayout(new FlowLayout()); 
		frame.revalidate();
		frame.repaint();

		URLs = new String[AMOUNT_PLANETS];
		URLs[0] = ("planet1.png");
		URLs[1] = ("planet2.png");
		URLs[2] = ("planet3.png");
		URLs[3] = ("planet5.png");

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		final JComboBox dropdownList = new JComboBox(numberList);
		dropdownList.setSelectedIndex(0);
		//frame.getContentPane().add(dropdownList);
		JLabel amountOfPlayers = new JLabel("Give the amount of players: ");
		amountOfPlayers.setForeground(Color.WHITE);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(amountOfPlayers);
		panel.add(dropdownList);
		outerPanel.add(panel);
		frame.add(outerPanel);
		panel.setBackground(Color.BLACK);
		outerPanel.setBackground(Color.BLACK);
		frame.revalidate();
		frame.repaint();
		dropdownList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox cb = (JComboBox)e.getSource();
				amountPlayers = Integer.parseInt((String)cb.getSelectedItem());
				panel.remove(dropdownList);
				setUpPlayers();
			}	
		});
	}

	public void setUpPlayers(){
		players = new Player[amountPlayers];
		text = new JTextField[amountPlayers];
		for(int i = 0; i < amountPlayers; i++){
			JLabel name = new JLabel("Name: ");
			name.setForeground(Color.WHITE);
			text[i] = new JTextField("",10);
			panel.add(name);
			panel.add(text[i]);
		}
		JLabel space = new JLabel("             ");
		space.setForeground(Color.BLACK);
		panel.add(space);
		final JButton done = new JButton("Start Game");
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				startButton();
				panel.remove(done);
			}
		});
		panel.add(done,BorderLayout.SOUTH);
		frame.revalidate();
		frame.repaint();
	}

	public void startButton(){
		for(int i = 0; i < text.length; i++){
			text[i].setEditable(false);
		}
		int amount = getAmountPlayers();
		players = new Player[amount];
		for(int i = 0; i < amount; i++){
			players[i] = new Player();
			players[i].setName(text[i].getText());
			players[i].setURL(URLs[i % AMOUNT_PLANETS]);
		}
		String[] amountCircles = {"2","3"};
		
		JComboBox amountOfCirclesList = new JComboBox(amountCircles);
		amountOfCirclesList.setSelectedIndex(0);
			
		JLabel amountOfCircles = new JLabel("Give the amount of circles in each row");
		amountOfCircles.setForeground(Color.WHITE);
		panel.add(amountOfCircles);
		panel.add(amountOfCirclesList);
		frame.revalidate();
		frame.repaint();
		
		amountOfCirclesList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox cb = (JComboBox)e.getSource();
				int circleAmount = Integer.parseInt((String)cb.getSelectedItem());
				new Field(circleAmount, frame, players);
			}	
		});
	}

	public Player getPlayer(int i){
		return players[i];
	}

	public int getAmountPlayers(){
		return amountPlayers;
	}
	

	/*
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
	 */
	//URLs[3] = ("planet4.png");
}
