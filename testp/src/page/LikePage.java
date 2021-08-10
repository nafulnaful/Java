package page;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import handler.UserHandler;

import java.util.*;

public class LikePage extends JPanel {

	MainFrame mainF;
	JPanel pNorth = new JPanel(new GridLayout(1, 0, 10, 10));
	JPanel pCenter = new JPanel(new BorderLayout());
	JLabel lbUpdate;

	JLabel lbTop;
	UserHandler uh;
	
	public LikePage(MainFrame mainF, UserHandler uh) {
		this.mainF = mainF;
		this.uh = uh;
		setBackground(Color.white);

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");

		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/상단바_내차자랑.png"), JLabel.CENTER);
		pNorth.add(lbTop);

		// Panel 옵션
		pNorth.setBackground(Color.white);

	}

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}

}