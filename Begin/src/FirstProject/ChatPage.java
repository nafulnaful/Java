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

   

   
   // ���� ��¥
   Date date = new Date();
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
   String dateNewFormat = sdf.format(date);

   public ChatPage() {
      super(":: 1:1 ���Ǽ��� ::");

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
      lbTop = new JLabel("", new ImageIcon("./pj_img/��ܹ�_����.png"), JLabel.CENTER);
      lbDone = new JLabel("", new ImageIcon("./pj_img/����.png"), JLabel.CENTER);
      pNorth.add(lbTop);
      pSouth_E.add(lbDone);

      // TextField, Button
      tfChat = new JTextField("   ������ �Է��� ������", 25);
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
            model.addElement("��: " + str);
            tfChat.requestFocus();
         }
      });

      // ����Ű ������ �� �����ϱ�
      
      tfChat.addKeyListener(new KeyAdapter() {

         // Ű���忡�� Ű �ϳ��� �������� �ڵ����� ����Ǵ� �޼ҵ�..: �ݹ� �޼ҵ�

         @Override

         public void keyPressed(KeyEvent e) {

            super.keyPressed(e);

            // �Է¹��� Ű�� �������� �˾Ƴ���, KeyEvent ��ü�� Ű������ ���� ��������

            int keyCode = e.getKeyCode();

            switch (keyCode) {
            
//            case KeyEvent.vl
            

            case KeyEvent.VK_ENTER:
               tfChat.setText("");
               String str = tfChat.getText();
               model.addElement("��: " + str);
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