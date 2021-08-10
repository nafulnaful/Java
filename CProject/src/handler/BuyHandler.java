package handler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import db.CarDAO;
import db.CarDB;
import exception.AuthenException;
import page.MainFrame;

public class BuyHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
	CarDAO cDao;
	CarDB cdb;

	public BuyHandler(MainFrame mainF) {
		this.mainF = mainF;
		cDao=new CarDAO();
		cdb=new CarDB();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		int cb = mainF.buyF.cbSearch.getSelectedIndex();

		/**검색 이벤트*/
		if (o == mainF.buyF.tfSearch) {
			mainF.buyF.tfSearch.setText("");
			mainF.buyF.tfSearch.setForeground(Color.black);
		}
		
		if (cb == 1 && o == mainF.buyF.lbSearch) {
			try {
				ArrayList<CarDB> list=cDao.selectCarBr(mainF.buyF.tfSearch.getText());
				mainF.buyF.contentsBox.removeAll();
				mainF.buyF.showItem(list);
				mainF.buyF.contentsBox.requestFocus();
			} catch (Exception e1) {
				System.out.println("차량검색 예외:"+e1.getMessage());
				e1.printStackTrace();
			}
		}else if (cb == 2 && o == mainF.buyF.lbSearch) {
			try {
				ArrayList<CarDB> list=cDao.selectCarMo(mainF.buyF.tfSearch.getText());
				mainF.buyF.contentsBox.removeAll();
				mainF.buyF.showItem(list);
				mainF.buyF.contentsBox.requestFocus();
			} catch (Exception e1) {
				System.out.println("차량검색 예외:"+e1.getMessage());
				e1.printStackTrace();
			}
		}else if (cb == 0){
			JOptionPane.showMessageDialog(mainF, "카테고리를 선택하세요.");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
