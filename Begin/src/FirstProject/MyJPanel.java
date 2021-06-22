package FirstProject;

import java.awt.*;
import javax.swing.*;

public class MyJPanel extends JPanel {
	private int a, b, c, d;

	public MyJPanel() {
		a = 20;
		b = 20;
		c = 20;
		d = 20;
	}

	public MyJPanel(int x, int y, int z, int k) {
		a = x;
		b = y;
		c = z;
		d = k;
	}

	@Override
	public Insets getInsets() {
		return new Insets(a, b, c, d);
	}

}//////////////////////////////////
