package day20;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
public class SubFrame extends JFrame {
	JButton bt;
	JPanel p1;
	JSlider sr, sg, sb;
	
	public SubFrame() {
		super(":::SubFrame:::");
		Container cp=getContentPane();
		//cp에 p1생성해서 부착
		p1=new JPanel();
		p1.setLayout(new GridLayout(0,1));//1열로 고정, 행은 가변적으로
		cp.add(p1,"Center");
		
		sr=new JSlider(0,255,50);//0과 255사이에 50엣 놓여있음
		sr.setBorder(new LineBorder(Color.red, 2));
		p1.add(sr);
		//자꾸 쓸거 같은건 메소드로 만들어라
		showTicks(sr);
		
		sg=new JSlider(0,255,50);
		sg.setBorder(new LineBorder(Color.green, 2));
		p1.add(sg);
		showTicks(sg);
		
		sb=new JSlider(0,255,50);
		sb.setBorder(new LineBorder(Color.blue, 2));
		p1.add(sb);
		showTicks(sb);
		
		
		//p1에 bt생성해서 부착
		bt=new JButton("Close");
		p1.add(bt);
		//p1.add(bt=new JButton("Close"));
	}
	
	public void showTicks(JSlider s) {
		s.setMajorTickSpacing(50);//큰 눈금 간격
		s.setMinorTickSpacing(10);//작은 눈금 간격
		s.setPaintTicks(true);//눈금을 그리도록
		s.setPaintLabels(true);//수치 표시하도록
	}
	
}

