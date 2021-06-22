package day24;
/*(6)*/
import java.awt.*;
import java.awt.event.*;
/*WindowEvent처리를 해보자
 * 1) 이벤트 소스  : Frame
 * 2) 이벤트	     : windowEvent
 * 3) 이벤트 핸들러 : windowListener(임터페이스) or windowAdapter(추상클래스)
 * - WindowAdapter클래스는 추상클래스로
 * 	 WindowListener 등의 인터페이스를 상속받아 추상메소드를 빈 모듈로 구현해놓고 있음
 * - ~~~Adapter클래스를 상속받으면 우리가 필요한 메소드만 재정의하면 되기 때문에 편리함
 * Adapter를 사용하여 코드를 간단하게 해준다*/
public class WindowEventFrame2 extends Frame {//자바는 단일 상속가능(extends WindowAdapter 추가 불가)

	public WindowEventFrame2() {
		super("::WindowEventFrame2::");

		this.addWindowListener(new MyHandler());

	}//생성자---------
	
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