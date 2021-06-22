	package day20;
	
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.border.*;
	/*라디오버튼을 클릭하면 캔버스 색상이 해당 색상으로 변경되도록 처리하기
	 * itemListener를 상속받는 핸들러 클래스를 이너 클래스로 구성해서 처리핵보기
	 * open버튼을 클릭하면 새로운 JFrame을 띄운다.
	 * ==>ActionListener구현
	 * 클래스명: SubFrame==> JFrame을 상속받아 구현==>JButton 한개 붙이기*/
	public class MyColorGui extends JFrame {
	
		JPanel p;
		Canvas can;//컴포넌트. 도화지 역할을 수행
		JRadioButton raR, raG, raB;
		ButtonGroup group;//라디오버튼들을 그룹지어주는 객ㅊㅔ
		JButton btOpen;
		//subFrame sub=new subFrame();==>이걸 위로 올려야한다
		public MyColorGui() {
			super("::MyColorGui::");
			Container cp=this.getContentPane();
			p=new JPanel();
			cp.add(p,"Center");
			p.setBackground(Color.white);
			
			can=new Canvas();
			p.add(can);
			//캔버스는 배경색을 주지않으면 확인하기 어려움
			//캔버스는 사이즈를 지정해야 한다.
			can.setSize(200,200);//w,h
			can.setBackground(Color.cyan);
			
			raR=new JRadioButton("Red",true);
			raG=new JRadioButton("Green",false);
			raB=new JRadioButton("Blue",false);
			
			//라디오버튼을 그룹지어주어야 단일 선택 가능하다.
			group=new ButtonGroup();
			group.add(raR);
			group.add(raG);
			group.add(raB);
			
			p.add(raR);
			p.add(raG);
			p.add(raB);
			
			btOpen=new JButton("Open");
			p.add(btOpen);
			
			//리스너 부착
			MyHandler handler=new MyHandler();
			raR.addItemListener(handler);
			raG.addItemListener(handler);
			raB.addItemListener(handler);
			btOpen.addActionListener(handler);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		}//생성자------
	
		class MyHandler implements ItemListener,ActionListener
		{
				@Override
				public void itemStateChanged(ItemEvent e) {
					Object obj=e.getItem();//getSource()와 비슷
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