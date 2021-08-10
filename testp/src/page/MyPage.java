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
		lbTop = new JLabel("", new ImageIcon("src/images/상단바_마이페이지.png"), JLabel.CENTER);
		lbWelcome = new JLabel("", new ImageIcon("src/images/환영.png"), JLabel.CENTER);
		lbUserInfo = new JLabel("", new ImageIcon("src/images/회원정보수정.png"), JLabel.CENTER);
		lbCarInfo = new JLabel("", new ImageIcon("src/images/관심차량조회.png"), JLabel.CENTER);
		lbTalk = new JLabel("", new ImageIcon("src/images/문의.png"), JLabel.CENTER);
		lbLogout = new JLabel("", new ImageIcon("src/images/로그아웃.png"), JLabel.CENTER);
		pNorth.add(lbTop);
		pNorth.add(lbWelcome);
		pCenter.add(lbUserInfo);
		pCenter.add(lbCarInfo);
		pCenter.add(lbTalk);
		pCenter.add(lbLogout);

		// Panel 옵션
		pNorth.setBackground(Color.white);
		pCenter.setBackground(Color.white);

		// ID 옵션
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

	}// 생성자------
	
	public void logout() {
		JOptionPane.showMessageDialog(pCenter, "로그아웃 되었습니다.");
		System.exit(0);
	}// --------------------

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}

}
