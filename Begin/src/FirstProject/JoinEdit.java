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

    /**user���� ���� ���̺�*/
    Hashtable<String, User> userTable = new Hashtable<>();
    boolean isLogin=false;
    ObjectOutputStream out;
    ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;

   public JoinEdit() {
      super(":: Join2 ::");
      //�⺻ ȸ�� ������ �������� 
      readFile("src/FirstProject/user.txt");
      Container cp = this.getContentPane();
      cp.add(p, "Center");
      p.setBackground(Color.white);
      
      // Join2 â ��ġ, ũ�����
      setLocation(300, 100);
      setResizable(false);
      
      // Panel
      add(pNorth, "North");
      add(pCenter, "Center");
      add(pSouth, "South");

      pNorth.add(pNorth_W);
      pNorth.add(pNorth_C);

      // CheckBox
      cbUse = new JCheckBox("���� ������ �����մϴ�.");
      pSouth.add(cbUse);

      // Label
      lbTop = new JLabel("", new ImageIcon("./pj_img/��ܹ�_ȸ����������.png"), JLabel.CENTER);
      lbMust1 = new JLabel("", new ImageIcon("./pj_img/�ʼ��Է�.png"), JLabel.CENTER);
      lbMust2 = new JLabel("", new ImageIcon("./pj_img/�ʼ��Է�.png"), JLabel.CENTER);
      lbDone = new JLabel("", new ImageIcon("./pj_img/�Ϸ�.png"), JLabel.CENTER);
      pNorth.add(lbTop);
      pSouth.add(lbDone);

      lbName = new JLabel("", new ImageIcon("./pj_img/����_�̸�.png"), JLabel.CENTER);
      lbBirth = new JLabel("", new ImageIcon("./pj_img/����_�������.png"), JLabel.CENTER);
      lbId = new JLabel("", new ImageIcon("./pj_img/����_���̵�.png"), JLabel.CENTER);
      lbPwd = new JLabel("", new ImageIcon("./pj_img/����_��й�ȣ.png"), JLabel.CENTER);
      lbTel = new JLabel("", new ImageIcon("./pj_img/����_�޴���ȭ.png"), JLabel.CENTER);
      lbEmail = new JLabel("", new ImageIcon("./pj_img/����_�̸���.png"), JLabel.CENTER);

      // TextField
      tfName = new JTextField(20);
      tfBirth = new JTextField(" YYYYMMDD", 20);
      tfId = new JTextField(" ���� �ҹ��ڿ� ���� ���� 4~12�ڸ�", 20);
      tfPwd = new JPasswordField(20);
      tfTel = new JTextField(" '-' �����ϰ� ���ڸ� �Է�", 20);
      tfEmail = new JTextField(" example@chacha.com", 20);

      // Label + TextField �׸��� ����
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

      // Panel �ɼ�
      pNorth.setBackground(new Color(162, 108, 254));
      pCenter.setBackground(Color.white);
      pSouth.setBackground(Color.white);

      pNorth_W.setLayout(new GridLayout(6, 1));
      pNorth_C.setLayout(new GridLayout(6, 1));

      // CheckBox �ɼ�
      cbUse.setHorizontalAlignment(JCheckBox.CENTER);
      cbUse.setBackground(Color.white);
      cbUse.setOpaque(true);

      // TextField �ɼ�
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
			//userTable�� ���Ͽ� ����
			saveFile("src/FirstProject/user.txt");
			dispose();
		}
	  });
		
		/**JoinHandler �ڵ鷯 ����*/
		
		
   }// ������------
  
   /**�˸�â showMsg()*/
   public void showMsg(String message) {
	   JOptionPane.showMessageDialog(pCenter, message);
   }//----------------------------------
   
   /**userTable => user.txt ����*/
   public void readFile(String fileName) {
		try {
			fin=new FileInputStream(fileName);
			in=new ObjectInputStream(fin);
			Object obj=in.readObject();
			userTable=(Hashtable<String,User>)obj;
			setTitle("���� ȸ�� ��: "+userTable.size());
		} catch (Exception e) {
			setTitle("���� �д� �� ����: "+e.getMessage());
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
			System.out.println(fileName+"�� ���� �Ϸ�!");
		} catch (IOException e) {
			System.out.println("���� ���� �� ���� �߻�: "+e.getMessage());
			e.printStackTrace();
		}
	}//-------------------

   /**Join �������*/
   public void join() {
      String name=tfName.getText();
      String birth=tfBirth.getText();
      String id=tfId.getText();
      char[] ch=tfPwd.getPassword();
      String pwd=new String(ch);
      String tel=tfTel.getText();
      String email=tfEmail.getText();
  
      /**���� üũ*/
      if(name.trim().equals("") || birth.trim().equals("") || id.trim().equals("") || pwd.trim().equals("") || tel.trim().equals("") || email.trim().equals("")) {
    	  showMsg("��� ������ �Է��ϼ���.");
    	  return;
      }else if(!cbUse.isSelected()) {
    	  showMsg("���� ������ �����ϼ���.");
    	  return;
      }
      
      name=name.trim();
      birth=birth.trim();
      id=id.trim();
      pwd=pwd.trim();
      tel=tel.trim();
      email=email.trim();
      
      /**userTable Hashtable ���� ����*/
      User user=new User(name, birth, id, pwd, tel, email);
      userTable.put(id, user);
      System.out.println("ȸ������ �Ϸ�! ���� ȸ����: "+userTable.size()+"��");
      showMsg("ȸ�������� �Ϸ�Ǿ����ϴ�!");
      dispose();
   }//----------------------
      
   /**key�� �ߺ� üũ �� true ��ȯ*/
   public boolean idCheck(String id) {
	   boolean b=userTable.containsKey(id);
	   return !b;
   }
  
   /**�Է�â ����*/
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