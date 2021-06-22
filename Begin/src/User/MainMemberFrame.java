package User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class MainMemberFrame extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel pN =new JPanel(new GridLayout(1,0));
	JPanel pC=new JPanel();
	JLabel lbLogin, lbJoin, lbList;//MouseEvent
	
	LoginPage loginP;
	JoinPage joinP;
	ListPage listP;
	
	CardLayout card;//ī�巹�̾ƿ��� ��������� ��������. => �̺�Ʈ �����ؾ� �ϹǷ�
	
	Hashtable<String, User> userTable=new Hashtable<>();
	//key��: ���̵�, value��: User��ü
	/*JoinPage�� ȸ������ ��ư�� ������ userTable�� �ش� ȸ�������� 
	 * ������ �ڿ�, Ÿ��Ʋ�� "1�� ����" ��µǵ��� ó���غ���*/
	boolean isLogin=false;
	
	ObjectOutputStream out;//��ü�� ���Ϸ� ������ �� �ִ� Ŭ����
	ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;

	public MainMemberFrame() {
		super("::MainMemberFrame::");
		//�⺻ ȸ�� ������ �������� 
		readFile("src/user/app/user.txt");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		p.add(pN,"North");
		p.add(pC,"Center");
		pC.setBackground(new Color(122,111,90));
		
		lbLogin=new JLabel("Login",new ImageIcon("images/img2.png"), JLabel.CENTER);
		lbJoin=new JLabel("Join",new ImageIcon("images/img3.png"), JLabel.CENTER);
		lbList=new JLabel("Users",new ImageIcon("images/img4.png"),JLabel.CENTER);
		
		//lbLogin.setBackground(Color.white);
		//lbLogin.setOpaque(true);//���� �����ϰ� �����ؾ� ������ �����
		setLabelUI(lbLogin);
		setLabelUI(lbJoin);
		setLabelUI(lbList);
		
		pN.add(lbLogin);
		pN.add(lbJoin);
		pN.add(lbList);
		
		pC.setLayout(card=new CardLayout());//ī�巹�̾ƿ����� ����
		loginP=new LoginPage(this);
		joinP=new JoinPage();
		listP=new ListPage(this);
		//ī�巹�̾ƿ��� ���� add�� �� ��Ī�� �־�� �Ѵ�.
		pC.add("login",loginP);
		pC.add("join", joinP);
		pC.add("list", listP);
		
		//�󺧿� ������ �����ؼ� MyHandler�� �����ϱ�
		MyHandler handler=new MyHandler(this);
		lbLogin.addMouseListener(handler);
		lbJoin.addMouseListener(handler);
		lbList.addMouseListener(handler);
		
		joinP.btJoin.addActionListener(handler);
		joinP.btReset.addActionListener(handler);
		
		loginP.btLogin.addActionListener(handler);
		
		

		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//userTable�� ���Ͽ� ��������
				saveFile("src/user/app/user.txt");
				System.exit(0);
			}
		});
		
	}//������------------
	
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
			setTitle(fileName+"�� ���� �Ϸ�!");
			System.out.println(fileName+"�� ���� �Ϸ�!");
		} catch (IOException e) {
			setTitle("���� ���� �� ���� �߻�: "+e.getMessage());
			e.printStackTrace();
		}
		
	}//-------------------
	
	public void clearJoinInput() {
		joinP.tfName.setText("");
		joinP.tfUserid.setText("");
		joinP.tfPwd.setText("");
		joinP.tfTel.setText("");
		joinP.tfName.requestFocus();
	}//--------------------
	public void join() {
		String name=joinP.tfName.getText();
		String userid=joinP.tfUserid.getText();
		//String pwd=joinP.tfPwd.getText();
		char[] ch=joinP.tfPwd.getPassword();
		String pwd=new String(ch);
		
		String tel=joinP.tfTel.getText();
		//���̵� �ߺ�üũ ���⼭ �ؾ���
		//userTable�� key������ �����ؼ� ���� �����Ϸ��� ���̵� 
		//�̹� ����Ǿ� �ִ��� ã�ƺ���==> �̹� �ִٸ� "�ٸ� ���̵� �Է��ϼ���"
		//return
		/*
		Set<String> set=userTable.keySet();
		for(String id:set) {
			if(id.equals(userid)) {
				JOptionPane.showMessageDialog(joinP,
						"���̵�� �̹� ������Դϴ�. �ٸ� ���̵� �Է��ϼ���");
				joinP.tfUserid.requestFocus();
				return;
			}
		}
		*/
		boolean isUse=idCheck(userid);//���̵� �ߺ�üũ �޼ҵ� ȣ��
		if(!isUse) {
			JOptionPane.showMessageDialog(joinP,
					"���̵�� �̹� ������Դϴ�. �ٸ� ���̵� �Է��ϼ���");
			joinP.tfUserid.requestFocus();
			return;
		}
		
		User user=new User(name,userid, pwd, tel);
		userTable.put(userid, user);
		setTitle("ȸ������ ó�� �Ϸ�!! ���� ȸ����: "+userTable.size()+"��");
		clearJoinInput();
		
	}//----------------------
	
	public boolean idCheck(String userid) {
		boolean b=userTable.containsKey(userid);
		//key�� �߿� userid�� �ش��ϴ� ���� ������ true�� ��ȯ�Ѵ�.
		return !b;
	}
	
	public void setLabelUI(JLabel lb) {
		lb.setOpaque(true);
		lb.setBackground(Color.white);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.BOTTOM);
		lb.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}

	public static void main(String[] args) {
		MainMemberFrame my = new MainMemberFrame();
		my.setSize(500, 700);
		my.setVisible(true);
	}

}