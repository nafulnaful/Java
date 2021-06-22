package day24;
/*(7)*/
import java.awt.*;
import java.awt.event.*;
/*WindowEvent처리를 해보자
 * 1) 이벤트 소스  : Frame
 * 2) 이벤트	     : windowEvent
 * 3) 이벤트 핸들러 : windowListener(임터페이스) or windowAdapter(추상클래스)
 * - 윈도우 이벤트 처리를 Anonymous class로 해보자.
 * Adapter보다도 Anonymous 가 간편하다*/
public class WindowEventFrame3 extends Frame {

	public WindowEventFrame3() {
		super("::WindowEventFrame3::");

		this.addWindowListener(new WindowAdapter() {//Anonymous
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});//추상클래스는 new가 안되는가? 알아보기
			

	}//생성자---------

	public static void main(String[] args) {
		WindowEventFrame3 my = new WindowEventFrame3();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}