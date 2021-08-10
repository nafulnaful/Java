package page;

import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import handler.EditHandler;
import handler.LoginHandler;
import handler.SellHandler;
import db.*;
import exception.AuthenException;

public class Car_EditPage extends JPanel {
   
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
   // Panel
   JPanel pNorth = new JPanel(new GridLayout(1, 0));
   JPanel pCenter = new JPanel(new BorderLayout(10, 10));

   JPanel pCenter_W = new JPanel(); // ��������~ ��й�ȣ
   JPanel pCenter_C = new JPanel(); // ����
   JPanel pCenter_S = new JPanel(); // �Ϸ�
   JPanel pCenter_W_C = new JPanel(); // ��������, �޺��ڽ�

   // Label
   JLabel lbWelcome, lbUserInfo, lbCarInfo, lbTalk, lbLogout;
   JLabel lbTop, lbShow, lbInfor;

   // ���� ���ε� ��ư////////////////////////////////////////////////#0705 ���
   JButton btChoose = new JButton("�̹���÷��");
   JLabel lbChoose = new JLabel("����");
   public JTextField tfImg = new JTextField();// ���ϰ�� �����ִ� textfield
   JFileChooser jfc = new JFileChooser("src/images/car");// ���ϼ��� ���̾�α�
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

   CarDB cdb = new CarDB();
   CarDAO cardao = new CarDAO();

   public Car_EditPage(MainFrame mainF ) {
      this.mainF = mainF;
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
      tfImg.setEnabled(false);// #���
      tfImg.setBackground(Color.white);// #���

      tfNo = new JTextField(20);
      tfModel = new JTextField(20);
      tfYear = new JTextField(20);
      tfAcc = new JTextField(20);
      tfKm = new JTextField(20);
      tfPr = new JTextField(20);
      tfImg = new JTextField(20);
      tfNo.setEnabled(false);
      tfImg.setEnabled(false);

      cbBrand = new JComboBox<>(brand);

      pCenter_W.add(lbNo);
      pCenter_W.add(lbBrand);
      pCenter_W.add(lbModel);
      pCenter_W.add(lbYear);
      pCenter_W.add(lbAcc);
      pCenter_W.add(lbKm);
      pCenter_W.add(lbPr);
      pCenter_W.add(lbImg);
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

      pCenter_C.add(tfImg);
      pCenter_C.add(btChoose);

      pCenter_S.add(lbDone);

      SellHandler handler = new SellHandler(mainF);
      lbDone.addMouseListener(handler);
      btChoose.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btChooseActionPerformed(evt);
         }
      });
      
      /** EditHandler �ڵ鷯 ���� */
      EditHandler handlerE=new EditHandler(mainF);
      lbDone.addMouseListener(handlerE);

   }
////////////////////////////////////////////////////////////////[GUI]////////////	

	/** UPDATE */
	public void carUpdate() {
		/** �ؽ�Ʈ�ʵ� �Է°� -> String */
		String id = mainF.mypageF.lbWelcome.getText();
		String no = tfNo.getText();
	    String brand = mainF.ceditF.cbBrand.getSelectedItem().toString();
		String model = tfModel.getText();
		String year = tfYear.getText();
		String acc = tfAcc.getText();
		String km = tfKm.getText();
		String price = tfPr.getText();
		String img = tfImg.getText();

		CarDB cardb=new CarDB(400,id,no,brand,model,year,acc,km,price,img);

			/** ����üũ */
			if (brand.equals("----- �� �� -----") || no == null || brand == null || model == null || year == null
					|| acc == null || km == null || price == null || img == null || no.trim().isEmpty()
					|| brand.trim().isEmpty() || model.trim().isEmpty() || year.trim().isEmpty() || acc.trim().isEmpty()
					|| km.trim().isEmpty() || price.trim().isEmpty() || img.trim().isEmpty()) {
				showMsg("��� ������ �Է��ϼ���.");
				return;
			}
	mainF.sellF.Response(cardb);	
		
	}// userInsert()----------------

	public void showInfo(ArrayList<CarDB> list) {

		if (list == null) {
			System.out.println("list null");
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			tfNo.setText(list.get(i).getCarNo());
			tfYear.setText(list.get(i).getCarYear());
			tfModel.setText(list.get(i).getCarModel());
			tfAcc.setText(list.get(i).getCarAcc());
			tfKm.setText(list.get(i).getCarKm());
			tfPr.setText(list.get(i).getCarPrice());
			tfImg.setText(list.get(i).getCarImg());

		}

		this.updateUI();
		this.validate();

	}
	
	   /** ���� ��ư �̺�Ʈ */
	   public void btChooseActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btOpenActionPerformed
	      int n = jfc.showOpenDialog(this);
	      if (n == JFileChooser.APPROVE_OPTION) {
	         File file = jfc.getSelectedFile();
	         if (file == null)
	            return;
	         String path = file.getAbsolutePath();
	         tfImg.setText(path);
	         readFile(path);

	         Container cp = popF.getContentPane();
	         lbPhoto = new JLabel("", new ImageIcon(path), JLabel.CENTER);
	         cp.add(lbPhoto);
	         
	         cp.setLayout(getLayout());
	      }
	   }


	   public void readFile(String path) {
	      try {
	         // path�� --> ��彺Ʈ�� --> BufferedReader�� ���͸�

	         br = new BufferedReader(new FileReader(path));
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
		tfNo.setText("");
		cbBrand.setSelectedIndex(0);
		tfModel.setText("");
		tfYear.setText("");
		tfAcc.setText("");
		tfKm.setText("");
		tfPr.setText("");
		tfImg.setText("");
	}

	@Override
	public Insets getInsets() {
		return new Insets(0, 30, 20, 30);
	}

}