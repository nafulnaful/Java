package net.day1;
import java.net.*;

public class URLTest {

	public static void main(String[] args) {
		// URL : Uniform Resource Locator
		//URL형태
		//프로토콜://IP주소:포트번호/디렉토리/파일명?쿼리스트링
		//https://en.dict.naver.com/#/main
		//http://naver.com
		//ftp://www.tis.com/example/ex01.html
		//file:///c:/MyJava/test.html
		try {
//			URL url=new URL("https://en.dict.naver.com/#/main");
			URL url=new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=100&oid=277&aid=0004922386");
			//nhn맵핑한것
			
			System.out.println("Protocol: "+url.getProtocol());
			System.out.println("Host: "+url.getHost());
			System.out.println("Port: "+url.getPort());
			//-1을 반환하는 경우 포트번호가 -1이라는 것이 아니라, 프로토콜에 해당하는
			//디폴트 포트로 접속이 일어난다는 것을 의미
			System.out.println("DefaultPort: "+url.getDefaultPort());
			
			System.out.println("Path: "+url.getPath());
			System.out.println("File: "+url.getFile());
			System.out.println("Query String: "+url.getQuery());
			System.out.println("Ref: "+url.getRef());
			
		} catch (MalformedURLException e) {
			System.out.println("URL형식에 맞지 않아요: "+e.getMessage());
			e.printStackTrace();
		}
		

	}

}
