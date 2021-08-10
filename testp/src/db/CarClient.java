package db;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import page.MainFrame;

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
	db.CarDAO cardao=new CarDAO();
	public String myId;
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
			listener = new Thread(this);
			listener.start();
		}catch(Exception e) {
			System.out.println("클-소켓 에러");
		}
	}

	@Override
	public void run() {
		Object obj;
		try {
			while((obj = in.readObject())!=null||!isStop) {
				if(obj instanceof String) {
					String response =(String) obj;
					switch (response) {
					case "가입완료":{
						System.out.println("클라이언트까지 넘어옴");
						mainF.card.show(mainF.pCenter, "로그인");
						showMsg("회원가입 성공");
						joinPage.lbDone.setEnabled(true);
					}break;
					case "가입실패":{
						showMsg("회원가입 실패");
						
					}break;
					case "로그인완료":{
						System.out.println("클라이언트까지 넘어와서 로그인 성공");
						myId = mainF.loginF.tfId.getText();
						showMsg("로그인 성공");
						
						mainF.isLogin = true;
						mainF.card.show(mainF.pCenter, "내차구매");
//						mainF.mypageF.lbWelcome.setText(id);

//						ArrayList<CarDB> list=cardao.selectCar();
//			 			mainF.buyF.showItem(list);
						clearReg();
//						mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인.png"));
//						mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매선택.png"));
//						mainF.lbLogin = new JLabel();
					}break;
					case "로그인실패":{
						showMsg("로그인 실패");
					}break;
					case "차량등록완료":{
						System.out.println("클라이언트까지 넘어와서 차량등록 완료");
						showMsg("차량등록성공");
					}
					case "차량등록실패":{
						System.out.println("클라이언트까지 넘어와서 차량등록 실패");
						showMsg("차량등록불가");
					}
					}//switch----------------------------------
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void clearReg() {
		mainF.loginF.tfId.setText("");
		mainF.loginF.tfPwd.setText("");
		mainF.loginF.tfId.requestFocus();
	}

	private void showMsg(String str) {
		JOptionPane.showMessageDialog(null, str, str, 0);

	}
	
}
