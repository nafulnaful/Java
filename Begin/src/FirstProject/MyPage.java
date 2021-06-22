package FirstProject;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyPage extends JPanel {

	MainFrame mainF;
	JPanel pNorth = new JPanel(new GridLayout(2, 0, 10, 10));
	JPanel pCenter = new JPanel(new GridLayout(4, 0, 10, 10));

	JLabel lbTop;
	JLabel lbWelcome, lbUserInfo, lbCarInfo, lbTalk, lbLogout;

	public MyPage(MainFrame mainF) {
		this.mainF = mainF;
		setBackground(Color.white);

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");

		// Label
		lbTop = new JLabel("", new ImageIcon("./pj_img/상단바_마이페이지.png"), JLabel.CENTER);
		lbWelcome = new JLabel("", new ImageIcon("./pj_img/환영.png"), JLabel.CENTER);
		lbUserInfo = new JLabel("", new ImageIcon("./pj_img/회원정보수정.png"), JLabel.CENTER);
		lbCarInfo = new JLabel("", new ImageIcon("./pj_img/구매차량조회.png"), JLabel.CENTER);
		lbTalk = new JLabel("", new ImageIcon("./pj_img/문의.png"), JLabel.CENTER);
		lbLogout = new JLabel("", new ImageIcon("./pj_img/로그아웃.png"), JLabel.CENTER);
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

		// 핸들러 부착
		MypageHandler handler = new MypageHandler(this);
		//lbUserInfo.addMouseListener(handler);
		lbCarInfo.addMouseListener(handler);
		//lbTalk.addMouseListener(handler);
		lbLogout.addMouseListener(handler);
		
		lbUserInfo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		super.mouseClicked(e);
	    		JoinEdit joinEditF=new JoinEdit();
	    		joinEditF.setSize(400,600);
	    		joinEditF.setVisible(true);
	    	}
		});
	    
	    lbTalk.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		System.out.println("동작중");
	    		ChatPage cp=new ChatPage();
	    		cp.setSize(450,450);
	    		cp.setVisible(true);
	    		
	    	}
		});
	    

	}// 생성자------

	public void logout() {
		JOptionPane.showMessageDialog(pCenter, "로그아웃 되었습니다.");
		mainF.isLogin = false;
		mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매.png"));
		mainF.lbSell.setIcon(new ImageIcon("./pj_img/하단바_내차팔기.png"));
		mainF.lbLike.setIcon(new ImageIcon("./pj_img/하단바_관심차량.png"));
		mainF.lbMypage.setIcon(new ImageIcon("./pj_img/하단바_마이페이지.png"));
		mainF.card.show(mainF.pCenter, "로그인");
		mainF.setTitle(":: Chachacha ::");
	}// --------------------

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}

}
