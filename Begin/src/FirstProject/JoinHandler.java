package FirstProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class JoinHandler extends MouseAdapter implements ActionListener {
	Join joinF;

	public JoinHandler(Join joinF) {
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
			joinF.join();
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
