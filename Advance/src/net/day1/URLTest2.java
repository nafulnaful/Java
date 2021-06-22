package net.day1;
import java.io.*;
import java.net.*;

public class URLTest2 {

	public static void main(String[] args) throws MalformedURLException,IOException {
		
		String urlStr="https://imgnews.pstatic.net/image/014/2021/06/18/0004659429_001_20210618093503156.jpg?type=w647";
		String urlStr2="https://postfiles.pstatic.net/MjAyMTA1MDJfOTIg/MDAxNjE5OTMxMjIwMDA5.uHpxTW3_fEyLt2pX9BUJxdc8L70C05g_nA-ZPYSNLNMg.Kw2ar0BouPq1Ig5rutEfcW6eYbQtSEmTzYAL5A3CCD0g.JPEG.muryangsoo/%B4%D9%BF%EE%B7%CE%B5%E5%C6%C4%C0%CF-8.jpg?type=w1";
		String urlStr3="https://news.v.daum.net/v/20210618073016741";
		URL url=new URL(urlStr3);
		
		//URLConnection ��ü�� �ش� ���ҽ� ������ ũ��, ����ƮŸ�� ���� ������ �˾Ƴ� �� ����
		URLConnection urlCon=url.openConnection();
		String type=urlCon.getContentType();
		System.out.println("������ ����Ʈ Ÿ��: "+type);
		System.out.println("������ ũ��: "+urlCon.getContentLengthLong());//[1]������ �޾ƿͼ� 
		
		//InputStream is2=urlCon.getInputStream();//�ؿ� �ٰ� ���� �����̴�
		InputStream is=url.openStream();//[2]�ҽ��� ���
		
		BufferedInputStream bis=new BufferedInputStream(is);//[3]���� �̾Ƴ���
		byte[] data=new byte[4000];
		
		BufferedOutputStream bos
		=new BufferedOutputStream(new FileOutputStream("url3.jpg"));
		
		int n=0;
		while((n=bis.read(data))!=-1) {
			bos.write(data,0,n);
			bos.flush();
		}
		System.out.println("ī�� �Ϸ�!!");
		bis.close();
		bos.close();

	}
/*
 * package net.day1;
import java.io.*;
import java.net.*;

public class URLTest2 {

   public static void main(String[] args) throws MalformedURLException,IOException {
      
      String urlStr="https://imgnews.pstatic.net/image/081/2021/06/18/0003194995_001_20210618050709830.jpg?type=w647";
      String urlStr2="https://news.v.daum.net/v/20210618080531357";
      URL url=new URL(urlStr);
      
      //URLConnection ��ü�� �ش� ���ҽ� ������ ũ��,����ƮŸ�� ���� ������ �˾Ƴ� �� ����
      URLConnection urlCon=url.openConnection();
      String type=urlCon.getContentType();
      System.out.println("������ ����Ʈ Ÿ��: "+type);
      System.out.println("���� ũ��: "+urlCon.getContentLengthLong());
      //InputStream is2=urlCon.getInputStream();
      
      InputStream is=url.openStream();
      
      BufferedInputStream bis=new BufferedInputStream(is);
      byte[] data=new byte[4000];
      
      BufferedOutputStream bos
      =new BufferedOutputStream(new FileOutputStream("url2.jpg"));
      
      int n=0;
      while((n=bis.read(data))!=-1) {
         bos.write(data,0,n);
         bos.flush();
      }
      System.out.println("ī�� �Ϸ�!!");
      bis.close();
      bos.close();
      
      

   }

}*/
}
