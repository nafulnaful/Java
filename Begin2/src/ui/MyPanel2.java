package ui;
import java.awt.*;
import javax.swing.*;

/**ȸ���������� ������*/

public class MyPanel2 extends JPanel{
	
	public JPanel pS, pC;
	public JPanel pC_W, pC_C;	
	public JLabel lbN, lbId, lbPwd, lbTel; //lbAddr //601d ����
	public JTextField tfN, tfId, tfTel; //tfAddr, //601d ����
	public JPasswordField tfPwd;
	public JButton btUpdate;//����
	public JButton btDel;//602
		

	public MyPanel2() {
		
		setLayout(new BorderLayout(20,50));
		setBackground(Color.white);
		
		
		pS = new JPanel();
		add(pS,"South");
		pS.setLayout(new GridLayout(1,0,10,10));
		pS.setBackground(Color.white);
		
		btUpdate = new JButton("�����Ϸ�");
		pS.add(btUpdate);
		btUpdate.setBackground(Color.black);
		btUpdate.setForeground(Color.white);
		
		btDel = new JButton("ȸ��Ż��");//602
		pS.add(btDel);//602
		btDel.setBackground(Color.black);//602
		btDel.setForeground(Color.white);//602
		

		///////
		
		pC = new JPanel();
		add(pC,"Center");
		pC.setLayout(new BorderLayout());
		pC.setBackground(Color.white);
		
		pC_W = new JPanel();
		pC_C = new JPanel();
		pC.add(pC_W,"West");
		pC.add(pC_C,"Center");	
		pC_W.setLayout(new GridLayout(5,1,13,13));//����
		pC_C.setLayout(new GridLayout(5,1,13,13));//����
		pC_C.setBackground(Color.white);
		pC_W.setBackground(Color.white);
		
		///////

		lbN = new JLabel("�̸� : ");
		lbId = new JLabel("ID : ");
		lbPwd = new JLabel("Password : ");
//		lbAddr = new JLabel("�ּ� : "); //601d ����
		lbTel = new JLabel("Tel : ");
		
		tfN = new JTextField(10);
		tfId = new JTextField(10);
//		tfAddr = new JTextField(10); //601d ����
		tfTel = new JTextField(10);
		tfPwd = new JPasswordField(10);

	
		pC_W.add(lbN);
		pC_W.add(lbId);
		pC_W.add(lbPwd);
//		pC_W.add(lbAddr); //601d ����
		pC_W.add(lbTel);

		pC_C.add(tfN);
		pC_C.add(tfId);
		pC_C.add(tfPwd);
//		pC_C.add(tfAddr); //601d ����
		pC_C.add(tfTel);
		//��, �Է¶� �Ϸ�	
		
		
		tfN.setEditable(false);
		tfId.setEditable(false);
		//�̸�, ID �����Ұ�
		
		
		
		
			
		
	}
	
	
	@Override
	public Insets getInsets() {
		return new Insets(100,20,80,20);
	}
}
