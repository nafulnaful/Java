package function;

import javax.swing.JOptionPane; 
import data.*;
import ui.*;
public class Join {
	MainPanel mp;
	
	public Join(MainPanel mp) {
		this.mp=mp;
	}
	
	public void join() {
		String name=mp.joinP.tfName.getText();
		String userid=mp.joinP.tfUserid.getText();
		
		char[] ch=mp.joinP.tfPwd.getPassword();
		String pwd=new String(ch);
		
		String tel=mp.joinP.tfTel.getText();
		
		if(name==null || userid==null || pwd==null || tel==null || name.trim().equals("")||userid.trim().equals("") || pwd.trim().equals("")|| tel.trim().equals("")) {
			JOptionPane.showMessageDialog(mp.pC,"회원가입 정보를 입력하세요.");
			return;
		}
		
		name=name.trim();
		userid=userid.trim();
		pwd=pwd.trim();
		tel=tel.trim();
		
		boolean isUse=idCheck(userid);//아이디 중복체크 메소드 호출
		if(!isUse) {
			JOptionPane.showMessageDialog(mp.joinP,
					"아이디는 이미 사용중입니다. 다른 아이디를 입력하세요");
			mp.joinP.tfUserid.requestFocus();
			return;
		}
		
		UserDB user=new UserDB(name,userid, pwd, tel);
		mp.userTable.put(userid, user);
		JOptionPane.showMessageDialog(mp.pC,"회원가입 완료. \n로그인 해주세요.");//531d
		 
		
		clearJoinInput();
		
		mp.card.show(mp.pC, "login");
		
		
	}//----------------------
	
	public boolean idCheck(String userid) {
		boolean b=mp.userTable.containsKey(userid);
		return !b;
	}
	public void clearJoinInput() {
		mp.joinP.tfName.setText("");
		mp.joinP.tfUserid.setText("");
		mp.joinP.tfPwd.setText("");
		mp.joinP.tfTel.setText("");
		mp.joinP.tfName.requestFocus();
	}//--------------------

}
