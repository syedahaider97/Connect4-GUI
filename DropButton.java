import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class DropButton extends JButton{
	int xLoc;
	int yLoc = 0;
	JFrame frame;
	static String[][] valueHolder = new String[6][7];
	
	DropButton(int x, JFrame frame) {
		xLoc = x;
		String empty = "";
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				valueHolder[i][j] = empty;
				empty+= " ";
			}
		}
		this.frame = frame;
		setPreferredSize(new Dimension(frame.getWidth()/8,100));
		
		addActionListener(new event());
		
		String currentDirectory;
		File file = new File("");
		currentDirectory = file.getAbsolutePath();
		System.out.println(currentDirectory);
		ImageIcon image = new ImageIcon(currentDirectory + "\\arrow.png");
		setIcon(image);
	}//End Constructor
	
	public void resetYLoc() {
		yLoc = 0;
	}
	
	public class event implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton button;
			Slots slot = findSlot();
			
			if(Connect4.alternator == 0) {
				slot.red();
				Connect4.alternator = 1;
			}
			else if(Connect4.alternator == 1) {
				slot.yellow();
				Connect4.alternator = 0;
			}
			
			placer();
			yLoc++;
			checker();
			if(yLoc > 5) {
				button = (JButton) e.getSource();
				button.setEnabled(false);
			}
		}
		public Slots findSlot() {
			int i = 0;
				while(true) {
				if(DiscSlot.slotArray[i].getXLoc() == xLoc && DiscSlot.slotArray[i].getYLoc() == yLoc) {
					//System.out.println("Made it" + i);
					return DiscSlot.slotArray[i];
					}//End Search If
				else {
					i++;
				}//End While
			}
		}//End findSlot
		
		public void placer() {
			Slots slot = findSlot();
			valueHolder[yLoc][xLoc] = slot.getColor();	
		}//End Placer
		
		public void checker() {
				//Horizontal
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 4; j++) {
					if(valueHolder[i][j].equals(valueHolder[i][j+1]) && valueHolder[i][j].equals(valueHolder[i][j+2]) && valueHolder[i][j].equals(valueHolder[i][j+3]))
					{
						win();
					}
				}
			}
				//Vertical
			for(int h = 0; h < 3; h++) {
				for (int j = 0; j < 7; j++) {
					if(valueHolder[h][j].equals(valueHolder[h+1][j]) && valueHolder[h][j].equals(valueHolder[h+2][j]) && valueHolder[h][j].equals(valueHolder[h+3][j]))
					{
						win();
					}
				}
			}
				//Right Diagonal
			for(int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					if(valueHolder[i][j].equals(valueHolder[i+1][j+1]) && valueHolder[i][j].equals(valueHolder[i+2][j+2]) && valueHolder[i][j].equals(valueHolder[i+3][j+3]))
					{
						win();
					}
				}
			}
				//Left Diagonal
			for(int i = 0; i < 3; i++) {
				for(int j = 6; j != 2; j--) {
					if(valueHolder[i][j].equals(valueHolder[i+1][j-1]) && valueHolder[i][j].equals(valueHolder[i+2][j-2]) && valueHolder[i][j].equals(valueHolder[i+3][j-3]))
					{
						win();
					}
				}
			}
		}//End Checker
		
		public void win() {
			if(Connect4.alternator == 1) {
				Connect4.player1Score++;
				Connect4.score1.setText("Player 1: " + Connect4.player1Score + "             ");
			}
			else if(Connect4.alternator == 0) {
				Connect4.player2Score++;
				Connect4.score2.setText("         Player 2: " + Connect4.player2Score);
			}
			for(int i = 0; i < 7; i++) {
				Connect4.buttonArray[i].setEnabled(false);
			}
			
			Dialog dialog = new Dialog(frame);
			dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setSize(300,300); 
		}//End Win
		
	
	
	}//End Event
}//End Class









