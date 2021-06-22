package day18;

import java.awt.*;
import java.awt.event.*;//1)

public class MySearchGui extends Frame implements ActionListener{//2)

	Button[] bt=new Button[4];
	String str[]= {"Naver","Daum","Google","Yahoo"};
	
	Color origin;
	public MySearchGui() {
		super("::MySearchGui::");
		//레이아웃 변경 2행2열
		setLayout(new GridLayout(2,2,10,10));
		
		//반복문 돌면서 bt배열에 버튼 생성해서 저장후 부착
		for(int i=0;i<bt.length;i++) {
			bt[i]=new Button(str[i]);
			add(bt[i]);
			bt[i].addActionListener(this);
		}
		//첫번째 버튼의 원래색을 얻어오자.
		//origin=bt[0].getBackground();
		//System.out.println(origin);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}//생성자------

	@Override
	public void actionPerformed(ActionEvent e) {//3)
		Object obj=e.getSource();
		//String getActionCommand()
		String cmd = e.getActionCommand();//버튼의 라벨 문자열을 반환
		setTitle(cmd+"버튼을 눌렀군요~~");
		//버튼이 ===1)원래색이거나 2)원래색이 아닌경우
		
		//이벤트소스(버튼)의 배경색을 얻어와 cr에 전달
		Color cr=((Button)obj).getBackground();
		//if(cr==origin) {
		if(cr.equals(origin)) {	
			//원래색이라면
		if(obj==bt[0]) {
			bt[0].setBackground(Color.green);
		}else if(obj==bt[1]) {
			bt[1].setBackground(Color.orange);
		}else if(obj==bt[2]) {
			bt[2].setBackground(Color.magenta);
		}else if(obj==bt[3]) {
			bt[3].setBackground(Color.cyan);
		}
		}else {
			//원래색이 아니라면=> 이벤트소스의 배경색을 원래색으로 변경
			((Button)obj).setBackground(origin);
			
		}
	}
	public Insets getInsets() {
		return new Insets(40,10,10,10);
	}	
	
	public static void main(String[] args) {
		MySearchGui my = new MySearchGui();
		my.setSize(500, 500);
		my.setVisible(true);
		my.origin = my.bt[0].getBackground();
		System.out.println(my.origin);
	}

}