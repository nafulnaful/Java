package FirstProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class LikePage extends JPanel {

	MainFrame mainF;
	JPanel pNorth = new JPanel(new GridLayout(1, 0, 10, 10));
	JPanel pCenter = new JPanel(new BorderLayout());
	JLabel lbUpdate;

	JLabel lbTop;

	public LikePage(MainFrame mainF) {
		this.mainF = mainF;
		setBackground(Color.white);

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");

		// Label
		lbTop = new JLabel("", new ImageIcon("./pj_img/��ܹ�_��������.png"), JLabel.CENTER);
		lbUpdate = new JLabel("", new ImageIcon("./pj_img/������Ʈ.png"), JLabel.CENTER);
		pNorth.add(lbTop);
		pCenter.add(lbUpdate);

		// Panel �ɼ�
		pNorth.setBackground(Color.white);

	}

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}

}