package day13;
/* GUI(Graphic User  Interface)==> awt,swing 그래픽 환경 프로그램
 * CLI(CommandLine Interface)==> 콘솔 환경 프로그램
 * 
 * AWT(Abstract Window Toolkit)
 * */
/*
 *   Component----------------------부품(Button, TextField, TextArea, Checkbox, List, Label ...)
 *       +------Container (플랫폼 역할을 한다. 부품을 담아주는 역할)
 *                +---Window (독립적)  ==>기본 레이아웃은 BorderLayout
 *                      +-----Frame
 *                      +-----Dialog ---FileDialog
 *                +---Panel (비독립적. 다른 컨테이너에 포함되어져 사용됨)
 *                   ==> 기본 레이아웃이 FlowLayout
 * */ 
//import java.awt.Frame;//Window계열 컨테이너
//import java.awt.Button;
import java.awt.*;

public class MyGui extends Frame{//Container
	Button b1,b2,b3; //Component
	TextField tf1, tf2;
	Label lb1,lb2,lb3;
	TextArea ta1,ta2;
	
	//기본생성자 구성하세요
	public MyGui() {
		super(":::MyGui Program:::");//제목에 문자열 올라감
		setLayout(new FlowLayout());//레이아웃 설정
		
		b1=new Button();//컴포넌트들은 컨테이너에 부착해야 한다.
		b2=new Button("회원 가입");
		b3=new Button("로 그 인");
		this.add(b1);
		add(b2);		add(b3);
		b2.setBackground(Color.blue);//배경색
		b2.setForeground(Color.white);//글자색
		b3.setBackground(Color.red);
		b3.setForeground(Color.yellow);
	
		//Frame의 배경색을 lightGray으로 주기
		this.setBackground(Color.lightGray);
		
		//tf1, tf2====>TextField찾아보고 객체 생성해서 부착하기
		tf1=new TextField("네이버를 검색해봐~~",40);
		tf2=new TextField(20);
		add(tf1);
		add(tf2);
		tf1.setBackground(Color.darkGray);
		tf1.setForeground(Color.red);
		//Label(String text, int alignment)
		//static int CENTER
		
		//lb1 이름 배경색 노랑색
		//lb2 아이디 배경색 핑크색
		//lb3 비밀번호 배경색 cyan
		
		lb1=new Label("이름: ");
		lb2=new Label("아이디: ",Label.CENTER);//중앙정렬
		lb3=new Label("비밀번호: ",Label.RIGHT);//오른쪽 정렬
		
		add(lb1);
		add(lb2);
		add(lb3);
		
		lb1.setBackground(Color.yellow);
		lb2.setBackground(Color.pink);
		lb3.setBackground(Color.cyan);
		
		//TextArea(String text, int rows, int columns, int scrollbars)
		ta1=new TextArea(7,30);//수직, 수평 스크롤바가 모두 생김 
		add(ta1);
		
		//ta2는 수직스크롤바만 생성되도록 생성해서 부착하기
		ta2=new TextArea()
	}

	public static void main(String[] args) {
		MyGui my=new MyGui();
		//Window계열일 경우는 반드시 setSize(width,height)
		//setVisible(true)를 주어야 한다.
		my.setSize(500,500);
		my.setVisible(true);

	}

}
