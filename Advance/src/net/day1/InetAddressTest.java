package net.day1;
import java.net.*;
/*InetAddress클래스 : IP를 추상화한 클래스
 * */
public class InetAddressTest {

	public static void main(String[] args) {
		InetAddress inet=null;
		
			//static Inetaddress getByName(String host)
			try {
				inet=InetAddress.getByName("www.naver.com");
				System.out.println("getHostName(): "+inet.getHostName());//호스트이름
				System.out.println("getHostAddress(): "+inet.getHostAddress());//호스트아이피주소
				System.out.println("getLocalHost(): "+inet.getLocalHost());//내컴퓨터의 이름과 아이피주소
				
				InetAddress[] inets=InetAddress.getAllByName("www.daum.net");
				
				if(inets!=null) {
					for(InetAddress ia:inets){//변수:자료구조
						System.out.println(ia.getHostAddress());
					}
				}
				
			}catch(UnknownHostException e) {
				e.printStackTrace();
		}
	}
}
