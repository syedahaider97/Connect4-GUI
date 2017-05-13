import java.awt.*;
import javax.swing.*;

public class Slots extends JButton {
	
	int xLoc;
	int yLoc;
	boolean white = true;
	boolean red = false;
	boolean yellow = false;
	String color;
	Slots(int x, int y, String empty)
	{
		xLoc = x;
		yLoc = y;
		setBackground(Color.BLUE);
		setEnabled(false);
		color = empty;
	}//End Constructor
	
	public int getXLoc() {
		return xLoc;
	}
	public int getYLoc() {
		return yLoc;
	}
	
	public void yellow() {
		yellow = true;
		red = false;
		white = false;
		repaint();
	}
	
	public void red() {
		red = true;
		yellow = false;
		white = false;
		repaint();
	}
	public void white() {
		red = false;
		yellow = false;
		white = true;
		repaint();		
	}
	public String getColor() {
		if(red) {
			color = "Red";
		}
		else if(yellow) {
			color = "Yellow";
		}
		return color;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(white) {
			g.setColor(Color.WHITE);
			g.fillOval(1, 1, getWidth()-2, getHeight()-2);
		}
		else if(red) {
			g.setColor(Color.RED);
			g.fillOval(1, 1, getWidth()-2, getHeight()-2);
		}
		else if(yellow) {
			g.setColor(Color.YELLOW);
			g.fillOval(1, 1, getWidth()-2, getHeight()-2);
		}
	}//End PaintComponent
}//End Class