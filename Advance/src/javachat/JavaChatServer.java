package javachat;
import java.net.*;
import java.io.*;
import java.util.*;

public class JavaChatServer extends Thread {
	
	private ServerSocket server;
	private int port=9999;//��Ʈ��ȣ ���ϱ�
	public Vector<JavaChatHandler> userV=new Vector<>(5,3);//���� 5,3���� ����///////////////////////////????
	
	
	public JavaChatServer() {//������ �����
		try {//[1]
			server=new ServerSocket(port);
			System.out.println("##ä�� ���� ���۵Ǿ����##");
			System.out.println("##["+port+"]��Ʈ���� �����##");
		} catch (IOException e) {
			System.out.println("##ä�� ���� ���� �� ����: "+e+"##");
		}
	}
	
	public void run() {
		while(true) {//[3]
			try {
				Socket sock=server.accept();
				System.out.println("["+sock.getInetAddress()+"]���� �����߾��##");
				JavaChatHandler chat=new JavaChatHandler(sock,userV);//�ڵ鷯�� sock�� userV�� �ѱ��
				chat.start();//chat�� �������̴ϱ� ��ŸƮ ������Ѵ�
			} catch (IOException e) {
				System.out.println("JavaChatServer run()����: "+e);
			}
		}
	}

	public static void main(String[] args) {
		//[2]
		new JavaChatServer().start();//������ �θ��� �ٷ� ��ŸƮ�� �Ѱ�

	}

}
