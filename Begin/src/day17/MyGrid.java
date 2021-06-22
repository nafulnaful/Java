package day17;
import java.awt.*;
import java.awt.event.*;

public class MyGrid extends Frame {
	//Frame: BorderLayout����Ʈ
	Button[] bt=new Button[5];
	Panel p;//FlowLayout����Ʈ(Container)
	Button b1;
	CheckBox c1, c2;
	public MyGrid(){
		super("::MyGrid::");
		setLayout(new GridLayout(2,3,10,10));//2��3��, ���򰣰�10 ��������10
		setBackground(Color.yellow);
		//�ݺ��� ���鼭 �迭 bt�� Button��ü �����ؼ� ������ �ڿ�
		//�ش� ��ư�� add()�ϼ��� "B1, B2, ... B5"
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
		
		//p1�� ���̾ƿ��� 3�� 1���� �����ϼ���.
		p.setLayout(new GridLayout(3,1));
		p.add(b1);
		p.add(c1);
		p.add(c2);
		
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
	}//������---------------

	//getInsets()�� �������ؼ� 40,20,20,20, �ٱ� ���� �ֱ�
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
