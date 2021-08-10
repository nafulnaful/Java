package net.day3;

import java.io.*;
import java.net.*;
import javax.swing.*;
/*�����͸� ������ ��
 * UDP��� - �񿬰� ���⼺. ��ŷ���. �����Ͱ� ������� �����Ѵٴ� ������ ����
 *          TCP�� ���� ������.
 * - DatagramPacket : ������ ���� ������, �۽��� ���� ������ 2������ �����Ѵ�.
 * - DatagramSocket : ������ ����, ���Ű� ���õ� Ŭ����
 * ��Ʈ�� ����� �ƴ϶� �����ͱ׷��� ���� ����� �Ѵ�.
 * */
import java.util.*;
public class UDPSender {

	public static void main(String[] args) 
	throws IOException
	{
		String host = JOptionPane.showInputDialog("�����͸� �޴� ���� IP�ּ� �Է�");
		if(host==null) return;
		final int port = 3333;
		
		Scanner sc = new Scanner(System.in);
		String msg = "";
		DatagramPacket pack = null;//����
		DatagramSocket ds = new DatagramSocket(); //��ü�� ������
		
		System.out.println("���� ������ �Է��ϼ���=>");
		
		while((msg=sc.nextLine())!=null) {
			//��������(���ڿ�)�� byte�迭�� ��´�.
			byte[] data = msg.getBytes();
			
			pack = new DatagramPacket(data,data.length, InetAddress.getByName(host),port);
			//�����͸� ��Ŷ�� ��´�. �������� IP�ּҿ� ��Ʈ ��ȣ�� �Ű������� �����Ѵ�.
			ds.send(pack);
			System.out.println("���� ������ �Է��ϼ���=>");
		}
		
		ds.close();
		sc.close();
	}

}
