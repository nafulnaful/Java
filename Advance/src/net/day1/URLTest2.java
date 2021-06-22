package net.day1;
import java.io.*;
import java.net.*;

public class URLTest2 {

	public static void main(String[] args) throws MalformedURLException,IOException {
		
		String urlStr="https://imgnews.pstatic.net/image/014/2021/06/18/0004659429_001_20210618093503156.jpg?type=w647";
		String urlStr2="https://postfiles.pstatic.net/MjAyMTA1MDJfOTIg/MDAxNjE5OTMxMjIwMDA5.uHpxTW3_fEyLt2pX9BUJxdc8L70C05g_nA-ZPYSNLNMg.Kw2ar0BouPq1Ig5rutEfcW6eYbQtSEmTzYAL5A3CCD0g.JPEG.muryangsoo/%B4%D9%BF%EE%B7%CE%B5%E5%C6%C4%C0%CF-8.jpg?type=w1";
		String urlStr3="https://news.v.daum.net/v/20210618073016741";
		URL url=new URL(urlStr3);
		
		//URLConnection 객체로 해당 리소스 파일의 크기, 컨텐트타입 등의 정보를 알아낼 수 있음
		URLConnection urlCon=url.openConnection();
		String type=urlCon.getContentType();
		System.out.println("파일의 컨텐트 타입: "+type);
		System.out.println("파일의 크기: "+urlCon.getContentLengthLong());//[1]정보를 받아와서 
		
		//InputStream is2=urlCon.getInputStream();//밑에 줄과 같은 내용이다
		InputStream is=url.openStream();//[2]소스에 담고
		
		BufferedInputStream bis=new BufferedInputStream(is);//[3]내용 뽑아내기
		byte[] data=new byte[4000];
		
		BufferedOutputStream bos
		=new BufferedOutputStream(new FileOutputStream("url3.jpg"));
		
		int n=0;
		while((n=bis.read(data))!=-1) {
			bos.write(data,0,n);
			bos.flush();
		}
		System.out.println("카피 완료!!");
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
      
      //URLConnection 객체로 해당 리소스 파일의 크기,컨텐트타입 등의 정보를 알아낼 수 있음
      URLConnection urlCon=url.openConnection();
      String type=urlCon.getContentType();
      System.out.println("파일의 컨텐트 타입: "+type);
      System.out.println("파일 크기: "+urlCon.getContentLengthLong());
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
      System.out.println("카피 완료!!");
      bis.close();
      bos.close();
      
      

   }

}*/
}
