package handler;

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
import page.SellPage;

public class SellHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
//	CarDAO cDao;

	public SellHandler(MainFrame mainF) {
		this.mainF = mainF;
//		cDao=new CarDAO();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o == mainF.sellF.lbDone) {
			try {
				mainF.sellF.carInsert();
				mainF.sellF.popF.dispose();
//				ArrayList<CarDB> list=cDao.selectCar();
				mainF.buyF.contentsBox.removeAll();
//				mainF.buyF.showItem(list);
				mainF.buyF.contentsBox.requestFocus();
			} catch (Exception e1) {
				System.out.println("차량등록(서버로 안 넘어감) 예외:"+e1.getMessage());
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
