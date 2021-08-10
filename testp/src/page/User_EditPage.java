package page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.UserDAO;
import db.UserDB;
import exception.AuthenException;
import exception.UserException;
import handler.EditHandler;
import handler.UserHandler;

public class User_EditPage extends JPanel {
	
	MainFrame mainF;

	JPanel p = new JPanel(new BorderLayout());
	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel(new FlowLayout());
	JPanel pSouth = new JPanel(new FlowLayout());

	JPanel pNorth_W = new JPanel(new GridLayout(7, 1, 10, 10));
	JPanel pNorth_C = new JPanel(new GridLayout(7, 1, 10, 10));

	public JLabel lbTop, lbMust1, lbMust2, lbName, lbBirth, 
			lbId, lbPwd, lbTel, lbEmail, lbDone, lbDel;
	public JTextField tfName, tfBirth, tfId, tfTel, tfEmail;
	JPasswordField tfPwd;
	
	boolean isLogin = false;
	private UserHandler uh;
	
	UserDB udb=new UserDB();
	UserDAO userdao=new UserDAO();
	UserException ue=new UserException();

	public User_EditPage(MainFrame mainF, UserHandler uh) {
		this.uh = uh;
		this.mainF = mainF;
		setBackground(Color.white);
		setLayout(new BorderLayout());
		pCenter.setBackground(Color.white);

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");
		add(pSouth, "South");

		pNorth.add(pNorth_W);
		pNorth.add(pNorth_C);

		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/��ܹ�_ȸ����������.png"), JLabel.CENTER);
		lbMust1 = new JLabel("", new ImageIcon("src/images/�ʼ��Է�.png"), JLabel.CENTER);
		lbMust2 = new JLabel("", new ImageIcon("src/images/�ʼ��Է�.png"), JLabel.CENTER);
		lbDone = new JLabel("", new ImageIcon("src/images/�Ϸ�1.png"), JLabel.CENTER);
		lbDel = new JLabel("", new ImageIcon("src/images/ȸ��Ż��.png"), JLabel.CENTER);
		pNorth.add(lbTop);
		pSouth.add(lbDone);
		pSouth.add(lbDel);

		lbName = new JLabel("", new ImageIcon("src/images/����_�̸�.png"), JLabel.CENTER);
		lbBirth = new JLabel("", new ImageIcon("src/images/����_�������.png"), JLabel.CENTER);
		lbId = new JLabel("", new ImageIcon("src/images/����_���̵�.png"), JLabel.CENTER);
		lbPwd = new JLabel("", new ImageIcon("src/images/����_��й�ȣ.png"), JLabel.CENTER);
		lbTel = new JLabel("", new ImageIcon("src/images/����_�޴���ȭ.png"), JLabel.CENTER);
		lbEmail = new JLabel("", new ImageIcon("src/images/����_�̸���.png"), JLabel.CENTER);

		// TextField
		tfName = new JTextField(20);
		tfBirth = new JTextField(" YYYYMMDD", 20);
		tfId = new JTextField(20);
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

		// TextField �ɼ�
		tfName.setPreferredSize(new Dimension(80, 39));
		tfBirth.setPreferredSize(new Dimension(80, 39));
		tfId.setPreferredSize(new Dimension(80, 39));
		tfPwd.setPreferredSize(new Dimension(80, 39));
		tfTel.setPreferredSize(new Dimension(80, 39));
		tfEmail.setPreferredSize(new Dimension(80, 39));
		tfBirth.setForeground(Color.LIGHT_GRAY);
		tfTel.setForeground(Color.LIGHT_GRAY);
		tfEmail.setForeground(Color.LIGHT_GRAY);
//////////////////////////////////////////////////////////////////////////////////////////////////////[GUI]//////////////
		
		/** JoinHandler �ڵ鷯 ���� */
		EditHandler handler=new EditHandler(mainF);
		tfTel.addMouseListener(handler);
		tfEmail.addMouseListener(handler);
		lbDone.addMouseListener(handler);
		lbDel.addMouseListener(handler);

	}// ������-------------------------------------------------------------------------------------------------------
	
	/** �˸�â showMsg() */
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(pCenter, message);
	}// ----------------------------------
	
	/** UPDATE */
	public void userUpdate() throws AuthenException {

		/**�ؽ�Ʈ�ʵ� �Է°� -> String*/
		String name = tfName.getText();
		String birth = tfBirth.getText();
		String id = tfId.getText();
		char[] ch = tfPwd.getPassword();
		String pwd = new String(ch);
		String tel = tfTel.getText();
		String email = tfEmail.getText();
		try {
			
			/*�̸� ����*/
			udb.setUserName(name);
			/*������� ����*/
			udb.setUserBirth(birth);
			/*���̵� ����*/
			udb.setUserId(id); //���̵� �ҷ��ͼ� ����
			/*�н����� ����*/
			udb.setUserPwd(pwd);
			/*�޴���ȭ ����*/
			udb.setUserTel(tel);
			/*�̸��� ����*/
			udb.setUserEmail(email);
			
			/**���� �Ϸ� Ȯ��*/
			int result = userdao.updateUser(udb);
			System.out.println(result);			
			
			/**����üũ*/
			if (pwd.trim().isEmpty() || tel.trim().isEmpty() || email.trim().isEmpty()) {
				showMsg("��� ������ �Է��ϼ���.");
				return;
				
			} else if (blankCheck(pwd) == true || blankCheck(tel) == true || blankCheck(email) == true) {
				showMsg("���⿡ �����ϼ���.");
				return;

			}else if(result==1) {
				showMsg("ȸ������ ������ �Ϸ�Ǿ����ϴ�.");
				mainF.card.show(mainF.pCenter, "����������");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}//userInsert()----------------
	
	/** DELETE */
	public void deleteUser() {
		String id = tfId.getText();
		char[] ch = tfPwd.getPassword();
		String pwd = new String(ch);

		try {
			
			int yesorno = JOptionPane.showConfirmDialog(mainF.pCenter, "���� Ż���Ͻðڽ��ϱ�?", "Ȯ��", 
					JOptionPane.YES_NO_OPTION);
			if(yesorno==JOptionPane.YES_OPTION) {
				int result = userdao.deleteUser(id);
				System.out.println(result);
				
				if(result==1){
					udb.setUserId(id);
					showMsg("ȸ���� Ż�� �Ǿ����ϴ�.");
					System.exit(0);
				}else if(result==0) {
					showMsg("���̵� �Է��ϼ���."); //���� �ҷ����� �����ϸ� �����ص� ��
					return;
				}
				
			}else {
				showMsg("ȸ��Ż�� �����߽��ϴ�.\n���������� T^T"); 
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/** �Է�â ���� */
	public void clearReg() {
		tfPwd.setText("");
		tfTel.setText("");
		tfEmail.setText("");
		tfPwd.requestFocus();
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
	
	public void showId() 
	{	
		
	}
	
	
	public void showEdit(UserDB userd) 
	{
		tfName.setText(userd.getUserName());
		tfBirth.setText(userd.getUserBirth());
		tfPwd.setText(userd.getUserPwd());
		tfTel.setText(userd.getUserTel());
		tfEmail.setText(userd.getUserEmail());
	}

}