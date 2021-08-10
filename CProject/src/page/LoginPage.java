package page;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import db.CarDAO;
import db.CarDB;
import db.UserDAO;
import db.UserDB;
import exception.UserException;
import handler.CardHandler;
import handler.LoginHandler;


public class LoginPage extends JPanel {

	MainFrame mainF;
	CarClient carclient;
	CardHandler ch;
	JPanel p = new JPanel();

	JPanel pNorth = new JPanel();
	JPanel pCenter = new MyJPanel(10, 50, 5, 50);
	JPanel pSouth = new MyJPanel(30, 45, 5, 45);

public	JTextField tfId;
	public JPasswordField tfPwd;
	
	UserDB udb=new UserDB();
	UserDAO userdao=new UserDAO();
	CarDAO cardao=new CarDAO();
	UserException ue=new UserException();
	
public	JLabel lbTop, lbId, lbPwd, lbLogin, lbJoin;

	

	public LoginPage(MainFrame mainF, CarClient car, CardHandler ch) {
		this.mainF = mainF;
		this.carclient=car;
		this.ch=ch;
		setBackground(new Color(255, 255, 255));

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");
		add(pSouth, "South");

		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/�α��ηΰ�.png"), JLabel.CENTER);
		lbLogin = new JLabel("", new ImageIcon("src/images/�α��ι�ư.png"), JLabel.CENTER);
		lbJoin = new JLabel("", new ImageIcon("src/images/ȸ�����Թ�ư.png"), JLabel.CENTER);
		pSouth.add(this.lbLogin);
		pSouth.add(lbJoin);

		lbId = new JLabel("", new ImageIcon("src/images/���ξ��̵�.png"), JLabel.CENTER);
		lbPwd = new JLabel("", new ImageIcon("src/images/���κ�й�ȣ.png"), JLabel.CENTER);

		// TextField
		tfId = new JTextField();
		tfPwd = new JPasswordField();

		// Label + TextField
		pCenter.add(lbId);
		pCenter.add(tfId);
		pCenter.add(lbPwd);
		pCenter.add(tfPwd);

		// Panel �ɼ�
		pCenter.setLayout(new GridLayout(4, 1));
		pSouth.setLayout(new GridLayout(1, 2));
		pNorth.setBackground(new Color(162, 108, 254));
		pCenter.setBackground(Color.white);
		pSouth.setBackground(Color.white);

		// TextField �ɼ�
		tfId.setBorder(null);
		tfPwd.setBorder(null);
		tfId.setBackground(new Color(233, 233, 233));
		tfPwd.setBackground(new Color(233, 233, 233));
		tfId.setHorizontalAlignment(JTextField.CENTER);
		tfPwd.setHorizontalAlignment(JTextField.CENTER);
		tfId.setFont(new Font("sans-serif", Font.BOLD, 18));
		tfPwd.setFont(new Font("sans-serif", Font.BOLD, 18));

		pNorth.add(lbTop);
		
		LoginHandler handler=new LoginHandler(mainF);
		lbLogin.addMouseListener(handler);
		lbJoin.addMouseListener(handler);
		
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////[gui]////////////////

	public void LoginCheck() {
		/**�ؽ�Ʈ�ʵ� �Է°� -> String*/
		String id = tfId.getText();
		char[] ch = tfPwd.getPassword();
		String pwd = new String(ch);
	try {	
		UserDB udb=new UserDB(200,id,pwd);
		/**�α��ΰ���üũ*/
		if(id==null||pwd==null) {
			showMsg("������ �Է��ϼ���.");
			return;
		}
		mainF.mypageF.lbWelcome.setText(id);
		Response(udb);
	} catch (Exception e) {
		e.printStackTrace();
	}
	clearReg();
	}//LoginCheck()----------
	public void Response(UserDB udb2) {
		try {
			carclient.out.writeObject(udb2);
			carclient.out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**�޼��� ����*/
	private void showMsg(String string) {
		JOptionPane.showMessageDialog(mainF.pCenter, string);
	}//showMsg()----------
	
	/**����*/
	private void clearReg() {
		mainF.loginF.tfId.setText("");
		mainF.loginF.tfPwd.setText("");
		mainF.loginF.tfId.requestFocus();		
	}//clearReg()-----------
	
	
}