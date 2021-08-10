package ui;

import java.awt.*;


import java.awt.event.*;


import javax.swing.*;

import javax.swing.border.EmptyBorder;

import data.ImageDB;
import data.ProductsDB;



//   
public class productDetailsPanel extends JPanel {
   MainPanel main;
   public JPanel p;
   JPanel can;
   public JLabel i_img,i_name,i_price,i_place,i_date;    //////back 삭제 
   public JTextArea i_info;
   ProductsDB product;
   public ImageDB img;
   public JButton btbuy;   /////////////삭제,btAddwish;

   public productDetailsPanel(MainPanel main, ProductsDB product) {
      
//      setBorder(new EmptyBorder(5, 5, 5, 5));
      setBounds(100, 100, 400, 600);
      setLayout(null);
      setBackground(Color.white);
      
      this.main = main;
      this.product=product;
      
      
      img = main.iDB.get(product.key);
            
            
            
            
      p = new JPanel();
      p.setPreferredSize(new Dimension(400,600));
      p.setBorder(new EmptyBorder(5, 5, 5, 5));

      p.setLayout(null);
      
      
      JPanel BuyTab = new JPanel();
       BuyTab.setLayout(new GridLayout(0, 2, 0, 0));
      i_img = new JLabel(img.dimg);   
      i_name = new JLabel(product.getNameP()); 
      i_place = new JLabel(product.주인);
       i_date = new JLabel(product.pDate2);
      i_price = new JLabel(main.pF.PriceComma(product.getPriceP()));  //////////////수정 
      i_info = new JTextArea(product.getInfo());  
   
      
      JPanel can = new JPanel();
      can.setBackground(Color.LIGHT_GRAY);
      btbuy= new JButton("판매완료");  
       /////////////삭제   btAddwish= new JButton(" 좋아요 ");  /////////////삭제
       /////////////삭제back = new JLabel("뒤로가"); ///////////////삭제 
       /////////////삭제BuyTab.add(back); /////////////삭제
      
      
      JLabel heart = new JLabel();
            ///////////수정            판매 완료시  찜  가리기
      if(!(product.getPriceP().equals("판매완료"))){
      heart.setForeground(Color.lightGray);
      heart.setText("♡");
      if(main.pF.checkwish(product.key)) {
         heart.setForeground(Color.red);
         heart.setText("♥");
      }
      }
      
            ///////////수정
      
      
      
      //set
      i_name.setFont(new Font("",Font.BOLD,35));
      i_price.setFont(new Font("",Font.BOLD,30));///////////수정
      i_date.setFont(new Font("",Font.PLAIN,13));///////////수정
      i_place.setFont(new Font("",Font.CENTER_BASELINE,15));///////////수정
      heart.setFont(new Font("",Font.PLAIN,20));
      i_date.setForeground(Color.LIGHT_GRAY);///////////수정
      
      
      
   
      
      
      
      
      // bounds
      i_img.setBounds(10, 20, 350, 350);
      i_name.setBounds(10, 409, 360, 53);
      i_place.setBounds(10, 372, 79, 25);
      i_date.setBounds(132, 372, 161, 25);
      //i_price.setBounds(10, 474, 182, 38);
      i_price.setBounds(83, 14, 181, 60);
      can.setBounds(10, 406, 350, 1);
      i_info.setBounds(10, 500, 360, 800);
      heart.setBounds(25, 14, 35, 35);
      btbuy.setBounds(265, 20, 117, 29);
      
   
      
   
      
      BuyTab.setBounds(5, 450, 390, 80);
      BuyTab.setLayout(null);
      i_price.setBounds(83, 14, 181, 40);
      
      
      
   
      
      
      
       
        //부착 
       p.add(i_img);   
       p.add(i_name);  
       p.add(i_place);
       p.add(i_info);
       p.add(i_date);
       p.add(can);
    
       BuyTab.add(i_price);
       BuyTab.add(heart);
       
       
       if(main.pF.checkMyProduct(product.key)) {
          BuyTab.add(btbuy);
       }
      
      
       JScrollPane scroll = new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       scroll.setBounds(5, 5, 390, 430);
       p.setBounds(5, 5, 390, 430);
       //BuyTab.setBackground(Color.white);
       
       
       

      
      
       BuyTab.setBackground(Color.white);
       p.setBackground(Color.white);
      add(BuyTab, BorderLayout.SOUTH);
      add(scroll, BorderLayout.CENTER);
      add(BuyTab);
       
       
       
       btbuy.addActionListener(new ActionListener() {  //판매하기 버튼 눌렀을때.
         
         @Override
         public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(main.pC,"판매완료");
            main.Iam.SallList.remove(product.key);
            
            for(String x : product.wishUser) {
               main.userTable.get(x).WishList.remove(product.key);
            }
            
            main.pF.PeedUpdateUI(2);
            product.setPriceP("판매완료");
         
         
         main.pF.PeedUpdateUI(1);
         
         
      
         
         main.card.show(main.pC, "home");
         
         }
      });
    
       heart.addMouseListener(new MouseAdapter() { //너는 좋아용 
          public void mousePressed(MouseEvent e) {
        	 try {
	             if(heart.getText().equals("♡")) {
	                main.Iam.WishList.add(product.key);
	                product.wishUser.add(main.Iam.getUserid());
	                heart.setForeground(Color.red);
	                heart.setText("♥");
	             }else {
	                main.Iam.WishList.remove(product.key);
	                product.wishUser.remove(main.Iam.getUserid());
	                heart.setForeground(Color.lightGray);
	                heart.setText("♡");
	                
	             }
    		 }catch(NullPointerException e1) {
 				main.loginP.showMsg("로그인 하셔야 합니다.");
 				main.card.show(main.pC, "login");
    		 }  	             
       
             
        }});
       
      
       
   
      
       
   }//생성자------
   

   

   
}
