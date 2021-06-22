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
		btLogin=new JButton("로그인");
		
		p.add(tfId);
		p.add(tfPwd);
		p.add(btLogin);
		
		p.setOpaque(false);//투명하게
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
		
	}//생성자------------------------
	
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(mainF.pC, message);
	}//--------------------------------
	
	/**로그인 처리를 하는 메소드*/
	public void loginCheck() {
		//mainF.setTitle("loginCheck");
		//1. tfId에 입력한 값 받기
		String uid=tfId.getText();
		
		//2. tfPwd에 입력한 값 받기
		char[] ch=tfPwd.getPassword();
		String upw=new String(ch);
		
		//유효한 값이 아닐 경우 체크 => 유효성 체크
		//String의 trim()메소드 : 문자열 앞 뒤의 공백을 제거해줌
		if(uid==null|| upw==null || uid.trim().equals("")||upw.trim().equals("")) {
			showMsg("아이디, 비밀번호를 입력해야 해요!!");
			return;
		}
		uid=uid.trim();
		upw=upw.trim();
		
		showMsg(uid+"님 환영합니다");
		mainF.setTitle(uid+"/"+upw+"님 로그인 중....");
		
		//3. mainF의 userTable에 저장한 회원들 정보를 꺼내서 
		boolean isExist = mainF.userTable.containsKey(uid);
		//아이디가 존재하는지 체크
		if(!isExist) {
			showMsg("없는 ID입니다. 다시 입력하세요");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}
		
		//아이디가 맞는 경우 => 비번 체크
		User tmpUser=mainF.userTable.get(uid);
		String tmpPwd=tmpUser.getPwd();
		if(!upw.equals(tmpPwd)) {
			showMsg("비밀번호가 일치하지 않아요");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}
		
		showMsg(uid+"님 환영합니다.");
		mainF.setTitle(uid+"님 로그인 중");
		mainF.isLogin=true;
		mainF.lbLogin.setText("Logout");
	
		
		// 사용자가 입력한 아이디와 비번이 일치하는지 체크하자.
		/* 1) 없는 아이디를 입력한 경우 ==> "없는 ID 입니다"
		 * 2) 아이디는 맞지만 비번이 일치하지 않는 경우 ==> "비밀번호가 틀려요"
		 * 3) 아이디도 맞고 비번도 맞는 경우 ==> 로그인 처리 => "로그인 성공" 타이틀 변경
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
