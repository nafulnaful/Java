package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import db.CarDAO;
import db.UserDAO;

public class CarServer extends Thread {
	
	private ServerSocket server;
	private int port=9999;
	UserDAO userdao;
	CarDAO cardao;
	public Vector<ServerHandler> users = new Vector(3,5);
	public Vector<ServerHandler> cars = new Vector(3,5);
	public CarServer() {
		try {
			server=new ServerSocket(port);
			System.out.println("Car 서버 시작됨..");
			userdao = new UserDAO();
			cardao = new CarDAO();
		} catch (IOException e) {
			System.out.println("Car 서버 시작 중 에러"+e);
		}
		
	}//
	
	public void run() {
		while(true) {
			try {
				Socket sock=server.accept();
				System.out.println(sock.getInetAddress()+"님이 접속했습니다.");
				ServerHandler sh=new ServerHandler(sock, userdao, cardao);
				sh.start();
			} catch (IOException e) {
				System.out.println("CarServer run(): "+e);
			}
		}
	}
	
	
	public static void main(String[] args) {
		new CarServer().start();

	}

}
