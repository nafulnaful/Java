package ui;
import java.awt.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MyPanel extends JPanel{
		//    62 복붙 
	
	public JPanel pN, pC, pS,buyList;//527d(pS만 추가함)
	public JPanel pNC, pCC, pSC;//회원명, 판매상품목록 //527d(pSC만 추가)
	public JButton btUpdate, btLogout;//회원정보수정, 로그아웃
	public JLabel lbSell, lbName;//판매상품목록, 회원명
	JLabel lbBuy;//527d 추가
	public JPanel wish;
	
	//public JScrollPane scroll;
	
//	public JTextArea ta1 = new JTextArea(1,1);//527d 추가
//	public JTextArea ta2 = new JTextArea(8,8);//527d 추가
	
		////  미니박스 x  = 192 를하고    y =   121   
	
	public MyPanel() {
		this.setBackground(Color.black);
		
		
		
		
		setBounds(100, 100, 400, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
	
	
		JPanel Toppanel = new JPanel();
		btUpdate = new JButton("회원정보수정");
		btLogout = new JButton("로그아웃");
		lbSell = new JLabel("나의 판매목록", JLabel.CENTER);//603
		lbName = new JLabel("",JLabel.CENTER);//회원이름 연동 목적 //603
		lbBuy = new JLabel("나의 찜목록", JLabel.CENTER);//527d 추가 //603
		buyList = new JPanel();
		wish = new JPanel();

		
		


		
		btLogout.setBackground(new Color(234,234,234));
		btUpdate.setBackground(new Color(234,234,234));
		lbSell.setOpaque(true);
		lbName.setFont(new Font("돋움",Font.BOLD,17));//529d
		lbBuy.setOpaque(true);//527d 추가
		
		
	
		

		
		
		
		Toppanel.setBounds(14, 15, 373, 94);//603
		Toppanel.setLayout(null);
		lbName.setBounds(0, 5, 373, 29);//603 

		btLogout.setBounds(0, 65, 373, 29);//603
		btUpdate.setBounds(0, 35, 373, 29);//603
		lbSell.setBounds(14, 124, 373, 25);//602 //603
		lbBuy.setBounds(14, 405, 373, 25);//603
		buyList.setBounds(10, 149, 380, 255);//603
		wish.setBounds(10, 430, 380, 90);//603
		buyList.setLayout(null);
		buyList.setPreferredSize(new Dimension(400,600));
		buyList.setBorder(new EmptyBorder(10, 10, 10, 10));//603
		
		wish.setLayout(null);
		wish.setPreferredSize(new Dimension(400,600));
		wish.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	
		Toppanel.add(lbName);
		Toppanel.add(btLogout);
		Toppanel.add(btUpdate);
		buyList.setBackground(Color.white);
		wish.setBackground(Color.lightGray);
		
		JScrollPane scroll1 = new JScrollPane(buyList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane scroll2 = new JScrollPane(wish,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll1.setBounds(14, 149, 373, 240);//603
		scroll2.setBounds(14, 430, 373, 87);//603
		
		
		add(Toppanel);
		add(lbSell);
		add(lbBuy);
		add(scroll1);
		add(scroll2);
		
		
		wish.setBackground(Color.white);//602
		Toppanel.setBackground(Color.white);//602
		
		
		
		
		
		
		
		
		
		

		
	}//생성자----------

	@Override
	public Insets getInsets() {
		return new Insets(20,20,20,20);
	}

}