package day23;
/*(5)*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;//�׵θ� �־��ֱ� ���� import�� ��
import java.util.*;

public class MainMemberFrame extends JFrame {

   JPanel p = new JPanel(new BorderLayout());
   JPanel pN =new JPanel(new GridLayout(1,0));//���� ���� panel(�յ��ϰ� �ϱ����� gridlayout)
   JPanel pC =new JPanel();//����� ���� panel
   JLabel lbLogin, lbJoin, lbList;//���� ��-�̺�Ʈ �ڵ鷯 �ۼ��� ���� �̺�Ʈ �ȸ��� ���̶���
   //MouseEvent�� ����
   
   LoginPage loginP;
   JoinPage joinP;
   ListPage listP;//���� �ǳڿ� ���� �ǵ� CardLayOut�� ����� ���̴�
   
   CardLayout card;//ī�巹�̾ƿ��� ��������� ��������.(�������� x) => �̺�Ʈ ������ �ؾ� �ϹǷ�

   Hashtable<String, User> userTable=new Hashtable<>();
   //[����2]key��: ���̵�, value��: User��ü
   /*JoinPage�� ȸ������ ��ư�� ������ userTable�� �ش� ȸ��������
    *  ������ �ڿ�, Ÿ��Ʋ�� "1�� ����" ��µǵ��� ó���غ���*/
   
  
   
   public MainMemberFrame() {
      super("::MainMemberFrame::");
      Container cp = this.getContentPane();
      cp.add(p, "Center");
      p.setBackground(Color.white);

      p.add(pN,"North");
      p.add(pC,"Center");
      pC.setBackground(new Color(122,111,90));
      
      lbLogin=new JLabel("Login",new ImageIcon("Images/img2.png"), JLabel.CENTER);//��ư ����
      lbJoin=new JLabel("Join",new ImageIcon("Images/img3.png"), JLabel.CENTER);//��ư�̸�,��ư�̹���,��ư��ġ
      lbList=new JLabel("Users",new ImageIcon("Images/img4.png"), JLabel.CENTER);
      
      
      /*lbLogin.setBackground(Color.white);
      //Label�� �������ϱ⶧���� �����ϰ� ���������Ѵ�.
      lbLogin.setOpaque(true);
      �������� �κ��̹Ƿ� �ؿ� setLabeUi�� ���� �ش�.
      */
      
      setLabelUI(lbLogin);
      setLabelUI(lbJoin);
      setLabelUI(lbList);
      
      pN.add(lbLogin);//��ư ���̱�pN��
      pN.add(lbJoin);
      pN.add(lbList);
      
      pC.setLayout(card=new CardLayout());//ī�巹�̾ƿ����� ����
      loginP=new LoginPage();
      joinP=new JoinPage();
      listP=new ListPage();
      //ī�巹�̾ƿ��� ���� add �� �� ��Ī�� �־�� �Ѵ�.
      pC.add("Login",loginP);
      pC.add("Join",joinP);
      pC.add("List",listP);
      //[����1]�󺧿� ������ �����ؼ� MyHandler�� �����ϱ�
      MyHandler handler=new MyHandler();
      lbLogin.addMouseListener(handler);
      lbJoin.addMouseListener(handler);
      lbList.addMouseListener(handler);
      
      joinP.btJoin.addActionListener(handler);
      joinP.btReset.addActionListener(handler);
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//������------
   
   public void clearJoinInput() {
	   joinP.tfName.setText("");
	   joinP.tfUserid.setText("");
	   joinP.tfPwd.setText("");
	   joinP.tfTel.setText("");
	   joinP.tfName.requestFocus();
   	   }//--------clearJoin
   public void join() {
	   String name=joinP.tfName.getText();
	   String userid=joinP.tfUserid.getText();
	   //String pwd=joinP.tfPwd.getText();
	   char[] ch=joinP.tfPwd.getPassword();
	   String pwd=new String(ch);
	   
	   
	   String tel=joinP.tfTel.getText();
	   //[����3]���̵� �ߺ�üũ ���⼭ �ؾ���
	   //userTable�� key������ �����ؼ� ���� �����Ϸ��� ���̵�
	   //�̹� ����Ǿ� �ִ��� ã�ƺ���==> �̹� ������ "�ٸ� ���̵� �Է��ϼ���"
	   //return
	   
	   User user=new User(name,userid, pwd, tel);//Hashtable �ޱ�����
	   userTable.put(userid,  user);
	   setTitle("ȸ������ ó�� �Ϸ�!! ���� ȸ����: "+userTable.size()+"��");
	   clearJoinInput();
	   }//--------------------join
   
   
   //�̺�Ʈ �ڵ鷯//java.awt.event Interface MouseListener
   class MyHandler implements MouseListener, ActionListener
   {
	   public void actionPerformed(ActionEvent e) {
		   Object o=e.getSource();
		   if(o==joinP.btJoin) {
			   join();
		   }else if(o==joinP.btReset) {
			  clearJoinInput();
		   }
	   }
	   
	   public void mouseClicked(MouseEvent e) {
		   //System.out.println("click");
	   }
	   public void mouseEntered(MouseEvent e) {
		   //System.out.println("enter");
	   }
	   public void mouseExited(MouseEvent e) {
		   //System.out.println("exit");
	   }
	   public void mousePressed(MouseEvent e) {
		   //System.out.println("press");
		   Object obj=e.getSource();
		   if(obj==lbLogin) {
			   card.show(pC, "Login");//ī�忡�� ������ (���,��Ī)
		   }else if(obj==lbJoin) {
			   card.show(pC, "Join");
		   }else if(obj==lbList) {
			   card.show(pC, "List");
		   }
	   }///pressed------------------------------
	   public void mouseReleased(MouseEvent e) {
		   //System.out.println("release");
	   }
	   
   }////////////////////////

   public void setLabelUI(JLabel lb) {
	   lb.setOpaque(true);
	   lb.setBackground(Color.white);
	   lb.setHorizontalTextPosition(JLabel.CENTER);//�ؽ�Ʈ�� ��ġ�� �߾�����
	   lb.setVerticalTextPosition(JLabel.BOTTOM);//�ؽ�Ʈ�� ��ġ ������
	   lb.setBorder(new EtchedBorder(EtchedBorder.RAISED));//�󺧿� �׵θ� �־���
   }
   
   public static void main(String[] args) {
      MainMemberFrame my = new MainMemberFrame();
      my.setSize(500, 700);
      my.setVisible(true);
   }

}
