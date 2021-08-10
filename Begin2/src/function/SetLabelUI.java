package function;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class SetLabelUI {
	public void setLabelUI(JLabel lb) {
		lb.setOpaque(true);
		lb.setBackground(Color.white);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.BOTTOM);
		lb.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}
}
