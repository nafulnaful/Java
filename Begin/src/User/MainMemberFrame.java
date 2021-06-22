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
	
	CardLayout card;//카드레이아웃은 멤버변수로 선언하자. => 이벤트 연동해야 하므로
	
	Hashtable<String, User> userTable=new Hashtable<>();
	//key값: 아이디, value값: User객체
	/*JoinPage의 회원가입 버튼을 누르면 userTable에 해당 회원정보를 
	 * 저장한 뒤에, 타이틀에 "1명 저장" 출력되도록 처리해보기*/
	boolean isLogin=false;
	
	ObjectOutputStream out;//객체를 파일로 저장할 수 있는 클래스
	ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;

	public MainMemberFrame() {
		super("::MainMemberFrame::");
		//기본 회원 데이터 가져오기 
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
		//lbLogin.setOpaque(true);//라벨을 투명하게 설정해야 배경색이 적용됨
		setLabelUI(lbLogin);
		setLabelUI(lbJoin);
		setLabelUI(lbList);
		
		pN.add(lbLogin);
		pN.add(lbJoin);
		pN.add(lbList);
		
		pC.setLayout(card=new CardLayout());//카드레이아웃으로 설정
		loginP=new LoginPage(this);
		joinP=new JoinPage();
		listP=new ListPage(this);
		//카드레이아웃일 경우는 add할 때 별칭을 주어야 한다.
		pC.add("login",loginP);
		pC.add("join", joinP);
		pC.add("list", listP);
		
		//라벨에 리스너 부착해서 MyHandler와 연결하기
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
				//userTable을 파일에 저장하자
				saveFile("src/user/app/user.txt");
				System.exit(0);
			}
		});
		
	}//생성자------------
	
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
			setTitle(fileName+"에 저장 완료!");
			System.out.println(fileName+"에 저장 완료!");
		} catch (IOException e) {
			setTitle("파일 저장 중 에러 발생: "+e.getMessage());
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
		//아이디 중복체크 여기서 해야함
		//userTable의 key값들을 추출해서 새로 가입하려는 아이디가 
		//이미 저장되어 있는지 찾아보기==> 이미 있다면 "다른 아이디 입력하세요"
		//return
		/*
		Set<String> set=userTable.keySet();
		for(String id:set) {
			if(id.equals(userid)) {
				JOptionPane.showMessageDialog(joinP,
						"아이디는 이미 사용중입니다. 다른 아이디를 입력하세요");
				joinP.tfUserid.requestFocus();
				return;
			}
		}
		*/
		boolean isUse=idCheck(userid);//아이디 중복체크 메소드 호출
		if(!isUse) {
			JOptionPane.showMessageDialog(joinP,
					"아이디는 이미 사용중입니다. 다른 아이디를 입력하세요");
			joinP.tfUserid.requestFocus();
			return;
		}
		
		User user=new User(name,userid, pwd, tel);
		userTable.put(userid, user);
		setTitle("회원가입 처리 완료!! 현재 회원수: "+userTable.size()+"명");
		clearJoinInput();
		
	}//----------------------
	
	public boolean idCheck(String userid) {
		boolean b=userTable.containsKey(userid);
		//key값 중에 userid에 해당하는 값이 있으면 true를 반환한다.
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