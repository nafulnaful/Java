package net.day3;

import java.io.*;
import java.net.*;
import javax.swing.*;
/*데이터를 보내는 측
 * UDP방식 - 비연결 지향성. 비신뢰적. 데이터가 순서대로 도착한다는 보장을 못함
 *          TCP에 비해 빠르다.
 * - DatagramPacket : 수신을 위한 생성자, 송신을 위한 생성자 2가지를 제공한다.
 * - DatagramSocket : 데이터 전송, 수신과 관련된 클래스
 * 스트림 통신이 아니라 데이터그램을 통해 통신을 한다.
 * */
import java.util.*;
public class UDPSender {

	public static void main(String[] args) 
	throws IOException
	{
		String host = JOptionPane.showInputDialog("데이터를 받는 이의 IP주소 입력");
		if(host==null) return;
		final int port = 3333;
		
		Scanner sc = new Scanner(System.in);
		String msg = "";
		DatagramPacket pack = null;//소포
		DatagramSocket ds = new DatagramSocket(); //우체부 아저씨
		
		System.out.println("보낼 내용을 입력하세요=>");
		
		while((msg=sc.nextLine())!=null) {
			//보낼내용(문자열)을 byte배열에 담는다.
			byte[] data = msg.getBytes();
			
			pack = new DatagramPacket(data,data.length, InetAddress.getByName(host),port);
			//데이터를 패킷에 담는다. 수신자의 IP주소와 포트 번호를 매개변수로 전달한다.
			ds.send(pack);
			System.out.println("보낼 내용을 입력하세요=>");
		}
		
		ds.close();
		sc.close();
	}

}
