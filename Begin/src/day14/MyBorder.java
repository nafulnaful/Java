package day14;
import java.awt.*;
import java.awt.event.*;
// Frame�� default ���̾ƿ�=> BorderLayout
//��,��,��,��, �߾��� ������ �����ؼ� ������Ʈ�� �ٿ��� �Ѵ�.
//������ �������� �ʰ� ���̸� ����Ʈ�� �߾ӿ� �ٴ´�.
public class MyBorder extends Frame {
	
	Button b1,b2,b3,b4,b5;

	public MyBorder() {
		super("--------MyBorder-------");
		setLayout(new BorderLayout(10,20));//���򰣰�, ��������
		b1=new Button("B1");
		b2=new Button("B2");
		b3=new Button("B3");
		b4=new Button("B4");
		b5=new Button("B5");
		
		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.SOUTH);
		add(b3, BorderLayout.EAST);
		add(b4, "West");
		add(b5, "Center");
		
		setBackground(Color.darkGray);
		
		//â�ݱ� �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
	}//������================================
	/*�ٱ� ������ �ַ��� �����Ǹ� ����*/
	@Override
	public Insets getInsets() {
		Insets in=new Insets(40,20,30,40);//�ð� �ݴ� ������ ����
		return in;
	}
	public static void main(String[] args) {
		MyBorder my=new MyBorder();
		my.setSize(500,500);
		my.setVisible(true);

	}

}
