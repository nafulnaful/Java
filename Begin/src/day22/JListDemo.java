package day22;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*MFC==>MVC����
 *JFc==>MVC����==>UI DelegationModel
 *
 *Model==>�����͸� ������ �ִ� Ŭ����
 *View==>ȭ���
 *Controller==>view�� Model�� ���̿��� �帧�� �����ϴ� Ŭ����*/
public class JListDemo extends JFrame {

   JPanel p = new JPanel();

   JList<String> lst1, lst2; //view ==> ������Ʈ�� �����̳ʵ��� view�� �شܵȴ�
   JComboBox<String> combo1 ,combo2;//view
   
   DefaultListModel<String> model1;//JList�� ��, �����͸� ���� Ŭ����
   DefaultComboBoxModel<String> model2;//JComboBox�� ��
   
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
      
      //view�� model�� ����
      lst1.setModel(model1);
      
      model2.addElement("Java");
      model2.addElement("JavaScript");
      model2.addElement("JSP");
      model2.addElement("SQL");
      
      //View�� Model����
      combo1.setModel(model2);
   
      lst2=new JList<>(data);
      //������ ���ο��� data�� �⺻����Ʈ�𵨿� �����Ѵ�.
      p.add(new JScrollPane(lst2));
      
      combo2=new JComboBox<>(data);
      p.add(combo2);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//������------

   public static void main(String[] args) {
      JListDemo my = new JListDemo();
      my.setSize(500, 500);
      my.setVisible(true);
   }

}

