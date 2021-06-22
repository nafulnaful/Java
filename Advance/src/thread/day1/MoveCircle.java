//[3]
package thread.day1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//��ư�� ���� �׼� �̺�Ʈ ó���ϱ� => Anonymous class�� �ϱ�
//������ Ŭ���� �����=> inner class�� �����
//������ ����=> MyPanel�� x �Ǵ� y��ǥ�� �ݺ��ؼ� ������Ű��
//���� ��ư ������ ������ ���� ��Ű��


public class MoveCircle extends JFrame {
	
	JPanel p = new JPanel(new BorderLayout());
	JPanel pN=new JPanel();
	MyPanel pC=new MyPanel();
	JButton btStart, btStop;
	MyThread tr=null;
	boolean isStop=false;
	
	
	public MoveCircle() {
		super("::MoveCircle::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		p.add(pN,"North");
		p.add(pC,"Center");
		
		pN.setBackground(Color.cyan);
		btStart=new JButton(" Start ");
		btStop=new JButton(" Stop ");
		
		pN.add(btStart);
		pN.add(btStop);
		//��ư�� �׼� �̺�Ʈ ó��(anonymous class)��
		btStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//setTitle("start"); ó���� �� �Ǵ��� Ȯ���ϱ� ���� ���� ��
				//������ �����ؼ� ���۽�Ű��
				//MyThread tr=new MyThread();���������� �������� ���������� ���� ���� Ȯ��
				isStop=false;
				if(tr==null) {
				tr=new MyThread();
				tr.start();
				}
			}
		});
		
		btStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//setTitle("stop");
				//������ ������Ű��
				isStop=true;
				if(tr!=null) {
					tr.interrupt();
					tr=null;
				}
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------
	int i=5;
	class MyThread extends Thread{
		
		@Override
		public void run() {
			//pC�� x��ǥ�� �ݺ� ���鼭 ������Ű��
			while(!isStop) {//ƨ�ܳ��� ���� i�� ��ȯ�ؼ� ��
					if(pC.x>400) {
						i=-5;
						}
					if(pC.x<0)
					{
						i=5;
					}
					pC.x+=i;
					System.out.println("pC.x="+pC.x);//�̰� ȣ��Ǵ��� ������ �־
					pC.repaint();//repaint()�� ȣ���ϸ� jvm�� �ڵ����� paint()ȣ����
					try {
						Thread.sleep(100);//0.1�ʰ� ����(���ϸ� Ȯ���ϱ� ����)
					}catch(InterruptedException e) {
						System.out.println("error: "+e.getMessage());
					//e.printStackTrace();--��ž��ư�� �Դ°� Ȯ���ϱ� ����
					break;//break�� �ɾ���� stop����
					//interrup()�� ȣ���ϸ� ���ܰ� �߻���
					//catch������ break�ϸ� while������ ����鼭 run()
					//������ ��ġ�� �ȴ�.
					}
				}//while----------------
		}//run()------------------
	}//////////////////
	
	
	public static void main(String[] args) {
		MoveCircle my = new MoveCircle();
		my.setSize(500, 500);
		my.setVisible(true);
	}
}
	