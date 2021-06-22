package day24;
/*(5)*/
import java.awt.*;
import java.awt.event.*;
/*WindowEventó���� �غ���
 * 1) �̺�Ʈ �ҽ�  : Frame
 * 2) �̺�Ʈ	     : windowEvent
 * 3) �̺�Ʈ �ڵ鷯 : windowListener(�������̽�) or windowAdapter(�߻�Ŭ����)
 * */
public class WindowEventFrame extends Frame implements WindowListener {

	public WindowEventFrame() {
		super("::WindowEventFrame::");

		//������ ����
		this.addWindowListener(this);

	}//������---------

	public static void main(String[] args) {
		WindowEventFrame my = new WindowEventFrame();
		my.setSize(500, 500);
		my.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);//�ý��� ����
	}
	@Override
	public void windowClosed(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowDeactivated(WindowEvent e) {		
	}

}////////////////////////////////