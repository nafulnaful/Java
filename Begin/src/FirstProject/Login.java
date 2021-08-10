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
		lbTop = new JLabel("", new ImageIcon("./pj_img/로그인로고.png"), JLabel.CENTER);
		lbLogin = new JLabel("", new ImageIcon("./pj_img/로그인버튼.png"), JLabel.CENTER);
		lbJoin = new JLabel("", new ImageIcon("./pj_img/회원가입버튼.png"), JLabel.CENTER);
		pSouth.add(lbLogin);
		pSouth.add(lbJoin);

		lbId = new JLabel("", new ImageIcon("./pj_img/메인아이디.png"), JLabel.CENTER);
		lbPwd = new JLabel("", new ImageIcon("./pj_img/메인비밀번호.png"), JLabel.CENTER);

		// TextField
		tfId = new JTextField();
		tfPwd = new JPasswordField();

		// Label + TextField
		pCenter.add(lbId);
		pCenter.add(tfId);
		pCenter.add(lbPwd);
		pCenter.add(tfPwd);

		// Panel 옵션
		pCenter.setLayout(new GridLayout(4, 1));
		pSouth.setLayout(new GridLayout(1, 2));
		pNorth.setBackground(new Color(162, 108, 254));
		pCenter.setBackground(Color.white);
		pSouth.setBackground(Color.white);

		// TextField 옵션
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
	}// 생성자------

	/** 알림창 showMsg() */
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(pCenter, message);
	}// ----------------------------------

	/** 로그인 처리를 하는 메소드 */
	public void loginCheck() {
		// mainF.setTitle("loginCheck");
		// 1. tfId에 입력한 값 받기""
		String uid = tfId.getText();

		// 2. tfPwd에 입력한 값 받기
		char[] ch = tfPwd.getPassword();
		String upw = new String(ch);

		// 유효한 값이 아닐 경우 체크=> 유효성 체크
		// String의 trim()메소드: 문자열 앞 뒤의 공백을 제거해줌
		if (uid == null || upw == null || uid.trim().equals("") || upw.trim().equals("")) {
			showMsg("아이디와 비밀번호를 입력하세요.");
			return;
		}
		uid = uid.trim();
		upw = upw.trim();

		boolean isExist = joinF.userTable.containsKey(uid);
		// 아이디가 존재하는지 체크
		if (!isExist) {
			showMsg("아이디가 존재하지 않습니다.");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}

		// 아이디가 맞는 경우 => 비번 체크
		FirstProject.User tmpUser = joinF.userTable.get(uid);
		String tmpPwd = tmpUser.getPwd();
		if (!upw.equals(tmpPwd)) {
			showMsg("비밀번호가 일치하지 않습니다.");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}

		// 테이블에 저장된 값 보여주기
		mainF.buyF.showCarTable();

		showMsg(uid + "님 환영합니다!");
		mainF.setTitle(":: Chachacha :: " + uid + "님 로그인 중...");
		mainF.isLogin = true;
		mainF.card.show(mainF.pCenter, "내차구매");
		mainF.mypageF.lbWelcome.setText(uid);
		mainF.loginF.clearLoginInput();
		mainF.lbLogin.setIcon(new ImageIcon("./pj_img/하단바_로그인.png"));
		mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매선택.png"));
		mainF.lbLogin = new JLabel();

	}// -------------------------

	/** 입력창 비우기 */
	public void clearLoginInput() {
		tfId.setText("");
		tfPwd.setText("");
	}// --------------------

}