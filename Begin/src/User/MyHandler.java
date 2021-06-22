package User;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class MyHandler extends MouseAdapter implements ActionListener 
{
	MainMemberFrame mainF;
	
	public MyHandler(MainMemberFrame mainF) {
		this.mainF = mainF;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//mainF.setTitle("action");
		Object o=e.getSource();
		if(o==mainF.joinP.btJoin) {
			mainF.join();
		}else if(o==mainF.joinP.btReset) {
			mainF.clearJoinInput();
		}else if(o==mainF.loginP.btLogin) {
			mainF.loginP.loginCheck();
		}
		
	}//-------------------------------
	
	@Override
	public void mousePressed(MouseEvent e) {
		//mainF.setTitle("mouse");
		Object o=e.getSource();
		if(o==mainF.lbJoin) {
			mainF.card.show(mainF.pC, "join");
		}else if(o==mainF.lbLogin) {
			//로그인 하지 않았을 때는 로그인 페이지를 보여주고
			if(mainF.isLogin==false) {
				mainF.card.show(mainF.pC, "login");
			}else {
				//로그인 했을 경우 => Logout처리
				mainF.isLogin=false;
				mainF.setTitle("::MainMemberFrame::");
				mainF.lbLogin.setText("Login");
				mainF.card.show(mainF.pC, "login");
			}
					
			
		}else if(o==mainF.lbList) {
			if(mainF.isLogin) {
				mainF.card.show(mainF.pC, "list");
				//mainF.listP.showUsers();//모든 회원목록 보여주는 메소드 호출
				mainF.listP.showUserTable();//JTable로 보여주는 메소드

				
			}else {//로그인하지 않았다면 로그인 페이지를 보여주자
				JOptionPane.showMessageDialog(mainF.pC, "로그인 해야 이용 가능합니다.");
				mainF.card.show(mainF.pC, "login");
			}
		
		}
		
		
	}

}
