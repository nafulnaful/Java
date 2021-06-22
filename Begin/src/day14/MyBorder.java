package day14;
import java.awt.*;
import java.awt.event.*;
// Frame의 default 레이아웃=> BorderLayout
//동,서,남,북, 중앙의 영역을 지정해서 컴포넌트를 붙여야 한다.
//영역을 지정하지 않고 붙이면 디폴트로 중앙에 붙는다.
public class MyBorder extends Frame {
	
	Button b1,b2,b3,b4,b5;

	public MyBorder() {
		super("--------MyBorder-------");
		setLayout(new BorderLayout(10,20));//수평간격, 수직간격
		b1=new Button("B1");
		b2=new Button("B2");
		b3=new Button("B3");
		b4=new Button("B4");
		b5=new Button("B5");
		
		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.SOUTH);
		add(b3, BorderLayout.EAST);
		add(b4, "West");
		add(b5, "Center");
		
		setBackground(Color.darkGray);
		
		//창닫기 이벤트 처리
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
	}//생성자================================
	/*바깥 여백을 주려면 재정의를 하자*/
	@Override
	public Insets getInsets() {
		Insets in=new Insets(40,20,30,40);//시계 반대 방향의 여백
		return in;
	}
	public static void main(String[] args) {
		MyBorder my=new MyBorder();
		my.setSize(500,500);
		my.setVisible(true);

	}

}
