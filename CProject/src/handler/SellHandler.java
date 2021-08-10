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

public class SellHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
	CarDAO cDao;

	public SellHandler(MainFrame mainF) {
		this.mainF = mainF;
		cDao=new CarDAO();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o == mainF.sellF.lbDone) {
			try {
				mainF.sellF.carInsert();
				mainF.sellF.popF.dispose();
				
				CarDB cardb=new CarDB(600);
				mainF.sellF.Response(cardb);

			} catch (Exception e1) {
				System.out.println("차량등록 예외:"+e1.getMessage());
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
