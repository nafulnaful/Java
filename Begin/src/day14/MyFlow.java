package day14;
import java.awt.*;
import java.awt.event.*;
/*
 *   Component----------------------부품(Button, TextField, TextArea, Checkbox, List, Label, Choice ...)
 *       +------Container (플랫폼 역할을 한다. 부품을 담아주는 역할)
 *                +---Window (독립적)  ==>기본 레이아웃은 BorderLayout
 *                      +-----Frame
 *                      +-----Dialog ---FileDialog
 *                +---Panel (비독립적. 다른 컨테이너에 포함되어져 사용됨)
 *                   ==> 기본 레이아웃이 FlowLayout
 * */
//Frame: 디폴트 레이아웃은 BorderLayout(동,서,남,북, 중앙 지역으로 배치하는 방식)
//레이아웃 변경은 생성자 상단에서 setLayout() 메소드로 변경한다.
/*LayoutManager
 * -FlowLayout(물 흘러가듯이 배치한다)
 * -BorderLayout(동,서,남,북, 중앙 지역으로 배치하는 방식)
 * -GridLayout (행과 열의 형태로 배치)
 * -CardLayout(카드를 포개놓은 듯 배치하는 방법)
 * -GridBagLayout(GridLayout의 확장)
 * */
public class MyFlow extends Frame {
	Button b1,b2,b3,b4;
	public MyFlow() {
		super(":::MyFlow:::");
		//FlowLayout(int align)
		//FlowLayout(int align, int hgap, int vgap)
		FlowLayout fl=new FlowLayout(FlowLayout.RIGHT,30,50);//기본이 중앙정렬로 배치함
		setLayout(fl); 
		//버튼들이 오른쪽에 정렬되도록 배치해보기
		
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
	}//생성자---------------------

	public static void main(String[] args) {

		MyFlow my=new MyFlow();
		my.setSize(500,500);
		my.setVisible(true);

	}

}
