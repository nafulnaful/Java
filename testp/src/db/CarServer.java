package db;

import java.net.*;
import java.io.*;
import java.util.*;


public class CarServer extends Thread {
	
	private ServerSocket server;
	UserDAO userDao;
	CarDAO carDao;
	private int PORT=9999;
	public Vector<ServerHandler> users = new Vector(3,5);
	public Vector<ServerHandler> cars = new Vector(3,5);
	public CarServer() {
		try {
			server=new ServerSocket(PORT);
			System.out.println("Car 서버 시작됨..");
			carDao = new CarDAO();
			userDao = new UserDAO();
		} catch (IOException e) {
			System.out.println("Car 서버 시작 중 에러"+e);
		}
		
	}//
	
	public void run() {
		while(true) {
			try {
				Socket sock=server.accept();
				System.out.println(sock.getInetAddress()+"님이 접속했습니다.");
				ServerHandler serverhandler = new ServerHandler(sock, users, userDao, carDao);
				serverhandler.start();
			} catch (IOException e) {
				System.out.println("CarServer run(): "+e);
			}
		}
	}
	
	
	public static void main(String[] args) {
		new CarServer().start();

	}

}
