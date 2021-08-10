package page;

import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import message.UserMessage;

public class CarChatPage extends JFrame implements Runnable{
   
	private Socket sock;
	private boolean isStop;
	private boolean isSendOne;
	private ObjectOutputStream out;
	private ObjectInputStream in;
   JPanel p=new JPanel();
   JPanel pNorth=new JPanel(new GridLayout());
   JPanel pCenter=new JPanel(new GridLayout());
   JPanel pSouth=new JPanel(new BorderLayout());
   JPanel pSouth_E=new JPanel();
   JPanel pSouth_C=new JPanel();
   
   JLabel lbTop, lbDone;
   JButton btsend;               //#������
   JList<String> lstChat;
   JTextField tfChat;
   
   Vector<String> chatVector;
   DefaultListModel<String> model;
   
   //���� ��¥
   Date date = new Date();
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
   String dateNewFormat = sdf.format(date);
   
   public CarChatPage() {
      super(":: worud �԰� ä�� ��... ::"); //#������

      Container cp= this.getContentPane();
      cp.add(p,"Center");
      p.setBackground(Color.WHITE);
      p.setLayout(new BorderLayout());
      
      //Panel
      p.add(pNorth,"North");
      p.add(pCenter,"Center");
      p.add(pSouth, "South");
      pSouth.add(pSouth_C, "Center");
      pSouth.add(pSouth_E, "East");
      pSouth_C.setBackground(Color.white);
      pSouth_E.setBackground(Color.white);
      
      //Label
      lbTop = new JLabel("", new ImageIcon("./pj_img/��ܹ�_����.png"), JLabel.CENTER);
//      lbDone = new JLabel("", new ImageIcon("./pj_img/����.png"), JLabel.CENTER);
      
      btsend = new JButton("����");            //#�߰���
      pNorth.add(lbTop);
      pSouth_E.add(btsend);

      //TextField, Button
      tfChat = new JTextField("   ������ �Է��� ������", 25);
      pSouth_C.add(tfChat);
      tfChat.setPreferredSize(new Dimension(0, 30));
      tfChat.setForeground(Color.LIGHT_GRAY);
      
      //Vector, List
      chatVector=new Vector<>();
      lstChat=new JList<>(chatVector);
      pCenter.add(lstChat,"Center");
      lstChat.setBorder(new TitledBorder(dateNewFormat));
      lstChat.setFont(getFont());
      
      model=new DefaultListModel<>();
      lstChat.setModel(model);
      
      tfChat.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            tfChat.setText("");
            tfChat.setForeground(Color.black);
         }
      });
      
      btsend.addMouseListener(new MouseAdapter() {    //#������
         public void mousePressed(MouseEvent e) {
            String str=tfChat.getText();
            tfChat.setText("");
            chatVector.add(str);
            model.addElement("��: "+str);
            tfChat.requestFocus();
         }
      });
   }
   
   public static void main(String[] args) {
      CarChatPage cp=new CarChatPage();
      cp.setSize(400, 600);
      cp.setVisible(true);
   }

@Override
public void run() {
	try {
		while(!isStop) {
			Object obj=in.readObject();
			System.out.println("Ŭ���̾�Ʈ obj"+obj);
			if(obj==null) return;
			if(obj instanceof UserMessage) {
				UserMessage data=(UserMessage)obj;
				parsing(data);
			}
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}    

}