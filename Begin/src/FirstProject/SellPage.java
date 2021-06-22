package FirstProject;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class SellPage extends JPanel {
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
	JLabel lbBrand, lbModel, lbLoc, lbDate, lbKm, lbPwd, lbDone;

	// TextField
	JTextField tfModel, tfLoc, tfDate, tfKm;
	JPasswordField tfPwd;

	// ComboBox
	JComboBox<String> cbBrand;
	String[] brand = { "----- �� �� -----", "����", "���" };

	// Vector ����
	Vector<Car> carVector = new Vector<>();

	// Car ���� ���� ���̺� �ε�
	ObjectOutputStream out;
	ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;

	public SellPage(MainFrame mainF) {
		this.mainF = mainF;
		setBackground(Color.white);
		add(pNorth, "North");
		add(pCenter, "Center");
		readFileCar("src/FirstProject/car.txt");

		// Panel

		// Label
		lbTop = new JLabel("", new ImageIcon("./pj_img/��ܹ�_�����ȱ�.png"), JLabel.CENTER);
		pNorth.add(lbTop);

		// Panel �ɼ�
		pNorth.setBackground(Color.white);
		pCenter.setBackground(Color.white);
		pCenter_C.setBackground(Color.white);
		pCenter_S.setBackground(Color.white);
		pCenter_W.setBackground(Color.white);
		pCenter_W_C.setBackground(Color.white);
		lbInfor = new JLabel("", new ImageIcon("./pj_img/�����������.png"), JLabel.CENTER);
		lbInfor.setFont(new Font("sans-serif", Font.BOLD, 18));

		lbDone = new JLabel("", new ImageIcon("./pj_img/�Ϸ�.png"), JLabel.CENTER);

		pCenter.add(lbInfor, "North");
		pCenter.add(pCenter_W, "West");
		pCenter.add(pCenter_C, "Center");
		pCenter.add(pCenter_S, "South");

		pCenter_W.setLayout(new GridLayout(0, 1, 5, 5));
		pCenter_C.setLayout(new GridLayout(0, 1, 5, 5));

		// pCenter_W.setBackground(Color.white);
		// pCenter_C.setBackground(Color.white);

		lbBrand = new JLabel("", new ImageIcon("./pj_img/�귣���.png"), JLabel.CENTER);
		lbModel = new JLabel("", new ImageIcon("./pj_img/�𵨸�.png"), JLabel.CENTER);
		lbLoc = new JLabel("", new ImageIcon("./pj_img/��������.png"), JLabel.CENTER);
		lbDate = new JLabel("", new ImageIcon("./pj_img/��������.png"), JLabel.CENTER);
		lbKm = new JLabel("", new ImageIcon("./pj_img/����Ÿ�.png"), JLabel.CENTER);
		lbPwd = new JLabel("", new ImageIcon("./pj_img/��й�ȣ1.png"), JLabel.CENTER);

		tfModel = new JTextField(20);
		tfLoc = new JTextField();
		tfDate = new JTextField();
		tfKm = new JTextField();
		tfPwd = new JPasswordField();

		cbBrand = new JComboBox<>(brand);

		pCenter_W.add(lbBrand);
		pCenter_W.add(lbModel);
		pCenter_W.add(lbLoc);
		pCenter_W.add(lbDate);
		pCenter_W.add(lbKm);
		pCenter_W.add(lbPwd);

		pCenter_W_C.setLayout(new FlowLayout(50, 50, 10));

		pCenter_W_C.add(cbBrand);

		pCenter_C.add(pCenter_W_C);
		pCenter_C.add(tfModel);
		pCenter_C.add(tfLoc);
		pCenter_C.add(tfDate);
		pCenter_C.add(tfKm);
		pCenter_C.add(tfPwd);
		pCenter_S.add(lbDone);

		/** SellHandler �ڵ鷯 ���� */
		SellHandler handler = new SellHandler(this);
		lbDone.addMouseListener(handler);

	}

	public void saveFileCar(String fileName) {
		try {
			fout = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fout);
			out.writeObject(mainF.carVector);
			out.flush();
			out.close();
			fout.close();
			System.out.println(fileName + "�� ���� �Ϸ�!");
			System.out.println(fileName + "�� ���� �Ϸ�!");
		} catch (IOException e) {
			System.out.println("���� ���� �� ���� �߻�: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void readFileCar(String fileName) {
		try {
			fin = new FileInputStream(fileName);
			in = new ObjectInputStream(fin);
			Object obj = in.readObject();
			mainF.carVector = (Vector<Car>) obj;
			System.out.println("���� ��ϵ� �ڵ��� ��: " + mainF.carVector.size());
		} catch (Exception e) {
			System.out.println("���� �д� �� ����: " + e.getMessage());
		}
	}// ----------------------------

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}
	
	/**����������� �� ��� �� �ʱ�ȭ*/
	public void clearCarInput() {
	 	cbBrand.setSelectedItem(brand[0]);
	 	tfModel.setText("");
		tfLoc.setText("");
		tfDate.setText("");
		tfKm.setText("");
		tfPwd.setText("");
		tfModel.requestFocus();
   }

	/** �˸�â showMsg() */
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(pCenter, message);
	}// ----------------------------------

	/** Car ������� */
	public void car() {
		String brand = cbBrand.getSelectedItem().toString();
		String model = tfModel.getText();
		String local = tfLoc.getText();
		String buydate = tfDate.getText();
		String km = tfKm.getText();
		char[] ch = tfPwd.getPassword();
		String pwd = new String(ch);

		// carTable Hashtable ���� ����
		Car car = new Car(brand, model, local, buydate, km, pwd);
		/** ���� üũ */
		if (brand.trim().equals("----- �� �� -----") || model.trim().equals("") || local.trim().equals("")
				|| buydate.trim().equals("") || km.trim().equals("") || pwd.trim().equals("")) {
			showMsg("��� ������ �Է��ϼ���.");
			return;
		} else {
			System.out.println("������� �Ϸ�! ���� ������: " + carVector.size() + "��");
			showMsg("����� �Ϸ�Ǿ����ϴ�!");
			mainF.carVector.add(car);
		}

		model = model.trim();
		local = local.trim();
		buydate = buydate.trim();
		km = km.trim();
		pwd = pwd.trim();

		System.out.println(brand);
		System.out.println(model);
		System.out.println(buydate);
		
        mainF.card.show(mainF.pCenter, "��������");
        mainF.buyF.showCarTable();

	}// ----------------------
	
	public void update(String[] str ) {
	      
	    cbBrand.setSelectedItem(str[0]);
	    
	    //JTextField tfModel, tfLoc, tfDate, tfKm;
	    tfModel.setText(str[1]);
	    tfLoc.setText(str[2]);
	    tfDate.setText(str[3]);
	    tfKm.setText(str[4]);
	    
	   }
}