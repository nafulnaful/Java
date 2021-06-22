//[7]--6과 연결
package net.day1;
import java.io.*;
import java.net.*;

public class EchoClient {

	public static void main(String[] args)
	throws IOException{
		String ip="127.0.0.1";//InetAddress.getLocalHost()와 비슷하다 자기를 불러오는 것
		final int port=7777;
		
		//소켓 생성
		Socket sock=new Socket(ip, port);
		System.out.println("##에코 서버와 연결됨##");
		
		//1. 소켓을 통해 듣는 스트림 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(sock.getInputStream()));//노드연결이 서버와 입력이 되어있는 것
		
		//2. 소켓을 통해 출력하는 스트림 생성
		PrintWriter out=new PrintWriter(sock.getOutputStream(), true);
		//3. 키보드와 연결된 입력스트림 생성
		BufferedReader key=new BufferedReader(new InputStreamReader(System.in));//노드연결이 입력값(즉 키보드)으로 되어있는 것
		//먼저 서버가 보내온 메시지를 듣고 콘솔에 출력하자
		String serverMsg=in.readLine();
		System.out.println("From EchoServer>>"+serverMsg);
		
		String myMsg="";//내가 보낸 메세지를 myMsg에 담는다
		//키보드로 입력하여 서버에 메시지를 보내고
		while((myMsg=key.readLine())!=null) {
			out.println(myMsg);//내 메세지 보내기
		
		//서버가 보내오는 메아리 메시지를 듣는다.
		serverMsg=in.readLine();
		System.out.println("From EchoServer>>"+serverMsg);
		}
		in.close();
		out.close();
		key.close();
		sock.close();
		

	}

}
