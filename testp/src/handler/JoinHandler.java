package handler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import exception.AuthenException;
import page.JoinPage;

public class JoinHandler extends MouseAdapter implements ActionListener {
	JoinPage joinF;

	public JoinHandler(JoinPage joinF) {
		this.joinF = joinF;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}// -----
	
	//마우스 커서 이동시 공백처리
	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o == joinF.lbDone) {
			try {
				joinF.userInsert(); //회원정보등록
				
			} catch (AuthenException e1) {
				System.out.println("회원등록 예외: "+e1.getMessage());
			}
		} else if (o == joinF.tfBirth) {
			joinF.tfBirth.setText("");
			joinF.tfBirth.setForeground(Color.black);
		} else if (o == joinF.tfId) {
			joinF.tfId.setText("");
			joinF.tfId.setForeground(Color.black);
		} else if (o == joinF.tfTel) {
			joinF.tfTel.setText("");
			joinF.tfTel.setForeground(Color.black);
		} else if (o == joinF.tfEmail) {
			joinF.tfEmail.setText("");
			joinF.tfEmail.setForeground(Color.black);
		}
	}// -----
}
