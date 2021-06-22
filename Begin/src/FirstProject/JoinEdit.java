package FirstProject;

import java.awt.*;



import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import FirstProject.User;

public class JoinEdit extends JFrame {

   JPanel p = new MyJPanel();
   JPanel pNorth = new JPanel();
   JPanel pCenter = new JPanel(new FlowLayout());
   JPanel pSouth = new JPanel(new GridLayout(2,1));

   JPanel pNorth_W = new JPanel(new GridLayout(7, 1, 10, 10));
   JPanel pNorth_C = new JPanel(new GridLayout(7, 1, 10, 10));

   JLabel lbTop, lbMust1, lbMust2, lbName, lbBirth, lbId, lbPwd, lbTel, lbEmail, lbDone;
   JTextField tfName, tfBirth, tfId, tfTel, tfEmail;
   JPasswordField tfPwd;
   JCheckBox cbUse;

    /**user정보 저장 테이블*/
    Hashtable<String, User> userTable = new Hashtable<>();
    boolean isLogin=false;
    ObjectOutputStream out;
    ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;

   public JoinEdit() {
      super(":: Join2 ::");
      //기본 회원 데이터 가져오기 
      readFile("src/FirstProject/user.txt");
      Container cp = this.getContentPane();
      cp.add(p, "Center");
      p.setBackground(Color.white);
      
      // Join2 창 위치, 크기고정
      setLocation(300, 100);
      setResizable(false);
      
      // Panel
      add(pNorth, "North");
      add(pCenter, "Center");
      add(pSouth, "South");

      pNorth.add(pNorth_W);
      pNorth.add(pNorth_C);

      // CheckBox
      cbUse = new JCheckBox("정보 수정에 동의합니다.");
      pSouth.add(cbUse);

      // Label
      lbTop = new JLabel("", new ImageIcon("./pj_img/상단바_회원정보수정.png"), JLabel.CENTER);
      lbMust1 = new JLabel("", new ImageIcon("./pj_img/필수입력.png"), JLabel.CENTER);
      lbMust2 = new JLabel("", new ImageIcon("./pj_img/필수입력.png"), JLabel.CENTER);
      lbDone = new JLabel("", new ImageIcon("./pj_img/완료.png"), JLabel.CENTER);
      pNorth.add(lbTop);
      pSouth.add(lbDone);

      lbName = new JLabel("", new ImageIcon("./pj_img/수정_이름.png"), JLabel.CENTER);
      lbBirth = new JLabel("", new ImageIcon("./pj_img/수정_생년월일.png"), JLabel.CENTER);
      lbId = new JLabel("", new ImageIcon("./pj_img/수정_아이디.png"), JLabel.CENTER);
      lbPwd = new JLabel("", new ImageIcon("./pj_img/수정_비밀번호.png"), JLabel.CENTER);
      lbTel = new JLabel("", new ImageIcon("./pj_img/수정_휴대전화.png"), JLabel.CENTER);
      lbEmail = new JLabel("", new ImageIcon("./pj_img/수정_이메일.png"), JLabel.CENTER);

      // TextField
      tfName = new JTextField(20);
      tfBirth = new JTextField(" YYYYMMDD", 20);
      tfId = new JTextField(" 영문 소문자와 숫자 조합 4~12자리", 20);
      tfPwd = new JPasswordField(20);
      tfTel = new JTextField(" '-' 제외하고 숫자만 입력", 20);
      tfEmail = new JTextField(" example@chacha.com", 20);

      // Label + TextField 그리드 적용
      pCenter.add(lbMust1);
      pCenter.add(lbMust2);
      pCenter.add(lbName);
      pCenter.add(tfName);
      pCenter.add(lbBirth);
      pCenter.add(tfBirth);
      pCenter.add(lbId);
      pCenter.add(tfId);
      pCenter.add(lbPwd);
      pCenter.add(tfPwd);
      pCenter.add(lbTel);
      pCenter.add(tfTel);
      pCenter.add(lbEmail);
      pCenter.add(tfEmail);

      // Panel 옵션
      pNorth.setBackground(new Color(162, 108, 254));
      pCenter.setBackground(Color.white);
      pSouth.setBackground(Color.white);

      pNorth_W.setLayout(new GridLayout(6, 1));
      pNorth_C.setLayout(new GridLayout(6, 1));

      // CheckBox 옵션
      cbUse.setHorizontalAlignment(JCheckBox.CENTER);
      cbUse.setBackground(Color.white);
      cbUse.setOpaque(true);

      // TextField 옵션
      tfName.setPreferredSize(new Dimension(80, 40));
      tfBirth.setPreferredSize(new Dimension(80, 40));
      tfId.setPreferredSize(new Dimension(80, 40));
      tfPwd.setPreferredSize(new Dimension(80, 40));
      tfTel.setPreferredSize(new Dimension(80, 40));
      tfEmail.setPreferredSize(new Dimension(80, 40));
      tfBirth.setForeground(Color.LIGHT_GRAY);
      tfId.setForeground(Color.LIGHT_GRAY);
      tfTel.setForeground(Color.LIGHT_GRAY);
      tfEmail.setForeground(Color.LIGHT_GRAY);

	  addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			//userTable을 파일에 저장
			saveFile("src/FirstProject/user.txt");
			dispose();
		}
	  });
		
		/**JoinHandler 핸들러 부착*/
		
		
   }// 생성자------
  
   /**알림창 showMsg()*/
   public void showMsg(String message) {
	   JOptionPane.showMessageDialog(pCenter, message);
   }//----------------------------------
   
   /**userTable => user.txt 저장*/
   public void readFile(String fileName) {
		try {
			fin=new FileInputStream(fileName);
			in=new ObjectInputStream(fin);
			Object obj=in.readObject();
			userTable=(Hashtable<String,User>)obj;
			setTitle("현재 회원 수: "+userTable.size());
		} catch (Exception e) {
			setTitle("파일 읽는 중 에러: "+e.getMessage());
		} 
	}//----------------------------

	public void saveFile(String fileName) {
		try {
			fout=new FileOutputStream(fileName);
			out=new ObjectOutputStream(fout);
			out.writeObject(userTable);
			out.flush();
			out.close();
			fout.close();
			System.out.println(fileName+"에 저장 완료!");
		} catch (IOException e) {
			System.out.println("파일 저장 중 에러 발생: "+e.getMessage());
			e.printStackTrace();
		}
	}//-------------------

   /**Join 정보등록*/
   public void join() {
      String name=tfName.getText();
      String birth=tfBirth.getText();
      String id=tfId.getText();
      char[] ch=tfPwd.getPassword();
      String pwd=new String(ch);
      String tel=tfTel.getText();
      String email=tfEmail.getText();
  
      /**공백 체크*/
      if(name.trim().equals("") || birth.trim().equals("") || id.trim().equals("") || pwd.trim().equals("") || tel.trim().equals("") || email.trim().equals("")) {
    	  showMsg("모든 정보를 입력하세요.");
    	  return;
      }else if(!cbUse.isSelected()) {
    	  showMsg("정보 수정에 동의하세요.");
    	  return;
      }
      
      name=name.trim();
      birth=birth.trim();
      id=id.trim();
      pwd=pwd.trim();
      tel=tel.trim();
      email=email.trim();
      
      /**userTable Hashtable 정보 저장*/
      User user=new User(name, birth, id, pwd, tel, email);
      userTable.put(id, user);
      System.out.println("회원가입 완료! 현재 회원수: "+userTable.size()+"명");
      showMsg("회원가입이 완료되었습니다!");
      dispose();
   }//----------------------
      
   /**key값 중복 체크 후 true 반환*/
   public boolean idCheck(String id) {
	   boolean b=userTable.containsKey(id);
	   return !b;
   }
  
   /**입력창 비우기*/
   public void clearJoinInput() {
		tfName.setText("");
		tfBirth.setText("");
		tfId.setText("");
		tfPwd.setText("");
		tfTel.setText("");
		tfEmail.setText("");
		tfName.requestFocus();
	}//--------------------
   
  
  
}