	package day20;
	
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.border.*;
	/*������ư�� Ŭ���ϸ� ĵ���� ������ �ش� �������� ����ǵ��� ó���ϱ�
	 * itemListener�� ��ӹ޴� �ڵ鷯 Ŭ������ �̳� Ŭ������ �����ؼ� ó���ٺ���
	 * open��ư�� Ŭ���ϸ� ���ο� JFrame�� ����.
	 * ==>ActionListener����
	 * Ŭ������: SubFrame==> JFrame�� ��ӹ޾� ����==>JButton �Ѱ� ���̱�*/
	public class MyColorGui extends JFrame {
	
		JPanel p;
		Canvas can;//������Ʈ. ��ȭ�� ������ ����
		JRadioButton raR, raG, raB;
		ButtonGroup group;//������ư���� �׷������ִ� ������
		JButton btOpen;
		//subFrame sub=new subFrame();==>�̰� ���� �÷����Ѵ�
		public MyColorGui() {
			super("::MyColorGui::");
			Container cp=this.getContentPane();
			p=new JPanel();
			cp.add(p,"Center");
			p.setBackground(Color.white);
			
			can=new Canvas();
			p.add(can);
			//ĵ������ ������ ���������� Ȯ���ϱ� �����
			//ĵ������ ����� �����ؾ� �Ѵ�.
			can.setSize(200,200);//w,h
			can.setBackground(Color.cyan);
			
			raR=new JRadioButton("Red",true);
			raG=new JRadioButton("Green",false);
			raB=new JRadioButton("Blue",false);
			
			//������ư�� �׷������־�� ���� ���� �����ϴ�.
			group=new ButtonGroup();
			group.add(raR);
			group.add(raG);
			group.add(raB);
			
			p.add(raR);
			p.add(raG);
			p.add(raB);
			
			btOpen=new JButton("Open");
			p.add(btOpen);
			
			//������ ����
			MyHandler handler=new MyHandler();
			raR.addItemListener(handler);
			raG.addItemListener(handler);
			raB.addItemListener(handler);
			btOpen.addActionListener(handler);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		}//������------
	
		class MyHandler implements ItemListener,ActionListener
		{
				@Override
				public void itemStateChanged(ItemEvent e) {
					Object obj=e.getItem();//getSource()�� ���
					if(obj==raR) {
						can.setBackground(Color.red);
					}else if(obj==raG) {
						can.setBackground(Color.green);
					}else if(obj==raB) {
						can.setBackground(Color.blue);
					}
				}
		
				@Override
				public void actionPerformed(ActionEvent e) {
					Object obj=e.getSource();
					if(obj==btOpen) {
						SubFrame p1=new SubFrame();
						
						p1.setSize(200,200);//w,h
						p1.setLocation(535,0);//x,y
						p1.setVisible(true);
						}
					}
					
					
		}
		public static void main(String[] args) {
			MyColorGui my = new MyColorGui();
			my.setSize(550, 300);
			my.setVisible(true);
		}
	
	}