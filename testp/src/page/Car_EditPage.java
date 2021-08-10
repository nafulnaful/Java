package page;

import java.awt.*;


import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

import handler.EditHandler;
import handler.LoginHandler;
import handler.SellHandler;
import handler.UserHandler;
import db.*;
import exception.AuthenException;


public class Car_EditPage extends JPanel {
	MainFrame mainF;
	// Panel
	JPanel p = new JPanel(new BorderLayout());
	JPanel pNorth = new JPanel(new GridLayout(1, 0, 10, 10));
	JPanel pCenter = new JPanel(new BorderLayout(10, 10));

	JPanel pCenter_W = new JPanel(); // ��������~ ��й�ȣ
	JPanel pCenter_C = new JPanel(); // ����
	JPanel pCenter_S = new JPanel(); // �Ϸ�
	JPanel pCenter_W_C = new JPanel(); // ��������, �޺��ڽ�

	// Label
	JLabel lbWelcome, lbUserInfo, lbCarInfo, lbTalk, lbLogout;
	JLabel lbTop, lbShow, lbInfor;
	//�󺧿� public �ٿ��� �ٸ� ������ �̿��� ����
public JLabel lbNo, lbBrand, lbModel, lbYear, lbAcc, lbKm, lbPr, lbImg, lbOpen, lbDone;

	// TextField
	JTextField tfNo, tfModel, tfYear, tfAcc, tfKm, tfPr, tfImg;
	
	// ComboBox
	JComboBox<String> cbBrand;
	String[] brand = { "----- �� �� -----", "����", "���" };
	
	//�ڵ鷯 
	UserHandler uh;
	
//	CarDB cdb=new CarDB();	
//	CarDAO cardao=new CarDAO();
	CarClient carclient=new CarClient(mainF);
	
	public Car_EditPage(MainFrame mainF, UserHandler uh) {
		this.mainF = mainF;
		this.uh = uh;
//		cardao=new CarDAO();
		setBackground(Color.white);
		add(pNorth, "North");
		add(pCenter, "Center");

		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/��ܹ�_�����ȱ�.png"), JLabel.CENTER);
		pNorth.add(lbTop);

		// Panel �ɼ�
		pNorth.setBackground(Color.white);
		pCenter.setBackground(Color.white);
		pCenter_C.setBackground(Color.white);
		pCenter_S.setBackground(Color.white);
		pCenter_W.setBackground(Color.white);
		pCenter_W_C.setBackground(Color.white);
		lbInfor = new JLabel("", new ImageIcon("src/images/�����������.png"), JLabel.CENTER);
		lbInfor.setFont(new Font("sans-serif", Font.BOLD, 18));

		lbDone = new JLabel("", new ImageIcon("src/images/�Ϸ�.png"), JLabel.CENTER);

		pCenter.add(lbInfor, "North");
		pCenter.add(pCenter_W, "West");
		pCenter.add(pCenter_C, "Center");
		pCenter.add(pCenter_S, "South");

		pCenter_W.setLayout(new GridLayout(0, 1, 5, 5));
		pCenter_C.setLayout(new GridLayout(0, 1, 5, 5));
		
		lbNo = new JLabel("", new ImageIcon("src/images/������ȣ.png"), JLabel.CENTER);
		lbBrand = new JLabel("", new ImageIcon("src/images/�귣���.png"), JLabel.CENTER);
		lbModel = new JLabel("", new ImageIcon("src/images/�𵨸�.png"), JLabel.CENTER);
		lbYear = new JLabel("", new ImageIcon("src/images/����.png"), JLabel.CENTER);
		lbAcc = new JLabel("", new ImageIcon("src/images/�������.png"), JLabel.CENTER);
		lbKm = new JLabel("", new ImageIcon("src/images/����Ÿ�.png"), JLabel.CENTER);
		lbPr = new JLabel("", new ImageIcon("src/images/�ǸŰ���.png"), JLabel.CENTER);
		lbImg = new JLabel("", new ImageIcon("src/images/�̹���.png"), JLabel.CENTER);
		
		tfNo = new JTextField(20);
		tfModel = new JTextField();
		tfYear = new JTextField();
		tfAcc = new JTextField();
		tfKm = new JTextField();
		tfPr = new JTextField();
		tfImg = new JTextField();

		cbBrand = new JComboBox<>(brand);
		
		pCenter_W.add(lbNo);
		pCenter_W.add(lbBrand);
		pCenter_W.add(lbModel);
		pCenter_W.add(lbYear);
		pCenter_W.add(lbAcc);
		pCenter_W.add(lbKm);
		pCenter_W.add(lbPr);
		pCenter_W.add(lbImg);

		pCenter_W_C.setLayout(new FlowLayout(50, 50, 7));

		pCenter_W_C.add(cbBrand);
		
		pCenter_C.add(tfNo);
		pCenter_C.add(pCenter_W_C);
		pCenter_C.add(tfModel);
		pCenter_C.add(tfYear);
		pCenter_C.add(tfAcc);
		pCenter_C.add(tfKm);
		pCenter_C.add(tfPr);
		pCenter_C.add(tfImg);
		
		pCenter_S.add(lbDone);


		EditHandler handler=new EditHandler(mainF);
		lbDone.addMouseListener(handler);
		
	}
////////////////////////////////////////////////////////////////[GUI]////////////	
	
	/** UPDATE */
	public void carUpdate() {

		/**�ؽ�Ʈ�ʵ� �Է°� -> String*/
		String no = tfNo.getText();
		String brand = cbBrand.getSelectedItem().toString();
		String model = tfModel.getText();
		String year = tfYear.getText();
		String acc = tfAcc.getText();
		String km = tfKm.getText();
		String price = tfPr.getText();
		String img = tfImg.getText();
		
		try {
			
			CarDB cdb=new CarDB(400,no,brand,model,year,acc,km,price,img);
			
//			/**���� �Ϸ� Ȯ��*/
//			int result = cardao.updateCar(cdb);
//			System.out.println(result);			
//			
			/**����üũ*/
			if(brand.trim().equals("----- �� �� -----")||no==null||brand==null||model==null||year==null
				||acc==null||km==null||price==null||img==null||
				no.trim().isEmpty()||brand.trim().isEmpty()||model.trim().isEmpty()||
				year.trim().isEmpty()||acc.trim().isEmpty()||
				km.trim().isEmpty()||price.trim().isEmpty()||img.trim().isEmpty()) {
				showMsg("��� ������ �Է��ϼ���.");
				return;
//			}else if(result==1) {
//				showMsg("���� ������ �Ϸ�Ǿ����ϴ�.");
//				mainF.card.show(mainF.pCenter, "��������"); //����� ����ȭ�� ���
//				clearReg();
//				mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
//				mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_�������ż���.png"));
			}
			if(cdb==null) {
				System.out.println("cdb�� null�� �����Դϴ�.");
			}
			Response(cdb);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}//userInsert()----------------
	
	
	private void Response(CarDB cdb) {
		try {
			carclient.out.writeObject(cdb);
			carclient.out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
}
	private void showMsg(String string) {
		JOptionPane.showMessageDialog(mainF, string);
		
	}
	
	private void clearReg() {
		mainF.sellF.tfNo.setText("");
		mainF.sellF.cbBrand.setSelectedIndex(0);
		mainF.sellF.tfModel.setText("");
		mainF.sellF.tfYear.setText("");
		mainF.sellF.tfAcc.setText("");
		mainF.sellF.tfKm.setText("");
		mainF.sellF.tfPr.setText("");
		mainF.sellF.tfimagepath.setText("");
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}
	
	
}