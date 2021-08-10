package page;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import db.CarDAO;
import db.CarDB;
import db.UserDB;
import exception.AuthenException;

public class Buy_info extends javax.swing.JPanel {
	MainFrame mainF;
	CarDB cdb = new CarDB();
	CarDAO cardao = new CarDAO();
	UserDB userID;//[1]

	public Buy_info(MainFrame mainF) {
		this.mainF = mainF;
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		lbImg = new javax.swing.JLabel();
		lbEdit = new javax.swing.JLabel();
		lbDel = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		lbLike = new javax.swing.JLabel();
		lbChat = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		lbNo = new javax.swing.JLabel();
		lbModel = new javax.swing.JLabel();
		lbYear = new javax.swing.JLabel();
		lbAcc = new javax.swing.JLabel();
		lbKm = new javax.swing.JLabel();
		lbPr = new javax.swing.JLabel();
		lbBrand = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(410, 649));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jLabel2.setBackground(new java.awt.Color(162, 108, 254));
		jLabel2.setIcon(new javax.swing.ImageIcon("src/images/상단바_차량정보.png")); // NOI18N
		jLabel2.setOpaque(true);

		lbImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		lbEdit.setIcon(new javax.swing.ImageIcon("src/images/수정.png")); // NOI18N
		lbEdit.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				lbEditMousePressed(evt);
			}
		});

		lbDel.setIcon(new javax.swing.ImageIcon("src/images/삭제.png")); // NOI18N
		lbDel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				lbDelMousePressed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20)
						.addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 314,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbEdit, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lbDel, javax.swing.GroupLayout.Alignment.TRAILING))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbImg, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4)
										.addComponent(lbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(lbDel, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setIcon(new javax.swing.ImageIcon("src/images/차량정보_1.png")); // NOI18N

		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setIcon(new javax.swing.ImageIcon("src/images/차량정보_3.png")); // NOI18N

		jLabel5.setIcon(new javax.swing.ImageIcon("src/images/차량정보_4.png")); // NOI18N

		jLabel6.setIcon(new javax.swing.ImageIcon("src/images/차량정보_7.png")); // NOI18N

		jLabel7.setIcon(new javax.swing.ImageIcon("src/images/차량정보_6.png")); // NOI18N

		lbLike.setIcon(new javax.swing.ImageIcon("src/images/차량정보_찜하기.png")); // NOI18N
		lbLike.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				lbLikeMousePressed(evt);
			}
		});

		lbChat.setIcon(new javax.swing.ImageIcon("src/images/차량정보_채팅거래.png")); // NOI18N
		lbChat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				lbChatMousePressed(evt);
			}
		});

		jLabel10.setIcon(new javax.swing.ImageIcon("src/images/차량정보_5.png")); // NOI18N
		jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

		lbNo.setFont(new java.awt.Font("돋움", 0, 16)); // NOI18N
		lbNo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

		lbModel.setFont(new java.awt.Font("돋움", 1, 16)); // NOI18N
		lbModel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

		lbYear.setFont(new java.awt.Font("돋움", 0, 16)); // NOI18N
		lbYear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

		lbAcc.setFont(new java.awt.Font("돋움", 0, 16)); // NOI18N
		lbAcc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

		lbKm.setFont(new java.awt.Font("돋움", 0, 16)); // NOI18N
		lbKm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

		lbPr.setFont(new java.awt.Font("돋움", 1, 16)); // NOI18N
		lbPr.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

		lbBrand.setFont(new java.awt.Font("돋움", 0, 16)); // NOI18N
		lbBrand.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(jPanel3Layout.createSequentialGroup().addComponent(lbLike)
												.addGap(97, 97, 97).addComponent(lbChat))
										.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel6)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel3Layout.createSequentialGroup()
																.addGroup(jPanel3Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(lbAcc,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(lbKm,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(lbPr,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(lbNo,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(lbYear,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(jPanel3Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(jPanel3Layout.createSequentialGroup()
																				.addComponent(jLabel7)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(lbBrand,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						62,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addComponent(jLabel10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				96,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(lbModel, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel5)))
						.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel4)
								.addGroup(jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabel6)
												.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel3Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(jLabel7,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(lbBrand,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
														.addComponent(lbNo, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(lbModel, javax.swing.GroupLayout.PREFERRED_SIZE,
																30, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(jPanel3Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(jPanel3Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																		.addGroup(jPanel3Layout.createSequentialGroup()
																				.addComponent(lbYear,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						25,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(10, 10, 10)
																				.addComponent(lbAcc,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						27,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(lbKm,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						29,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(38, 38, 38))
																		.addComponent(jLabel10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				140,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(jPanel3Layout.createSequentialGroup()
																		.addGap(117, 117, 117).addComponent(lbPr,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				29,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGap(0, 0, Short.MAX_VALUE)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lbLike).addComponent(lbChat))
												.addGap(33, 33, 33))
										.addComponent(jLabel5)))
						.addContainerGap(31, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel3,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

	}// </editor-fold>

	private void lbLikeMousePressed(java.awt.event.MouseEvent evt) {
		try {
			mainF.likeF.likecar();
			System.out.println("찜하기버튼");
		} catch (Exception e1) {
			System.out.println("차량찜 예외:" + e1.getMessage());
			e1.printStackTrace();
		}
	}

	private void lbChatMousePressed(java.awt.event.MouseEvent evt) {
		System.out.println("채팅거래");
	}

	private void lbEditMousePressed(java.awt.event.MouseEvent evt) {
		carEdit();
	}


	private void lbDelMousePressed(java.awt.event.MouseEvent evt) {
			carDel();
	}

	///////////////////// 이벤트 핸들러 끝///////////////////////////////
	
	/** 수정하기 */
	public void carEdit() {
		String id = mainF.mypageF.lbWelcome.getText();
		String no = lbNo.getText();

		int Con = JOptionPane.showConfirmDialog(this, "정말 수정하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
		if (Con == JOptionPane.YES_OPTION) {
		CarDB cardb=new CarDB(450,no,id);
		mainF.sellF.Response(cardb);
		mainF.card.show(mainF.pCenter,"차량정보수정");
		}
		
	}

	/** 삭제하기 */
	private void carDel() {
		String id = mainF.mypageF.lbWelcome.getText();
		String no = lbNo.getText();
		System.out.println("buy_info: "+id+"||"+no);
		int Con = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
		if(Con == JOptionPane.YES_OPTION) {
		CarDB cardb=new CarDB(410,no);
		mainF.sellF.Response(cardb);
		}
	}
	
	private String url = "";
	
	public void clearReg() {
		lbNo.setText("");
		lbBrand.setText("");
		lbModel.setText("");
		lbYear.setText("");
		lbAcc.setText("");
		lbKm.setText("");
		lbPr.setText("");
		lbImg.setText("");
	}
	
	public void removeItem(ArrayList<CarDB> list) {
		ArrayList<CarDAO> cararr = new ArrayList<CarDAO>();
		if(cararr.size()>0) {
			if(cararr.size()==0) return;
			list = null;
		}
		list.clear();
	}
	
	
	/** 상세정보 보여주기 */
	public void showInfo(ArrayList<CarDB> list) {

		if (list == null) {
			System.out.println("list null");
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			
			
			lbNo.setText(list.get(i).getCarNo());
			lbBrand.setText(list.get(i).getCarBrand());
			lbModel.setText(list.get(i).getCarModel());
			lbYear.setText(list.get(i).getCarYear());
			lbAcc.setText(list.get(i).getCarAcc());
			lbKm.setText(list.get(i).getCarKm());
			lbPr.setText(list.get(i).getCarPrice());
			lbImg.setIcon(new ImageIcon(list.get(i).getCarImg()));
			url = list.get(i).getCarImg();
		}

		jPanel1.updateUI();
		jPanel1.validate();
		jPanel3.updateUI();
		jPanel3.validate();

	}

	private void showMsg(String string) {
		JOptionPane.showMessageDialog(mainF, string);

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Window".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Buy_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Buy_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Buy_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Buy_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

	}/////////////////////

	// Variables declaration - do not modify
	public javax.swing.JLabel jLabel1;
	public javax.swing.JLabel jLabel10;
	public javax.swing.JLabel lbAcc;
	public javax.swing.JLabel jLabel2;
	public javax.swing.JLabel jLabel4;
	public javax.swing.JLabel jLabel5;
	public javax.swing.JLabel jLabel6;
	public javax.swing.JLabel jLabel7;
	public javax.swing.JLabel lbLike;
	public javax.swing.JLabel lbChat;
	public javax.swing.JPanel jPanel1;
	public javax.swing.JPanel jPanel3;
	public javax.swing.JLabel lbBrand;
	public javax.swing.JLabel lbDel;
	public javax.swing.JLabel lbEdit;
	public javax.swing.JLabel lbImg;
	public javax.swing.JLabel lbKm;
	public javax.swing.JLabel lbModel;
	public javax.swing.JLabel lbNo;
	public javax.swing.JLabel lbPr;
	public javax.swing.JLabel lbYear;
	// End of variables declaration
}
