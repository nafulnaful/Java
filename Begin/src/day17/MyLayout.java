package day17;

import java.awt.*;
import java.awt.event.*;

public class MyLayout extends Frame {
Panel p1,p2;

Button b1,b2,b3,b4;
Button b5,b6;

	public MyLayout() {
		super("::MyLayout::");
		//Frame의 레이아웃 설정
		this.setLayout(new BorderLayout(10,10));
		//p1, p2객체 생성해서 붙이기
		p1=new MyPanel();
		p2=new MyPanel();
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.pink);
		
		add(p1, BorderLayout.CENTER);
		add(p2, "South");
		//p1,p2의 레이아웃 설정
		p1.setLayout(new GridLayout(2,2,10,10));
		p2.setLayout(new GridLayout(2,1,10,10));
		//Button객체들 생성해서 각각 붙이기
		b1=new Button("B1");
		b2=new Button("B2");
		b3=new Button("B3");
		b4=new Button("B4");
		
		b5=new Button("B5");
		b6=new Button("B6");
		
		p1.add(b1); p1.add(b2);
		p1.add(b3); p1.add(b4);
		
		p2.add(b5); p2.add(b6);
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}//생성자---------
/*
	public Insets getInsets() {
		
		return new Insets(45,20,20,20);
	}
	*/
	public static void main(String[] args) {
		MyLayout my = new MyLayout();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}
