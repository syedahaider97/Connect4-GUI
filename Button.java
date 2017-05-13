import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button extends JButton {
	int column,alternator;
	int row = 0;
	public Button(int column, int alternator)
	{
		this.column = column;
		this.alternator = alternator;
		event e = new event();
		this.addActionListener(e);
	}
	public class event implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			if(alternator == 0)
			{
				repaint();
				alternator = 1;
			}
			else if(alternator == 1)
			{
				repaint();
				alternator = 0;
			}
			row++;
		}
		
	}//End ActionListener
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(alternator == 0)
		{
			g.setColor(Color.RED);	
		}
	}
}
