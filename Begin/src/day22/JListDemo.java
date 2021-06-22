package day22;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*MFC==>MVC패턴
 *JFc==>MVC패턴==>UI DelegationModel
 *
 *Model==>데이터를 가지고 있는 클래스
 *View==>화면단
 *Controller==>view와 Model의 사이엥서 흐름을 제어하는 클래스*/
public class JListDemo extends JFrame {

   JPanel p = new JPanel();

   JList<String> lst1, lst2; //view ==> 컴포넌트나 컨테이너들의 view에 해단된다
   JComboBox<String> combo1 ,combo2;//view
   
   DefaultListModel<String> model1;//JList의 모델, 데이터를 갖는 클래스
   DefaultComboBoxModel<String> model2;//JComboBox의 모델
   
   //Controller => XXXRenderer, XXXEditor....
   
   String[] data= {"HTML","CSS","Vue.js","React.js"};
   
   public JListDemo() {
      super("::JListDemo::");
      Container cp = this.getContentPane();
      cp.add(p, "Center");
      p.setBackground(Color.white);

      lst1=new JList<>();
      p.add(new JScrollPane(lst1));
      
      
      combo1=new JComboBox<>();
      p.add(combo1);
      
      model1=new DefaultListModel<>();//Model
      model1.addElement("Windows");
      model1.addElement("Linux");
      model1.addElement("Max");
      
      //view와 model을 연결
      lst1.setModel(model1);
      
      model2.addElement("Java");
      model2.addElement("JavaScript");
      model2.addElement("JSP");
      model2.addElement("SQL");
      
      //View와 Model연결
      combo1.setModel(model2);
   
      lst2=new JList<>(data);
      //생성자 내부에서 data를 기본리스트모델에 전달한다.
      p.add(new JScrollPane(lst2));
      
      combo2=new JComboBox<>(data);
      p.add(combo2);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//생성자------

   public static void main(String[] args) {
      JListDemo my = new JListDemo();
      my.setSize(500, 500);
      my.setVisible(true);
   }

}

