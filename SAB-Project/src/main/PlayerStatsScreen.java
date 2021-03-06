package main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Initializes the players with names etc.
 * Starts the game field from here
 */
public class PlayerStatsScreen {

	private JFrame frame;
	private JPanel outerPanel;
	private JPanel panel;
	private int amountPlayers;
	private Player[] players;
	private JTextField[] text; 

	public PlayerStatsScreen(final JFrame frame){
		this.frame = frame;
		setUpDropdowns();
	}
	
	/**
	 * Setups a dropdown menu that you choose amount of players playing
	 */
	public void setUpDropdowns(){
		
		String[] numberList = {"2","3","4"};
		frame.getContentPane().removeAll();
		
		outerPanel = new JPanel();		
		outerPanel.setLayout(new FlowLayout()); 
		frame.revalidate();
		frame.repaint();
		
		//JComboBox = Dropwdown list
		final JComboBox<String> dropdownList = new JComboBox<>(numberList);
		dropdownList.setSelectedIndex(0);
		//frame.getContentPane().add(dropdownList);
		final JLabel amountOfPlayers = new JLabel("Give the amount of players: ");
		amountOfPlayers.setForeground(Color.WHITE);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JLabel instructions = new JLabel();
		PictureCreateClass instructionsP = new PictureCreateClass(URLs.INSTRUCTIONS,400,400);
		Image image =  instructionsP.getImage();
		ImageIcon icon = new ImageIcon(image);
		instructions.setIcon(icon);
		panel.add(amountOfPlayers);
		panel.add(dropdownList);
		JPanel uberOuterPanel = new JPanel();
		uberOuterPanel.setLayout(new FlowLayout());
		uberOuterPanel.setBackground(Color.BLACK);
		uberOuterPanel.add(instructions);
		uberOuterPanel.add(outerPanel);
		outerPanel.add(panel);
		frame.add(uberOuterPanel);
		panel.setBackground(Color.BLACK);
		outerPanel.setBackground(Color.BLACK);
		JButton returnButton = new JButton("Go to Menu");
		outerPanel.add(Box.createHorizontalStrut(100));
		outerPanel.add(returnButton);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Menu m = new Menu(frame);
				m.makeMenu();
			}
		});
		
		frame.revalidate();
		frame.repaint();
		dropdownList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				amountPlayers = Integer.parseInt((String)cb.getSelectedItem());
				panel.remove(dropdownList);
				amountOfPlayers.setText("Type the player names");
				setUpPlayers(amountOfPlayers);
			}	
		});
	}

	/**
	 * When amountOfPlayers is chosen, Name options are given.
	 */
	public void setUpPlayers(final JLabel amountOfPlayers){
		players = new Player[amountPlayers];
		text = new JTextField[amountPlayers];
		for(int i = 0; i < amountPlayers; i++){
			JLabel name = new JLabel("Name: ");
			name.setForeground(Color.WHITE);
			text[i] = new JTextField("",10);
			panel.add(name);
			panel.add(text[i]);
		}
		panel.add(Box.createVerticalStrut(100));
		final JButton done = new JButton("Start Game");
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				startButton();
				panel.remove(done);
				panel.remove(amountOfPlayers);
			}
		});
		panel.add(done,BorderLayout.SOUTH);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Sets up the players with their stats if startsbutton is clicked
	 * Gives a final options to choose size of the table
	 */
	public void startButton(){
		for(int i = 0; i < text.length; i++){
			text[i].setEditable(false);
		}
		int amount = getAmountPlayers();
		players = new Player[amount];
		for(int i = 0; i < amount; i++){
			players[i] = new Player();
			players[i].setName(text[i].getText());
			players[i].setURL(URLs.CIRCLES[i % URLs.AMOUNT_PLANETS]);
			players[i].setColor(URLs.COLORS[i % URLs.AMOUNT_PLANETS]);
		}
		String[] amountCircles = {"2","3"};

		JComboBox<String> amountOfCirclesList = new JComboBox<>(amountCircles);
		amountOfCirclesList.setSelectedIndex(0);

		JLabel amountOfCircles = new JLabel("Give the amount of circles in each row");
		amountOfCircles.setForeground(Color.WHITE);
		panel.add(amountOfCircles);
		panel.add(amountOfCirclesList);
		frame.revalidate();
		frame.repaint();

		amountOfCirclesList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
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
}
