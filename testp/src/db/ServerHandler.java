package db;

import java.net.*;
import java.sql.PreparedStatement;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.sun.corba.se.pept.transport.Connection;

import db.UserDAO;
import db.UserDB;
import exception.UserException;
import util.DBUtil;

public class ServerHandler extends Thread {
	page.MainFrame mainF;
	private Socket sock;
	private Vector<ServerHandler> users;
	private Vector<ServerHandler> cars;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean isStop;
	UserDAO userDao;
	CarDAO carDao;
	UserDB udb = new UserDB();
	CarDB cdb = new CarDB();
	UserException ue = new UserException();
	String myId;

	// thread돌린 데이터 값들
	public ServerHandler(Socket sock, Vector<ServerHandler> users, UserDAO userDao, CarDAO carDao) {

		this.sock = sock;
		this.users = users;
		this.userDao = userDao;
		this.carDao = carDao;

		try {
			in = new ObjectInputStream(this.sock.getInputStream());
			out = new ObjectOutputStream(this.sock.getOutputStream());
		} catch (IOException e) {
			System.out.println("소켓 인아웃 에러");
		}

	}// serverHandler()------------------------------------------------------------

	@Override
	public void run() {
		if (!isStop) {
			try {
				Object obj;

				while ((obj = in.readObject()) != null) {
					if (obj instanceof UserDB) {
						UserDB udb = (UserDB) obj;
						System.out.println(udb.getUserId());

						switch (udb.getCode()) {

						case 100: {// 회원가입
							System.out.println(udb.getCode());
							boolean flag = userDao.insertUser(udb);
							System.out.println(flag);
							if (flag) {
								response("가입완료");
							} else {
								response("가입실패");
							}
						}
							break;
						case 200: {// 로그인

							int re = userDao.loginCheck(udb.getUserId(), udb.getUserPwd());
							System.out.println("re:" + re);
							if (re == 1) {
								response("로그인완료");
								myId=udb.getUserId();
							} else {
								response("로그인실패");
							}
						}
							break;

						case 700: {// 회원정보수정

						}
						case 800: {// 로그아웃

						}
						case 900: {// 1:1문의

						}
						}// switch-----------------------------------------
					} else if (obj instanceof CarDB) {
						CarDB cdb = (CarDB) obj;
						System.out.println(cdb.getCode() + "서버넘");

						switch (cdb.getCode()) {
						case 300: {// 차량등록
							System.out.println(cdb.getCarNo() + "서버까지는 넘어옴");
							int cin = carDao.insertCar(cdb);
							System.out.println(cin);
							if (cin == 1) {
								response("차량등록완료");
							} else {
								response("차량등록실패");
							}

						}
							break;
						case 400: {// 차량수정//수정 일단 보류--------------------------------페이지 넘어가기 알아보기
							System.out.println(cdb.getCarNo() + "차량수정서버까지는 넘어옴");
							int cup = carDao.updateCar(cdb);
							System.out.println(cup);
							if (cup == 1) {
								response("차량수정완료");
							} else {
								response("차량수정실패");
							}
						}
							break;
						case 500: {// 차량구매

						}
						case 600: {// 관심차량

						}
						}
					} // carDB if()-------------------------------
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} // ifstop
	}// run()---------------------------------------

	private void response(Object obj) {// 응답하기 편하기 위해 만듬
		try {
			out.writeObject(obj);
			out.flush();

			System.out.println("response 완료");
		} catch (Exception e) {
			System.out.println("response 에러" + e);
		}
	}

}
