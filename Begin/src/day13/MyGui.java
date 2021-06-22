package day13;
/* GUI(Graphic User  Interface)==> awt,swing �׷��� ȯ�� ���α׷�
 * CLI(CommandLine Interface)==> �ܼ� ȯ�� ���α׷�
 * 
 * AWT(Abstract Window Toolkit)
 * */
/*
 *   Component----------------------��ǰ(Button, TextField, TextArea, Checkbox, List, Label ...)
 *       +------Container (�÷��� ������ �Ѵ�. ��ǰ�� ����ִ� ����)
 *                +---Window (������)  ==>�⺻ ���̾ƿ��� BorderLayout
 *                      +-----Frame
 *                      +-----Dialog ---FileDialog
 *                +---Panel (�񵶸���. �ٸ� �����̳ʿ� ���ԵǾ��� ����)
 *                   ==> �⺻ ���̾ƿ��� FlowLayout
 * */ 
//import java.awt.Frame;//Window�迭 �����̳�
//import java.awt.Button;
import java.awt.*;

public class MyGui extends Frame{//Container
	Button b1,b2,b3; //Component
	TextField tf1, tf2;
	Label lb1,lb2,lb3;
	TextArea ta1,ta2;
	
	//�⺻������ �����ϼ���
	public MyGui() {
		super(":::MyGui Program:::");//���� ���ڿ� �ö�
		setLayout(new FlowLayout());//���̾ƿ� ����
		
		b1=new Button();//������Ʈ���� �����̳ʿ� �����ؾ� �Ѵ�.
		b2=new Button("ȸ�� ����");
		b3=new Button("�� �� ��");
		this.add(b1);
		add(b2);		add(b3);
		b2.setBackground(Color.blue);//����
		b2.setForeground(Color.white);//���ڻ�
		b3.setBackground(Color.red);
		b3.setForeground(Color.yellow);
	
		//Frame�� ������ lightGray���� �ֱ�
		this.setBackground(Color.lightGray);
		
		//tf1, tf2====>TextFieldã�ƺ��� ��ü �����ؼ� �����ϱ�
		tf1=new TextField("���̹��� �˻��غ�~~",40);
		tf2=new TextField(20);
		add(tf1);
		add(tf2);
		tf1.setBackground(Color.darkGray);
		tf1.setForeground(Color.red);
		//Label(String text, int alignment)
		//static int CENTER
		
		//lb1 �̸� ���� �����
		//lb2 ���̵� ���� ��ũ��
		//lb3 ��й�ȣ ���� cyan
		
		lb1=new Label("�̸�: ");
		lb2=new Label("���̵�: ",Label.CENTER);//�߾�����
		lb3=new Label("��й�ȣ: ",Label.RIGHT);//������ ����
		
		add(lb1);
		add(lb2);
		add(lb3);
		
		lb1.setBackground(Color.yellow);
		lb2.setBackground(Color.pink);
		lb3.setBackground(Color.cyan);
		
		//TextArea(String text, int rows, int columns, int scrollbars)
		ta1=new TextArea(7,30);//����, ���� ��ũ�ѹٰ� ��� ���� 
		add(ta1);
		
		//ta2�� ������ũ�ѹٸ� �����ǵ��� �����ؼ� �����ϱ�
		ta2=new TextArea()
	}

	public static void main(String[] args) {
		MyGui my=new MyGui();
		//Window�迭�� ���� �ݵ�� setSize(width,height)
		//setVisible(true)�� �־�� �Ѵ�.
		my.setSize(500,500);
		my.setVisible(true);

	}

}
