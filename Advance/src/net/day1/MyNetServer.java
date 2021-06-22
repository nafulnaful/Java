//[4]
package net.day1;
import java.io.*;
import java.net.*;
/*서버단 (ServerSocket과 Socket이 필요함)
 * - 포트 번호를 지정해야 한다. 포트번호는 1~ 65535까지 가능하나, 1~1024 까지는 예약된 포트가 많으므로 피하는게 좋다.
 * - 클라이언트이 접솝해오면 클라이언트의 ip주소를 콘솔에 출력해보자
 * - 클라이언트에게 랜덤한 정수를 보내자.==>출력스트림(소켓을 통해 얻는다.)을 이용해서
 * */
public class MyNetServer {

	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(55555);//포트번호 하나 지정하기
		System.out.println("클라이언트 연결을 기다림...");
		while(true) {
			Socket sock=server.accept();//지금 block상태에 있음//accept의 반환타입은 socket이므로 socket으로 받는다.
			//accept() : 클라이언트의 접속을 기다리고 있다가, 클이 접속해오면
			//해당 클과 연결된 소켓객체를 반환해준다. 클이 접속할 때 까지 block상태에 있음
			System.out.println("클라이언트가 접속했어요");
			InetAddress inet=sock.getInetAddress();
			System.out.println("클의 IP주소: "+inet.getHostAddress());
			
			OutputStream os=sock.getOutputStream();//1byte짜리니까 필터링을 한번한다 밑에서
			//클에게 출력 가능한 스트림
			DataOutputStream dos=new DataOutputStream(os);//필터링
			
			//1~100사이의 랜덤한 정수를 만들어서 dos통해서 보내자.
			int num=(int)(Math.random()*100)+1;
			

			
			dos.writeInt(num);
			dos.flush();
			
			//[실습2]클이 보내온 답변 메시지를 듣고 콘솔에 출력하기
			
			InputStream is=sock.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			
			String msg=dis.readUTF();
			System.out.println("From client"+inet.getHostAddress()+">>"+msg);
			
			
		}

	}

}
