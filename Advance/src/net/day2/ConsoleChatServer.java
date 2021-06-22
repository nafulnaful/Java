//[1]6/21
package net.day2;
import java.net.*;
import java.io.*;

/*������ ����
*  - ä�� ������ Ŭ���̾�Ʈ�� 1��1�� ä���ϴ� ���α׷�
*  1)  Ű����� �޽����� �Է��ؼ� Ŭ�ʿ� ����
*  2) Ŭ���̾�Ʈ�� �޽����� �������� �̸� ��� �ֿܼ� ���
* */

public class ConsoleChatServer implements Runnable {
	
	ServerSocket server;
	Socket sock;
	final int port=7269;
	//�Է½�Ʈ��
	BufferedReader key, in;
	//��½�Ʈ��
	PrintWriter out;
	
	public ConsoleChatServer() {
		System.out.println("##ConsoleChatServer Started...##"+port+"�� ��Ʈ���� �����...##");
		try {//�ͼ��� ó��
			server=new ServerSocket(port);
			sock=server.accept();
			System.out.println("##Ŭ���̾�Ʈ�� �����##");
			//1. Ű���� �Է� ��Ʈ�� ����
			key=new BufferedReader(new InputStreamReader(System.in));
			//2. Ŭ���̾�Ʈ���� ���� ��½�Ʈ�� ����
			out=new PrintWriter(sock.getOutputStream(), true);
			//3. Ŭ�� �������� �޽����� ��� �����带 �����ؼ� ����
			Thread listener=new Thread(this);
			listener.start();
			
			//4. Ű���� �Է��ϸ鼭 Ŭ���� �޽��� ����
			sendMessage();
			
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}//������--------------------------
	
	private void sendMessage() throws IOException {
		String myMsg="";
		while((myMsg=key.readLine())!=null) {
			out.println(myMsg);
		}
		key.close();
		out.close();
	}//----------------------------------------------

	@Override
	public void run() {
		try {
				//Ŭ�� �������� �޽����� ��� �ֿܼ� �����
				in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
				String cMsg="";
				while((cMsg=in.readLine())!=null) {
					System.out.println("From Client>>"+cMsg);
			}
		} catch (IOException e) {
				System.out.println("run()���� ����: "+e.getMessage());
				System.out.println("##Ŭ���̾�Ʈ�� ������ �������ϴ�.###");
				try {
				if(in!=null) in.close();
				if(sock!=null && !sock.isClosed()) {
					sock.close();
				}
		}catch(IOException ex) {}
	}
}//--------------------------------------

	public static void main(String[] args) {
		new ConsoleChatServer();//�ڱ� ��ü ����
	}

}
