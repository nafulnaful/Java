package ui;
import data.*;  

import function.*;
import data.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;


import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainPanel extends JFrame {
	/*   
	 * 	148~150 나중에 지워주세요
	 *  로그인 false로 바꿔야 합니다.
	 *   
	 *    
	 *   
	 * */
	public JPanel p = new JPanel(new BorderLayout());
	public JPanel pN =new JPanel(new GridLayout(1,0));
	public JPanel pC=new JPanel();
	public JLabel lbHome, lbProducts, lbMy;
	
	public HomePanel homeP;
	public ProductsPanel productsP;
	public LoginPanel loginP;
	public JoinPanel joinP;	
	public MyPanel myP;
	public MyPanel2 myP2;//다혜
	
	public boolean isLogin=false;
	
	
	public UserFunction uf = new UserFunction(this);
	
	public UserDB Iam;   
	
	//public ArrayList<ItemBox> productsList = new ArrayList<>(); 
	public ArrayList<ProductsDB> productsList2= new ArrayList<>();   //61  성근 
	public Hashtable<String, data.UserDB> userTable=new Hashtable<>();
	public HashMap<String,ImageDB> iDB=new HashMap<>();
	public CardLayout card;
	public productFunction pF;   
	public productDetailsPanel detailP; // 성
	private Join jl;
	ObjectOutputStream out;//객체를 파일로 저장할 수 있는 클래스
	ObjectInputStream in;
	FileOutputStream fout;//파일하고 연결하는 애들
	FileInputStream fin;
	
	public Join getJl() {
		return jl;
	}
	public void setJl(Join jl) {
		this.jl = jl;
	}


	@SuppressWarnings("unchecked")
	public MainPanel() {
		super("::평화로운 중고나라::");
		//System.out.println("starttest");
		readFile("src/data/user.txt");
			
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/data/pdata.txt"));
			productsList2 = (ArrayList<ProductsDB>)ois.readObject();//파일에서 ArrayList읽기
			ois.close();
		} catch (Exception ex)
		{
			System.out.println("파일을 찾지못했습니다.");
		}
		
		
		
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/data/image.txt"));
			iDB = (HashMap<String,ImageDB>)ois.readObject();//파일에서 ArrayList읽기
			ois.close();
		} catch (Exception ex)
		{
			System.out.println("파일을 찾지못했습니다.");
		}
		
		try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		p.add(pN,"South");
		p.add(pC,"Center");
		pC.setBackground(new Color(122,111,90));
		
		lbHome=new JLabel("홈",new ImageIcon("material-design-icons-1.0.0/material-design-icons-1.0.0/action/1x_web/ic_home_black_48dp.png"), JLabel.CENTER);
		lbProducts=new JLabel("중고거래",new ImageIcon("material-design-icons-1.0.0/material-design-icons-1.0.0/action/1x_web/ic_shopping_basket_black_48dp.png"), JLabel.CENTER);
		lbMy=new JLabel("로그인",new ImageIcon("material-design-icons-1.0.0/material-design-icons-1.0.0/action/1x_web/ic_face_unlock_black_48dp.png"),JLabel.CENTER);
		
		SetLabelUI slu=new SetLabelUI();
		slu.setLabelUI(lbHome);
		slu.setLabelUI(lbProducts);
		slu.setLabelUI(lbMy);
		
		pN.add(lbHome);
		pN.add(lbProducts);
		pN.add(lbMy);
		
		pC.setLayout(card=new CardLayout());
		homeP=new HomePanel(this);
		productsP=new ProductsPanel(this);
		loginP=new LoginPanel(this);
		joinP=new JoinPanel(this);
		myP=new MyPanel();
		myP2=new MyPanel2();//다혜
		
		pC.add("home",homeP);
		pC.add("products",productsP);
		pC.add("login", loginP);
		pC.add("join",joinP);
		pC.add("my",myP);
		pC.add("my2",myP2);//다혜
		
		Handler handler=new Handler(this);
		lbHome.addMouseListener(handler);
		lbProducts.addMouseListener(handler);
		lbMy.addMouseListener(handler);
		loginP.btLogin.addActionListener(handler);
		loginP.btJoin.addActionListener(handler);
		joinP.btJoin.addActionListener(handler);
		joinP.btReset.addActionListener(handler);
		productsP.btSell.addActionListener(handler);
		productsP.lb.addMouseListener(handler);	
		myP2.btUpdate.addActionListener(handler);//다혜
		myP.btUpdate.addActionListener(handler);//다혜
		myP.btLogout.addActionListener(handler);//다혜
		homeP.bt_SearchPanel.addActionListener(handler);//성근
		myP2.btDel.addActionListener(handler);//602
		
		jl=new Join(this);
		pF=new productFunction(this);  
		
//		UserDB dh = new UserDB("p","p","p","p");
//		userTable.put("p", dh);
//		Iam=dh;
		
		
		card.show(pC, "login");
		this.addWindowListener(new WindowAdapter() {//WindowAdapter를 상속받는 클래스 만들기(하단)
			public void windowClosing(WindowEvent e) {
				//userTable을 파일에 저장하자
				saveFile("src/data/user.txt");//File로 저장할거야(파일명 user.txt)
				System.exit(0);
			}
		});
	}//생성자------

	public void readFile(String fileName) {//읽어내는 메소드
		try {
			fin=new FileInputStream(fileName);
			in=new ObjectInputStream(fin);//오브젝트 객체를 읽는 역할?!
			Object obj = in.readObject();//해당 클래스가 없으면 오류남=>catch에서 잡기
			userTable=(Hashtable<String,data.UserDB>)obj;//Object타입을 우리가 정한 Hashtable타입으로 변환
		
		}catch(Exception e) {}
	}//------------

	public void saveFile(String fileName) {//저장하는 메소드
		//exception이 나므로 try~catch절 써주기
		try {
			fout=new FileOutputStream(fileName);
			out=new ObjectOutputStream(fout);
			out.writeObject(userTable);
			out.flush();//데이터를 한꺼번에 ㅇ?해주는
			out.close();
			fout.close();
			System.out.println(fileName+"에 저장 완료!");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MainPanel my = new MainPanel();
		my.setSize(418, 650);
		my.setVisible(true);
		my.setResizable(false);
		
	}
}
