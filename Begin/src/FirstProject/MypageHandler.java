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
		// ȸ������ ������ư ������ ȸ������â���� �̵� �� �ؽ�Ʈ�ʵ� ��Ȱ��ȭ
		if (o == mypageF.lbUserInfo) {
			joinF.setSize(400, 600);
			joinF.setLocation(350, 0);
			joinF.setVisible(true);
			joinF.tfId.setEnabled(false);
			joinF.tfId.setText("����� ���̵�");
			joinF.tfName.setEnabled(false);
			joinF.tfName.setText("����� �̸�");
			joinF.tfBirth.setEnabled(false);
			joinF.tfBirth.setText("����� �������");

		} else if (o == mypageF.lbCarInfo) {
			System.out.println("���������ȸ ����");
		} else if (o == mypageF.lbTalk) {
			System.out.println("1:1 ���� ����");
		} else if (o == mypageF.lbLogout) {
			System.out.println("����");
			mypageF.logout();
		}

	}// -----

}