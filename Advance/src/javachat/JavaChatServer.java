package javachat;
import java.net.*;
import java.io.*;
import java.util.*;

public class JavaChatServer extends Thread {
	
	private ServerSocket server;
	private int port=9999;//포트번호 정하기
	public Vector<JavaChatHandler> userV=new Vector<>(5,3);//벡터 5,3으로 생성///////////////////////////????
	
	
	public JavaChatServer() {//생성자 만들기
		try {//[1]
			server=new ServerSocket(port);
			System.out.println("##채팅 서버 시작되었어요##");
			System.out.println("##["+port+"]포트에서 대기중##");
		} catch (IOException e) {
			System.out.println("##채팅 서버 시작 중 예외: "+e+"##");
		}
	}
	
	public void run() {
		while(true) {//[3]
			try {
				Socket sock=server.accept();
				System.out.println("["+sock.getInetAddress()+"]님이 접속했어요##");
				JavaChatHandler chat=new JavaChatHandler(sock,userV);//핸들러에 sock과 userV를 넘긴다
				chat.start();//chat도 스레드이니까 스타트 해줘야한다
			} catch (IOException e) {
				System.out.println("JavaChatServer run()예외: "+e);
			}
		}
	}

	public static void main(String[] args) {
		//[2]
		new JavaChatServer().start();//생성자 부르고 바로 스타트를 한것

	}

}
