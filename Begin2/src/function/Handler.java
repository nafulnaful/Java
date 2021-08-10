package function;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import ui.MainPanel;
/**핸들러*/
public class Handler extends MouseAdapter implements ActionListener {
	
	//62          행 71~89 수정, 행 110~117 수정
	
	
	
	
	
	MainPanel mp;
	Image img;//상품 이미지 사이즈 변경 x
	ImageIcon changeIcon;//48,48 사이즈변경 이미지 아이콘
	
	public Handler (MainPanel mp) {
		this.mp=mp;
		
	}
	

	public void actionPerformed(ActionEvent e) {
		//mp.setTitle("action");
		Object o=e.getSource();
		if(o==mp.joinP.btJoin) {
			mp.getJl().join();
		}else if(o==mp.joinP.btReset) {
			mp.getJl().clearJoinInput();
		}else if(o==mp.loginP.btLogin) {
			mp.loginP.loginCheck();
			try {
				mp.myP.lbName.setText(mp.Iam.getName()+" 님");//530d				
			}catch(NullPointerException e1) {
				
			}
			mp.pF.PeedUpdateUI(1);
		}else if(o==mp.loginP.btJoin) {
			mp.card.show(mp.pC, "join");		
		}else if(o==mp.productsP.btSell) {   //성근 
			mp.pF.addProduct();
		}else if(o==mp.myP.btUpdate) {//이 행부터
			mp.uf.showInfo();//529d
			mp.card.show(mp.pC, "my2");
		}else if(o==mp.myP.btLogout) {
			mp.card.show(mp.pC, "login");
			mp.isLogin=false;
			mp.loginP.tfId.setText("");
			mp.loginP.tfPwd.setText("");
			mp.loginP.tfId.requestFocus();
			mp.setTitle("::평화로운 중고나라::");//531d
			mp.lbMy.setText("로그인");
		}else if(o==mp.myP2.btUpdate) {
			mp.uf.UpdateInfo();//528d
			JOptionPane.showMessageDialog(mp.pC,"수정되었습니다.");
			mp.card.show(mp.pC, "my");
		}////여기까지 수정(다혜)
		else if(o==mp.homeP.bt_SearchPanel) {  //성근 5/30 		
		
			mp.pF.PeedUpdateUI(3);
		}
		else if(o==mp.myP2.btDel) {
			int result=JOptionPane.showConfirmDialog(mp.pC,"회원탈퇴 하시겠습니까?","회원탈퇴",JOptionPane.YES_NO_OPTION);
			if(result==0) {
				mp.isLogin=false;//봄 추가
				mp.setTitle("::평화로운 중고나라::");//봄 추가
				mp.lbMy.setText("로그인");
				mp.card.show(mp.pC,"login");
				mp.loginP.tfId.setText("");
				mp.loginP.tfPwd.setText("");
				mp.loginP.tfId.requestFocus();
				for(int i=0; i<mp.Iam.SallList.size();i++) {
					String name =mp.Iam.SallList.get(i);
					for(int j=0;j<mp.productsList2.size();j++) {
						if(mp.productsList2.get(j).key.equals(name)) {
							mp.productsList2.remove(j);
						}
					}
				}
				
				mp.userTable.remove(mp.Iam.getUserid());
				mp.myP.updateUI();		
			}else {
				
			}

		}
		
	}//-------------------------------
	

	@Override
	public void mousePressed(MouseEvent e) {
		//mp.setTitle("mouse");
		Object o=e.getSource();
		if(o==mp.lbHome) {
			mp.card.show(mp.pC, "home");
			mp.pF.PeedUpdateUI(1); //성근
		}else if(o==mp.lbProducts) {
			if(mp.isLogin==true) {
				mp.productsP.lb.setIcon(mp.productsP.pimage);
				mp.productsP.lb.setText("사진첨부");
				mp.card.show(mp.pC, "products");
			}else if(mp.isLogin==false) {
				mp.loginP.showMsg("로그인 하셔야 합니다.");
				mp.card.show(mp.pC, "login");
			}			
		}else if(o==mp.lbMy) {
			if(mp.isLogin==true) {
				mp.pF.PeedUpdateUI(2);
				mp.pF.PeedUpdateUI(4);
				mp.card.show(mp.pC, "my");
				mp.myP.updateUI();
			}else if(mp.isLogin==false) {
				mp.card.show(mp.pC, "login");
			}
		}else if(o==mp.productsP.lb) {
			mp.pF.addImage();
		}
		
	}

}
