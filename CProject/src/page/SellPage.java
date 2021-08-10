package page;

import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import handler.CardHandler;
import handler.LoginHandler;
import handler.SellHandler;

import db.*;
import exception.AuthenException;

public class SellPage extends JPanel {
   
   public ImageDB imgDB;
   public Image img;
   public ImageIcon changeIcon;
   public Image changeImg;
   public Image PanelImg;
   public Image detailImg;
   public Image mImg;
   public ImageIcon PanelIcon;
   public ImageIcon DetailIcon;
   public ImageIcon mIcon;
   
   
   MainFrame mainF;
   CarClient carclient;
   CardHandler ch;
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
   // 라벨에 public 붙여야 다른 곳에서 이용이 가능\

   // 파일 업로드 버튼////////////////////////////////////////////////#0705 재경
   JButton btChoose = new JButton("사진첨부");
   JLabel lbChoose = new JLabel("사진");
   JTextField tfimagepath = new JTextField();// 파일경로 보여주는 textfield
   JFileChooser jfc = new JFileChooser("C:\\MyJava\\Workspace\\CProject\\src\\images\\car");// 파일선택 다이얼로그
   File file = jfc.getSelectedFile();

   ///////////////////////////////////////////////////////////////////// #재경

   BufferedReader br;// #재경
   PrintWriter pw;// #재경
//   public HashMap<String, ImageDB> iDB= new HashMap<String, ImageDB>(); //이미지 저장을 위한 배열

   // #재경
   public JFrame popF = new JFrame(":::Emoticon:::");// #재경

   public JLabel lbNo, lbBrand, lbModel, lbYear, lbAcc, lbNone, lbKm, lbPr, lbImg, lbOpen, lbDone;
   public JLabel lbPhoto=new JLabel();
   // TextField
   public JTextField tfNo, tfModel, tfYear, tfAcc, tfKm, tfPr;

   // ComboBox
   JComboBox<String> cbBrand;

   String[] brand = { "----- 선 택 -----", "현대", "기아" };

   // 핸들러
   

   CarDB cdb = new CarDB();
   CarDAO cardao = new CarDAO();

   public SellPage(MainFrame mainF, CardHandler ch, CarClient car) {
      this.mainF = mainF;
      this.ch=ch;
      this.carclient=car;
      cardao = new CarDAO();
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

      lbNone = new JLabel("", JLabel.CENTER);// #재경
      tfimagepath.setEnabled(false);// #재경
      tfimagepath.setBackground(Color.white);// #재경

      tfNo = new JTextField(20);
      tfModel = new JTextField();
      tfYear = new JTextField();
      tfAcc = new JTextField();
      tfKm = new JTextField();
      tfPr = new JTextField();
      tfimagepath = new JTextField();
      tfimagepath.setEnabled(false);

      cbBrand = new JComboBox<>(brand);

      pCenter_W.add(lbNo);
      pCenter_W.add(lbBrand);
      pCenter_W.add(lbModel);
      pCenter_W.add(lbYear);
      pCenter_W.add(lbAcc);
      pCenter_W.add(lbKm);
      pCenter_W.add(lbPr);
      pCenter_W.add(lbImg);
//      pCenter_W.add(lbPhoto);// #재경
      pCenter_W.add(lbNone);// #재경

      pCenter_W_C.setLayout(new FlowLayout(50, 50, 7));

      pCenter_W_C.add(cbBrand);

      pCenter_C.add(tfNo);
      pCenter_C.add(pCenter_W_C);
      pCenter_C.add(tfModel);
      pCenter_C.add(tfYear);
      pCenter_C.add(tfAcc);
      pCenter_C.add(tfKm);
      pCenter_C.add(tfPr);

      pCenter_C.add(tfimagepath);// #재경
      pCenter_C.add(btChoose);// #재경

      pCenter_S.add(lbDone);

      SellHandler handler = new SellHandler(mainF);
      lbDone.addMouseListener(handler);
      btChoose.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btChooseActionPerformed(evt);
         }
      });
///////////////////////////////////////////////////////////////////////////////////

   }//생성자
   


   /** INSERT */
   public void carInsert() throws AuthenException {
	  String id = mainF.mypageF.lbWelcome.getText();
      String no = mainF.sellF.tfNo.getText();
      String brand = mainF.sellF.cbBrand.getSelectedItem().toString();
      String model = mainF.sellF.tfModel.getText();
      String year = mainF.sellF.tfYear.getText();
      String acc = mainF.sellF.tfAcc.getText();
      String km = mainF.sellF.tfKm.getText();
      String price = mainF.sellF.tfPr.getText();
      String img = mainF.sellF.tfimagepath.getText();
      try {
    	  
    	  CarDB cdb=new CarDB(300,id,no,brand,model,year,acc,km,price,img);
        
//         /** 차량번호 중복체크 */
//         if (!cardao.ExistCar(no)) {
//            showMsg(no + "은(는) 이미 등록된 차량입니다.");
//            return;
//         }
//
//         /** 저장 완료 확인 */
//         int result = cardao.insertCar(cdb);
//         System.out.println(result);

         /** 공백체크 */
         if (brand.trim().equals("----- 선 택 -----") || no == null || brand == null || model == null || year == null
               || acc == null || km == null || price == null || img == null || no.trim().isEmpty()
               || brand.trim().isEmpty() || model.trim().isEmpty() || year.trim().isEmpty() || acc.trim().isEmpty()
               || km.trim().isEmpty() || price.trim().isEmpty() || img.trim().isEmpty()) {
            showMsg("모든 정보를 입력하세요.");
            return;
//         } else if (result == 1) {
//        	ArrayList<CarDB> list=cardao.selectCar();
// 			mainF.buyF.showItem(list);
//            showMsg("차량 등록이 완료되었습니다.");
//            mainF.card.show(mainF.pCenter, "내차구매"); // 등록후 구매화면 띄움
//            clearReg();
//            mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
//            mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매선택.png"));
         }
         if(cdb==null) {
        	 System.out.println("cdb가 널 입니다.");
         }
         System.out.println(cdb.getCarNo()+"/"+cdb.getCarBrand());
         Response(cdb);
      } catch (Exception e) {
         System.out.println(e.toString());
      }

   }// carInsert()----------

   public void Response(CarDB cdb2) {
	try {
		System.out.println(cdb2.getCode()+"||"+cdb2.getCarNo());
		carclient.out.writeObject(cdb2);
		carclient.out.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
}



/** 열기 버튼 이벤트 */
   public void btChooseActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btOpenActionPerformed
      int n = jfc.showOpenDialog(this);
      if (n == JFileChooser.APPROVE_OPTION) {
         File file = jfc.getSelectedFile();//
         if (file == null)
            return;
         String path = file.getAbsolutePath();
         tfimagepath.setText(path);
         readFile(path);

         Container cp = popF.getContentPane();
         lbPhoto = new JLabel("", new ImageIcon(path), JLabel.CENTER);
         cp.add(lbPhoto);
         
         cp.setLayout(getLayout());//         
         // #재경-------------------------------
         popF.pack();
         popF.setLocation(this.getWidth(), 0);
         popF.setVisible(true);
         // #재경--------------------------------
      }
   }


   public void readFile(String path) {
      try {
         // path와 --> 노드스트림 --> BufferedReader로 필터링

         br = new BufferedReader(new FileReader(path));
//            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));// 브릿지 스트림의 장점 :InputsteamReader 인코딩방식을 지정할 수 있다.
         String line = "";

         // 반복문 돌면서 line단위로 읽어서 ta에 append

         br.close();

      } catch (IOException e) {
         showMsg(e.getMessage());
      }

   }// -------------------------------------------------------------

   private void showMsg(String string) {
      JOptionPane.showMessageDialog(mainF, string);

   }

   public void clearReg() {
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

	/** SELECT */
	public void carSelect() throws AuthenException {
		
		try {
			
			/**저장 완료 확인*/
			ArrayList<CarDB> list = cardao.selectCar();
			System.out.println(list);		
	  
			 			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}//carSelect()----------------
	
	
}