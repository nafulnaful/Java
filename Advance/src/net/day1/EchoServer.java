//[6]
package net.day1;
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
/**
������ ����
-Client�� Server�� �����ϸ�...
  1) �����κ��� ���� "�ȳ��ϼ��� Ŭ���̾�Ʈ��?" �̶�
      �޽����� �޴´�.
  
  2) �׷��� Ŭ���̾�Ʈ�� ���� �ֿܼ��� Ű���� �Է��� ����
      �޽����� ������[Ű���� �Է½�Ʈ���� ������ ���ϰ�
     �����Ͽ� �޽����� �ְ�޴� ��ǲ/�ƿ�ǲ ��Ʈ���� �ʿ�]
 
 //�̷��� parsing�Ѵٰ� �Ѵ� (��)
  3) �׷��� ������ Ŭ���̾�Ʈ�κ��� ���� �޽����� ����
       ��) "�ȳ��ϼ���?" �� "����"�� �޽����� ����
           --->"Ŭ�� �ݰ�����" ��� �޽����� ������
      ��) "���� ��¥��" �̶� �޽����� ����
          ----> ���� ��¥�� ������
        ��) ��Ÿ �ٸ� �޽����� ����
         "~~~�� � ��~~"�� �޽����� ������.


*/
public class EchoServer {

	public static void main(String[] args) 
	throws Exception
	{
		final int port=7777;
		ServerSocket server=new ServerSocket(port);
		System.out.println("EchoServer Started...");//�����
		Socket sock=server.accept();//������ �޴� ��
		InetAddress inet=sock.getInetAddress();
		String cip=inet.getHostAddress();//Ŭ�� ip�ּ�
		System.out.println(cip+"���� �����߽��ϴ�.##");
		//1. ������ Ŭ���� ���� "�ȳ��ϼ���? ~~��"�ϰ� �λ縻�� �ǳ���.
		PrintWriter pout=new PrintWriter(sock.getOutputStream(), true);//�Ʊ�[5]���� ����� outputstream�� ���� ���
		pout.println("�ȳ��ϼ���? "+cip+"��~~");
		
		//2. Ŭ�� �������� �޽����� ��� �Է� ��Ʈ�� ����
		BufferedReader in=new BufferedReader(new InputStreamReader(sock.getInputStream()));//1byte�� sock.getInpuStream�� new InputStreamReader�� �޾����
		
		//3. �ݺ��� ���鼭 Ŭ�� �������� �޽����� ��� �̸� �м��Ͽ� ������ �亯�� ������.
		String cMsg="";//�޼����� ������� ����
		
		while((cMsg=in.readLine())!=null) {
			//cMsg�� �м� => parsing�ؼ� ������ Ŭ���� ������
			
			if(cMsg.contains("�ȳ�") ||cMsg.contains("����")) {//contains�� �ڿ� ������ ������ ����ִ���? �̷� �ǹ�
				pout.println(cip+"�� �ݰ�����");
			}else if(cMsg.contains("���� ��¥")||cMsg.contains("���ó�¥")) {
				Date today=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
				pout.println(sdf.format(today));
			}else if(cMsg.contains("����")){
				pout.println(cip+"�� ���� �ϼ���~~");
			}else {
				pout.println(cip+"�� � ��~~");
			}
		}
		
		
		//4. ����� �ڿ� close
		pout.close();
		in.close();
		sock.close();
		server.close();
		
		

	}

}
