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
		lbTop = new JLabel("", new ImageIcon("src/images/상단바_회원정보수정.png"), JLabel.CENTER);
		lbMust1 = new JLabel("", new ImageIcon("src/images/필수입력.png"), JLabel.CENTER);
		lbMust2 = new JLabel("", new ImageIcon("src/images/필수입력.png"), JLabel.CENTER);
		lbDone = new JLabel("", new ImageIcon("src/images/완료1.png"), JLabel.CENTER);
		lbDel = new JLabel("", new ImageIcon("src/images/회원탈퇴.png"), JLabel.CENTER);
		pNorth.add(lbTop);
		pSouth.add(lbDone);
		pSouth.add(lbDel);

		lbName = new JLabel("", new ImageIcon("src/images/수정_이름.png"), JLabel.CENTER);
		lbBirth = new JLabel("", new ImageIcon("src/images/수정_생년월일.png"), JLabel.CENTER);
		lbId = new JLabel("", new ImageIcon("src/images/수정_아이디.png"), JLabel.CENTER);
		lbPwd = new JLabel("", new ImageIcon("src/images/수정_비밀번호.png"), JLabel.CENTER);
		lbTel = new JLabel("", new ImageIcon("src/images/수정_휴대전화.png"), JLabel.CENTER);
		lbEmail = new JLabel("", new ImageIcon("src/images/수정_이메일.png"), JLabel.CENTER);

		// TextField
		tfName = new JTextField(20);
		tfBirth = new JTextField(" YYYYMMDD", 20);
		tfId = new JTextField(20);
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

		// TextField 옵션
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
		
		/** JoinHandler 핸들러 부착 */
		EditHandler handler=new EditHandler(mainF);
		tfTel.addMouseListener(handler);
		tfEmail.addMouseListener(handler);
		lbDone.addMouseListener(handler);
		lbDel.addMouseListener(handler);

	}// 생성자-------------------------------------------------------------------------------------------------------
	
	/** 알림창 showMsg() */
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(pCenter, message);
	}// ----------------------------------
	
	/** UPDATE */
	public void userUpdate() throws AuthenException {

		/**텍스트필드 입력값 -> String*/
		String name = tfName.getText();
		String birth = tfBirth.getText();
		String id = tfId.getText();
		char[] ch = tfPwd.getPassword();
		String pwd = new String(ch);
		String tel = tfTel.getText();
		String email = tfEmail.getText();
		try {
			
			/*이름 저장*/
			udb.setUserName(name);
			/*생년월일 저장*/
			udb.setUserBirth(birth);
			/*아이디 저장*/
			udb.setUserId(id); //아이디 불러와서 저장
			/*패스워드 저장*/
			udb.setUserPwd(pwd);
			/*휴대전화 저장*/
			udb.setUserTel(tel);
			/*이메일 저장*/
			udb.setUserEmail(email);
			
			/**저장 완료 확인*/
			int result = userdao.updateUser(udb);
			System.out.println(result);			
			
			/**공백체크*/
			if (pwd.trim().isEmpty() || tel.trim().isEmpty() || email.trim().isEmpty()) {
				showMsg("모든 정보를 입력하세요.");
				return;
				
			} else if (blankCheck(pwd) == true || blankCheck(tel) == true || blankCheck(email) == true) {
				showMsg("띄어쓰기에 유의하세요.");
				return;

			}else if(result==1) {
				showMsg("회원정보 수정이 완료되었습니다.");
				mainF.card.show(mainF.pCenter, "마이페이지");
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
			
			int yesorno = JOptionPane.showConfirmDialog(mainF.pCenter, "정말 탈퇴하시겠습니까?", "확인", 
					JOptionPane.YES_NO_OPTION);
			if(yesorno==JOptionPane.YES_OPTION) {
				int result = userdao.deleteUser(id);
				System.out.println(result);
				
				if(result==1){
					udb.setUserId(id);
					showMsg("회원이 탈퇴 되었습니다.");
					System.exit(0);
				}else if(result==0) {
					showMsg("아이디를 입력하세요."); //정보 불러오기 성공하면 삭제해도 됨
					return;
				}
				
			}else {
				showMsg("회원탈퇴에 실패했습니다.\n가지마세요 T^T"); 
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/** 입력창 비우기 */
	public void clearReg() {
		tfPwd.setText("");
		tfTel.setText("");
		tfEmail.setText("");
		tfPwd.requestFocus();
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