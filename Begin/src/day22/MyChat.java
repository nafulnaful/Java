package day22;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyChat extends JFrame {

	JPanel p = new JPanel();
	JTextField tf;
	JButton bt;
	JList<String> lst;
	Vector<String> userV;
	JPanel pC;

	public MyChat() {
		super("::MyChat::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		p.setLayout(new BorderLayout());
		
		pC=new JPanel();
		tf=new JTextField(20);
		bt=new JButton("입장");
		
		userV=new Vector<>(5,3);//닉네임을 저장할 벡터
		lst=new JList<>(userV);
		//userV가 생성자 안에서 자동으로 DefaultListModel에 저장된다.
		
		JScrollPane sp=null;
		p.add(pC,"Center");
		p.add(new JScrollPane(lst),"East");
		
		//sp.setBorder(new TitledBorder("::채팅 참여자 목록::"));
		
		pC.add(tf);
		pC.add(bt);
		
		//모델에 변경이 일어난 것을 화면(VIEW)에서 알아채지 못하는 경우
		//==> 컴포넌트 메소드 중 updateUI()를 호출하면 갱신이 일어난
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------

	public static void main(String[] args) {
		MyChat my = new MyChat();
		my.setSize(600, 450);
		my.setVisible(true);
	}

}