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
		bt=new JButton("����");
		
		userV=new Vector<>(5,3);//�г����� ������ ����
		lst=new JList<>(userV);
		//userV�� ������ �ȿ��� �ڵ����� DefaultListModel�� ����ȴ�.
		
		JScrollPane sp=null;
		p.add(pC,"Center");
		p.add(new JScrollPane(lst),"East");
		
		//sp.setBorder(new TitledBorder("::ä�� ������ ���::"));
		
		pC.add(tf);
		pC.add(bt);
		
		//�𵨿� ������ �Ͼ ���� ȭ��(VIEW)���� �˾�ä�� ���ϴ� ���
		//==> ������Ʈ �޼ҵ� �� updateUI()�� ȣ���ϸ� ������ �Ͼ
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------

	public static void main(String[] args) {
		MyChat my = new MyChat();
		my.setSize(600, 450);
		my.setVisible(true);
	}

}