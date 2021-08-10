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

   JPanel pCenter_W = new JPanel(); // ��������~ ��й�ȣ
   JPanel pCenter_C = new JPanel(); // ����
   JPanel pCenter_S = new JPanel(); // �Ϸ�
   JPanel pCenter_W_C = new JPanel(); // ��������, �޺��ڽ�

   // Label
   JLabel lbWelcome, lbUserInfo, lbCarInfo, lbTalk, lbLogout;
   JLabel lbTop, lbShow, lbInfor;
   // �󺧿� public �ٿ��� �ٸ� ������ �̿��� ����\

   // ���� ���ε� ��ư////////////////////////////////////////////////#0705 ���
   JButton btChoose = new JButton("����÷��");
   JLabel lbChoose = new JLabel("����");
   JTextField tfimagepath = new JTextField();// ���ϰ�� �����ִ� textfield
   JFileChooser jfc = new JFileChooser("C:\\MyJava\\Workspace\\CProject\\src\\images\\car");// ���ϼ��� ���̾�α�
   File file = jfc.getSelectedFile();

   ///////////////////////////////////////////////////////////////////// #���

   BufferedReader br;// #���
   PrintWriter pw;// #���
//   public HashMap<String, ImageDB> iDB= new HashMap<String, ImageDB>(); //�̹��� ������ ���� �迭

   // #���
   public JFrame popF = new JFrame(":::Emoticon:::");// #���

   public JLabel lbNo, lbBrand, lbModel, lbYear, lbAcc, lbNone, lbKm, lbPr, lbImg, lbOpen, lbDone;
   public JLabel lbPhoto=new JLabel();
   // TextField
   public JTextField tfNo, tfModel, tfYear, tfAcc, tfKm, tfPr;

   // ComboBox
   JComboBox<String> cbBrand;

   String[] brand = { "----- �� �� -----", "����", "���" };

   // �ڵ鷯
   

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

      lbNone = new JLabel("", JLabel.CENTER);// #���
      tfimagepath.setEnabled(false);// #���
      tfimagepath.setBackground(Color.white);// #���

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
//      pCenter_W.add(lbPhoto);// #���
      pCenter_W.add(lbNone);// #���

      pCenter_W_C.setLayout(new FlowLayout(50, 50, 7));

      pCenter_W_C.add(cbBrand);

      pCenter_C.add(tfNo);
      pCenter_C.add(pCenter_W_C);
      pCenter_C.add(tfModel);
      pCenter_C.add(tfYear);
      pCenter_C.add(tfAcc);
      pCenter_C.add(tfKm);
      pCenter_C.add(tfPr);

      pCenter_C.add(tfimagepath);// #���
      pCenter_C.add(btChoose);// #���

      pCenter_S.add(lbDone);

      SellHandler handler = new SellHandler(mainF);
      lbDone.addMouseListener(handler);
      btChoose.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btChooseActionPerformed(evt);
         }
      });
///////////////////////////////////////////////////////////////////////////////////

   }//������
   


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
        
//         /** ������ȣ �ߺ�üũ */
//         if (!cardao.ExistCar(no)) {
//            showMsg(no + "��(��) �̹� ��ϵ� �����Դϴ�.");
//            return;
//         }
//
//         /** ���� �Ϸ� Ȯ�� */
//         int result = cardao.insertCar(cdb);
//         System.out.println(result);

         /** ����üũ */
         if (brand.trim().equals("----- �� �� -----") || no == null || brand == null || model == null || year == null
               || acc == null || km == null || price == null || img == null || no.trim().isEmpty()
               || brand.trim().isEmpty() || model.trim().isEmpty() || year.trim().isEmpty() || acc.trim().isEmpty()
               || km.trim().isEmpty() || price.trim().isEmpty() || img.trim().isEmpty()) {
            showMsg("��� ������ �Է��ϼ���.");
            return;
//         } else if (result == 1) {
//        	ArrayList<CarDB> list=cardao.selectCar();
// 			mainF.buyF.showItem(list);
//            showMsg("���� ����� �Ϸ�Ǿ����ϴ�.");
//            mainF.card.show(mainF.pCenter, "��������"); // ����� ����ȭ�� ���
//            clearReg();
//            mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
//            mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_�������ż���.png"));
         }
         if(cdb==null) {
        	 System.out.println("cdb�� �� �Դϴ�.");
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



/** ���� ��ư �̺�Ʈ */
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
         // #���-------------------------------
         popF.pack();
         popF.setLocation(this.getWidth(), 0);
         popF.setVisible(true);
         // #���--------------------------------
      }
   }


   public void readFile(String path) {
      try {
         // path�� --> ��彺Ʈ�� --> BufferedReader�� ���͸�

         br = new BufferedReader(new FileReader(path));
//            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));// �긴�� ��Ʈ���� ���� :InputsteamReader ���ڵ������ ������ �� �ִ�.
         String line = "";

         // �ݺ��� ���鼭 line������ �о ta�� append

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
			
			/**���� �Ϸ� Ȯ��*/
			ArrayList<CarDB> list = cardao.selectCar();
			System.out.println(list);		
	  
			 			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}//carSelect()----------------
	
	
}