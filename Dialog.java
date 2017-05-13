import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Dialog extends JDialog{
	JButton reset;
	JButton exit;
	JLabel prompt;
	Dialog(JFrame frame) {
		super(frame,"Result", true);
		setLayout(new FlowLayout());
		setSize(390,200);
		setLocationRelativeTo(frame);
		
		prompt = new JLabel();
		if(Connect4.alternator == 0) {
			prompt.setForeground(Color.YELLOW);
			prompt.setText("Congratulations! Yellow Wins!");
		}
		else if(Connect4.alternator == 1) {
			prompt.setForeground(Color.RED);
			prompt.setText("Congratulations! Red Wins!");
		}
		
		prompt.setFont(new Font("Arial", Font.BOLD, 24));
	
		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(200,50));
		Connect4.Reset r = new Connect4.Reset();
		ResetClose r2 = new ResetClose(this);
		reset.addActionListener(r);
		reset.addActionListener(r2);
		
		exit = new JButton("Exit");
		exit.setPreferredSize(new Dimension(200,50));
		Connect4.Exit e = new Connect4.Exit();
		exit.addActionListener(e);
		
		add(prompt);
		add(reset);
		add(exit);
		
	}//End Constructor

	public class ResetClose implements ActionListener {
		
		JDialog dialog;
		ResetClose(JDialog dialog)
		{
			this.dialog = dialog;
		}
		public void actionPerformed(ActionEvent arg0) {
			
			dialog.setVisible(false);
		}
	
	}//End ResetClose
}//End Class
