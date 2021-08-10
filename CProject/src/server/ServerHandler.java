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
	
	
	//thread���� ������ ����
	public ServerHandler(Socket sock, UserDAO userDao, CarDAO carDao) {
		
		this.sock =sock;
		this.userDao=userDao;
		this.carDao=carDao;
		
		try {
			in = new ObjectInputStream(this.sock.getInputStream());
			out = new ObjectOutputStream(this.sock.getOutputStream());
		}catch(IOException e) {
			System.out.println("���� �ξƿ� ����");
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
						case 100:{//ȸ������
							boolean flag =userDao.insertUser(udb);
							if(flag) {
								response("���ԿϷ�");
							}else {
								response("���Խ���");
							}
						}
						break;
						case 110:{//ȸ��Ż��
							int re=userDao.deleteUser(udb.getUserId());
							if(re==1) {
								response("ȸ��Ż��Ϸ�");
							}else {
								response("ȸ��Ż�����");
							}
							
						}break;
						case 120:{//ȸ����ȸ?
							Vector<UserDB> list=userDao.selectUserIn(udb.getUserId()); //ArrayList�� �ϸ� �ڵ��� ��ȸ �Ҷ� �浹�� �׷��� vector��
							response(list);
						}break;
						case 200:{//�α���
							
							int re=userDao.loginCheck(udb.getUserId(), udb.getUserPwd());
							if(re==1) {
								response("�α��οϷ�");
								
							}else {
								response("�α��ν���");
							}
						}break;
						
						case 700:{//ȸ����������
						int re=userDao.updateUser(udb);
						if(re==1) {
							response("ȸ�����������Ϸ�");
						}else 
							System.out.println("ȸ�����������ȵ�!");
						}
						case 800:{//�α׾ƿ�
							
						}
						case 900:{//1:1����
							
						}
						}//switch-----------------------------------------
					}
			
					if(obj instanceof CarDB) {
						CarDB cdb= (CarDB) obj;
						switch (cdb.getCode()) {
						case 300:{//�������
							boolean b=carDao.insertCar(cdb);
						if(b) {
							response("������ϿϷ�");
						}else {
							response("������Ͻ���");
						}break;//300
						
						}
						case 400:{//��������
							int cup=carDao.updateCar(cdb);
							ArrayList<CarDB> list=carDao.selectCar();
							response(list);
						if(cup==1) {
							response("���������Ϸ�");
						}else {
							response("������������");
						}
						}break;
						case 410:{//��������
						int	re=carDao.deleteCar(cdb.getCarNo());
						System.out.println("�����ڵ鷯������������: "+re);
							if(re==1) {
								response("���������Ϸ�");
							}
							else {
								response("������������");
							}
						}break;
						case 450:{//������ȣ�� ��ȸ
							System.out.println(cdb.getCarNo());
							ArrayList<CarDB> list=carDao.selectCarInfo(cdb.getCarNo());
							response(list);
						}
						
						case 500:{//ID�� ����� ���� ����
							System.out.println("�����ڵ鷯 500��: "+cdb.getCode()+"||"+cdb.getCarId());
							ArrayList<CarDB> list=carDao.selectMyCar(cdb.getCarId());
							System.out.println(list);
							response(list);
						}break;
						case 510:{//�����������
							int re=carDao.likeCar(cdb);
							if(re==1) {
								response("����������ϼ���");
							}else {
								response("����������Ͻ���");
							}
						}break;
						case 550:{//����������ȸ
							System.out.println("�����ڵ鷯 550��: "+cdb.getCarId()
							+"īno"+cdb.getCarNo());
							ArrayList<CarDB> list=carDao.selectLikeCar(cdb.getCarId());
							response(list);
						}
						case 600:{//������ü��ȸ
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

	private void response(Object obj) {//�����ϱ� ���ϱ� ���� ����
		try {
			out.writeObject(obj);
			out.flush();
		} catch (Exception e) {
		}
	}
	
}
