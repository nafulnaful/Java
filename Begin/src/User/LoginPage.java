package User;
import java.awt.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.*;

public class LoginPage extends JPanel{
	ImageIcon bgIcon;
	JPanel p=new JPanel();
	
	JTextField tfId;
	JPasswordField tfPwd;
	JButton btLogin;
	MainMemberFrame mainF;
	
	public LoginPage(MainMemberFrame frame) {
		this.mainF=frame;
		setBackground(Color.white);
		bgIcon=new ImageIcon("images/main.png");
		add(p);
		p.setLayout(new GridLayout(0,1,10,10));
		tfId=new JTextField(20);
		tfPwd=new JPasswordField(20);
		btLogin=new JButton("�α���");
		
		p.add(tfId);
		p.add(tfPwd);
		p.add(btLogin);
		
		p.setOpaque(false);//�����ϰ�
		TitledBorder tb1=null, tb2=null;
		
		tfId.setBorder(tb1=new TitledBorder("User ID"));
		tfPwd.setBorder(tb2=new TitledBorder("Password"));
		
		tb1.setTitleColor(Color.white);
		tb2.setTitleColor(Color.white);
		
		btLogin.setBackground(Color.red);
		btLogin.setForeground(Color.white);
		tfId.setOpaque(false);
		tfPwd.setOpaque(false);
		//btLogin.setOpaque(false);
		
	}//������------------------------
	
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(mainF.pC, message);
	}//--------------------------------
	
	/**�α��� ó���� �ϴ� �޼ҵ�*/
	public void loginCheck() {
		//mainF.setTitle("loginCheck");
		//1. tfId�� �Է��� �� �ޱ�
		String uid=tfId.getText();
		
		//2. tfPwd�� �Է��� �� �ޱ�
		char[] ch=tfPwd.getPassword();
		String upw=new String(ch);
		
		//��ȿ�� ���� �ƴ� ��� üũ => ��ȿ�� üũ
		//String�� trim()�޼ҵ� : ���ڿ� �� ���� ������ ��������
		if(uid==null|| upw==null || uid.trim().equals("")||upw.trim().equals("")) {
			showMsg("���̵�, ��й�ȣ�� �Է��ؾ� �ؿ�!!");
			return;
		}
		uid=uid.trim();
		upw=upw.trim();
		
		showMsg(uid+"�� ȯ���մϴ�");
		mainF.setTitle(uid+"/"+upw+"�� �α��� ��....");
		
		//3. mainF�� userTable�� ������ ȸ���� ������ ������ 
		boolean isExist = mainF.userTable.containsKey(uid);
		//���̵� �����ϴ��� üũ
		if(!isExist) {
			showMsg("���� ID�Դϴ�. �ٽ� �Է��ϼ���");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}
		
		//���̵� �´� ��� => ��� üũ
		User tmpUser=mainF.userTable.get(uid);
		String tmpPwd=tmpUser.getPwd();
		if(!upw.equals(tmpPwd)) {
			showMsg("��й�ȣ�� ��ġ���� �ʾƿ�");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}
		
		showMsg(uid+"�� ȯ���մϴ�.");
		mainF.setTitle(uid+"�� �α��� ��");
		mainF.isLogin=true;
		mainF.lbLogin.setText("Logout");
	
		
		// ����ڰ� �Է��� ���̵�� ����� ��ġ�ϴ��� üũ����.
		/* 1) ���� ���̵� �Է��� ��� ==> "���� ID �Դϴ�"
		 * 2) ���̵�� ������ ����� ��ġ���� �ʴ� ��� ==> "��й�ȣ�� Ʋ����"
		 * 3) ���̵� �°� ����� �´� ��� ==> �α��� ó�� => "�α��� ����" Ÿ��Ʋ ����
		 */
		
	}//-----------------
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgIcon.getImage(),0,0,this.getWidth(), this.getHeight(), this);
		
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(80,20,20,20);
	}

}//////////////////////////////////
