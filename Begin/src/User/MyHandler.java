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
			//�α��� ���� �ʾ��� ���� �α��� �������� �����ְ�
			if(mainF.isLogin==false) {
				mainF.card.show(mainF.pC, "login");
			}else {
				//�α��� ���� ��� => Logoutó��
				mainF.isLogin=false;
				mainF.setTitle("::MainMemberFrame::");
				mainF.lbLogin.setText("Login");
				mainF.card.show(mainF.pC, "login");
			}
					
			
		}else if(o==mainF.lbList) {
			if(mainF.isLogin) {
				mainF.card.show(mainF.pC, "list");
				//mainF.listP.showUsers();//��� ȸ����� �����ִ� �޼ҵ� ȣ��
				mainF.listP.showUserTable();//JTable�� �����ִ� �޼ҵ�

				
			}else {//�α������� �ʾҴٸ� �α��� �������� ��������
				JOptionPane.showMessageDialog(mainF.pC, "�α��� �ؾ� �̿� �����մϴ�.");
				mainF.card.show(mainF.pC, "login");
			}
		
		}
		
		
	}

}
