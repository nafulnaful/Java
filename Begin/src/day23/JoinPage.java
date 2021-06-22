package day23;
import java.awt.*;

/*(5.2)MainMemberFrame�� ��*/
import javax.swing.*;
import javax.swing.border.*;

public class JoinPage extends JPanel{

	JTextField tfName, tfUserid, tfTel;
	JPasswordField tfPwd;
	JButton btJoin, btReset;
	
	public JoinPage() {
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
		
		
		tfBorder(tfName,"Name");//������ �ٿ��ִ� ����
		tfBorder(tfUserid,"Userid");
		tfBorder(tfPwd,"Password");
		tfBorder(tfTel,"Tel");
		
		JPanel p=new JPanel(new GridLayout(1,2,10,10));
		p.add(btJoin=new JButton("ȸ������"));
		p.add(btReset=new JButton("�ٽþ���"));
		add(p);//�ؿ� ��ư
		btJoin.setBackground(Color.white);
		btReset.setBackground(Color.white);
		p.setBackground(Color.white);
		
		
		
	}
	
	public void tfBorder(JTextField t, String str) {
		t.setBorder(new TitledBorder(str));//������ �ٿ��ִ� ����
	}
	
	
	@Override
	public Insets getInsets() {
		return new Insets(40,20,40,20);//��,��,��,��
	}
}
