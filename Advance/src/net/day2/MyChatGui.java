package net.day2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import javax.swing.border.*;

public class MyChatGui extends JFrame implements Runnable{

   JPanel p = new JPanel(new BorderLayout());
   JPanel pN = new JPanel(new GridLayout(1,0));
   
   JTextArea ta;
   JTextField tfInput, tfHost, tfNick;
   JButton btCon, btExit;
   Socket sock;
   DataInputStream in;
   DataOutputStream out;
   
   Thread listener;
   boolean isStop=false;
   String host, nick;
   
   public static final int INIT=0;
   public static final int EXIT=-1;
   
   
   public MyChatGui() {
      super("::MyChatGui::");
      Container cp = this.getContentPane();
      cp.add(p, "Center");
      p.setBackground(Color.white);
      
      p.add(pN,"North");
      ta=new JTextArea("Welcome to MyChat");
      p.add(new JScrollPane(ta),"Center");
      ta.setBackground(Color.black);
      ta.setForeground(Color.yellow);
      ta.setFont(new Font("sans-serif",Font.BOLD, 18));
      
      tfInput=new JTextField();
      p.add(tfInput,"South");
      tfInput.setBorder(new LineBorder(Color.orange,3));
      
      tfHost=new JTextField("192.168.0.63");
      tfNick=new JTextField();
      btCon=new JButton("����(C)");
      btExit=new JButton("������(X)");
      
      btCon.setMnemonic('C');//Alt+C
      btExit.setMnemonic('X');//Alt+X
      
      pN.add(tfHost);
      pN.add(tfNick);
      pN.add(btCon);
      pN.add(btExit);
      
      tfHost.setBorder(new TitledBorder("::HOST::"));
      tfNick.setBorder(new TitledBorder("::NICK::"));
      //btCon.setBorder(new EtchedBorder());
      setEnabled(INIT);
      
      MyHandler my=new MyHandler();
      
      btCon.addActionListener(my);
      btExit.addActionListener(my);
      tfNick.addActionListener(my);
      tfInput.addActionListener(my);
      
      
      //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            chatExit();
            System.exit(0);
         }
      });
      
   }//������------
   
   public void chatLogin() {
      //�г��Ӱ� ȣ��Ʈ�� �ޱ�
      nick=tfNick.getText();
      host=tfHost.getText();
      if(nick==null||host==null||nick.trim().isEmpty()||host.trim().isEmpty()) {
         showMsg("ȣ��Ʈ��,�г��� ��� �Է��ؾ� �ؿ�");         
         return;
      }
      //����msg�� ��� ������ ������ ����
      isStop=false;
      if(listener==null) {
         listener=new Thread(this);
         listener.start();
         this.setEnabled(EXIT);
      }
   }//-----------------------
   
   public void chatExit() {
      //���� Ȯ��
      int yn=JOptionPane.showConfirmDialog(ta,"���� �ұ��?", 
                  "���� Ȯ��",JOptionPane.YES_NO_OPTION);
      if(yn==JOptionPane.NO_OPTION) return;
      
      //�����ʿ� ���� �޽����� ������. "Exit#�г���"
      try {
         out.writeUTF("Exit#"+nick);
         out.flush();
      
         //������ ����
         isStop=true;
         listener=null;
         //��ư Ȱ��ȭ ���� ����       
         setEnabled(INIT);
         ta.setText("Welcome to MyChat\n");
         close();
      } catch (IOException e) {         
         System.out.println("���� �� ����: "+e);
      }
   }//-------------------------
   
   private void close() throws IOException{
      isStop=true;
      if(in!=null) in.close();
      if(out!=null) out.close();
      if(sock!=null) sock.close();
   }//-------------------------

   private void showMsg(String str) {
      JOptionPane.showMessageDialog(ta,str);      
   }

   final int port=33333;
   public void run() {
      try {
         sock=new Socket(host,port);
         ta.append("\nConnected to "+host+":33333\n");
         out=new DataOutputStream(sock.getOutputStream());
         in = new DataInputStream(sock.getInputStream());
         //�г����� �����ʿ� ������.
         out.writeUTF(nick);
         out.flush();
         
         //������ �������� �޽����� ��� �޼ҵ� ȣ��
         listen();
         
      } catch (IOException e) {
         System.out.println("Ŭ�� run()����: "+e);
         //ta.append("\n���� ���� �Ǵ� ��� �� ���� �߻�: "+e+"\n");
         try {
         close();
         }catch(Exception ex) {}
      }
      
   }
   /*������ �������� �޽����� ��� ��� ta�� ����ϴ� �޼ҵ�*/
   private void listen() throws IOException {
      while(!isStop) {
         String serMsg=in.readUTF();
         ta.append(serMsg+"\n");
         //Ŀ���� ��ġ�� ta�� ������ �̵���Ű��.
         String txt=ta.getText();
         ta.setCaretPosition(txt.length()-1);
      }
   }

   class MyHandler implements ActionListener
   {

      @Override
      public void actionPerformed(ActionEvent e) {
         Object o=e.getSource();
         if(o==btCon||o==tfNick) {
            chatLogin();
         }else if(o==btExit) {
            chatExit();
         }else if(o==tfInput) {
            String myMsg=tfInput.getText();
            sendMessage(myMsg);
            tfInput.setText("");
         }
      }
   }///////////////
   
   private void sendMessage(String myMsg) {
      try {
         out.writeUTF(myMsg);
         out.flush();
      } catch (Exception e) {
         System.out.println("sendMessage()����: "+e);
      }      
   }//------------------------------------
   
   public void setEnabled(int mode) {
      if(mode==INIT) {
         btCon.setEnabled(true);
         btExit.setEnabled(false);
      }else if(mode==EXIT) {
         btCon.setEnabled(false);
         btExit.setEnabled(true);
      }
   }//---------------------------------

   public static void main(String[] args) {
      MyChatGui my = new MyChatGui();
      my.setSize(500, 700);
      my.setVisible(true);
   }

}