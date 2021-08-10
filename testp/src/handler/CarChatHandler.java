package handler;

import java.io.*;
import java.net.*;
import java.util.*;

import exception.CarMessage;


/*
100 : Ŭ���̾�Ʈ ����Ʈ ����(100|���̵�|��ȭ��)
400: �Ϲ� ��ȭ �޽���(400|�۲û�|�޽���)
500: �ӼӸ�(500|�ӼӸ� ������ ����� ��ȭ��|�ӼӸ� �޽���)
800 : ������ ��ȭ���� ���� �� ������ �����Ų��(800|)
900 : ä�� ���� (900|��ȭ��)*/
public class CarChatHandler {

	private Socket sock;
	private Vector<CarChatHandler> userV;
	private String userId;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean isStop;
	

	public CarChatHandler(Socket sock, Vector<CarChatHandler>v)//�ѱ� �����̶� ���� �ޱ� 
	{
		this.sock=sock;
		this.userV=v;
		try 
		{//Thread�� ���� ��ü ����
			in=new ObjectInputStream(this.sock.getInputStream());
			out=new ObjectOutputStream(this.sock.getOutputStream());
		} catch (Exception e) {
			System.out.println("CarChatHandler()������ ���� :"+e);
		}
	}
	
	public void run() 
	{
		try {
			Object obj=in.readObject();
			if(obj==null) return;
			CarMessage data=null;
			System.out.println("obj=="+obj);
			if(obj instanceof CarMessage) {//obj�� �޽��� Ÿ���ΰ�
				data=(CarMessage)obj;
			}
			
			if(data.getCode()==100) 
			{
				userId=data.getId();
				sendId();
				
			}
			
			while(!isStop)
			{
				data=(CarMessage)in.readObject();
				process(data);
			}
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			System.out.println("CarChatHandler run() ����:" +e);
		}
	}
	
	private void process(CarMessage data) {
		int code=data.getCode();
		switch(code) 
		{
		case 300:
			{//Ŭ=> �������� "300|�̸�Ƽ�ܹ�ȣ"//[76]
			 //����=>Ŭ���� "300|�����»����ȭ��|�̸�Ƽ�ܹ�ȣ"�� ������.
				CarMessage sendMsg=new CarMessage(data.getCode(),data.getIconCmd());
				sendMessageAll(sendMsg);
			}break;
		case 400:
			{//Ŭ=>�������� "400|�޼���|���ڻ�"//[59]
			 //����=>Ŭ���� "400|�����»����ȭ��|�޽���|���ڻ�"
				CarMessage sendData=new CarMessage(400,userId,data.getFontRGB(),data.getMsg());
				sendMessageAll(sendData);
			}break;
		case 500:
			{//Ŭ=>�������� "500|�޴»�� ��ȭ��|�ӼӸ� �޽���"//[65]
			 //����=>Ŭ���� "500|�޴»�� ��ȭ��|�ӼӸ� �޽���"
				String oneMsg=data.getMsg();
				//���� ��ü�� ã�Ƽ� �� ��ü���Ը� �޽����� ������.
				for(CarChatHandler userChat: userV) 
				{
					
					CarMessage data2=new CarMessage();
					data2.setCode(500);
					data2.setMsg(oneMsg);
					userChat.sendMessageTo(data2);
					break;
				}
			}
		case 900://Ŭ=> �������� "900|���̵�|��ȭ��"
		case 800:
			{//Ŭ=> �������� "800|���̵�|��ȭ��"
			 //��� Ŭ���� ���� �����Ѵٰ� �˷��ְ�,
			this.sendMessageAll(data);

			//userV���� JavaChatHandler ����
			userV.remove(this);
			
			//�ڿ� �ݳ�
			closeAll();
			
			}break;
		}//switch--------------------------	
	}//process()---------------------------

	private void closeAll() 
	{
		isStop=true;
		try 
		{
			if(in!=null) in.close();
			if(out!=null) out.close();
			if(sock!=null) 
			{
				sock.close();
				sock=null;
			}	
		} 
	catch (Exception e) 
		{
		System.out.println("closeAll()����: "+e);
		}
	}//closeAll()-------------------------
	
	/**Ư�� Ŭ���̾�Ʈ ���Ը� �޽����� ������ �޼ҵ�*/
	public synchronized void sendMessageTo(CarMessage msg) {//stringŸ���ΰ� messageŸ������ �ٲٰ� synchronized ����
		try 
		{
			out.writeObject(msg);
			out.flush();
		} 
		catch (IOException e) {
			System.out.println("sendMessageTo() ����: "+e);
		}
		
	
	}
	
	private void sendMessageAll(CarMessage sendMsg) {
		for(CarChatHandler userChat:userV) {
			try {
			userChat.out.writeObject(sendMsg);
			userChat.out.flush();
			}catch(IOException e) {
				System.out.println("sendMEssageAll()���� : "+e);
				userV.remove(userChat);
				break;
			}
		}
	}

	private void sendId() 
	{
		for(CarChatHandler userChat:userV)
		{
			CarMessage sendData=new CarMessage(100,userChat.userId);
			sendMessageTo(sendData);
		}
		
		userV.add(this);
		CarMessage data=new CarMessage(100,userId);
		sendMessageAll(data);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
