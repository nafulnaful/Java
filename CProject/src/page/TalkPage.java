package page;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.util.*;

public class TalkPage extends JPanel {

	MainFrame mainF;
	JPanel pNorth = new JPanel(new GridLayout(1, 0, 10, 10));
	JPanel pCenter = new JPanel(new BorderLayout());
	JLabel lbUpdate;

	JLabel lbTop;
	
	public TalkPage(MainFrame mainF ) {
		this.mainF = mainF;
		setBackground(Color.white);

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");

		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/��ܹ�_�����ڶ�.png"), JLabel.CENTER);
		pNorth.add(lbTop);

		// Panel �ɼ�
		pNorth.setBackground(Color.white);

	}

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}

}