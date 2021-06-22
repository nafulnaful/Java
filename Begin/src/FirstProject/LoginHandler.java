package FirstProject;

import java.awt.event.*;
import javax.swing.*;

public class LoginHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;

	public LoginHandler(MainFrame mainF) {
		this.mainF = mainF;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o == mainF.loginF.lbLogin) {
			mainF.loginF.loginCheck();
		} else if (o == mainF.loginF.lbJoin) {
			mainF.loginF.joinF.pack();
			mainF.loginF.joinF.setSize(400, 600);
			mainF.loginF.joinF.setLocation(350, 0);
			mainF.loginF.joinF.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}