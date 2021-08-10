package page;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import db.UserDB;
import handler.MypageHandler;
import handler.UserHandler;

public class MyPage extends JPanel {

	MainFrame mainF;
	JPanel pNorth = new JPanel(new GridLayout(2, 0, 10, 10));
	JPanel pCenter = new JPanel(new GridLayout(4, 0, 10, 10));

	JLabel lbTop;
	public JLabel lbWelcome;
	public JLabel lbUserInfo;
	public JLabel lbCarInfo;
	public JLabel lbTalk;
	public JLabel lbLogout;

	UserHandler uh;
	
	public MyPage(MainFrame mainF, UserHandler uh) {
		this.uh = uh;
		this.mainF = mainF;
		setBackground(Color.white);

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");

		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/��ܹ�_����������.png"), JLabel.CENTER);
		lbWelcome = new JLabel("", new ImageIcon("src/images/ȯ��.png"), JLabel.CENTER);
		lbUserInfo = new JLabel("", new ImageIcon("src/images/ȸ����������.png"), JLabel.CENTER);
		lbCarInfo = new JLabel("", new ImageIcon("src/images/����������ȸ.png"), JLabel.CENTER);
		lbTalk = new JLabel("", new ImageIcon("src/images/����.png"), JLabel.CENTER);
		lbLogout = new JLabel("", new ImageIcon("src/images/�α׾ƿ�.png"), JLabel.CENTER);
		pNorth.add(lbTop);
		pNorth.add(lbWelcome);
		pCenter.add(lbUserInfo);
		pCenter.add(lbCarInfo);
		pCenter.add(lbTalk);
		pCenter.add(lbLogout);

		// Panel �ɼ�
		pNorth.setBackground(Color.white);
		pCenter.setBackground(Color.white);

		// ID �ɼ�
		lbWelcome.setHorizontalTextPosition(JLabel.LEFT);
		lbWelcome.setBackground(Color.white);
		lbWelcome.setOpaque(true);
		lbWelcome.setForeground(new Color(147, 67, 255));
		lbWelcome.setFont(new Font("sans-serif", Font.ITALIC, 16));
		
		MypageHandler handler=new MypageHandler(mainF);
		lbUserInfo.addMouseListener(handler);
		lbCarInfo.addMouseListener(handler);
		lbTalk.addMouseListener(handler);
		lbLogout.addMouseListener(handler);

	}// ������------
	
	public void logout() {
		JOptionPane.showMessageDialog(pCenter, "�α׾ƿ� �Ǿ����ϴ�.");
		System.exit(0);
	}// --------------------

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}

}
