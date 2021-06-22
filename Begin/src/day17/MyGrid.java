package day17;
import java.awt.*;
import java.awt.event.*;

public class MyGrid extends Frame {
	//Frame: BorderLayout디폴트
	Button[] bt=new Button[5];
	Panel p;//FlowLayout디폴트(Container)
	Button b1;
	CheckBox c1, c2;
	public MyGrid(){
		super("::MyGrid::");
		setLayout(new GridLayout(2,3,10,10));//2행3열, 수평간격10 수직간격10
		setBackground(Color.yellow);
		//반복문 돌면서 배열 bt에 Button객체 생성해서 저장한 뒤에
		//해당 버튼을 add()하세요 "B1, B2, ... B5"
		for(int i=0;i<bt.length;i++) {
			Button btn=new Button("B"+(i+1));
			bt[i]=btn;
			//System.out.println(bt[i]);
			add(bt[i]);
		}
		
		p=new Panel();
		add(p);
		p.setBackground(Color.cyan);
		
		b1=new Button("Close");
		c1=new CheckBox("Red", true);
		c2=new CheckBox("Blue", false);
		
		//p1의 레이아웃을 3행 1열로 변경하세요.
		p.setLayout(new GridLayout(3,1));
		p.add(b1);
		p.add(c1);
		p.add(c2);
		
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
	}//생성자---------------

	//getInsets()를 재정의해서 40,20,20,20, 바깥 여백 주기
	@Override
	public Insets getInsets() {
		Insets in=new Insets(40,20,20,20);
		return in;
	}//------------------------
	
	
	public static void main(String[] args) {
		MyGrid my=new MyGrid();
		my.setSize(500,500);
		my.setVisible(true);

	}//main

}//////////////////////////////
