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

	// thread���� ������ ����
	public ServerHandler(Socket sock, Vector<ServerHandler> users, UserDAO userDao, CarDAO carDao) {

		this.sock = sock;
		this.users = users;
		this.userDao = userDao;
		this.carDao = carDao;

		try {
			in = new ObjectInputStream(this.sock.getInputStream());
			out = new ObjectOutputStream(this.sock.getOutputStream());
		} catch (IOException e) {
			System.out.println("���� �ξƿ� ����");
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

						case 100: {// ȸ������
							System.out.println(udb.getCode());
							boolean flag = userDao.insertUser(udb);
							System.out.println(flag);
							if (flag) {
								response("���ԿϷ�");
							} else {
								response("���Խ���");
							}
						}
							break;
						case 200: {// �α���

							int re = userDao.loginCheck(udb.getUserId(), udb.getUserPwd());
							System.out.println("re:" + re);
							if (re == 1) {
								response("�α��οϷ�");
								myId=udb.getUserId();
							} else {
								response("�α��ν���");
							}
						}
							break;

						case 700: {// ȸ����������

						}
						case 800: {// �α׾ƿ�

						}
						case 900: {// 1:1����

						}
						}// switch-----------------------------------------
					} else if (obj instanceof CarDB) {
						CarDB cdb = (CarDB) obj;
						System.out.println(cdb.getCode() + "������");

						switch (cdb.getCode()) {
						case 300: {// �������
							System.out.println(cdb.getCarNo() + "���������� �Ѿ��");
							int cin = carDao.insertCar(cdb);
							System.out.println(cin);
							if (cin == 1) {
								response("������ϿϷ�");
							} else {
								response("������Ͻ���");
							}

						}
							break;
						case 400: {// ��������//���� �ϴ� ����--------------------------------������ �Ѿ�� �˾ƺ���
							System.out.println(cdb.getCarNo() + "������������������ �Ѿ��");
							int cup = carDao.updateCar(cdb);
							System.out.println(cup);
							if (cup == 1) {
								response("���������Ϸ�");
							} else {
								response("������������");
							}
						}
							break;
						case 500: {// ��������

						}
						case 600: {// ��������

						}
						}
					} // carDB if()-------------------------------
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} // ifstop
	}// run()---------------------------------------

	private void response(Object obj) {// �����ϱ� ���ϱ� ���� ����
		try {
			out.writeObject(obj);
			out.flush();

			System.out.println("response �Ϸ�");
		} catch (Exception e) {
			System.out.println("response ����" + e);
		}
	}

}
