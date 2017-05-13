import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Connect4 extends JFrame {
	
	JPanel buttonPanel, gamePanel,scorePanel;
	static JLabel score1,score2;
	JLabel welcomeLabel;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem exit,reset;
	
	DiscSlot discSlot;
	static DropButton buttonArray[];
	
	GridBagConstraints c;
	static int alternator = 0;
	static int player1Score;
	static int player2Score;
	
	public Connect4() {
		//Setup
		super("Connect 4");
		setLayout(new BorderLayout());
		setSize(850,700);
		
		//Menu Construction
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		menu = new JMenu("File");
		menubar.add(menu);
		
		reset = new JMenuItem("Reset");
		menu.add(reset);
		exit = new JMenuItem("Exit");
		menu.add(exit);
		//Reset r = new Reset();
		//Exit e = new Exit();
		reset.addActionListener(new Reset());
		exit.addActionListener(new Exit());
		
		//Button Panel
		buttonPanel = new JPanel(new GridLayout(1,7));
		buttonPanel.setPreferredSize(new Dimension(getWidth(),110));
		buttonArray = new DropButton[7];
		
		for (int i = 0; i < 7; i ++) {
			
			buttonArray[i] = new DropButton(i,this);
			buttonPanel.add(buttonArray[i]);
		}//End For
		
		add(buttonPanel,BorderLayout.NORTH);
		
		//Game Panel
		discSlot = new DiscSlot();
		add(discSlot,BorderLayout.CENTER);
		
		//Score Panel
		scorePanel = new JPanel(new FlowLayout());
		score1 = new JLabel("Player 1: 0             ");
		score1.setFont(new Font("Arial",Font.BOLD,20));
		score2 = new JLabel("         Player 2: " + player2Score);
		score2.setFont(new Font("Arial",Font.BOLD,20));
		scorePanel.add(score1);
		scorePanel.add(score2);
		add(scorePanel,BorderLayout.SOUTH);
		
	}//End Constructor
	
	public static void main(String args[]) {
		Connect4 gui = new Connect4();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//End Main
	
	public static class Reset implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String empty = "";
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					DropButton.valueHolder[i][j] = empty;
					empty+= " ";
				}//InnerFor
			}//LogicFor
			
			for(int k = 0; k < 42; k++) {
				DiscSlot.slotArray[k].white();
			}//Repaint White
			
			for(int i = 0; i < 7; i++) {
				buttonArray[i].setEnabled(true);
				buttonArray[i].resetYLoc();
			}//Button Reset & Location Reset
			
		}//End ActionPerformed
	}//End Reset Class
	public static class Exit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}//End ActionPerformed
	}//End ExitClass
}//End Class