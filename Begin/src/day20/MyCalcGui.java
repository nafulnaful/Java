package day20;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MyCalcGui extends JFrame {//JFrame은 창닫기 가능하나 console에는 꺼진게 아니다

		JLabel lb1, lb2, lb3;
		JTextField tf1, tf2, tfResult;
		
		JButton btPlus, btMinus, btGop, btDiv, btReset;
	
		Container cp;
		JPanel pS, pC;
		JPanel pCW, pCC;
		
		public MyCalcGui() {
			super(":::MyCalcGui:::");
			//JFrame은 컴포넌트들을 직접 JFrame에 붙이는 것이 아니라
			//ContentPane을 얻어와서 컨텐트페인에 붙여야 한다.
			cp=this.getContentPane();//컨텐트 페인=> BorderLayout이 디폴트이다.
			
			pS=new MyJPanel();
			pC=new MyJPanel();
			cp.add(pS,"South");
			cp.add(pC,"Center");
			
			pS.setLayout(new GridLayout(1,0,10,10));//행은 1로 고정, 열은 가변적으로
			
			btPlus=new JButton("+");
			btMinus=new JButton("-");
			btGop=new JButton("x");
			btDiv=new JButton("/");
			btReset=new JButton("Reset");
			pS.add(btPlus);
			pS.add(btMinus);
			pS.add(btGop);
			pS.add(btDiv);
			pS.add(btReset);
			
			pC.setLayout(new BorderLayout());
			pCC=new MyJPanel(30,20,40,20);//기본이 10이다
			pCW=new MyJPanel(30,20,40,20);
			pC.add(pCW,"West");
			pC.add(pCC,"Center");
			
			pCW.setLayout(new GridLayout(3,1,20,20));
			pCC.setLayout(new GridLayout(3,1,20,20));
			
			lb1=new JLabel("Input 1: ");
			lb2=new JLabel("Input 2: ");
			lb3=new JLabel("Result : ");
			
			pCW.add(lb1);
			pCW.add(lb2);
			pCW.add(lb3);
			
			tf1=new JTextField();
			tf2=new JTextField();
			tfResult=new JTextField();
			
			pCC.add(tf1);
			pCC.add(tf2);
			pCC.add(tfResult);
			
			tfResult.setEditable(false);//편집 불가능하게
			tfResult.setBorder(new LineBorder(Color.magenta,3,true));
			
			//MyCalcGui.MyEventHandler handler=this.new MyEventHandler();
			MyEventHandler handler=new MyEventHandler();
			btPlus.addActionListener(handler);
			btMinus.addActionListener(handler);
			btGop.addActionListener(handler);
			btDiv.addActionListener(handler);
			btReset.addActionListener(handler);
			
			//메소드로 창닫기 지원해줌
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}//생성자------
		
		public void calculate(String cmd) {
			
				if(cmd.equals("Reset")) {
					tf1.setText("");
					tf2.setText("");
					tfResult.setText("");
					tf1.requestFocus();
					return;
				}
				
				//if(cmd.equals("+"))
				String str1=tf1.getText();
				String str2=tf2.getText();
				try {
				int num1=Integer.parseInt(str1);
				int num2=Integer.parseInt(str2);
				int res=0;
				switch(cmd) {
				case "+":
					res=num1+num2;
					break;
				case "-":
					res=num1-num2;
					break;
				case "x":
					res=num1*num2;
					break;
				case "/":
					res=num1/num2;
					break;
				case "Reset":
					tf1.setText("");
					tf2.setText("");
					tfResult.setText("");
					return;
				}//switch----------------
				tfResult.setText(String.valueOf(res));
				}catch(NumberFormatException ex) {
					tfResult.setText("정수를 입력해야 해요");
					tf1.setText("");
					tf2.setText("");
					tf1.requestFocus();
				}

		}
		//이너클래스로 이벤트 핸들러를 구성하자. => 이벤트 처리 코드를 이너클래스로 모을 수 있다.
		class MyEventHandler implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd=e.getActionCommand();
				setTitle(cmd+"버튼을 눌렀군요");
				calculate(cmd);
				}
		}///////////////
		
		
		class MyJPanel extends JPanel{
			int a,b,c,d;
			public MyJPanel() {
				a=10;b=10;c=10;d=10;
			}
			public MyJPanel(int a, int b, int c, int d) {
				this.a=a; this.b=b; this.c=c; this.d=d;
			}
			public Insets getInsets() {
				return new Insets(a,b,c,d);
			}
		}/////////////////////////////

		public static void main(String[] args) {
			MyCalcGui my=new MyCalcGui();
			my.setSize(600,400);
			my.setVisible(true);
		}


}
//이벤트 핸들러 구성방법
/*
1.이벤트소스를 가진 클래스가 이벤트 핸들러도 되는 방법
2. 이벤트 핸들러를 이너클래스로 구성하는 방법
3. 이벤트 핸들러를 Anonymous class로 구성하는 방법
4. 이벤트 핸들러를 별도의 외부클래스로 구성하는 방법
*/
