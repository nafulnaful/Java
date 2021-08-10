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
	
	public JavaChatHandler(Socket sock, Vector<JavaChatHandler> v) {//[4]�ѱ� �����̶� ���� �ޱ�
		this.sock=sock;
		this.userV=v;
		try {//[5]Thread�� ���� ��ü ����
			in=new ObjectInputStream(this.sock.getInputStream());
			out=new ObjectOutputStream(this.sock.getOutputStream());
			//����:�����ʿ��� in,out������ �����ϸ� client�ʿ����� out,in������ ��������
			//		�׷��� ����� ��
		} catch (IOException e) {
			System.out.println("JavaChatHandler()������ ����: "+e);
		}
	}
	
	
	public void run() {//[6]=>[25]
		//Ŭ�� ���� �����ϸ� "100|���̵�|��ȭ��"�� ������.==>�̰� ���� ����.
		try {
			Object obj=in.readObject();
			if(obj==null) return;
			Message data=null;
			System.out.println("obj=="+obj);
			if(obj instanceof Message) {//obj�� �޽��� Ÿ���̸�//instanceof�� ��Ӱ��� Ȯ��
				data=(Message)obj;
			}
			
			//[26]
			if(data.getCode()==100) {//�������� ���ڵ尪�� 100���� ���ٸ�->����޽����� �Դٸ�
				userId=data.getId();
				nick=data.getNick();
				
				checkNick();//�ߺ��˻�
				//[29]��ȭ��(nick)�� �ߺ����θ� üũ����
				//1. ��ȭ���� �ߺ��ȴٸ�...
				
				//2. ��ȭ���� �ߺ����� �ʴ´ٸ�
				
				
				
			}
			
			while(!isStop) {//������ �ʴ´ٸ�
				//Ŭ�� �������� �޽����� ��� ��� �� ������ �м��ؼ� �������� ó������.[27]???????????????
				data=(Message)in.readObject();
				process(data);
			}
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("JavaChatHandler run() ����: "+e);
		}
		
	}
	
	private void checkNick() {//[30]
		// ��ȭ�� �ߺ����θ� üũ�ϴ� �޼ҵ� ȣ��
		boolean isExist=isDuplicateNick(nick);
		//�ߺ��Ǵ� �г����̸� true�� ��ȯ
		if(isExist) {//[32]
			//��ȭ���� �ߺ��ȴٸ�
			Message data=new Message();
			data.setCode(700);
			sendMessageTo(data);
		}else {
			//�ߺ����� �ʴ´ٸ�[37]
			//1) ��� ������ Ŭ���� ������ �̹� ������ �ִ� Ŭ�� ������ ��������.
			for(JavaChatHandler userChat:userV) {
				Message sendData=new Message(100,userChat.userId,userChat.nick);
				sendMessageTo(sendData);
			}
			
			//2) ��� ������ Ŭ�� ������ �̹� ������ ��� Ŭ���� �����ش�.
			userV.add(this);//JavaChatHandler�� userV�� ��������.
			Message data=new Message(100,userId,nick);
			sendMessageAll(data);
			
		}
		
	}


	public void process(Message data) {//[28]=>[43]
		int code=data.getCode();
		System.out.println("code=="+code);//Ȯ����
		switch(code) {
			case 300:{//Ŭ=> �������� "300|�̸�Ƽ�ܹ�ȣ"//[76]
				//����=>Ŭ���� "300|�����»����ȭ��|�̸�Ƽ�ܹ�ȣ"�� ������.
				Message sendMsg=new Message(data.getCode(),data.getIconCmd());
				sendMsg.setNick(this.nick);
				sendMessageAll(sendMsg);
			}break;
			case 400:{//Ŭ=>�������� "400|�޼���|���ڻ�"//[59]
				//����=>Ŭ���� "400|�����»����ȭ��|�޽���|���ڻ�"
				Message sendData=new Message(400,userId,nick,data.getFontRGB(),data.getMsg());
				sendMessageAll(sendData);
			}break;
			case 500:{//Ŭ=>�������� "500|�޴»�� ��ȭ��|�ӼӸ� �޽���"//[65]
						//����=>Ŭ���� "500|�޴»�� ��ȭ��|�ӼӸ� �޽���"
				String toNick=data.getNick();
				String oneMsg=data.getMsg();
				//userV �ݺ��� ���鼭 JavaChatHandler�� ������ toNick�� ������ ��ȭ����
				//���� ��ü�� ã�Ƽ� �� ��ü���Ը� �޽����� ������.
				for(JavaChatHandler userChat: userV) {
					if(toNick.equals(userChat.nick));//��� �а� ���ϴ»���� ���� ������ ������ֳ�?
					Message data2=new Message();
					data2.setCode(500);
					data2.setNick(this.nick);
					data2.setMsg(oneMsg);
					userChat.sendMessageTo(data2);
					break;
				}
			}
			
			case 900://Ŭ=> �������� "900|���̵�|��ȭ��" [47]
			case 800:{//Ŭ=> �������� "800|���̵�|��ȭ��"
				//��� Ŭ���� ���� �����Ѵٰ� �˷��ְ�,
				this.sendMessageAll(data);
	
				//userV���� JavaChatHandler ����
				userV.remove(this);
				
				//�ڿ� �ݳ�
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
			System.out.println("closeAll()����: "+e);
		}
	}
	/**Ư�� Ŭ���̾�Ʈ ���Ը� �޽����� ������ �޼ҵ�*/
	public synchronized void sendMessageTo(Message msg) {//[33]stringŸ���ΰ� messageŸ������ �ٲٰ� synchronized ����
		try {
			out.writeObject(msg);
			out.flush();
		} catch (IOException e) {
			System.out.println("sendMessageTo() ����: "+e);
		}
		
	
	}
	
	public synchronized void sendMessageAll(Message msg) {//[38]
		for(JavaChatHandler userChat:userV) {
			try {
			userChat.out.writeObject(msg);
			userChat.out.flush();
			}catch(IOException e) {
				System.out.println("sendMEssageAll()���� : "+e);
				userV.remove(userChat);
				break;
			}
		}
	}
	
	public boolean isDuplicateNick(String nick) {//[31]
		//������ ������ �ִ� ������� ��ȭ���� �˻�
		for(JavaChatHandler userChat:userV) {
			if(userChat.nick.equals(nick)) {//userChat���ִ� �а� ���� ���� ���� ������?
				return true;//������ ��ȭ�� ������ true��ȯ
			}//if------------------------
		}//for-----------------------------------
		return false;//������ ��ȭ���� ������ false��ȯ
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
