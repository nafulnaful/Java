//6/11[3]
package thread.day2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//JComboBox=> ItemEventlistener => 이벤트 처리하기
/*[1] combo에서 선택한 이미지를 보여주기
 * [2] Start버튼 누르면 이미지 파일이 T0.gif ~ T13.gif파일을 차례로
 * 로드한 뒤에 다시 그려주는 스레드를 구현한다. (단 Runnable을 상속받아 구현)
 * [3] Stop버튼 누르면 이미지 동작 스레드를 중지시키기*/

public class MyAnimation extends JFrame implements Runnable{

	JPanel p = new JPanel(new BorderLayout());

	JButton btStart, btStop;
	JComboBox<String> combo;//View
	DefaultComboBoxModel<String> cmodel;//Model=> 데이터를 갖는다.
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
		combo=new JComboBox<>(cmodel);//View와 Model을 결합
		pN.add(combo);
		
		pN.add(btStart=new JButton("Start"));
		pN.add(btStop=new JButton("Stop"));
		pN.setBackground(Color.white);
		imgP.setBackground(Color.white);
		
		tkit=Toolkit.getDefaultToolkit();
		img=tkit.getImage("images/a.png");
		//이미지를 메모리에 로드
		imgP.setImg(img);
		//리스너 부착----
		MyHandler handler = new MyHandler();
		combo.addItemListener(handler);
		//시작, 중지 버튼에 리스너 부착
		btStart.addActionListener(handler);
		btStop.addActionListener(handler);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	
	@Override
	public void run() {
		int i=0;
		while(!isStop) {
			/*if(i>13) {
				i=0;
			}*///밑에 i%=13;로 해도 됨
			i%=13;
			
			System.out.println("i="+i);
			//[4]이미지를 T0.gif ~ T13.gif로 차례대로 로드하고
			img=tkit.getImage("images/T"+i+".gif");
			//[5]imgP에 setter로 해당 이미지 설정하고 다시 그려주기
			imgP.setImg(img);
			imgP.repaint();
			i++;
			//[6]sleep걸어주기
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println("error: "+e);
				break;
			}
		}
	}
	
	//이벤트 핸들러 
	class MyHandler implements ItemListener, ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource();
			if(o==btStart) {
				if(o==btStart) {
				isStop=false;
				//[7]tr 생성해서 동작시키세요
				if(tr==null) {
				tr=new Thread(MyAnimation.this);//this를 쓰면 MyHandelr를 지정하는 것이고 아웃터클레스(MyAnimation)를 받기위해서는 MyAnimation.this를 사용
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
				//해당 이미지 파일을 로드
				img=tkit.getImage("images/"+file);
				//imgP에 설정
				imgP.setImg(img);
				imgP.repaint();//다시 안그려주면 전에 있던게 남아있음
			}
			
			
		}
	}

	public static void main(String[] args) {
		MyAnimation my = new MyAnimation();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}