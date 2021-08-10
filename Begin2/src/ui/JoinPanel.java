package ui;
import java.awt.*;  
import javax.swing.*;
import javax.swing.border.*;
import function.*;
import data.*;
public class JoinPanel extends JPanel {
	
	public JTextField tfName, tfUserid, tfTel;
	public JPasswordField tfPwd;
	public JButton btJoin, btReset;
	MainPanel main;
	
	public JoinPanel(MainPanel main) {
		this.main=main;
	
		setBackground(Color.white);
		setLayout(new GridLayout(0,1,20,20));
		tfName=new JTextField(20);
		tfUserid=new JTextField(20);
		tfTel=new JTextField(20);
		tfPwd=new JPasswordField(20);
		
		add(tfName);
		add(tfUserid);
		add(tfPwd);
		add(tfTel);
		tfBorder(tfName,"�̸�");
		tfBorder(tfUserid,"���̵�");
		tfBorder(tfPwd,"��й�ȣ");
		tfBorder(tfTel,"�޴���ȭ");
		
		JPanel p=new JPanel(new GridLayout(1,2,10,10));
		p.add(btJoin=new JButton("ȸ������"));
		p.add(btReset=new JButton("�ٽþ���"));
		add(p);
		btJoin.setBackground(Color.black);
		btReset.setBackground(Color.black);
		btJoin.setForeground(Color.white);
		btReset.setForeground(Color.white);
		p.setBackground(Color.white);
		
		
	}
	
	public void tfBorder(JTextField t, String str) {
		LineBorder lnb=new LineBorder(Color.black);//6.03���� ����
		t.setBorder(new TitledBorder(lnb,str));//6.03���� ����
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(40,20,40,20);
	}
	
}
