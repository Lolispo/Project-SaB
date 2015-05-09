package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PictureCreateClass extends JComponent{
	private BufferedImage image;

	public PictureCreateClass() {
		
		System.out.println(System.getProperty("user.dir"));

		try {                
			image = ImageIO.read(new File("/home/pettea/git/Project-SaB/SAB-Project/test.jpg")); //C:\\abcfolder\\textfile.txt
		} catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(new JFrame(), "File not found");
			e.printStackTrace();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), "Error: " + e + "\nReading /home/Dropbox/test.jpg");
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

	public BufferedImage getImage(){
		return image;
	}

}
