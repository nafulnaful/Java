//[7]--6�� ����
package net.day1;
import java.io.*;
import java.net.*;

public class EchoClient {

	public static void main(String[] args)
	throws IOException{
		String ip="127.0.0.1";//InetAddress.getLocalHost()�� ����ϴ� �ڱ⸦ �ҷ����� ��
		final int port=7777;
		
		//���� ����
		Socket sock=new Socket(ip, port);
		System.out.println("##���� ������ �����##");
		
		//1. ������ ���� ��� ��Ʈ�� ����
		BufferedReader in=new BufferedReader(new InputStreamReader(sock.getInputStream()));//��忬���� ������ �Է��� �Ǿ��ִ� ��
		
		//2. ������ ���� ����ϴ� ��Ʈ�� ����
		PrintWriter out=new PrintWriter(sock.getOutputStream(), true);
		//3. Ű����� ����� �Է½�Ʈ�� ����
		BufferedReader key=new BufferedReader(new InputStreamReader(System.in));//��忬���� �Է°�(�� Ű����)���� �Ǿ��ִ� ��
		//���� ������ ������ �޽����� ��� �ֿܼ� �������
		String serverMsg=in.readLine();
		System.out.println("From EchoServer>>"+serverMsg);
		
		String myMsg="";//���� ���� �޼����� myMsg�� ��´�
		//Ű����� �Է��Ͽ� ������ �޽����� ������
		while((myMsg=key.readLine())!=null) {
			out.println(myMsg);//�� �޼��� ������
		
		//������ �������� �޾Ƹ� �޽����� ��´�.
		serverMsg=in.readLine();
		System.out.println("From EchoServer>>"+serverMsg);
		}
		in.close();
		out.close();
		key.close();
		sock.close();
		

	}

}
