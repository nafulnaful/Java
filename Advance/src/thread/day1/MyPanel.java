//[4]movecircle�� �����ֱ����� ���� ��
package thread.day1;
import javax.swing.*;
import java.awt.*;
import java.util.*;//random ��������




public class MyPanel extends JPanel {
	int x=50, y=130, w=80, h=80;
	Color cr=Color.blue;

	public MyPanel() {
		//[1]rgb ���� �����ϰ� ���ؼ� ������ �������� ���� �׷�������.
		//Math.random() or RandomŬ���� Ȱ��
		//0 ~255
		Random ran=new Random();
		int r=ran.nextInt(256)+0;
		int g=ran.nextInt(256);
		int b=ran.nextInt(256);
		
		cr=new Color(r,g,b);
	}
	//paint()�޼ҵ�� �׸��� �׷��� �� ������ jvm�� �ڵ����� ȣ���Ѵ�.
	@Override//�׸��� �������̵�
	public void paint(Graphics g) {
		System.out.println("paint()ȣ���");
		super.paint(g);
		g.setColor(cr);
		g.fillOval(x,y,w,h);//�簢���� �׸��� drawRect(����)--x,y�� �κп� w,h�� �ﰢ��
		//fillRect�� ���� ä���� (�⺻�� ������)
		//fillOval�� ���� ���� ä����
	}
	
}


