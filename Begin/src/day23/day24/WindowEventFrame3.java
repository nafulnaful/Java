package day24;
/*(7)*/
import java.awt.*;
import java.awt.event.*;
/*WindowEventó���� �غ���
 * 1) �̺�Ʈ �ҽ�  : Frame
 * 2) �̺�Ʈ	     : windowEvent
 * 3) �̺�Ʈ �ڵ鷯 : windowListener(�������̽�) or windowAdapter(�߻�Ŭ����)
 * - ������ �̺�Ʈ ó���� Anonymous class�� �غ���.
 * Adapter���ٵ� Anonymous �� �����ϴ�*/
public class WindowEventFrame3 extends Frame {

	public WindowEventFrame3() {
		super("::WindowEventFrame3::");

		this.addWindowListener(new WindowAdapter() {//Anonymous
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});//�߻�Ŭ������ new�� �ȵǴ°�? �˾ƺ���
			

	}//������---------

	public static void main(String[] args) {
		WindowEventFrame3 my = new WindowEventFrame3();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}