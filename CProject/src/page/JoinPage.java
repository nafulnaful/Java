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
		cbUse = new JCheckBox("이용약관에 동의합니다.");
		pSouth.add(cbUse);

		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/상단바_회원가입.png"), JLabel.CENTER);
		lbMust1 = new JLabel("", new ImageIcon("src/images/필수입력.png"), JLabel.CENTER);
		lbMust2 = new JLabel("", new ImageIcon("src/images/필수입력2.png"), JLabel.CENTER);
		lbDone = new JLabel("", new ImageIcon("src/images/완료1.png"), JLabel.CENTER);
		pNorth.add(lbTop);
		pSouth.add(lbDone);

		lbName = new JLabel("", new ImageIcon("src/images/이름.png"), JLabel.CENTER);
		lbBirth = new JLabel("", new ImageIcon("src/images/생년월일.png"), JLabel.CENTER);
		lbId = new JLabel("", new ImageIcon("src/images/아이디.png"), JLabel.CENTER);
		lbPwd = new JLabel("", new ImageIcon("src/images/비밀번호.png"), JLabel.CENTER);
		lbTel = new JLabel("", new ImageIcon("src/images/휴대전화.png"), JLabel.CENTER);
		lbEmail = new JLabel("", new ImageIcon("src/images/이메일.png"), JLabel.CENTER);

		// TextField
		tfName = new JTextField(20);
		tfBirth = new JTextField(" YYYYMMDD", 20);
		tfId = new JTextField(" 영문 소문자와 숫자 조합 4~12자리", 20);
		tfPwd = new JPasswordField(20);
		tfTel = new JTextField(" '-' 제외하고 숫자만 입력", 20);
		tfEmail = new JTextField(" example@chacha.com", 20);

		// Label + TextField 그리드 적용
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

		// Panel 옵션
		pNorth.setBackground(new Color(162, 108, 254));
		pCenter.setBackground(Color.white);
		pSouth.setBackground(Color.white);

		pNorth_W.setLayout(new GridLayout(6, 1));
		pNorth_C.setLayout(new GridLayout(6, 1));

		// CheckBox 옵션
		cbUse.setHorizontalAlignment(JCheckBox.CENTER);
		cbUse.setBackground(Color.white);
		cbUse.setOpaque(true);

		// TextField 옵션
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
		

		/** JoinHandler 핸들러 부착 */
		JoinHandler handler = new JoinHandler(this);
		lbDone.addMouseListener(handler);
		tfBirth.addMouseListener(handler);
		tfId.addMouseListener(handler);
		tfTel.addMouseListener(handler);
		tfEmail.addMouseListener(handler);

	}// 생성자-------------------------------------------------------------------------------------------------------
	
	/** 알림창 showMsg() */
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(pCenter, message);
	}// ----------------------------------

	/** INSERT */
	public void userInsert() throws AuthenException {
		/**텍스트필드 입력값 -> String*/
		String name = tfName.getText();
		String birth = tfBirth.getText();
		String id = tfId.getText();
		char[] ch = tfPwd.getPassword();
		String pwd = new String(ch);
		String tel = tfTel.getText();
		String email = tfEmail.getText();
		try {
			
			UserDB udb=new UserDB(100,name,birth,id,pwd,tel,email);
			
			/**아이디 중복체크*/
			/*if(!userdao.ExistUser(id)){
				showMsg(id+"은(는) 이미 사용중 입니다.\n다른 아이디를 입력하세요.");
				return;
			}*/
			
			/**저장 완료 확인*/
			//boolean result = userdao.insertUser(udb);
				
			
			/**공백체크*/
			if (name.trim().isEmpty() || birth.trim().isEmpty() || id.trim().isEmpty() || pwd.trim().isEmpty()
					|| tel.trim().isEmpty() || email.trim().isEmpty()) {
				showMsg("모든 정보를 입력하세요.");
				return;
				
			} else if (blankCheck(name) == true || blankCheck(birth) == true || blankCheck(id) == true
						|| blankCheck(pwd) == true || blankCheck(tel) == true || blankCheck(email) == true) {
				System.out.println(blankCheck(name));
				showMsg("띄어쓰기에 유의하세요.");
				return;

			} else if (!cbUse.isSelected()) {
				showMsg("이용약관에 동의하세요.");
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

	/** 입력창 비우기 */
	public void clearReg() {
		tfName.setText("");
		tfBirth.setText("");
		tfId.setText("");
		tfPwd.setText("");
		tfTel.setText("");
		tfEmail.setText("");
		tfName.requestFocus();
	}// --------------------
	
	/** 공백 찾는 메소드 */
	public boolean blankCheck(String Code) {
	    for (int i = 0; i < Code.length(); i++) {
	       if (Code.charAt(i) == ' ') {
	          return true;
	       }
	    }
	    return false;

	}// -------------blankCheck-----------



}