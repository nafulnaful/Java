package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import db.CarDAO;
import db.CarDB;
import page.BuyPage;
import page.MainFrame;
import page.SellPage;

public class CardHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
	CarDAO cDao;

	public CardHandler(MainFrame mainF) {
		this.mainF = mainF;
		cDao=new CarDAO();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		
		//�α��� ��ư
		if (o == mainF.lbLogin) {
			mainF.card.show(mainF.pCenter, "�α���");
		}else if(o==mainF.loginF.lbJoin) {
	         mainF.card.show(mainF.pCenter, "ȸ������");
		//���� ���� ��ư	
		} else if (o == mainF.lbBuy) {
			mainF.select();
			mainF.card.show(mainF.pCenter, "��������");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α���.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_�������ż���.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ڶ�.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_����������.png"));
			//���� �Ǹ� ��ư
		} else if (o == mainF.lbSell) {
			mainF.card.show(mainF.pCenter, "�����ȱ�");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α���.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_��������.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ⼱��.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ڶ�.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_����������.png"));
			//���� ���� ��ư
		} else if (o == mainF.lbLike) {
			mainF.card.show(mainF.pCenter, "�����ڶ�");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α���.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_��������.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ڶ�����.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_����������.png"));
			//���������� ��ư
		} else if (o == mainF.lbMypage) {
			mainF.card.show(mainF.pCenter, "����������");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α���.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_��������.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ڶ�.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_��������������.png"));
		}
		//[�α������� ������ ���ٺҰ�]///////////////////////////////////////////////////////////////////////////
		if (o == mainF.lbBuy) {
			
			
			if (mainF.isLogin) {
			} else { 
				mainF.card.show(mainF.pCenter, "�α���");
				JOptionPane.showMessageDialog(mainF.pCenter, "�α��� �� �̿밡���մϴ�.");
				mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α��μ���.png"));
				mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_��������.png"));
				mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
				mainF.lbLike.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ڶ�.png"));
				mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_����������.png"));
			}

		} else if (o == mainF.lbSell) {
			
			
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "�����ȱ�");
			} else { 
				mainF.card.show(mainF.pCenter, "�α���");
				JOptionPane.showMessageDialog(mainF.pCenter, "�α��� �� �̿밡���մϴ�.");
				mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α��μ���.png"));
				mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_��������.png"));
				mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
				mainF.lbLike.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ڶ�.png"));
				mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_����������.png"));
			}

		} else if (o == mainF.lbLike) {
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "�����ڶ�");
			} else { 
				mainF.card.show(mainF.pCenter, "�α���");
				JOptionPane.showMessageDialog(mainF.pCenter, "�α��� �� �̿밡���մϴ�.");
				mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α��μ���.png"));
				mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_��������.png"));
				mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
				mainF.lbLike.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ڶ�.png"));
				mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_����������.png"));
			}

		} else if (o == mainF.lbMypage) {
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "����������");
			} else { 
				mainF.card.show(mainF.pCenter, "�α���");
				JOptionPane.showMessageDialog(mainF.pCenter, "�α��� �� �̿밡���մϴ�.");
				mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α��μ���.png"));
				mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_��������.png"));
				mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
				mainF.lbLike.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ڶ�.png"));
				mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_����������.png"));
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}