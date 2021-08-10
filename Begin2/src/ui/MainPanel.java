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
	 * 	148~150 ���߿� �����ּ���
	 *  �α��� false�� �ٲ�� �մϴ�.
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
	public MyPanel2 myP2;//����
	
	public boolean isLogin=false;
	
	
	public UserFunction uf = new UserFunction(this);
	
	public UserDB Iam;   
	
	//public ArrayList<ItemBox> productsList = new ArrayList<>(); 
	public ArrayList<ProductsDB> productsList2= new ArrayList<>();   //61  ���� 
	public Hashtable<String, data.UserDB> userTable=new Hashtable<>();
	public HashMap<String,ImageDB> iDB=new HashMap<>();
	public CardLayout card;
	public productFunction pF;   
	public productDetailsPanel detailP; // ��
	private Join jl;
	ObjectOutputStream out;//��ü�� ���Ϸ� ������ �� �ִ� Ŭ����
	ObjectInputStream in;
	FileOutputStream fout;//�����ϰ� �����ϴ� �ֵ�
	FileInputStream fin;
	
	public Join getJl() {
		return jl;
	}
	public void setJl(Join jl) {
		this.jl = jl;
	}


	@SuppressWarnings("unchecked")
	public MainPanel() {
		super("::��ȭ�ο� �߰���::");
		//System.out.println("starttest");
		readFile("src/data/user.txt");
			
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/data/pdata.txt"));
			productsList2 = (ArrayList<ProductsDB>)ois.readObject();//���Ͽ��� ArrayList�б�
			ois.close();
		} catch (Exception ex)
		{
			System.out.println("������ ã�����߽��ϴ�.");
		}
		
		
		
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/data/image.txt"));
			iDB = (HashMap<String,ImageDB>)ois.readObject();//���Ͽ��� ArrayList�б�
			ois.close();
		} catch (Exception ex)
		{
			System.out.println("������ ã�����߽��ϴ�.");
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
		
		lbHome=new JLabel("Ȩ",new ImageIcon("material-design-icons-1.0.0/material-design-icons-1.0.0/action/1x_web/ic_home_black_48dp.png"), JLabel.CENTER);
		lbProducts=new JLabel("�߰�ŷ�",new ImageIcon("material-design-icons-1.0.0/material-design-icons-1.0.0/action/1x_web/ic_shopping_basket_black_48dp.png"), JLabel.CENTER);
		lbMy=new JLabel("�α���",new ImageIcon("material-design-icons-1.0.0/material-design-icons-1.0.0/action/1x_web/ic_face_unlock_black_48dp.png"),JLabel.CENTER);
		
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
		myP2=new MyPanel2();//����
		
		pC.add("home",homeP);
		pC.add("products",productsP);
		pC.add("login", loginP);
		pC.add("join",joinP);
		pC.add("my",myP);
		pC.add("my2",myP2);//����
		
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
		myP2.btUpdate.addActionListener(handler);//����
		myP.btUpdate.addActionListener(handler);//����
		myP.btLogout.addActionListener(handler);//����
		homeP.bt_SearchPanel.addActionListener(handler);//����
		myP2.btDel.addActionListener(handler);//602
		
		jl=new Join(this);
		pF=new productFunction(this);  
		
//		UserDB dh = new UserDB("p","p","p","p");
//		userTable.put("p", dh);
//		Iam=dh;
		
		
		card.show(pC, "login");
		this.addWindowListener(new WindowAdapter() {//WindowAdapter�� ��ӹ޴� Ŭ���� �����(�ϴ�)
			public void windowClosing(WindowEvent e) {
				//userTable�� ���Ͽ� ��������
				saveFile("src/data/user.txt");//File�� �����Ұž�(���ϸ� user.txt)
				System.exit(0);
			}
		});
	}//������------

	public void readFile(String fileName) {//�о�� �޼ҵ�
		try {
			fin=new FileInputStream(fileName);
			in=new ObjectInputStream(fin);//������Ʈ ��ü�� �д� ����?!
			Object obj = in.readObject();//�ش� Ŭ������ ������ ������=>catch���� ���
			userTable=(Hashtable<String,data.UserDB>)obj;//ObjectŸ���� �츮�� ���� HashtableŸ������ ��ȯ
		
		}catch(Exception e) {}
	}//------------

	public void saveFile(String fileName) {//�����ϴ� �޼ҵ�
		//exception�� ���Ƿ� try~catch�� ���ֱ�
		try {
			fout=new FileOutputStream(fileName);
			out=new ObjectOutputStream(fout);
			out.writeObject(userTable);
			out.flush();//�����͸� �Ѳ����� ��?���ִ�
			out.close();
			fout.close();
			System.out.println(fileName+"�� ���� �Ϸ�!");
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
