package page;

import java.awt.*;
import javax.swing.*;
import javax.xml.ws.Response;


import db.UserDAO;
import db.UserDB;
import exception.AuthenException;
import exception.UserException;
import handler.CardHandler;
import handler.JoinHandler;


public class JoinPage extends JPanel {
	
	MainFrame mainF;

	JPanel p = new JPanel(new BorderLayout());
	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel(new FlowLayout());
	JPanel pSouth = new JPanel(new GridLayout(2, 1));

	JPanel pNorth_W = new JPanel(new GridLayout(7, 1, 10, 10));
	JPanel pNorth_C = new JPanel(new GridLayout(7, 1, 10, 10));

	public JLabel lbTop, lbMust1, lbMust2, lbName, lbBirth, lbId, lbPwd, lbTel, lbEmail, lbDone;
	public JTextField tfName, tfBirth, tfId, tfTel, tfEmail;
	JPasswordField tfPwd;
	JCheckBox cbUse;
	
	boolean isLogin = false;
	private CardHandler ch;
	
	UserDB udb=new UserDB();
	UserDAO userdao=new UserDAO();
	UserException ue=new UserException();
	CarClient carclient;
	
	public JoinPage(MainFrame mainF, CardHandler ch,CarClient car) {
		this.mainF = mainF;
		this.ch = ch;
		this.carclient=car;
		setBackground(Color.white);
		setLayout(new BorderLayout());
		pCenter.setBackground(Color.white);

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");
		add(pSouth, "South");

		pNorth.add(pNorth_W);
		pNorth.add(pNorth_C);

		// CheckBox
		cbUse = new JCheckBox("�̿����� �����մϴ�.");
		pSouth.add(cbUse);

		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/��ܹ�_ȸ������.png"), JLabel.CENTER);
		lbMust1 = new JLabel("", new ImageIcon("src/images/�ʼ��Է�.png"), JLabel.CENTER);
		lbMust2 = new JLabel("", new ImageIcon("src/images/�ʼ��Է�2.png"), JLabel.CENTER);
		lbDone = new JLabel("", new ImageIcon("src/images/�Ϸ�1.png"), JLabel.CENTER);
		pNorth.add(lbTop);
		pSouth.add(lbDone);

		lbName = new JLabel("", new ImageIcon("src/images/�̸�.png"), JLabel.CENTER);
		lbBirth = new JLabel("", new ImageIcon("src/images/�������.png"), JLabel.CENTER);
		lbId = new JLabel("", new ImageIcon("src/images/���̵�.png"), JLabel.CENTER);
		lbPwd = new JLabel("", new ImageIcon("src/images/��й�ȣ.png"), JLabel.CENTER);
		lbTel = new JLabel("", new ImageIcon("src/images/�޴���ȭ.png"), JLabel.CENTER);
		lbEmail = new JLabel("", new ImageIcon("src/images/�̸���.png"), JLabel.CENTER);

		// TextField
		tfName = new JTextField(20);
		tfBirth = new JTextField(" YYYYMMDD", 20);
		tfId = new JTextField(" ���� �ҹ��ڿ� ���� ���� 4~12�ڸ�", 20);
		tfPwd = new JPasswordField(20);
		tfTel = new JTextField(" '-' �����ϰ� ���ڸ� �Է�", 20);
		tfEmail = new JTextField(" example@chacha.com", 20);

		// Label + TextField �׸��� ����
		pCenter.add(lbMust1);
		pCenter.add(lbMust2);
		pCenter.add(lbName);
		pCenter.add(tfName);
		pCenter.add(lbBirth);
		pCenter.add(tfBirth);
		pCenter.add(lbId);
		pCenter.add(tfId);
		pCenter.add(lbPwd);
		pCenter.add(tfPwd);
		pCenter.add(lbTel);
		pCenter.add(tfTel);
		pCenter.add(lbEmail);
		pCenter.add(tfEmail);

		// Panel �ɼ�
		pNorth.setBackground(new Color(162, 108, 254));
		pCenter.setBackground(Color.white);
		pSouth.setBackground(Color.white);

		pNorth_W.setLayout(new GridLayout(6, 1));
		pNorth_C.setLayout(new GridLayout(6, 1));

		// CheckBox �ɼ�
		cbUse.setHorizontalAlignment(JCheckBox.CENTER);
		cbUse.setBackground(Color.white);
		cbUse.setOpaque(true);

		// TextField �ɼ�
		tfName.setPreferredSize(new Dimension(80, 39));
		tfBirth.setPreferredSize(new Dimension(80, 39));
		tfId.setPreferredSize(new Dimension(80, 39));
		tfPwd.setPreferredSize(new Dimension(80, 39));
		tfTel.setPreferredSize(new Dimension(80, 39));
		tfEmail.setPreferredSize(new Dimension(80, 39));
		tfBirth.setForeground(Color.LIGHT_GRAY);
		tfId.setForeground(Color.LIGHT_GRAY);
		tfTel.setForeground(Color.LIGHT_GRAY);
		tfEmail.setForeground(Color.LIGHT_GRAY);
//////////////////////////////////////////////////////////////////////////////////////////////////////[GUI]//////////////
		

		/** JoinHandler �ڵ鷯 ���� */
		JoinHandler handler = new JoinHandler(this);
		lbDone.addMouseListener(handler);
		tfBirth.addMouseListener(handler);
		tfId.addMouseListener(handler);
		tfTel.addMouseListener(handler);
		tfEmail.addMouseListener(handler);

	}// ������-------------------------------------------------------------------------------------------------------
	
	/** �˸�â showMsg() */
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(pCenter, message);
	}// ----------------------------------

	/** INSERT */
	public void userInsert() throws AuthenException {
		/**�ؽ�Ʈ�ʵ� �Է°� -> String*/
		String name = tfName.getText();
		String birth = tfBirth.getText();
		String id = tfId.getText();
		char[] ch = tfPwd.getPassword();
		String pwd = new String(ch);
		String tel = tfTel.getText();
		String email = tfEmail.getText();
		try {
			
			UserDB udb=new UserDB(100,name,birth,id,pwd,tel,email);
			
			/**���̵� �ߺ�üũ*/
			/*if(!userdao.ExistUser(id)){
				showMsg(id+"��(��) �̹� ����� �Դϴ�.\n�ٸ� ���̵� �Է��ϼ���.");
				return;
			}*/
			
			/**���� �Ϸ� Ȯ��*/
			//boolean result = userdao.insertUser(udb);
				
			
			/**����üũ*/
			if (name.trim().isEmpty() || birth.trim().isEmpty() || id.trim().isEmpty() || pwd.trim().isEmpty()
					|| tel.trim().isEmpty() || email.trim().isEmpty()) {
				showMsg("��� ������ �Է��ϼ���.");
				return;
				
			} else if (blankCheck(name) == true || blankCheck(birth) == true || blankCheck(id) == true
						|| blankCheck(pwd) == true || blankCheck(tel) == true || blankCheck(email) == true) {
				System.out.println(blankCheck(name));
				showMsg("���⿡ �����ϼ���.");
				return;

			} else if (!cbUse.isSelected()) {
				showMsg("�̿����� �����ϼ���.");
				return;
			}
			Response(udb);
			clearReg();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//userInsert()----------------
	
	private void Response(UserDB udb) {
		try {
			carclient.out.writeObject(udb);
			carclient.out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/** �Է�â ���� */
	public void clearReg() {
		tfName.setText("");
		tfBirth.setText("");
		tfId.setText("");
		tfPwd.setText("");
		tfTel.setText("");
		tfEmail.setText("");
		tfName.requestFocus();
	}// --------------------
	
	/** ���� ã�� �޼ҵ� */
	public boolean blankCheck(String Code) {
	    for (int i = 0; i < Code.length(); i++) {
	       if (Code.charAt(i) == ' ') {
	          return true;
	       }
	    }
	    return false;

	}// -------------blankCheck-----------



}