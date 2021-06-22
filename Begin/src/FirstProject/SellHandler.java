package FirstProject;

import java.awt.event.*;
import javax.swing.JOptionPane;
import FirstProject.Car;

public class SellHandler extends MouseAdapter implements ActionListener {
	SellPage sellF;

	public SellHandler(SellPage sellF) {
		this.sellF = sellF;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}// -----

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o == sellF.lbDone) {
			sellF.car();
			sellF.saveFileCar("src/FirstProject/car.txt");
		}
	}// -----

}