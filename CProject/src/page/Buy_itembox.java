package page;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import db.CarDAO;
import db.CarDB;
import exception.AuthenException;

public class Buy_itembox extends javax.swing.JPanel {

	MainFrame mainF;
	
    public Buy_itembox(MainFrame mainF) {
		this.mainF = mainF;
        initComponents();
    }

    @SuppressWarnings("unchecked")                        
    private void initComponents() {

        pBox = new javax.swing.JPanel();
        lbImg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbNo = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        lbAcc = new javax.swing.JLabel();
        lbYear = new javax.swing.JLabel();
        lbKm = new javax.swing.JLabel();
        lbPr = new javax.swing.JLabel();
        lbModel = new javax.swing.JLabel();

        pBox.setBackground(new java.awt.Color(255, 255, 255));
        pBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pBox.setPreferredSize(new java.awt.Dimension(334, 184));
        pBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pBoxMousePressed(evt);
            }
        });

        lbImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 108, 254), 3, true));
        lbImg.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel3.setIcon(new javax.swing.ImageIcon("src/images/lbOption.png")); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("src/images/lbOption2.png")); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon("src/images/lbOption3.png")); // NOI18N

        lbNo.setFont(new java.awt.Font("돋움", 0, 14)); // NOI18N

        lbBrand.setFont(new java.awt.Font("돋움", 0, 14)); // NOI18N

        lbAcc.setFont(new java.awt.Font("돋움", 0, 14)); // NOI18N

        lbYear.setFont(new java.awt.Font("돋움", 0, 14)); // NOI18N

        lbKm.setFont(new java.awt.Font("돋움", 0, 14)); // NOI18N

        lbPr.setFont(new java.awt.Font("돋움", 3, 20)); // NOI18N
        lbPr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPr.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbModel.setBackground(new java.awt.Color(162, 108, 254));
        lbModel.setFont(new java.awt.Font("HY헤드라인M", 0, 21)); // NOI18N
        lbModel.setForeground(new java.awt.Color(255, 255, 255));
        lbModel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbModel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbModel.setOpaque(true);

        javax.swing.GroupLayout pBoxLayout = new javax.swing.GroupLayout(pBox);
        pBox.setLayout(pBoxLayout);
        pBoxLayout.setHorizontalGroup(
            pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBoxLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbImg, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(lbModel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pBoxLayout.createSequentialGroup()
                        .addComponent(lbPr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(pBoxLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pBoxLayout.createSequentialGroup()
                                .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbAcc, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                        .addComponent(lbKm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lbYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2)
                                .addContainerGap())
                            .addGroup(pBoxLayout.createSequentialGroup()
                                .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))))))
        );
        pBoxLayout.setVerticalGroup(
            pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBoxLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pBoxLayout.createSequentialGroup()
                            .addComponent(lbNo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbBrand)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pBoxLayout.createSequentialGroup()
                                    .addComponent(lbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbAcc)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbKm))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(pBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbPr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbModel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBox, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, Short.MAX_VALUE)
        );

    }// </editor-fold>                        
    
    /**내차구매페이지 라벨 버튼 눌렀을때 작동하는 기능 */
    public void pBoxMousePressed(java.awt.event.MouseEvent evt) {
    	
    		Object obj=evt.getSource();
    		if(obj==mainF.cinfoF.by.pBox) {
    			System.out.println("제발");
    			
    		}
			
			Buy_itembox by=(Buy_itembox) ((JPanel)obj).getParent();

			String no=by.lbNo.getText();
			String id=mainF.mypageF.lbWelcome.getText();
			String Acc=by.lbAcc.getText();
			String year=by.lbYear.getText();
			String km=by.lbKm.getText();
			String pr=by.lbPr.getText();
			String model=by.lbModel.getText();
			String brand=by.lbBrand.getText();
			String img=by.lbImg.getText().toString();
			
			mainF.ceditF.clearReg();
			
			mainF.ceditF.tfNo.setText(no);
			mainF.ceditF.tfAcc.setText(Acc);
			mainF.ceditF.tfYear.setText(year);
			mainF.ceditF.tfKm.setText(km);
			mainF.ceditF.tfPr.setText(pr);
			mainF.ceditF.tfModel.setText(model);
			mainF.ceditF.tfImg.setText(img);
			
			mainF.infoF.lbNo.setText(no);
			mainF.infoF.lbBrand.setText(brand);
			mainF.infoF.lbModel.setText(model);
			mainF.infoF.lbYear.setText(year);
			mainF.infoF.lbPr.setText(pr);
			mainF.infoF.lbAcc.setText(Acc);
			mainF.infoF.lbKm.setText(km);
			mainF.infoF.lbImg.setText(img);
			
			
			mainF.card.show(mainF.pCenter, "차량정보조회");
			
    }                                 


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Buy_itembox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buy_itembox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buy_itembox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buy_itembox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

	/** 찜하기 */
	   public void carLikeExist() throws AuthenException {
//		  CarDB car = new CarDB();
//	      try {
//	         /** 차량번호 중복체크 */
////	         if (!cardao.likeExistCar(mainF.mypageF.lbWelcome.getText(), lbNo.getText())) {
//	            mainF.infoF.lbLike.setIcon(new ImageIcon("src/images/차량정보_찜하기1.png"));
//	            return;
//	         } else if (cardao.likeExistCar(mainF.mypageF.lbWelcome.getText(), lbNo.getText())) {
//			 mainF.infoF.lbLike.setIcon(new ImageIcon("src/images/차량정보_찜하기.png"));
//	         }
//	      } catch (Exception e) {
//	         e.printStackTrace();
//	      }

	   }// carLike()----------

    // Variables declaration - do not modify                     
    public javax.swing.JLabel lbImg;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel lbAcc;
    public javax.swing.JLabel lbBrand;
    public javax.swing.JLabel lbKm;
    public javax.swing.JLabel lbModel;
    public javax.swing.JLabel lbNo;
    public javax.swing.JLabel lbPr;
    public javax.swing.JLabel lbYear;
    public javax.swing.JPanel pBox;
    // End of variables declaration                   
}
