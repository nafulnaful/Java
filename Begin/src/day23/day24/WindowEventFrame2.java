package day24;
/*(6)*/
import java.awt.*;
import java.awt.event.*;
/*WindowEventó���� �غ���
 * 1) �̺�Ʈ �ҽ�  : Frame
 * 2) �̺�Ʈ	     : windowEvent
 * 3) �̺�Ʈ �ڵ鷯 : windowListener(�������̽�) or windowAdapter(�߻�Ŭ����)
 * - WindowAdapterŬ������ �߻�Ŭ������
 * 	 WindowListener ���� �������̽��� ��ӹ޾� �߻�޼ҵ带 �� ���� �����س��� ����
 * - ~~~AdapterŬ������ ��ӹ����� �츮�� �ʿ��� �޼ҵ常 �������ϸ� �Ǳ� ������ ����
 * Adapter�� ����Ͽ� �ڵ带 �����ϰ� ���ش�*/
public class WindowEventFrame2 extends Frame {//�ڹٴ� ���� ��Ӱ���(extends WindowAdapter �߰� �Ұ�)

	public WindowEventFrame2() {
		super("::WindowEventFrame2::");

		this.addWindowListener(new MyHandler());

	}//������---------
	
	class MyHandler extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}////////////////////

	public static void main(String[] args) {
		WindowEventFrame2 my = new WindowEventFrame2();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}