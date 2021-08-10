package FirstProject;

import java.awt.event.*;
import javax.swing.*;

public class CarHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;

	public CarHandler(MainFrame mainF) {
		this.mainF = mainF;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		
		//�α��� ��ư
		if (o == mainF.lbLogin) {
			mainF.card.show(mainF.pCenter, "�α���");
		//���� ���� ��ư	
		} else if (o == mainF.lbBuy) {
			mainF.card.show(mainF.pCenter, "��������");
			mainF.buyF.showCarTable();
			mainF.lbLogin.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�α���.png"));
			mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�������ż���.png"));
			mainF.lbSell.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�����ȱ�.png"));
			mainF.lbLike.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
			mainF.lbMypage.setIcon(new ImageIcon("./pj_img/�ϴܹ�_����������.png"));
			//���� �Ǹ� ��ư
		} else if (o == mainF.lbSell) {
			mainF.card.show(mainF.pCenter, "�����ȱ�");
			mainF.lbLogin.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�α���.png"));
			mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
			mainF.lbSell.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�����ȱ⼱��.png"));
			mainF.lbLike.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
			mainF.lbMypage.setIcon(new ImageIcon("./pj_img/�ϴܹ�_����������.png"));
			//���� ���� ��ư
		} else if (o == mainF.lbLike) {
			mainF.card.show(mainF.pCenter, "��������");
			mainF.lbLogin.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�α���.png"));
			mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
			mainF.lbSell.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�����ȱ�.png"));
			mainF.lbLike.setIcon(new ImageIcon("./pj_img/�ϴܹ�_������������.png"));
			mainF.lbMypage.setIcon(new ImageIcon("./pj_img/�ϴܹ�_����������.png"));
			//���������� ��ư
		} else if (o == mainF.lbMypage) {
			mainF.card.show(mainF.pCenter, "����������");
			mainF.lbLogin.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�α���.png"));
			mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
			mainF.lbSell.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�����ȱ�.png"));
			mainF.lbLike.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
			mainF.lbMypage.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������������.png"));
		}
		//[�α������� ������ ���ٺҰ�]///////////////////////////////////////////////////////////////////////////
		if (o == mainF.lbBuy) {
			
			
			if (mainF.isLogin) {
			} else { 
				mainF.card.show(mainF.pCenter, "�α���");
				JOptionPane.showMessageDialog(mainF.pCenter, "�α��� �� �̿밡���մϴ�.");
				mainF.lbLogin.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�α��μ���.png"));
				mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
				mainF.lbSell.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�����ȱ�.png"));
				mainF.lbLike.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
				mainF.lbMypage.setIcon(new ImageIcon("./pj_img/�ϴܹ�_����������.png"));
			}

		} else if (o == mainF.lbSell) {
			
			
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "�����ȱ�");
			} else { 
				mainF.card.show(mainF.pCenter, "�α���");
				JOptionPane.showMessageDialog(mainF.pCenter, "�α��� �� �̿밡���մϴ�.");
				mainF.lbLogin.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�α��μ���.png"));
				mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
				mainF.lbSell.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�����ȱ�.png"));
				mainF.lbLike.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
				mainF.lbMypage.setIcon(new ImageIcon("./pj_img/�ϴܹ�_����������.png"));
			}

		} else if (o == mainF.lbLike) {
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "��������");
			} else { 
				mainF.card.show(mainF.pCenter, "�α���");
				JOptionPane.showMessageDialog(mainF.pCenter, "�α��� �� �̿밡���մϴ�.");
				mainF.lbLogin.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�α��μ���.png"));
				mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
				mainF.lbSell.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�����ȱ�.png"));
				mainF.lbLike.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
				mainF.lbMypage.setIcon(new ImageIcon("./pj_img/�ϴܹ�_����������.png"));
			}

		} else if (o == mainF.lbMypage) {
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "����������");
			} else { 
				mainF.card.show(mainF.pCenter, "�α���");
				JOptionPane.showMessageDialog(mainF.pCenter, "�α��� �� �̿밡���մϴ�.");
				mainF.lbLogin.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�α��μ���.png"));
				mainF.lbBuy.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
				mainF.lbSell.setIcon(new ImageIcon("./pj_img/�ϴܹ�_�����ȱ�.png"));
				mainF.lbLike.setIcon(new ImageIcon("./pj_img/�ϴܹ�_��������.png"));
				mainF.lbMypage.setIcon(new ImageIcon("./pj_img/�ϴܹ�_����������.png"));
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}