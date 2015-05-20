package main;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class Menu {

	private PictureCreateClass imageComponent;
	private JButton[] buttonStorage;
	private JFrame frame;

	public Menu(JFrame frame){
		this.frame = frame;
		frame.getContentPane().removeAll();
		setComponent();
		buttonStorage = new JButton[3];
		makeButtons();
	}

	public void makeMenu(){

		ImagePanel imageP = new ImagePanel(getComponent().getImage());
		frame.getContentPane().add(imageP);
		frame.validate();
		frame.repaint();


		JPanel outside = new JPanel();
		JPanel panelButtons = new JPanel();

		outside.setLayout(new BoxLayout(outside, BoxLayout.LINE_AXIS));
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.PAGE_AXIS)); //new GridLayout());
		outside.add(Box.createHorizontalStrut(300));
		outside.add(panelButtons);
		outside.add(Box.createHorizontalStrut(300));

		JButton[] buttons = getButtons();

		Dimension d = new Dimension(200,40);

		panelButtons.add(Box.createVerticalStrut(0));

		for(JButton button : buttons){
			button.setSize(d);
			button.setMinimumSize(d);
			button.setMaximumSize(d);
			button.setPreferredSize(d);
			panelButtons.add(button);
			panelButtons.add(Box.createVerticalStrut(5));
		}

		panelButtons.setBackground(Color.BLACK);
		imageP.add(outside);
		frame.revalidate();
		frame.repaint();
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

		play.setPreferredSize(new Dimension(400,200));
		options.setPreferredSize(new Dimension(200,200));
		exit.setPreferredSize(new Dimension(200,200));
		buttonStorage[0] = play;
		buttonStorage[1] = options;
		buttonStorage[2] = exit;		
	}

	public JButton[] getButtons(){
		return buttonStorage;
	}

	public void setComponent(){ //SticksAndBoxes.png
		imageComponent = new PictureCreateClass(URLs.MENU,0,0); //"/home/pettea/git/Project-SaB/SAB-Project/"
	}

	public PictureCreateClass getComponent(){
		return imageComponent;
	}

	public void goPlay(){
		new PlayerStatsScreen(frame);
	}

	public void options(){
		frame.getContentPane().removeAll();
		//frame.setContentPane(new PictureCreateClass(URLs.BACKGROUND,0,0));
		JPanel outerPanel = new JPanel();		
		outerPanel.setLayout(new FlowLayout()); 
				
		String[] Themes = {"Space", "Original"};
		JComboBox<String> themeList = new JComboBox<>(Themes);
		themeList.setSelectedIndex(URLs.currentTheme);
		JLabel theme = new JLabel("Choose what theme you want on the game: ");
		theme.setForeground(Color.WHITE);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(theme);
		panel.add(themeList);
		outerPanel.add(panel);
		frame.add(outerPanel);
		
		panel.setBackground(Color.BLACK);
		outerPanel.setBackground(Color.BLACK);
		
		themeList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				@SuppressWarnings("unchecked") // I dono
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				String themeChosen = (String)cb.getSelectedItem();
				URLs.changeTheme(themeChosen);
			}	
		});
		JButton returnButton = new JButton("Back");
		panel.add(Box.createVerticalStrut(100));
		panel.add(returnButton);
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Menu m = new Menu(frame);
				m.makeMenu();
			}
		});
		frame.revalidate();
		frame.repaint();
		
	}

	public void exitGame(){
		System.exit(1);
	}
}
