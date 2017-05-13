import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiscSlot extends JPanel {

	static Slots[] slotArray;
	
	public DiscSlot() {
		setBackground(new Color(115,251,255));
		setLayout(new GridLayout(6,7));
		
		slotArray = new Slots[42];
		int k = 0;
		String color = "";
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				slotArray[k] = new Slots(j,5-i,color);
				add(slotArray[k]);
				k++;
				color += " ";
			}
		}//End Button Instantiation
		
	}//End Constructor
	
}//End Class
