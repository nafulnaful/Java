package day18;

import java.awt.*;
import java.awt.event.*;//1)

public class MySearchGui extends Frame implements ActionListener{//2)

	Button[] bt=new Button[4];
	String str[]= {"Naver","Daum","Google","Yahoo"};
	
	Color origin;
	public MySearchGui() {
		super("::MySearchGui::");
		//���̾ƿ� ���� 2��2��
		setLayout(new GridLayout(2,2,10,10));
		
		//�ݺ��� ���鼭 bt�迭�� ��ư �����ؼ� ������ ����
		for(int i=0;i<bt.length;i++) {
			bt[i]=new Button(str[i]);
			add(bt[i]);
			bt[i].addActionListener(this);
		}
		//ù��° ��ư�� �������� ������.
		//origin=bt[0].getBackground();
		//System.out.println(origin);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}//������------

	@Override
	public void actionPerformed(ActionEvent e) {//3)
		Object obj=e.getSource();
		//String getActionCommand()
		String cmd = e.getActionCommand();//��ư�� �� ���ڿ��� ��ȯ
		setTitle(cmd+"��ư�� ��������~~");
		//��ư�� ===1)�������̰ų� 2)�������� �ƴѰ��
		
		//�̺�Ʈ�ҽ�(��ư)�� ������ ���� cr�� ����
		Color cr=((Button)obj).getBackground();
		//if(cr==origin) {
		if(cr.equals(origin)) {	
			//�������̶��
		if(obj==bt[0]) {
			bt[0].setBackground(Color.green);
		}else if(obj==bt[1]) {
			bt[1].setBackground(Color.orange);
		}else if(obj==bt[2]) {
			bt[2].setBackground(Color.magenta);
		}else if(obj==bt[3]) {
			bt[3].setBackground(Color.cyan);
		}
		}else {
			//�������� �ƴ϶��=> �̺�Ʈ�ҽ��� ������ ���������� ����
			((Button)obj).setBackground(origin);
			
		}
	}
	public Insets getInsets() {
		return new Insets(40,10,10,10);
	}	
	
	public static void main(String[] args) {
		MySearchGui my = new MySearchGui();
		my.setSize(500, 500);
		my.setVisible(true);
		my.origin = my.bt[0].getBackground();
		System.out.println(my.origin);
	}

}