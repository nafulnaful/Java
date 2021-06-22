//[4]
package net.day1;
import java.io.*;
import java.net.*;
/*������ (ServerSocket�� Socket�� �ʿ���)
 * - ��Ʈ ��ȣ�� �����ؾ� �Ѵ�. ��Ʈ��ȣ�� 1~ 65535���� �����ϳ�, 1~1024 ������ ����� ��Ʈ�� �����Ƿ� ���ϴ°� ����.
 * - Ŭ���̾�Ʈ�� �����ؿ��� Ŭ���̾�Ʈ�� ip�ּҸ� �ֿܼ� ����غ���
 * - Ŭ���̾�Ʈ���� ������ ������ ������.==>��½�Ʈ��(������ ���� ��´�.)�� �̿��ؼ�
 * */
public class MyNetServer {

	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(55555);//��Ʈ��ȣ �ϳ� �����ϱ�
		System.out.println("Ŭ���̾�Ʈ ������ ��ٸ�...");
		while(true) {
			Socket sock=server.accept();//���� block���¿� ����//accept�� ��ȯŸ���� socket�̹Ƿ� socket���� �޴´�.
			//accept() : Ŭ���̾�Ʈ�� ������ ��ٸ��� �ִٰ�, Ŭ�� �����ؿ���
			//�ش� Ŭ�� ����� ���ϰ�ü�� ��ȯ���ش�. Ŭ�� ������ �� ���� block���¿� ����
			System.out.println("Ŭ���̾�Ʈ�� �����߾��");
			InetAddress inet=sock.getInetAddress();
			System.out.println("Ŭ�� IP�ּ�: "+inet.getHostAddress());
			
			OutputStream os=sock.getOutputStream();//1byte¥���ϱ� ���͸��� �ѹ��Ѵ� �ؿ���
			//Ŭ���� ��� ������ ��Ʈ��
			DataOutputStream dos=new DataOutputStream(os);//���͸�
			
			//1~100������ ������ ������ ���� dos���ؼ� ������.
			int num=(int)(Math.random()*100)+1;
			

			
			dos.writeInt(num);
			dos.flush();
			
			//[�ǽ�2]Ŭ�� ������ �亯 �޽����� ��� �ֿܼ� ����ϱ�
			
			InputStream is=sock.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			
			String msg=dis.readUTF();
			System.out.println("From client"+inet.getHostAddress()+">>"+msg);
			
			
		}

	}

}
