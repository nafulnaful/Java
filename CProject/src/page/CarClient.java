package page;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import db.CarDB;
import db.UserDB;

public class CarClient implements Runnable {
	public Socket sock;
	private Thread listener;
	static final int PORT = 9999;
	private String host = "localhost";
	public ObjectOutputStream out;
	public ObjectInputStream in;
	public boolean isStop;
	page.JoinPage joinPage;
	page.MainFrame mainF;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public CarClient(MainFrame mainF) {
		this.mainF=mainF;
		try {//소켓
			sock = new Socket(host, PORT);
			System.err.println("클-서버 연결 성공");
			
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			if(listener==null) {
			listener = new Thread(this);
			listener.start();
			}
		}catch(Exception e) {
			System.out.println("클-소켓 에러");
		}
	}

	@Override
	public void run() {
		Object obj;
		
		try {
			while((obj = in.readObject())!=null||!isStop) {
				//서버핸들러 코드번호 600에서 보내온 list를 gui에서 구현.
				if(obj instanceof ArrayList) {
					ArrayList<CarDB> list=(ArrayList<CarDB>) obj;
   					mainF.buyF.contentsBox.removeAll();
					mainF.cinfoF.contentsBox.removeAll();
					
					
					System.out.println(list);
					
					mainF.buyF.showItem(list);
					mainF.cinfoF.showItem(list);
					
//					mainF.infoF.showInfo(list);
//					mainF.infoF.clearReg();
					
					
					
				}
				if(obj instanceof Vector) {
					Vector<UserDB> list=(Vector<UserDB>) obj;
					mainF.ueditF.showInfo(list);
				
				}
				if(obj instanceof String) {
					String response =(String) obj;
					switch (response) {
					case "가입완료":{
						System.out.println("클라이언트까지 넘어옴");
						mainF.card.show(mainF.pCenter, "로그인");
						showMsg("회원가입 성공");
					}break;
					case "가입실패":{
						showMsg("회원가입 실패");
					}break;
					case "로그인완료":{
						showMsg("로그인 성공");
						mainF.card.show(mainF.pCenter, "내차구매");
						mainF.isLogin = true;
						mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인.png"));
						mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매선택.png"));
						mainF.lbLogin = new JLabel();
						clearReg();
					}break;
					case "로그인실패":{
						showMsg("로그인 실패");
					}break;
					case "회원정보수정완료":{
						showMsg("회원정보 수정 완료");
						mainF.card.show(mainF.pCenter, "마이페이지");
						mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지선택.png"));   
					}break;
					case "회원탈퇴완료":{
						mainF.card.show(mainF.pCenter, "로그인");
						mainF.isLogin=false;
						mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인선택.png"));    
						mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지.png"));
						showMsg("회원탈퇴 완료");
					}break;
					case "차량등록완료":{
						showMsg("차량등록성공");
						
						mainF.card.show(mainF.pCenter,"내차구매");
						mainF.sellF.clearReg();
						mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매선택.png"));
						mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
						
					}break;
					case "차량등록실패":{
						showMsg("차량등록실패");
					}break;
					case "차량수정완료":{
						System.out.println("카클 차량수정완료");
						showMsg("차량수정완료");
						mainF.card.show(mainF.pCenter,"내차구매");
						mainF.ceditF.clearReg();
						mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매선택.png"));
						mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
					}break;
					case "차량수정실패":{
						showMsg("차량수정실패");
					}break;
					case "관심차량등록":{
						showMsg("관심차량등록");
					}break;
					case "차량불러오기완료":{
						System.out.println("차량불러오기완료");
						
					}break;
					case "차량삭제완료":{
						showMsg("차량삭제완료");
						mainF.infoF.clearReg();
					}break;
					case "차량삭제실패":{
						showMsg("차량삭제실패");
					}
					case "관심차량등록성공":{
						
					}break;
					case "관심차량등록실패":{
						showMsg("관심차량등록실패");
					}
					}//switch----------------------------------
				}
			}
		} catch (Exception e) {
			System.out.println("클라이언트 run 오류: "+e);
		}
	}

	private void clearReg() {
		mainF.loginF.tfId.setText("");
		mainF.loginF.tfPwd.setText("");
		mainF.loginF.tfId.requestFocus();
	}

	private void showMsg(String str) {
		JOptionPane.showMessageDialog(mainF,str);

	}
	
}