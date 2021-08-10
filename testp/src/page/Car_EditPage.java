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

	JPanel pCenter_W = new JPanel(); // 차량정보~ 비밀번호
	JPanel pCenter_C = new JPanel(); // 내용
	JPanel pCenter_S = new JPanel(); // 완료
	JPanel pCenter_W_C = new JPanel(); // 차량정보, 콤보박스

	// Label
	JLabel lbWelcome, lbUserInfo, lbCarInfo, lbTalk, lbLogout;
	JLabel lbTop, lbShow, lbInfor;
	//라벨에 public 붙여야 다른 곳에서 이용이 가능
public JLabel lbNo, lbBrand, lbModel, lbYear, lbAcc, lbKm, lbPr, lbImg, lbOpen, lbDone;

	// TextField
	JTextField tfNo, tfModel, tfYear, tfAcc, tfKm, tfPr, tfImg;
	
	// ComboBox
	JComboBox<String> cbBrand;
	String[] brand = { "----- 선 택 -----", "현대", "기아" };
	
	//핸들러 
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
		lbTop = new JLabel("", new ImageIcon("src/images/상단바_내차팔기.png"), JLabel.CENTER);
		pNorth.add(lbTop);

		// Panel 옵션
		pNorth.setBackground(Color.white);
		pCenter.setBackground(Color.white);
		pCenter_C.setBackground(Color.white);
		pCenter_S.setBackground(Color.white);
		pCenter_W.setBackground(Color.white);
		pCenter_W_C.setBackground(Color.white);
		lbInfor = new JLabel("", new ImageIcon("src/images/차량정보등록.png"), JLabel.CENTER);
		lbInfor.setFont(new Font("sans-serif", Font.BOLD, 18));

		lbDone = new JLabel("", new ImageIcon("src/images/완료.png"), JLabel.CENTER);

		pCenter.add(lbInfor, "North");
		pCenter.add(pCenter_W, "West");
		pCenter.add(pCenter_C, "Center");
		pCenter.add(pCenter_S, "South");

		pCenter_W.setLayout(new GridLayout(0, 1, 5, 5));
		pCenter_C.setLayout(new GridLayout(0, 1, 5, 5));
		
		lbNo = new JLabel("", new ImageIcon("src/images/차량번호.png"), JLabel.CENTER);
		lbBrand = new JLabel("", new ImageIcon("src/images/브랜드명.png"), JLabel.CENTER);
		lbModel = new JLabel("", new ImageIcon("src/images/모델명.png"), JLabel.CENTER);
		lbYear = new JLabel("", new ImageIcon("src/images/연식.png"), JLabel.CENTER);
		lbAcc = new JLabel("", new ImageIcon("src/images/사고유무.png"), JLabel.CENTER);
		lbKm = new JLabel("", new ImageIcon("src/images/주행거리.png"), JLabel.CENTER);
		lbPr = new JLabel("", new ImageIcon("src/images/판매가격.png"), JLabel.CENTER);
		lbImg = new JLabel("", new ImageIcon("src/images/이미지.png"), JLabel.CENTER);
		
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

		/**텍스트필드 입력값 -> String*/
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
			
//			/**저장 완료 확인*/
//			int result = cardao.updateCar(cdb);
//			System.out.println(result);			
//			
			/**공백체크*/
			if(brand.trim().equals("----- 선 택 -----")||no==null||brand==null||model==null||year==null
				||acc==null||km==null||price==null||img==null||
				no.trim().isEmpty()||brand.trim().isEmpty()||model.trim().isEmpty()||
				year.trim().isEmpty()||acc.trim().isEmpty()||
				km.trim().isEmpty()||price.trim().isEmpty()||img.trim().isEmpty()) {
				showMsg("모든 정보를 입력하세요.");
				return;
//			}else if(result==1) {
//				showMsg("차량 수정이 완료되었습니다.");
//				mainF.card.show(mainF.pCenter, "내차구매"); //등록후 구매화면 띄움
//				clearReg();
//				mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
//				mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매선택.png"));
			}
			if(cdb==null) {
				System.out.println("cdb가 null인 상태입니다.");
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