package FirstProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class Login extends JPanel {

	MainFrame mainF;
	Join joinF = new Join();
	JPanel p = new JPanel();

	JPanel pNorth = new JPanel();
	JPanel pCenter = new MyJPanel(10, 50, 5, 50);
	JPanel pSouth = new MyJPanel(30, 45, 5, 45);

	JTextField tfId;
	JPasswordField tfPwd;
	JLabel lbTop, lbId, lbPwd, lbLogin, lbJoin;

	public Login(MainFrame mainF) {
		this.mainF = mainF;
		setBackground(new Color(255, 255, 255));

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");
		add(pSouth, "South");

		// Label
		lbTop = new JLabel("", new ImageIcon("./pj_img/�α��ηΰ�.png"), JLabel.CENTER);
		lbLogin = new JLabel("", new ImageIcon("./pj_img/�α��ι�ư.png"), JLabel.CENTER);
		lbJoin = new JLabel("", new ImageIcon("./pj_img/ȸ�����Թ�ư.png"), JLabel.CENTER);
		pSouth.add(lbLogin);
		pSouth.add(lbJoin);

		lbId = new JLabel("", new ImageIcon("./pj_img/���ξ��̵�.png"), JLabel.CENTER);
		lbPwd = new JLabel("", new ImageIcon("./pj_img/���κ�й�ȣ.png"), JLabel.CENTER);

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
		joinF = new Join();

		LoginHandler lh = new LoginHandler(mainF);
		lbJoin.addMouseListener(lh);
		lbLogin.addMouseListener(lh);
///////////////////////////////////////////////////////////////////////////////////////////////////[gui]////////////////
	}// ������------

	/** �˸�â showMsg() */
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(pCenter, message);
	}// ----------------------------------

	/** �α��� ó���� �ϴ� �޼ҵ� */
	public void loginCheck() {
		// mainF.setTitle("loginCheck");
		// 1. tfId�� �Է��� �� �ޱ�""
		String uid = tfId.getText();

		// 2. tfPwd�� �Է��� �� �ޱ�
		char[] ch = tfPwd.getPassword();
		String upw = new String(ch);

		// ��ȿ�� ���� �ƴ� ��� üũ=> ��ȿ�� üũ
		// String�� trim()�޼ҵ�: ���ڿ� �� ���� ������ ��������
		if (uid == null || upw == null || uid.trim().equals("") || upw.trim().equals("")) {
			showMsg("���̵�� ��й�ȣ�� �Է��ϼ���.");
			return;
		}
		uid = uid.trim();
		upw = upw.trim();

		boolean isExist = joinF.userTable.containsKey(uid);
		// ���̵� �����ϴ��� üũ
		if (!isExist) {
			showMsg("���̵� �������� �ʽ��ϴ�.");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}

		// ���̵� �´� ��� => ��� üũ
		FirstProject.User tmpUser = joinF.userTable.get(uid);
		String tmpPwd = tmpUser.getPwd();
		if (!upw.equals(tmpPwd)) {
			showMsg("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}

		// ���̺� ����� �� �����ֱ�
		mainF.buyF.showCarTable();

		showMsg(uid + "�� ȯ���մϴ�!");
		mainF.setTitle(":: Chachacha :: " + uid + "�� �α��� ��...");
		mainF.isLogin = true;
		mainF.card.show(mainF.pCenter, "��������");
		mainF.mypageF.lbWelcome.setText(uid);
		mainF.loginF.clearLoginInput();
		mainF.lbLogin.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�α���.png"));
		mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�������ż���.png"));
		mainF.lbLogin = new JLabel();

	}// -------------------------

	/** �Է�â ���� */
	public void clearLoginInput() {
		tfId.setText("");
		tfPwd.setText("");
	}// --------------------

}