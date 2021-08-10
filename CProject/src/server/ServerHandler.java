package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import db.CarDAO;
import db.CarDB;
import db.UserDAO;
import db.UserDB;
import exception.UserException;

public class ServerHandler extends Thread {
	page.MainFrame mainF;
	private Socket sock;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean isStop;
	UserDAO userDao;
	CarDAO carDao;
	
	UserException ue=new UserException();
	
	
	//thread돌린 데이터 값들
	public ServerHandler(Socket sock, UserDAO userDao, CarDAO carDao) {
		
		this.sock =sock;
		this.userDao=userDao;
		this.carDao=carDao;
		
		try {
			in = new ObjectInputStream(this.sock.getInputStream());
			out = new ObjectOutputStream(this.sock.getOutputStream());
		}catch(IOException e) {
			System.out.println("소켓 인아웃 에러");
		}
		
	}//serverHandler()------------------------------------------------------------

	@Override
	public void run() {
		if(!isStop) {
			try {
				Object obj;
				
				while((obj = in.readObject()) !=null) {
					if(obj instanceof UserDB) {
						UserDB udb= (UserDB) obj;
						switch (udb.getCode()) {
						case 100:{//회원가입
							boolean flag =userDao.insertUser(udb);
							if(flag) {
								response("가입완료");
							}else {
								response("가입실패");
							}
						}
						break;
						case 110:{//회원탈퇴
							int re=userDao.deleteUser(udb.getUserId());
							if(re==1) {
								response("회원탈퇴완료");
							}else {
								response("회원탈퇴실패");
							}
							
						}break;
						case 120:{//회원조회?
							Vector<UserDB> list=userDao.selectUserIn(udb.getUserId()); //ArrayList로 하면 자동차 조회 할때 충돌남 그래서 vector로
							response(list);
						}break;
						case 200:{//로그인
							
							int re=userDao.loginCheck(udb.getUserId(), udb.getUserPwd());
							if(re==1) {
								response("로그인완료");
								
							}else {
								response("로그인실패");
							}
						}break;
						
						case 700:{//회원정보수정
						int re=userDao.updateUser(udb);
						if(re==1) {
							response("회원정보수정완료");
						}else 
							System.out.println("회원정보수정안됨!");
						}
						case 800:{//로그아웃
							
						}
						case 900:{//1:1문의
							
						}
						}//switch-----------------------------------------
					}
			
					if(obj instanceof CarDB) {
						CarDB cdb= (CarDB) obj;
						switch (cdb.getCode()) {
						case 300:{//차량등록
							boolean b=carDao.insertCar(cdb);
						if(b) {
							response("차량등록완료");
						}else {
							response("차량등록실패");
						}break;//300
						
						}
						case 400:{//차량수정
							int cup=carDao.updateCar(cdb);
							ArrayList<CarDB> list=carDao.selectCar();
							response(list);
						if(cup==1) {
							response("차량수정완료");
						}else {
							response("차량수정실패");
						}
						}break;
						case 410:{//차량삭제
						int	re=carDao.deleteCar(cdb.getCarNo());
						System.out.println("서버핸들러차량삭제응답: "+re);
							if(re==1) {
								response("차량삭제완료");
							}
							else {
								response("차량삭제실패");
							}
						}break;
						case 450:{//차량번호로 조회
							System.out.println(cdb.getCarNo());
							ArrayList<CarDB> list=carDao.selectCarInfo(cdb.getCarNo());
							response(list);
						}
						
						case 500:{//ID로 등록한 차량 보기
							System.out.println("서버핸들러 500번: "+cdb.getCode()+"||"+cdb.getCarId());
							ArrayList<CarDB> list=carDao.selectMyCar(cdb.getCarId());
							System.out.println(list);
							response(list);
						}break;
						case 510:{//관심차량등록
							int re=carDao.likeCar(cdb);
							if(re==1) {
								response("관심차량등록성공");
							}else {
								response("관심차량등록실패");
							}
						}break;
						case 550:{//관심차량조회
							System.out.println("서버핸들러 550번: "+cdb.getCarId()
							+"카no"+cdb.getCarNo());
							ArrayList<CarDB> list=carDao.selectLikeCar(cdb.getCarId());
							response(list);
						}
						case 600:{//차량전체조회
							ArrayList<CarDB> list=carDao.selectCar();
							response(list);
						}break;
					}
				}//carDB if()-------------------------------
			}//carDB while()-----------------------------------
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
}//run()---------------------------------------

	private void response(Object obj) {//응답하기 편하기 위해 만듬
		try {
			out.writeObject(obj);
			out.flush();
		} catch (Exception e) {
		}
	}
	
}
