package day24;
import java.awt.*;
import java.awt.event.*;
/*(9)
 * 이벤트 핸들러를 외부 클래스로 구현하는 경우
 * - 인자 생성자를 구성한다.
 * 	 매개변수로 이벤트 소스를 가지고 있는 클래스유형을 받는다.
 * - 매개변수를 멤버변수에 전달하여
 * 	 이벤트 처리메소드에서 멤버변수를 통해 접근하도록 하자
 * */
public class MyGuiEventHandler implements ActionListener {

	MyGui gui;//멤버변수 선언
	public MyGuiEventHandler(MyGui gui) {
		this.gui = gui;//class에서 다 쓸 수 있게 만든 것
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//MyGui의 캔버스의 배경색을 red로 변경해보기
		//MyGui my= new MyGui();
		//my.pack();
		//my.setVisible(true);
		//my.can.setBackground(Color.red);- 이런식으로 하면 안된다
		
		int r=(int)(Math.random()*256);
		int g=(int)(Math.random()*256);
		int b=(int)(Math.random()*256);
		
		gui.can.setBackground(new Color(r,g,b));
		//랜던함 색상으로 바꿔보기
		
		System.out.println("Aaa");
	}
}
