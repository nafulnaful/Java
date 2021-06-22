package day20;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MyCalcGui extends JFrame {//JFrame�� â�ݱ� �����ϳ� console���� ������ �ƴϴ�

		JLabel lb1, lb2, lb3;
		JTextField tf1, tf2, tfResult;
		
		JButton btPlus, btMinus, btGop, btDiv, btReset;
	
		Container cp;
		JPanel pS, pC;
		JPanel pCW, pCC;
		
		public MyCalcGui() {
			super(":::MyCalcGui:::");
			//JFrame�� ������Ʈ���� ���� JFrame�� ���̴� ���� �ƴ϶�
			//ContentPane�� ���ͼ� ����Ʈ���ο� �ٿ��� �Ѵ�.
			cp=this.getContentPane();//����Ʈ ����=> BorderLayout�� ����Ʈ�̴�.
			
			pS=new MyJPanel();
			pC=new MyJPanel();
			cp.add(pS,"South");
			cp.add(pC,"Center");
			
			pS.setLayout(new GridLayout(1,0,10,10));//���� 1�� ����, ���� ����������
			
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
			pCC=new MyJPanel(30,20,40,20);//�⺻�� 10�̴�
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
			
			tfResult.setEditable(false);//���� �Ұ����ϰ�
			tfResult.setBorder(new LineBorder(Color.magenta,3,true));
			
			//MyCalcGui.MyEventHandler handler=this.new MyEventHandler();
			MyEventHandler handler=new MyEventHandler();
			btPlus.addActionListener(handler);
			btMinus.addActionListener(handler);
			btGop.addActionListener(handler);
			btDiv.addActionListener(handler);
			btReset.addActionListener(handler);
			
			//�޼ҵ�� â�ݱ� ��������
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}//������------
		
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
					tfResult.setText("������ �Է��ؾ� �ؿ�");
					tf1.setText("");
					tf2.setText("");
					tf1.requestFocus();
				}

		}
		//�̳�Ŭ������ �̺�Ʈ �ڵ鷯�� ��������. => �̺�Ʈ ó�� �ڵ带 �̳�Ŭ������ ���� �� �ִ�.
		class MyEventHandler implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd=e.getActionCommand();
				setTitle(cmd+"��ư�� ��������");
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
//�̺�Ʈ �ڵ鷯 �������
/*
1.�̺�Ʈ�ҽ��� ���� Ŭ������ �̺�Ʈ �ڵ鷯�� �Ǵ� ���
2. �̺�Ʈ �ڵ鷯�� �̳�Ŭ������ �����ϴ� ���
3. �̺�Ʈ �ڵ鷯�� Anonymous class�� �����ϴ� ���
4. �̺�Ʈ �ڵ鷯�� ������ �ܺ�Ŭ������ �����ϴ� ���
*/
