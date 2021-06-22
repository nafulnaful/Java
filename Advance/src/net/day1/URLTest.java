package net.day1;
import java.net.*;

public class URLTest {

	public static void main(String[] args) {
		// URL : Uniform Resource Locator
		//URL����
		//��������://IP�ּ�:��Ʈ��ȣ/���丮/���ϸ�?������Ʈ��
		//https://en.dict.naver.com/#/main
		//http://naver.com
		//ftp://www.tis.com/example/ex01.html
		//file:///c:/MyJava/test.html
		try {
//			URL url=new URL("https://en.dict.naver.com/#/main");
			URL url=new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=100&oid=277&aid=0004922386");
			//nhn�����Ѱ�
			
			System.out.println("Protocol: "+url.getProtocol());
			System.out.println("Host: "+url.getHost());
			System.out.println("Port: "+url.getPort());
			//-1�� ��ȯ�ϴ� ��� ��Ʈ��ȣ�� -1�̶�� ���� �ƴ϶�, �������ݿ� �ش��ϴ�
			//����Ʈ ��Ʈ�� ������ �Ͼ�ٴ� ���� �ǹ�
			System.out.println("DefaultPort: "+url.getDefaultPort());
			
			System.out.println("Path: "+url.getPath());
			System.out.println("File: "+url.getFile());
			System.out.println("Query String: "+url.getQuery());
			System.out.println("Ref: "+url.getRef());
			
		} catch (MalformedURLException e) {
			System.out.println("URL���Ŀ� ���� �ʾƿ�: "+e.getMessage());
			e.printStackTrace();
		}
		

	}

}
