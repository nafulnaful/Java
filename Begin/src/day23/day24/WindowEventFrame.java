package day24;
/*(5)*/
import java.awt.*;
import java.awt.event.*;
/*WindowEvent처리를 해보자
 * 1) 이벤트 소스  : Frame
 * 2) 이벤트	     : windowEvent
 * 3) 이벤트 핸들러 : windowListener(임터페이스) or windowAdapter(추상클래스)
 * */
public class WindowEventFrame extends Frame implements WindowListener {

	public WindowEventFrame() {
		super("::WindowEventFrame::");

		//리스너 부착
		this.addWindowListener(this);

	}//생성자---------

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
		System.exit(0);//시스템 종료
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