package handler;

import java.io.*;
import java.net.*;
import java.util.*;

import exception.CarMessage;


/*
100 : 클라이언트 리스트 정보(100|아이디|대화명)
400: 일반 대화 메시지(400|글꼴색|메시지)
500: 귓속말(500|귓속말 보내는 사람의 대화명|귓속말 메시지)
800 : 동일한 대화명이 있을 시 접속을 종료시킨다(800|)
900 : 채팅 종료 (900|대화명)*/
public class CarChatHandler {

	private Socket sock;
	private Vector<CarChatHandler> userV;
	private String userId;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean isStop;
	

	public CarChatHandler(Socket sock, Vector<CarChatHandler>v)//넘긴 소켓이랑 벡터 받기 
	{
		this.sock=sock;
		this.userV=v;
		try 
		{//Thread를 받을 객체 생성
			in=new ObjectInputStream(this.sock.getInputStream());
			out=new ObjectOutputStream(this.sock.getOutputStream());
		} catch (Exception e) {
			System.out.println("CarChatHandler()생성자 예외 :"+e);
		}
	}
	
	public void run() 
	{
		try {
			Object obj=in.readObject();
			if(obj==null) return;
			CarMessage data=null;
			System.out.println("obj=="+obj);
			if(obj instanceof CarMessage) {//obj가 메시지 타입인가
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
			System.out.println("CarChatHandler run() 예외:" +e);
		}
	}
	
	private void process(CarMessage data) {
		int code=data.getCode();
		switch(code) 
		{
		case 300:
			{//클=> 서버에게 "300|이모티콘번호"//[76]
			 //서버=>클에게 "300|보내는사람대화명|이모티콘번호"를 보내자.
				CarMessage sendMsg=new CarMessage(data.getCode(),data.getIconCmd());
				sendMessageAll(sendMsg);
			}break;
		case 400:
			{//클=>서버에게 "400|메세지|글자색"//[59]
			 //서버=>클에게 "400|보내는사람대화명|메시지|글자색"
				CarMessage sendData=new CarMessage(400,userId,data.getFontRGB(),data.getMsg());
				sendMessageAll(sendData);
			}break;
		case 500:
			{//클=>서버에게 "500|받는사람 대화명|귓속말 메시지"//[65]
			 //서버=>클에게 "500|받는사람 대화명|귓속말 메시지"
				String oneMsg=data.getMsg();
				//가진 객체를 찾아서 그 객체에게만 메시지를 보낸다.
				for(CarChatHandler userChat: userV) 
				{
					
					CarMessage data2=new CarMessage();
					data2.setCode(500);
					data2.setMsg(oneMsg);
					userChat.sendMessageTo(data2);
					break;
				}
			}
		case 900://클=> 서버에게 "900|아이디|대화명"
		case 800:
			{//클=> 서버에서 "800|아이디|대화명"
			 //모든 클에게 누가 퇴장한다고 알려주고,
			this.sendMessageAll(data);

			//userV에서 JavaChatHandler 제거
			userV.remove(this);
			
			//자원 반납
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
		System.out.println("closeAll()예외: "+e);
		}
	}//closeAll()-------------------------
	
	/**특정 클라이언트 에게만 메시지를 보내는 메소드*/
	public synchronized void sendMessageTo(CarMessage msg) {//string타입인걸 message타입으로 바꾸고 synchronized 해줌
		try 
		{
			out.writeObject(msg);
			out.flush();
		} 
		catch (IOException e) {
			System.out.println("sendMessageTo() 예외: "+e);
		}
		
	
	}
	
	private void sendMessageAll(CarMessage sendMsg) {
		for(CarChatHandler userChat:userV) {
			try {
			userChat.out.writeObject(sendMsg);
			userChat.out.flush();
			}catch(IOException e) {
				System.out.println("sendMEssageAll()예외 : "+e);
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
