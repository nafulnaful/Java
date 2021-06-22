package day14;
import java.awt.*;
import java.awt.event.*;
/*
 *   Component----------------------��ǰ(Button, TextField, TextArea, Checkbox, List, Label, Choice ...)
 *       +------Container (�÷��� ������ �Ѵ�. ��ǰ�� ����ִ� ����)
 *                +---Window (������)  ==>�⺻ ���̾ƿ��� BorderLayout
 *                      +-----Frame
 *                      +-----Dialog ---FileDialog
 *                +---Panel (�񵶸���. �ٸ� �����̳ʿ� ���ԵǾ��� ����)
 *                   ==> �⺻ ���̾ƿ��� FlowLayout
 * */
//Frame: ����Ʈ ���̾ƿ��� BorderLayout(��,��,��,��, �߾� �������� ��ġ�ϴ� ���)
//���̾ƿ� ������ ������ ��ܿ��� setLayout() �޼ҵ�� �����Ѵ�.
/*LayoutManager
 * -FlowLayout(�� �귯������ ��ġ�Ѵ�)
 * -BorderLayout(��,��,��,��, �߾� �������� ��ġ�ϴ� ���)
 * -GridLayout (��� ���� ���·� ��ġ)
 * -CardLayout(ī�带 �������� �� ��ġ�ϴ� ���)
 * -GridBagLayout(GridLayout�� Ȯ��)
 * */
public class MyFlow extends Frame {
	Button b1,b2,b3,b4;
	public MyFlow() {
		super(":::MyFlow:::");
		//FlowLayout(int align)
		//FlowLayout(int align, int hgap, int vgap)
		FlowLayout fl=new FlowLayout(FlowLayout.RIGHT,30,50);//�⺻�� �߾����ķ� ��ġ��
		setLayout(fl); 
		//��ư���� �����ʿ� ���ĵǵ��� ��ġ�غ���
		
		b1=new Button("B1");
		b2=new Button("B2");
		b3=new Button("B3");
		b4=new Button("B4");
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
	}//������---------------------

	public static void main(String[] args) {

		MyFlow my=new MyFlow();
		my.setSize(500,500);
		my.setVisible(true);

	}

}
