package javachat;
import java.net.*;
import java.io.*;
import java.util.*;

public class JavaChatHandler extends Thread {

	private Socket sock;
	private Vector<JavaChatHandler> userV;
	private String userId;
	private String nick;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean isStop;
	
	public JavaChatHandler(Socket sock, Vector<JavaChatHandler> v) {//[4]넘긴 소켓이랑 벡터 받기
		this.sock=sock;
		this.userV=v;
		try {//[5]Thread를 받을 객체 생성
			in=new ObjectInputStream(this.sock.getInputStream());
			out=new ObjectOutputStream(this.sock.getOutputStream());
			//주의:서버쪽에서 in,out순서로 생성하면 client쪽에서는 out,in순서로 생성하자
			//		그래야 통신이 됨
		} catch (IOException e) {
			System.out.println("JavaChatHandler()생성자 예외: "+e);
		}
	}
	
	
	public void run() {//[6]=>[25]
		//클이 먼저 접속하면 "100|아이디|대화명"을 보낸다.==>이걸 먼저 듣자.
		try {
			Object obj=in.readObject();
			if(obj==null) return;
			Message data=null;
			System.out.println("obj=="+obj);
			if(obj instanceof Message) {//obj가 메시지 타입이면//instanceof가 상속관계 확인
				data=(Message)obj;
			}
			
			//[26]
			if(data.getCode()==100) {//데이터의 갯코드값이 100번과 같다면->입장메시지가 왔다면
				userId=data.getId();
				nick=data.getNick();
				
				checkNick();//중복검사
				//[29]대화명(nick)의 중복여부를 체크하자
				//1. 대화명이 중복된다면...
				
				//2. 대화명이 중복되지 않는다면
				
				
				
			}
			
			while(!isStop) {//멈추지 않는다면
				//클이 보내오는 메시지를 계속 듣고 그 내용을 분석해서 로직별로 처리하자.[27]???????????????
				data=(Message)in.readObject();
				process(data);
			}
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("JavaChatHandler run() 예외: "+e);
		}
		
	}
	
	private void checkNick() {//[30]
		// 대화명 중복여부를 체크하는 메소드 호출
		boolean isExist=isDuplicateNick(nick);
		//중복되는 닉네임이면 true를 반환
		if(isExist) {//[32]
			//대화명이 중복된다면
			Message data=new Message();
			data.setCode(700);
			sendMessageTo(data);
		}else {
			//중복되지 않는다면[37]
			//1) 방금 접속한 클에게 기존에 이미 접속해 있는 클의 정보를 보내주자.
			for(JavaChatHandler userChat:userV) {
				Message sendData=new Message(100,userChat.userId,userChat.nick);
				sendMessageTo(sendData);
			}
			
			//2) 방금 접속한 클의 정보를 이미 접속한 모든 클에게 보내준다.
			userV.add(this);//JavaChatHandler를 userV에 저장하자.
			Message data=new Message(100,userId,nick);
			sendMessageAll(data);
			
		}
		
	}


	public void process(Message data) {//[28]=>[43]
		int code=data.getCode();
		System.out.println("code=="+code);//확인차
		switch(code) {
			case 300:{//클=> 서버에게 "300|이모티콘번호"//[76]
				//서버=>클에게 "300|보내는사람대화명|이모티콘번호"를 보내자.
				Message sendMsg=new Message(data.getCode(),data.getIconCmd());
				sendMsg.setNick(this.nick);
				sendMessageAll(sendMsg);
			}break;
			case 400:{//클=>서버에게 "400|메세지|글자색"//[59]
				//서버=>클에게 "400|보내는사람대화명|메시지|글자색"
				Message sendData=new Message(400,userId,nick,data.getFontRGB(),data.getMsg());
				sendMessageAll(sendData);
			}break;
			case 500:{//클=>서버에게 "500|받는사람 대화명|귓속말 메시지"//[65]
						//서버=>클에게 "500|받는사람 대화명|귓속말 메시지"
				String toNick=data.getNick();
				String oneMsg=data.getMsg();
				//userV 반복문 돌면서 JavaChatHandler를 꺼내서 toNick과 동일한 대화명을
				//가진 객체를 찾아서 그 객체에게만 메시지를 보낸다.
				for(JavaChatHandler userChat: userV) {
					if(toNick.equals(userChat.nick));//상대 닉과 귓하는사람의 닉이 동일한 사람이있나?
					Message data2=new Message();
					data2.setCode(500);
					data2.setNick(this.nick);
					data2.setMsg(oneMsg);
					userChat.sendMessageTo(data2);
					break;
				}
			}
			
			case 900://클=> 서버에게 "900|아이디|대화명" [47]
			case 800:{//클=> 서버에서 "800|아이디|대화명"
				//모든 클에게 누가 퇴장한다고 알려주고,
				this.sendMessageAll(data);
	
				//userV에서 JavaChatHandler 제거
				userV.remove(this);
				
				//자원 반납
				closeAll();
				
			}break;
		}//switch-----------
	}//process()-------------------
	
	public void closeAll() {//[44]
		isStop=true;
		try {
			if(in!=null) in.close();
			if(out!=null) out.close();
			if(sock!=null) {
				sock.close();
				sock=null;
			}
			
		} catch (Exception e) {
			System.out.println("closeAll()예외: "+e);
		}
	}
	/**특정 클라이언트 에게만 메시지를 보내는 메소드*/
	public synchronized void sendMessageTo(Message msg) {//[33]string타입인걸 message타입으로 바꾸고 synchronized 해줌
		try {
			out.writeObject(msg);
			out.flush();
		} catch (IOException e) {
			System.out.println("sendMessageTo() 예외: "+e);
		}
		
	
	}
	
	public synchronized void sendMessageAll(Message msg) {//[38]
		for(JavaChatHandler userChat:userV) {
			try {
			userChat.out.writeObject(msg);
			userChat.out.flush();
			}catch(IOException e) {
				System.out.println("sendMEssageAll()예외 : "+e);
				userV.remove(userChat);
				break;
			}
		}
	}
	
	public boolean isDuplicateNick(String nick) {//[31]
		//기존에 입장해 있는 사람들의 대화명을 검사
		for(JavaChatHandler userChat:userV) {
			if(userChat.nick.equals(nick)) {//userChat에있는 닉과 지금 들어온 닉이 같은지?
				return true;//동일한 대화명 있으면 true반환
			}//if------------------------
		}//for-----------------------------------
		return false;//동일한 대화명이 없으면 false반환
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
