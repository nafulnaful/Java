//[5]--4�� �����ų ��
package net.day1;
import java.io.*;
import java.net.*;

public class MyNetClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// Ŭ���̾�Ʈ �ʿ����� Socket�� ������ �ȴ�.
		// �� �� ������ ip�ּ�(ȣ��Ʈ��), ��Ʈ��ȣ�� �ʿ��ϴ�.
		//ipconfig��� cmd���� ġ�� �ڽ��� ip��ȣ�� �˼� �ִ�.
		Socket sock=new Socket("172.20.10."+args[0],55555);////InetAddress.getLocalHost()
		System.out.println("##������ �����##");
		//������ ����Ǹ� Socket��ü�� ������. ������� ������ ���ܰ� �߻��Ѵ�.
		
		/*c:\>cd myjava\workspace\advance\bin

		c:\MyJava\Workspace\Advance\bin>java net.day1.MyNetClient
		##������ �����##
		*/
		
		InputStream is=sock.getInputStream();
		DataInputStream dis =new DataInputStream(is);
		
		int num=dis.readInt();
		System.out.println("������ ���� �� ����� ����: "+num);
		//[�ǽ�]Ŭ�� ���ڸ� ������ �������� "�� �޾Ҿ��~~ ���� 55"�̶� �޽����� ��������.
		//�������ؼ� ��½�Ʈ�� ������ ���͸� ==> ���ڿ��� ������ �޼ҵ� ȣ��
		
		OutputStream os=sock.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
		
		dos.writeUTF("�� �޾ҽ��ϴ�~~ ���� ���ڴ� :"+num);
		dos.flush();
		
		
		
		dis.close();
		is.close();
		sock.close();

	}

}
