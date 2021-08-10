package net.day3;

import java.net.*;

public class UDPReceiver {

	public static void main(String[] args) 
	throws Exception
	{
		byte[] buffer = new byte[100];
		
		DatagramPacket pack = new DatagramPacket(buffer, buffer.length);
		DatagramSocket sock = new DatagramSocket(3333);
		
		while(true) {
			sock.receive(pack);
			//실제 데이터는 패킷에 담겨있다.
			byte[] rcvMsg = pack.getData();
			String str = new String(rcvMsg, 0, pack.getLength());
			System.out.println(pack.getAddress()+"로 부터 온 메시지>>"+str);
		}

	}

}
