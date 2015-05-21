package main;

import java.awt.event.*;

public class StickMouseAdapter extends MouseAdapter{

	private Stick stick;
	private Field field;
	
	public StickMouseAdapter(Stick stick, Field field){
		this.stick = stick;
		this.field = field;
	}
		
	
	@Override
	public void mouseMoved(MouseEvent e){
		if((e.getX() >= stick.getX() && e.getX() <= (stick.getX() + stick.getXLength())) && 
				(e.getY() >= stick.getY() && e.getY() <= (stick.getY() + stick.getYLength()))){
			System.out.println("Stick: " + stick.getX() + ","+stick.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e){
		clickWasMade(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		clickWasMade(e);
	}
	
	/**
	 * Checks the mouse position when clicked and checks if it's
	 *  in the sticks area.
	 * If it is, checks if it can place the stick and if game is over
	 * @param e
	 */
	public void clickWasMade(MouseEvent e){
		int stickX = stick.getX();
		int stickY = stick.getY();
		if((e.getX() >= stickX && e.getX() <= (stickX + stick.getXLength())) && 
				(e.getY() >= stickY && e.getY() <= (stickY + stick.getYLength()))){
			stick.place();
			field.clickUpdate(stick);
			int pointsEarned =field.checkIfSurroundend().size();
			if(pointsEarned == 0){
				field.changePlayer();
			}
			else{
				field.addPoints(pointsEarned);
				if(field.checkIfGameOver()){
					field.repaintVictory();
				}
			}
		}
	}
}
