package day23;
/*(5)*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;//테두리 넣어주기 위해 import한 것
import java.util.*;

public class MainMemberFrame extends JFrame {

   JPanel p = new JPanel(new BorderLayout());
   JPanel pN =new JPanel(new GridLayout(1,0));//위에 붙일 panel(균등하게 하기위해 gridlayout)
   JPanel pC =new JPanel();//가운데에 붙일 panel
   JLabel lbLogin, lbJoin, lbList;//붙일 라벨-이벤트 핸들러 작성시 엑션 이벤트 안먹음 제이라벨은
   //MouseEvent가 먹음
   
   LoginPage loginP;
   JoinPage joinP;
   ListPage listP;//센터 판넬에 넣을 건데 CardLayOut을 사용할 것이다
   
   CardLayout card;//카드레이아웃은 멤버변수로 선언하자.(지역변수 x) => 이벤트 연동을 해야 하므로

   Hashtable<String, User> userTable=new Hashtable<>();
   //[문제2]key값: 아이디, value값: User객체
   /*JoinPage의 회원가입 버튼을 누르면 userTable에 해당 회원정보를
    *  저장한 뒤에, 타이틀에 "1명 저장" 출력되도록 처리해보기*/
   
  
   
   public MainMemberFrame() {
      super("::MainMemberFrame::");
      Container cp = this.getContentPane();
      cp.add(p, "Center");
      p.setBackground(Color.white);

      p.add(pN,"North");
      p.add(pC,"Center");
      pC.setBackground(new Color(122,111,90));
      
      lbLogin=new JLabel("Login",new ImageIcon("Images/img2.png"), JLabel.CENTER);//버튼 생성
      lbJoin=new JLabel("Join",new ImageIcon("Images/img3.png"), JLabel.CENTER);//버튼이름,버튼이미지,버튼위치
      lbList=new JLabel("Users",new ImageIcon("Images/img4.png"), JLabel.CENTER);
      
      
      /*lbLogin.setBackground(Color.white);
      //Label은 불투명하기때문에 투명하게 만들어줘야한다.
      lbLogin.setOpaque(true);
      공통적인 부분이므로 밑에 setLabeUi로 묶어 준다.
      */
      
      setLabelUI(lbLogin);
      setLabelUI(lbJoin);
      setLabelUI(lbList);
      
      pN.add(lbLogin);//버튼 붙이기pN에
      pN.add(lbJoin);
      pN.add(lbList);
      
      pC.setLayout(card=new CardLayout());//카드레이아웃으로 설정
      loginP=new LoginPage();
      joinP=new JoinPage();
      listP=new ListPage();
      //카드레이아웃일 경우는 add 할 때 별칭을 주어야 한다.
      pC.add("Login",loginP);
      pC.add("Join",joinP);
      pC.add("List",listP);
      //[문제1]라벨에 리스너 부착해서 MyHandler와 연결하기
      MyHandler handler=new MyHandler();
      lbLogin.addMouseListener(handler);
      lbJoin.addMouseListener(handler);
      lbList.addMouseListener(handler);
      
      joinP.btJoin.addActionListener(handler);
      joinP.btReset.addActionListener(handler);
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//생성자------
   
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
	   //[문제3]아이디 중복체크 여기서 해야함
	   //userTable의 key값들을 추출해서 새로 가입하려는 아이디가
	   //이미 저장되어 있는지 찾아보기==> 이미 있으면 "다른 아이디 입력하세요"
	   //return
	   
	   User user=new User(name,userid, pwd, tel);//Hashtable 받기위해
	   userTable.put(userid,  user);
	   setTitle("회원가입 처리 완료!! 현재 회원수: "+userTable.size()+"명");
	   clearJoinInput();
	   }//--------------------join
   
   
   //이벤트 핸들러//java.awt.event Interface MouseListener
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
			   card.show(pC, "Login");//카드에서 보여줘 (페널,별칭)
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
	   lb.setHorizontalTextPosition(JLabel.CENTER);//텍스트의 위치를 중앙으로
	   lb.setVerticalTextPosition(JLabel.BOTTOM);//텍스트의 위치 밑으로
	   lb.setBorder(new EtchedBorder(EtchedBorder.RAISED));//라벨에 테두리 넣어줌
   }
   
   public static void main(String[] args) {
      MainMemberFrame my = new MainMemberFrame();
      my.setSize(500, 700);
      my.setVisible(true);
   }

}
