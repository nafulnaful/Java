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

	JPanel pCenter_W = new JPanel(); // 차량정보~ 비밀번호
	JPanel pCenter_C = new JPanel(); // 내용
	JPanel pCenter_S = new JPanel(); // 완료
	JPanel pCenter_W_C = new JPanel(); // 차량정보, 콤보박스

	// Label
	JLabel lbWelcome, lbUserInfo, lbCarInfo, lbTalk, lbLogout;
	JLabel lbTop, lbShow, lbInfor;
	JLabel lbBrand, lbModel, lbLoc, lbDate, lbKm, lbPwd, lbDone;

	// TextField
	JTextField tfModel, tfLoc, tfDate, tfKm;
	JPasswordField tfPwd;

	// ComboBox
	JComboBox<String> cbBrand;
	String[] brand = { "----- 선 택 -----", "현대", "기아" };

	// Vector 정보
	Vector<Car> carVector = new Vector<>();

	// Car 정보 파일 세이브 로드
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
		lbTop = new JLabel("", new ImageIcon("./pj_img/상단바_내차팔기.png"), JLabel.CENTER);
		pNorth.add(lbTop);

		// Panel 옵션
		pNorth.setBackground(Color.white);
		pCenter.setBackground(Color.white);
		pCenter_C.setBackground(Color.white);
		pCenter_S.setBackground(Color.white);
		pCenter_W.setBackground(Color.white);
		pCenter_W_C.setBackground(Color.white);
		lbInfor = new JLabel("", new ImageIcon("./pj_img/차량정보등록.png"), JLabel.CENTER);
		lbInfor.setFont(new Font("sans-serif", Font.BOLD, 18));

		lbDone = new JLabel("", new ImageIcon("./pj_img/완료.png"), JLabel.CENTER);

		pCenter.add(lbInfor, "North");
		pCenter.add(pCenter_W, "West");
		pCenter.add(pCenter_C, "Center");
		pCenter.add(pCenter_S, "South");

		pCenter_W.setLayout(new GridLayout(0, 1, 5, 5));
		pCenter_C.setLayout(new GridLayout(0, 1, 5, 5));

		// pCenter_W.setBackground(Color.white);
		// pCenter_C.setBackground(Color.white);

		lbBrand = new JLabel("", new ImageIcon("./pj_img/브랜드명.png"), JLabel.CENTER);
		lbModel = new JLabel("", new ImageIcon("./pj_img/모델명.png"), JLabel.CENTER);
		lbLoc = new JLabel("", new ImageIcon("./pj_img/거주지역.png"), JLabel.CENTER);
		lbDate = new JLabel("", new ImageIcon("./pj_img/구매일자.png"), JLabel.CENTER);
		lbKm = new JLabel("", new ImageIcon("./pj_img/주행거리.png"), JLabel.CENTER);
		lbPwd = new JLabel("", new ImageIcon("./pj_img/비밀번호1.png"), JLabel.CENTER);

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

		/** SellHandler 핸들러 부착 */
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
			System.out.println(fileName + "에 저장 완료!");
			System.out.println(fileName + "에 저장 완료!");
		} catch (IOException e) {
			System.out.println("파일 저장 중 에러 발생: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void readFileCar(String fileName) {
		try {
			fin = new FileInputStream(fileName);
			in = new ObjectInputStream(fin);
			Object obj = in.readObject();
			mainF.carVector = (Vector<Car>) obj;
			System.out.println("현재 등록된 자동차 수: " + mainF.carVector.size());
		} catch (Exception e) {
			System.out.println("파일 읽는 중 에러: " + e.getMessage());
		}
	}// ----------------------------

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}
	
	/**차량정보등록 시 모든 값 초기화*/
	public void clearCarInput() {
	 	cbBrand.setSelectedItem(brand[0]);
	 	tfModel.setText("");
		tfLoc.setText("");
		tfDate.setText("");
		tfKm.setText("");
		tfPwd.setText("");
		tfModel.requestFocus();
   }

	/** 알림창 showMsg() */
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(pCenter, message);
	}// ----------------------------------

	/** Car 정보등록 */
	public void car() {
		String brand = cbBrand.getSelectedItem().toString();
		String model = tfModel.getText();
		String local = tfLoc.getText();
		String buydate = tfDate.getText();
		String km = tfKm.getText();
		char[] ch = tfPwd.getPassword();
		String pwd = new String(ch);

		// carTable Hashtable 정보 저장
		Car car = new Car(brand, model, local, buydate, km, pwd);
		/** 공백 체크 */
		if (brand.trim().equals("----- 선 택 -----") || model.trim().equals("") || local.trim().equals("")
				|| buydate.trim().equals("") || km.trim().equals("") || pwd.trim().equals("")) {
			showMsg("모든 정보를 입력하세요.");
			return;
		} else {
			System.out.println("차량등록 완료! 현재 차량수: " + carVector.size() + "대");
			showMsg("등록이 완료되었습니다!");
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
		
        mainF.card.show(mainF.pCenter, "내차구매");
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