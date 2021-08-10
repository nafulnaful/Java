package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.ImageDB;
import data.ProductsDB;   

 /*
  *    복붙부탁드립니다ㅣ 
  *  	
  * 	
  * 
  * */
public class ItemBox extends JPanel{
	public ImageDB img;  //성
	JLabel pName;
	JLabel pPrice,lbimage;
	public ImageIcon image;  
	public JLabel pDateShow;
	public int pDate;
	public int pDate2;
	MainPanel main;
	productDetailsPanel dPanel;
	public String ItemName;
	public ProductsDB product;
	public ItemBox(ProductsDB product,MainPanel main) {
		this.main= main;
		this.product=product;
			img = main.iDB.get(product.key);
				//상품이름이 키  
				
				
				
		setBounds(5, 5, 350, 200);
		setLayout(null);
		
		setBackground(Color.white);
		
		
		
		
		
		
		 String price = main.pF.PriceComma( product.getPriceP());
		// setPreferredSize(new Dimension(360,40));		
		 
		 
			
	
		  
			//생성 
			pDateShow = new JLabel();
			try {
				
				lbimage = new JLabel(img.img);
			}catch(NullPointerException e) {
				
			}
			pName = new JLabel(product.getNameP());
			pPrice = new JLabel();
		
			pPrice.setText(price);
			
			
			if(product.getPriceP().equals("판매완료")) {
				pPrice.setForeground(Color.lightGray);
				pName.setForeground(Color.LIGHT_GRAY);
			}
			

			JPanel kan = new JPanel();
			
			
			
			
			//바운드 
			
			pName.setBounds(180, 6, 150, 70);
			pDateShow.setBounds(180, 77, 143, 16);
			pPrice.setBounds(180, 95, 148, 56);
			try {
				
				lbimage.setBounds(15, 17, 130, 130);
			}catch(NullPointerException e2) {
				
			}
			kan.setBounds(10, 183, 500, 1);
			
			
			// 폰트 
			pName.setFont(new Font("",Font.PLAIN,20));  
			pPrice.setFont(new Font("",Font.BOLD,20));  
			  
			pDateShow.setFont(new Font("",Font.PLAIN,10));
			pDateShow.setForeground(Color.lightGray);
			kan.setBackground(Color.LIGHT_GRAY);
			
			
			
			//부착 
			
			add(pName);
			add(pPrice);
			add(pDateShow);
			try {
				
				add(lbimage);
			}catch(NullPointerException e3) {
				
			}
			add(kan);
			
		 
			
			
			
			

		
		
		
		
		addMouseListener(new MouseAdapter() {  // 성근  
			@Override
			public void mousePressed(MouseEvent e) {
				dPanel = new productDetailsPanel(main,product);
				
				
				main.detailP=dPanel;
				main.pC.add("detail",main.detailP);
				main.card.show(main.pC, "detail");
				main.detailP.updateUI();
			}
			
		});
		
		
		
		
		
		
	}//생성자--------------
	
	

}
