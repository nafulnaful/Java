package FirstProject;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class ChatPage extends JFrame {

   JPanel p = new JPanel();
   JPanel pNorth = new JPanel(new GridLayout());
   JPanel pCenter = new JPanel(new GridLayout());
   JPanel pSouth = new JPanel(new BorderLayout());
   JPanel pSouth_E = new JPanel();
   JPanel pSouth_C = new JPanel();

   JLabel lbTop, lbDone;

   JList<String> lstChat;
   JTextField tfChat;

   Vector<String> chatVector;
   DefaultListModel<String> model;

   

   
   // 오늘 날짜
   Date date = new Date();
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
   String dateNewFormat = sdf.format(date);

   public ChatPage() {
      super(":: 1:1 문의센터 ::");

      Container cp = this.getContentPane();
      cp.add(p, "Center");
      p.setBackground(Color.WHITE);
      p.setLayout(new BorderLayout());

      // Panel
      p.add(pNorth, "North");
      p.add(pCenter, "Center");
      p.add(pSouth, "South");
      pSouth.add(pSouth_C, "Center");
      pSouth.add(pSouth_E, "East");
      pSouth_C.setBackground(Color.white);
      pSouth_E.setBackground(Color.white);

      // Label
      lbTop = new JLabel("", new ImageIcon("./pj_img/상단바_문의.png"), JLabel.CENTER);
      lbDone = new JLabel("", new ImageIcon("./pj_img/전송.png"), JLabel.CENTER);
      pNorth.add(lbTop);
      pSouth_E.add(lbDone);

      // TextField, Button
      tfChat = new JTextField("   질문을 입력해 보세요", 25);
      pSouth_C.add(tfChat);
      tfChat.setPreferredSize(new Dimension(0, 30));
      tfChat.setForeground(Color.LIGHT_GRAY);

      // Vector, List
      chatVector = new Vector<>();
      lstChat = new JList<>(chatVector);
      pCenter.add(lstChat, "Center");
      lstChat.setBorder(new TitledBorder(dateNewFormat));
      lstChat.setFont(getFont());

      model = new DefaultListModel<>();
      lstChat.setModel(model);

      tfChat.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            tfChat.setText("");
            tfChat.setForeground(Color.black);
         }
      });

      lbDone.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            tfChat.setText("");
            String str = tfChat.getText();
            chatVector.add(str);
            model.addElement("나: " + str);
            tfChat.requestFocus();
         }
      });

      // 엔터키 눌렀을 때 반응하기
      
      tfChat.addKeyListener(new KeyAdapter() {

         // 키보드에서 키 하나를 눌렀을때 자동으로 실행되는 메소드..: 콜백 메소드

         @Override

         public void keyPressed(KeyEvent e) {

            super.keyPressed(e);

            // 입력받은 키가 엔터인지 알아내기, KeyEvent 객체가 키에대한 정보 갖고있음

            int keyCode = e.getKeyCode();

            switch (keyCode) {
            
//            case KeyEvent.vl
            

            case KeyEvent.VK_ENTER:
               tfChat.setText("");
               String str = tfChat.getText();
               model.addElement("나: " + str);
               tfChat.setText("");
               break;

            }

         }

      });

      
      setVisible(true);

      tfChat.requestFocus();
      
      
      tfChat.getFocusAccelerator();
      
      
      

   }

   public static void main(String[] args) {
      ChatPage cp = new ChatPage();
      cp.setSize(400, 600);
      cp.setVisible(true);
   }

}