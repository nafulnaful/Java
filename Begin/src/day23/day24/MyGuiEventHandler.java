package day24;
import java.awt.*;
import java.awt.event.*;
/*(9)
 * �̺�Ʈ �ڵ鷯�� �ܺ� Ŭ������ �����ϴ� ���
 * - ���� �����ڸ� �����Ѵ�.
 * 	 �Ű������� �̺�Ʈ �ҽ��� ������ �ִ� Ŭ���������� �޴´�.
 * - �Ű������� ��������� �����Ͽ�
 * 	 �̺�Ʈ ó���޼ҵ忡�� ��������� ���� �����ϵ��� ����
 * */
public class MyGuiEventHandler implements ActionListener {

	MyGui gui;//������� ����
	public MyGuiEventHandler(MyGui gui) {
		this.gui = gui;//class���� �� �� �� �ְ� ���� ��
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//MyGui�� ĵ������ ������ red�� �����غ���
		//MyGui my= new MyGui();
		//my.pack();
		//my.setVisible(true);
		//my.can.setBackground(Color.red);- �̷������� �ϸ� �ȵȴ�
		
		int r=(int)(Math.random()*256);
		int g=(int)(Math.random()*256);
		int b=(int)(Math.random()*256);
		
		gui.can.setBackground(new Color(r,g,b));
		//������ �������� �ٲ㺸��
		
		System.out.println("Aaa");
	}
}
