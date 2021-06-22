package net.day1;
import java.net.*;
/*InetAddressŬ���� : IP�� �߻�ȭ�� Ŭ����
 * */
public class InetAddressTest {

	public static void main(String[] args) {
		InetAddress inet=null;
		
			//static Inetaddress getByName(String host)
			try {
				inet=InetAddress.getByName("www.naver.com");
				System.out.println("getHostName(): "+inet.getHostName());//ȣ��Ʈ�̸�
				System.out.println("getHostAddress(): "+inet.getHostAddress());//ȣ��Ʈ�������ּ�
				System.out.println("getLocalHost(): "+inet.getLocalHost());//����ǻ���� �̸��� �������ּ�
				
				InetAddress[] inets=InetAddress.getAllByName("www.daum.net");
				
				if(inets!=null) {
					for(InetAddress ia:inets){//����:�ڷᱸ��
						System.out.println(ia.getHostAddress());
					}
				}
				
			}catch(UnknownHostException e) {
				e.printStackTrace();
		}
	}
}
