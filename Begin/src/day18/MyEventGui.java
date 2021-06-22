package day18;

import java.awt.*;
import java.awt.event.*;//1)
/*
 1> import java.awt.event.*; 
 2> XXXListener �������̽��� ��� 
 3> 2���� ������ �ִ� �߻� �޼ҵ� ������ 
 4> �̺�Ʈ�ҽ��� �ڵ鷯�� �������� 
 ...addXXXListener()�޼ҵ��. 
 5> 3������ �������� �޼ҵ忡 ��ü���� 
 �̺�Ʈ ó�� �ڵ� ����
 */
public class MyEventGui extends Frame implements ActionListener {//2)
	
	Button btR, btG, btB;

   public MyEventGui() {
      super("::MyEventGui::");
      setLayout(new FlowLayout());
      //��ư 3�� �����ؼ� add�ϱ� "Red","Green","Blue"
      	btR=new Button("Red");
      	btG=new Button("Green");
      	btB=new Button("Blue");
      	
      	add(btR); add(btG); add(btB);
      	
      	//�̺�Ʈ �ҽ��� ������ ����---
      	btR.addActionListener(this);//4)
      	btG.addActionListener(this);
      	btB.addActionListener(this);
      	
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }//������------

   @Override
   public void actionPerformed(ActionEvent e) {//3)
	   Object obj= e.getSource();//�̺�Ʈ�� �߻��� �̺�Ʈ�ҽ� ��ü�� �ּҰ��� ��ȯ��
	   if(obj == btR) {
		   //5)
		   this.setBackground(Color.red);
	   }else if(obj == btG) {
		   this.setBackground(Color.green);
	   }else if(obj == btB) {
		   this.setBackground(Color.blue);
	   }
	  
	   
	   
	   
   }//---------------------
   public static void main(String[] args) {
      MyEventGui my = new MyEventGui();
      my.setSize(500, 500);
      my.setVisible(true);
   }

}

