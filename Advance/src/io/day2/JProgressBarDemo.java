//6/15[7]
package io.day2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JProgressBarDemo extends JFrame implements Runnable {

	JPanel p = new JPanel();
	
	JProgressBar bar;//게이지 차는 바
	JButton bt;

	public JProgressBarDemo() {
		super("::JProgressBarDemo::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		bar=new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		p.add(bar);//panl에 bar 붙이기
		bar.setStringPainted(true);//문자열을 보이겠다(몇%인지 보옂기 위해)
		bar.setValue(50);//값을 보여주고 싶을 때

		bt=new JButton("Copy");
		p.add(bt);
		/*
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("test");
			}
		});
		*/
		//위 코드를 lambda 식을 이용해 적용해보자.
		bt.addActionListener(e ->{
			//setTitle("lambda");
			//스레드를 생성해서 등족사키기
			Thread tr=new Thread(this);//안에 러너블 객체 넣어햐는데 여기서는 JProgressBarDemo extends JFrame implements Runnable이거니까 this
			tr.start();
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	
	public void run() {
		goProgress();
	}

	public void goProgress() {
		//0~100 까지 반복문 돌면서 bar의 값을 변경하고 sleep하기
		for(int i=0;i<=bar.getMaximum();i++) {
			bar.setValue(i);
			System.out.println(i);
			try {
			Thread.sleep(100);
			}catch(Exception e) {}
		}
			
		
		
	}
	public static void main(String[] args) {
		JProgressBarDemo my = new JProgressBarDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}


/*	bt.addActionListener(e ->{
			//setTitle("lambda");
			goProgress();
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------

	public void goProgress() {
		//0~100 까지 반복문 돌면서 bar의 값을 변경하고 sleep하기
		for(int i=0;i<=bar.getMaximum();i++) {
			bar.setValue(i);
			System.out.println(i);
			try {
			Thread.sleep(100);
			}catch(Exception e) {}
		}
이렇게 객채로 생성해서 하면 게이지가 차오르는 동작을 볼수 없다.
*/