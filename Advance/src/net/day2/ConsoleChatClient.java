//[2]6/21
package net.day2;
import java.net.*;
import java.io.*;
import javax.swing.*;
/*������ ����
 *  - ä�� ������ Ŭ���̾�Ʈ�� 1��1�� ä���ϴ� ���α׷�
 *  1)  Ű����� �޽����� �Է��ؼ� �����ʿ� ����
 *  2) ������ �޽����� �������� �̸� ��� �ֿܼ� ���
 * */
public class ConsoleChatClient extends Thread{

   Socket sock;
   String ip;
   final int port=7369;
   BufferedReader key, in;
   PrintWriter out;
   
   public ConsoleChatClient() {
      // TODO Auto-generated constructor stub
      if(ip==null) return;
      //1. ���� ����
      
      //2. Ű���� �Է½�Ʈ�� ����
      
      //3. ������ ������ ��½�Ʈ�� ����
      
      //4. ������ �������� �޽����� ��� ������ �����ؼ� ���۽�Ű��
      
      
      //5. Ű���� �Է��ϸ鼭 �޽��� ������
   }
   
   public void run() {
      //������ �������� �޽����� ��� ��� �ֿܼ� ����Ѵ�.
   }

   public static void main(String[] args) {
      ConsoleChatClient client=new ConsoleChatClient();
      client.ip=JOptionPane.showInputDialog("������ ������ IP�ּҸ� �Է��ϼ���");
      

   }

}