package net.day2;
import java.net.*;
import java.io.*;
import java.util.*;
/*Ư�� ��Ʈ�� Ŭ�� ������ ������ ��ٸ�
 * - Ŭ�� ������ �̷����� Ŭ�� ����� ����ϴ� ������(ChatHandler)�� ������ �� �����带 ���۽�Ų��.
 * - ���� ��� ����ϱ� ���� ChatHandler�� Vector�� �����Ͽ� �����Ѵ�.
 * */

public class MyChatServer extends Thread{
   
   Vector<ChatHandler> v=new Vector<>(5, 3);
   final int port=33333;
   ServerSocket server;

   public MyChatServer() {
      try {
         server=new ServerSocket(port);
         System.out.println("##ä�� ���� ���۵� ["+port+"]�� ���� �����...##");
         this.start();
      } catch (IOException e) {
         System.out.println("##ä�� ���� ���� �� ���� �߻�: "+e.getMessage()+"##");
      }
   }
   
   public void run() {
      while(true) {
         try {
            Socket sock=server.accept();
            System.out.println("##["+sock.getInetAddress()+"]���� �����߾��##");
            //����� ����ϴ� ������ ����
            //�̶� ���ϰ� ���͸� �����ڿ� �����Ѵ�.
            ChatHandler chatThread=new ChatHandler(sock, v);
            chatThread.start();
            
         }catch(IOException e) {
            System.out.println("#Ŭ�� ���� ����: "+e+"##");
         }
         
      }
   }

   public static void main(String[] args) {
      new MyChatServer();
   }

}


