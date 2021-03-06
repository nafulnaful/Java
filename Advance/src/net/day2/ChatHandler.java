package net.day2;
import java.net.*;
import java.io.*;
import java.util.*;
//클과 통신을 담당하는 스레드
public class ChatHandler extends Thread {
   Socket sock;
   Vector<ChatHandler> userV;
   
   DataInputStream in;
   DataOutputStream out;
   String nickName;
   
   public ChatHandler(Socket s, Vector<ChatHandler> v) {
      this.sock=s;
      this.userV=v;
      /////////////////
      userV.add(this);//ChatHandler를 Vector에 저장
      ///////////////////?
      
      try {
         in=new DataInputStream(sock.getInputStream());
         out=new DataOutputStream(sock.getOutputStream());
         
      } catch (IOException e) {
         System.out.println("ChatHandler()생성자 예외: "+e);
      }
      
   }
   
   boolean isStop=false;
   
   public void run() {
      //클의 메시지를 듣고 해당 메시지를 접속한 모든 클에게 보내준다.
      //1. 먼저 클의 닉네임을 받가.
      try {
         nickName=in.readUTF();
         System.out.println("##"+nickName+"님이 입장함##");
         broadcast("["+nickName+"]님이 입장했습니다");
         while(!isStop) {
            //클이 보내오는 메시지 듣기
            String cMsg=in.readUTF();
            //cMsg를 parsing하자.
            System.out.println(cMsg);
            if(cMsg.startsWith("Exit#")) {//Exit#nick
               //퇴장메시지가 왔다면
               String[] token=cMsg.split("#");//Exit, nick
               String exitNick=token[1];
               broadcast("["+exitNick+"]님이 퇴장하였습니다.");
               userV.remove(this);
               //userV에서 ChatHandler를 제거
               close();
            }else {
               broadcast(nickName+">>"+cMsg);
            }
            
         }
         
         
      } catch (IOException e) {
         System.out.println("ChatHandler run() 예외: "+e);
         //e.printStackTrace();
      }
   }

   private void close() throws IOException{
      isStop=true;
      if(in!=null) in.close();
      if(out!=null) out.close();
      if(sock!=null) sock.close();
   }

   /**모든 클에게 메시지를 전송하는 기능*/
   private synchronized void broadcast(String msg) {
      // userV에 저장된 ChatHandler를 한꺼번에 꺼내오자.
      Iterator<ChatHandler> it=userV.iterator();
      while(it.hasNext()) {
         ChatHandler chat=it.next();
         try {
            chat.out.writeUTF(msg);
            chat.out.flush();
         }catch(IOException e) {
            System.out.println("broadcast()예외: "+e);
            userV.remove(this);
            try {
            close();
            }catch(Exception ex) {}
            break;
         }
      }//while---------      
   }

}