package FirstProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MypageHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
	Login loginF;
	MyPage mypageF;
	Join joinF = new Join();

	public MypageHandler(MyPage mypageF) {
		this.mypageF = mypageF;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}// -----

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		// 회원정보 수정버튼 누르면 회원가입창으로 이동 후 텍스트필드 비활성화
		if (o == mypageF.lbUserInfo) {
			joinF.setSize(400, 600);
			joinF.setLocation(350, 0);
			joinF.setVisible(true);
			joinF.tfId.setEnabled(false);
			joinF.tfId.setText("저장된 아이디");
			joinF.tfName.setEnabled(false);
			joinF.tfName.setText("저장된 이름");
			joinF.tfBirth.setEnabled(false);
			joinF.tfBirth.setText("저장된 생년월일");

		} else if (o == mypageF.lbCarInfo) {
			System.out.println("등록차량조회 동작");
		} else if (o == mypageF.lbTalk) {
			System.out.println("1:1 문의 동작");
		} else if (o == mypageF.lbLogout) {
			System.out.println("동작");
			mypageF.logout();
		}

	}// -----

}