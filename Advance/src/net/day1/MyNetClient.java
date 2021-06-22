//[5]--4와 연결시킬 것
package net.day1;
import java.io.*;
import java.net.*;

public class MyNetClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 클라이언트 쪽에서는 Socket만 있으면 된다.
		// 이 때 서버의 ip주소(호스트명), 포트번호가 필요하다.
		//ipconfig라고 cmd차에 치면 자신의 ip번호를 알수 있다.
		Socket sock=new Socket("172.20.10."+args[0],55555);////InetAddress.getLocalHost()
		System.out.println("##서버와 연결됨##");
		//서버와 연결되면 Socket객체가 생성됨. 연결되지 않으면 예외가 발생한다.
		
		/*c:\>cd myjava\workspace\advance\bin

		c:\MyJava\Workspace\Advance\bin>java net.day1.MyNetClient
		##서버와 연결됨##
		*/
		
		InputStream is=sock.getInputStream();
		DataInputStream dis =new DataInputStream(is);
		
		int num=dis.readInt();
		System.out.println("서버로 부터 온 행운의 숫자: "+num);
		//[실습]클이 숫자를 받으면 서버에게 "잘 받았어요~~ 숫자 55"이란 메시지를 전송하자.
		//소켓통해서 출력스트림 얻어오고 필터링 ==> 문자열을 보내는 메소드 호출
		
		OutputStream os=sock.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
		
		dos.writeUTF("잘 받았습니다~~ 받은 숫자는 :"+num);
		dos.flush();
		
		
		
		dis.close();
		is.close();
		sock.close();

	}

}
