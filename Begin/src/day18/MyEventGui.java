package day18;

import java.awt.*;
import java.awt.event.*;//1)
/*
 1> import java.awt.event.*; 
 2> XXXListener 인터페이스를 상속 
 3> 2번이 가지고 있는 추상 메소드 재정의 
 4> 이벤트소스와 핸들러를 연결해줌 
 ...addXXXListener()메소드로. 
 5> 3번에서 재정의한 메소드에 구체적인 
 이벤트 처리 코드 구현
 */
public class MyEventGui extends Frame implements ActionListener {//2)
	
	Button btR, btG, btB;

   public MyEventGui() {
      super("::MyEventGui::");
      setLayout(new FlowLayout());
      //버튼 3개 생성해서 add하기 "Red","Green","Blue"
      	btR=new Button("Red");
      	btG=new Button("Green");
      	btB=new Button("Blue");
      	
      	add(btR); add(btG); add(btB);
      	
      	//이벤트 소스에 리스너 부착---
      	btR.addActionListener(this);//4)
      	btG.addActionListener(this);
      	btB.addActionListener(this);
      	
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }//생성자------

   @Override
   public void actionPerformed(ActionEvent e) {//3)
	   Object obj= e.getSource();//이벤트가 발생된 이벤트소스 객체의 주소값을 반환함
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

