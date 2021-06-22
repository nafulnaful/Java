//6/11[3]
package thread.day2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//JComboBox=> ItemEventlistener => �̺�Ʈ ó���ϱ�
/*[1] combo���� ������ �̹����� �����ֱ�
 * [2] Start��ư ������ �̹��� ������ T0.gif ~ T13.gif������ ���ʷ�
 * �ε��� �ڿ� �ٽ� �׷��ִ� �����带 �����Ѵ�. (�� Runnable�� ��ӹ޾� ����)
 * [3] Stop��ư ������ �̹��� ���� �����带 ������Ű��*/

public class MyAnimation extends JFrame implements Runnable{

	JPanel p = new JPanel(new BorderLayout());

	JButton btStart, btStop;
	JComboBox<String> combo;//View
	DefaultComboBoxModel<String> cmodel;//Model=> �����͸� ���´�.
	String[] data=new String[14];//=> Data
	
	MyImagePanel imgP;
	JPanel pN=new JPanel();
	
	Thread tr;
	boolean isStop=false;
	
	Toolkit tkit;
	Image img;
	
	public MyAnimation() {
		super("::MyAnimation::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		p.add(pN,"North");
		imgP=new MyImagePanel();
		p.add(imgP,"Center");
		
		for(int i=0;i<data.length;i++) {
			data[i]="T"+i+".gif";
		}
		cmodel=new DefaultComboBoxModel<>(data);
		combo=new JComboBox<>(cmodel);//View�� Model�� ����
		pN.add(combo);
		
		pN.add(btStart=new JButton("Start"));
		pN.add(btStop=new JButton("Stop"));
		pN.setBackground(Color.white);
		imgP.setBackground(Color.white);
		
		tkit=Toolkit.getDefaultToolkit();
		img=tkit.getImage("images/a.png");
		//�̹����� �޸𸮿� �ε�
		imgP.setImg(img);
		//������ ����----
		MyHandler handler = new MyHandler();
		combo.addItemListener(handler);
		//����, ���� ��ư�� ������ ����
		btStart.addActionListener(handler);
		btStop.addActionListener(handler);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------
	
	@Override
	public void run() {
		int i=0;
		while(!isStop) {
			/*if(i>13) {
				i=0;
			}*///�ؿ� i%=13;�� �ص� ��
			i%=13;
			
			System.out.println("i="+i);
			//[4]�̹����� T0.gif ~ T13.gif�� ���ʴ�� �ε��ϰ�
			img=tkit.getImage("images/T"+i+".gif");
			//[5]imgP�� setter�� �ش� �̹��� �����ϰ� �ٽ� �׷��ֱ�
			imgP.setImg(img);
			imgP.repaint();
			i++;
			//[6]sleep�ɾ��ֱ�
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println("error: "+e);
				break;
			}
		}
	}
	
	//�̺�Ʈ �ڵ鷯 
	class MyHandler implements ItemListener, ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource();
			if(o==btStart) {
				if(o==btStart) {
				isStop=false;
				//[7]tr �����ؼ� ���۽�Ű����
				if(tr==null) {
				tr=new Thread(MyAnimation.this);//this�� ���� MyHandelr�� �����ϴ� ���̰� �ƿ���Ŭ����(MyAnimation)�� �ޱ����ؼ��� MyAnimation.this�� ���
				if(!tr.isAlive())
				tr.start();
				}
			}else if(o==btStop) {
				isStop=true;
				if(tr!=null) {
					tr.interrupt();
					tr=null;
				}
			}	
			setTitle("isStop="+isStop);
			}
		}//----------------------------------
		
		public void itemStateChanged(ItemEvent e) {
			/* setTitle("ddd"); */
			Object obj=combo.getSelectedItem();
			String file=obj.toString();
			int n=e.getStateChange();
			//System.out.println("file="+file+", n="+n);	
			if(n==ItemEvent.SELECTED) {
				//�ش� �̹��� ������ �ε�
				img=tkit.getImage("images/"+file);
				//imgP�� ����
				imgP.setImg(img);
				imgP.repaint();//�ٽ� �ȱ׷��ָ� ���� �ִ��� ��������
			}
			
			
		}
	}

	public static void main(String[] args) {
		MyAnimation my = new MyAnimation();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}