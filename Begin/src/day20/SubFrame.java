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
		//cp�� p1�����ؼ� ����
		p1=new JPanel();
		p1.setLayout(new GridLayout(0,1));//1���� ����, ���� ����������
		cp.add(p1,"Center");
		
		sr=new JSlider(0,255,50);//0�� 255���̿� 50�� ��������
		sr.setBorder(new LineBorder(Color.red, 2));
		p1.add(sr);
		//�ڲ� ���� ������ �޼ҵ�� ������
		showTicks(sr);
		
		sg=new JSlider(0,255,50);
		sg.setBorder(new LineBorder(Color.green, 2));
		p1.add(sg);
		showTicks(sg);
		
		sb=new JSlider(0,255,50);
		sb.setBorder(new LineBorder(Color.blue, 2));
		p1.add(sb);
		showTicks(sb);
		
		
		//p1�� bt�����ؼ� ����
		bt=new JButton("Close");
		p1.add(bt);
		//p1.add(bt=new JButton("Close"));
	}
	
	public void showTicks(JSlider s) {
		s.setMajorTickSpacing(50);//ū ���� ����
		s.setMinorTickSpacing(10);//���� ���� ����
		s.setPaintTicks(true);//������ �׸�����
		s.setPaintLabels(true);//��ġ ǥ���ϵ���
	}
	
}

