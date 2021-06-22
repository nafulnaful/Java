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
		lbTop = new JLabel("", new ImageIcon("./pj_img/��ܹ�_����������.png"), JLabel.CENTER);
		lbWelcome = new JLabel("", new ImageIcon("./pj_img/ȯ��.png"), JLabel.CENTER);
		lbUserInfo = new JLabel("", new ImageIcon("./pj_img/ȸ����������.png"), JLabel.CENTER);
		lbCarInfo = new JLabel("", new ImageIcon("./pj_img/����������ȸ.png"), JLabel.CENTER);
		lbTalk = new JLabel("", new ImageIcon("./pj_img/����.png"), JLabel.CENTER);
		lbLogout = new JLabel("", new ImageIcon("./pj_img/�α׾ƿ�.png"), JLabel.CENTER);
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

		// �ڵ鷯 ����
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
	    		System.out.println("������");
	    		ChatPage cp=new ChatPage();
	    		cp.setSize(450,450);
	    		cp.setVisible(true);
	    		
	    	}
		});
	    

	}// ������------

	public void logout() {
		JOptionPane.showMessageDialog(pCenter, "�α׾ƿ� �Ǿ����ϴ�.");
		mainF.isLogin = false;
		mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
		mainF.lbSell.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�����ȱ�.png"));
		mainF.lbLike.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
		mainF.lbMypage.setIcon(new ImageIcon("./pj_img/�ϴܹ�_����������.png"));
		mainF.card.show(mainF.pCenter, "�α���");
		mainF.setTitle(":: Chachacha ::");
	}// --------------------

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}

}
