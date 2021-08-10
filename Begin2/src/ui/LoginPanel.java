package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import data.UserDB;


public class LoginPanel extends JPanel{
	
	ImageIcon bgIcon;
	JPanel p=new JPanel();
	public JTextField tfId;
	public JPasswordField tfPwd;
	public JButton btLogin,btJoin;
	MainPanel mp;
	
	public LoginPanel(MainPanel frame) {
		this.mp=frame;
		
		setBackground(Color.white);
		bgIcon=new ImageIcon("images/back.jpg");
		add(p);
		p.setLayout(new GridLayout(0,1,10,10));
		tfId=new JTextField(20);
		tfPwd=new JPasswordField(20);
		btLogin=new JButton("로그인");
		btJoin=new JButton("회원가입");
		
		ImageIcon Main_img = new ImageIcon("images/mark.jpg");
		Image img3 = Main_img.getImage();
		
		Image changeImg = img3.getScaledInstance(250, 60, Image.SCALE_SMOOTH);
		
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel mi = new JLabel(changeIcon);
		mi.setBackground(Color.white);
		mi.setLocation(0, 0);
		mi.setSize(250, 60);
		p.add(mi);



		
		p.add(tfId);
		p.add(tfPwd);
		p.add(btLogin);
		p.add(btJoin);
		p.setOpaque(false);//투명하게
		TitledBorder tb1=null, tb2=null;
		
		LineBorder lnb=new LineBorder(Color.black);//6.03일자 차봄
		tfId.setBorder(tb1=new TitledBorder(lnb,"아이디"));//6.03일자 차봄
		tfPwd.setBorder(tb2=new TitledBorder(lnb,"비밀번호"));//6.03일자 차봄
		
		tfId.setForeground(Color.black);
		tfPwd.setForeground(Color.black);
		btLogin.setBackground(Color.black);
		btLogin.setForeground(Color.white);
		btJoin.setBackground(Color.black);
		btJoin.setForeground(Color.white);
		tfId.setOpaque(false);
		tfPwd.setOpaque(false);
		//btLogin.setOpaque(false);
	}//생성자---------------------
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(mp.pC, message);
	}
	/**로그인 처리를 하는 메소드*/
	public void loginCheck() {
		//mp.setTitle("loginCheck");
		//1. tfId에 입력한 값 받기
		//2. tfPwd에 입력한 값 받기
		String id=tfId.getText();
		char[] pass=tfPwd.getPassword();
		String pwd=new String(pass);
		
		//유효한 값이 아닐 경우 체크=>유효성 체크
		//String의 trim()메소드: 문자열 앞 뒤의 공백을 제거해줌
		if(id==null || pwd==null || id.trim().equals("")||pwd.trim().equals("")) {
			showMsg("아이디,비밀번호를 입력해야 해요!!");
			return;
		}
		id=id.trim();
		pwd=pwd.trim();
				
		boolean isExist=mp.userTable.containsKey(id);
		//아이디가 존재하는 체크
		if(!isExist) {
			showMsg("없는 ID입니다. 다시 입력하세요");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}
		
		//아이디가 맞는 경우=> 비번 체크
		UserDB tmpUserDB=mp.userTable.get(id);
		String tmpPwd=tmpUserDB.getPwd();
		if(!pwd.equals(tmpPwd)) {
			showMsg("비밀번호가 일치하지 않아요");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}
		
		showMsg(id+"님 환영합니다.");
		mp.setTitle(id+"님 로그인 중...");
		mp.isLogin=true;
		
		
		
		mp.Iam = tmpUserDB;
		mp.userTable.put(mp.Iam.getUserid(), mp.Iam);  //string 오류테스트 
		
		if(mp.isLogin==true) {
			mp.lbMy.setText("내 정보");			
		}
		mp.card.show(mp.pC, "home");
	}//-------------------
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgIcon.getImage(),0,0,this.getWidth(),this.getHeight(),this);
		
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(60,20,20,20);
	}

}//////////////////////////////////
