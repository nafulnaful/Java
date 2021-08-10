package function;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import data.ImageDB;
import data.ProductsDB;
import ui.ItemBox;
import ui.MainPanel;
import ui.Mini_ItemBox;

/*
 *   ���ݲ�
 * 
 *    
 * 		 
 * 		
 * 		  
 * 
 * */
public class productFunction {
	public int x = 10, y=16;//603
	MainPanel main;
	public  ImageDB imgDB;
	public Image img;
	public ImageIcon changeIcon;
	public Image changeImg;
	public Image PanelImg;
	public Image detailImg;
	public Image mImg;
	public ImageIcon PanelIcon ;
	public ImageIcon DetailIcon ;
	public ImageIcon mIcon ;
	ImageIcon reset = new ImageIcon("material-design-icons-1.0.0/material-design-icons-1.0.0/action/2x_web/ic_account_balance_wallet_grey600_48dp.png");
	public productFunction(MainPanel main) {
		this.main=main;
	}
	
	public void addProduct() {
		// ���߿� ��ǰ �̸� ��ġ�� �ʰ� �ϱ� 
		
	
		
		ProductsDB product = new ProductsDB(    
			main.productsP.tf_n.getText(),main.productsP.tf_price.getText(),
			main.productsP.tf_place.getText(),main.productsP.tf_info.getText()); // 531 
		
		
		
		imgDB = new ImageDB(PanelIcon,DetailIcon,mIcon);//���� 
		Date d= new Date();
		String z = "m"+d.getMonth()+"h"+d.getHours()+"m"+d.getMinutes()+"s"+d.getSeconds();
		product.pDate= d.getDate();product.pH=d.getHours(); product.pM =d.getMinutes();
		product.key=z;
		main.iDB.put(z, imgDB); //���� 
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/data/image.txt"));
			oos.writeObject(main.iDB);//���Ͽ� ArrayList ����
			oos.close();
			System.out.println("��ǰ���� ����Ϸ�");
		} catch (Exception ex)
		{
			
		}
		
		main.productsList2.add(product);
		
		
		
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/data/pdata.txt"));
			oos.writeObject(main.productsList2);//���Ͽ� ArrayList ����
			oos.close();
			System.out.println("��ǰ���� ����Ϸ�");
		} catch (Exception ex)
		{
			
		}
		JOptionPane.showMessageDialog(main.productsP,main.Iam.getName()+"�� �� ��ǰ ��� �Ϸ� ");
			
		
		
		ItemBox item = new ItemBox(product,main);  
		
		
	
		
		
		product.���� = main.Iam.getUserid();//601

					
		
		
		Date date = new Date();
		item.pDate = date.getMinutes();
		
		main.Iam.SallList.add(z); 
		
		main.card.show(main.pC, "home" );
		
	     
		
	
		
		
		//������ x  += 192     y += 121   
		
			
		
		
		
		
		
		
		PeedUpdateUI(1);	
	
		clearProductInput();
		
		

		
		
		
		
	}//----------------------
	

	public void clearProductInput() {
		main.productsP.tf_n.setText("");
		main.productsP.tf_price.setText("");
		main.productsP.tf_place.setText("");
		main.productsP.tf_info.setText("");
	
	}
	
	
	
	public void PeedUpdateUI(int num) {     
		/* ��ǰ�� �ֱ� �ø������� ������Ʈ�ϱ�����    �����Ŀ� �ٽ� �ִ´�.
		 
		 1  =   Ȩ ���     ,  2  =   ���� ���     3 =  �˻� ��� 
		 
		*
		*
		*
		*
		*/
				
	
		ArrayList <Mini_ItemBox> miniList = new ArrayList<>();
		for(int i=0; i<main.productsList2.size();i++) {
			Mini_ItemBox I = new Mini_ItemBox(main.productsList2.get(i),main);
			miniList.add(I);
			
		}
		
		ArrayList<ItemBox> items =new ArrayList<>();
		for(int i=0;i<main.productsList2.size();i++) {
			
			ItemBox I = new ItemBox(main.productsList2.get(i),main);
			items.add(I);
			}
		
		
		
		
		
		
		//ArrayList<ItemBox> items =main.productsList;
//		ArrayList<String> itemsMe = main.Iam.getSallList();  
		switch(num) {
		
		
		case 1 :
			main.homeP.contentsBox.removeAll();
		for(int i=items.size();i>0;i--) {
			String time =Date(items.get(i-1).product);
			items.get(i-1).pDateShow.setText(time);
			items.get(i-1).setBounds(5, main.homeP.ItemY, 350, 200);
			main.homeP.contentsBox.add(items.get(i-1));
			main.homeP.ItemY+=220;
		} main.homeP.ItemY= 5; 
		break;
		
		case 2 :
			main.myP.buyList.removeAll();
			for(int i=0; i<miniList.size(); i++) {
				String p = miniList.get(i).product.key;
				
				for(int k =0; k<main.Iam.SallList.size();k++) {
				String p2 = main.Iam.SallList.get(k);
				if(p.equals(p2)) {
					
					Mini_ItemBox m = miniList.get(i);
					
					m.setBounds(x,y, 164, 95);
					main.myP.buyList.add(m);
					

					
					if (x==10) {//603
						x= 182;//603
					}else {
						x= 10;//603
						y += 121;
					
					}
					
				}
				}
			}
			x = 10; y=16;//603
		break;
		
		case 3 : 
			main.homeP.contentsBox.removeAll();
			String Search =main.homeP.tf_SearchPanel.getText();
			if(Search.equals("")) {
				main.homeP.contentsBox.removeAll();
				for(int i=items.size();i>0;i--) {
					String time =Date(items.get(i-1).product);
					items.get(i-1).pDateShow.setText(time);
					items.get(i-1).setBounds(5, main.homeP.ItemY, 350, 200);
					main.homeP.contentsBox.add(items.get(i-1));
					main.homeP.ItemY+=220;
				}
			}else {
			for(int i=items.size();i>0;i--) {
				String name = items.get(i-1).product.getNameP();
				if( name.contains(Search)){
					main.homeP.contentsBox.add(items.get(i-1));
					String time =Date(items.get(i-1).product);
					items.get(i-1).pDateShow.setText(time);
					items.get(i-1).setBounds(5, main.homeP.ItemY, 350, 200);
					main.homeP.ItemY+=220;
					main.homeP.contentsBox.add(items.get(i-1));
				}
			} 
		
			
			}main.homeP.ItemY= 5; 
			main.homeP.tf_SearchPanel.setText("");
			break;
		
		case 4 :
			main.myP.wish.removeAll();
			for(int i=0; i<miniList.size(); i++) {
				String p = miniList.get(i).product.key;
				
				for(int k =0; k<main.Iam.WishList.size();k++) {
				String p2 = main.Iam.WishList.get(k);
				if(p.equals(p2)) {
					
					Mini_ItemBox m = miniList.get(i);
					
					m.setBounds(x,y, 164, 95);
					main.myP.wish.add(m);
					

					
					if (x==10) {//603
						x= 182;//603
					}else {
						x= 10;//603
						y += 121;
					
					}
					
				}
				}
			}
			x = 10; y=16;//603
			break;
			
		
		}
		
		main.homeP.updateUI();
		main.myP.updateUI();
	}
		
	
	public String PriceComma(String price) {
		String p = "";
		String p2 = "";
		if(!(price.equals("�ǸſϷ�")))
		{
		for (int i = price.length(); i > 0; i--) {
			String first = price.charAt(i - 1) + "";
			p += first;
		}
		for (int i = p.length(); i > 0; i--) {
			String first = p.charAt(i - 1) + "";
			if (i != p.length()) {

				if (i == 3 || i == 6 || i == 9)
					p2 += ",";
			}
			p2 += first;
		}
	}else {
		p2="�ǸſϷ�";
		
	}
		return p2;
	}
	
	public void addImage() {
		JFileChooser fileChooser=new JFileChooser("images");
	
		int response = fileChooser.showOpenDialog(null);
		if(response==JFileChooser.APPROVE_OPTION) {
			System.out.println("d");
			
			fileChooser.setMultiSelectionEnabled(false);
		
			
			File file = fileChooser.getSelectedFile();
			
			
			
			
			
			try {
				BufferedImage bimg=ImageIO.read(file);
				
				ImageIcon icon=new ImageIcon(bimg);
				
				img=icon.getImage();
				
				changeImg=img.getScaledInstance(48,48,Image.SCALE_SMOOTH);
				PanelImg=img.getScaledInstance(150,150,Image.SCALE_SMOOTH); 
				detailImg=img.getScaledInstance(350,350,Image.SCALE_SMOOTH); 
				mImg=img.getScaledInstance(60,60,Image.SCALE_SMOOTH); 
				PanelIcon = new ImageIcon(PanelImg); 
				DetailIcon = new ImageIcon(detailImg); 
				mIcon = new ImageIcon(mImg); 

				changeIcon=new ImageIcon(changeImg); 
				main.productsP.lb.setIcon(changeIcon); 
				main.productsP.lb.setText("��������");
				img=reset.getImage();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		
		
	}}
		
		
		
		
		
	public String Date(ProductsDB product) {  				//
		Date d = new Date();
		int dpDate = d.getDate();int dpH =d.getHours();
		int dpM = d.getMinutes();int cal= 0;
		String result=""; 
		if((dpDate-product.pDate)!=0) {
			cal = dpDate-product.pDate;
			result = ""+cal+" day ago";
		}else if( (dpH-product.pH)!=0  ) {
			cal = dpH-product.pH;
			result = ""+cal+" h ago";
		}else if( (dpM-product.pM)!=0 ){
			cal = dpM-product.pM;
			result = ""+cal+" m ago";
		}else if((dpM-product.pM)==0){
			result = "����� ���";
		}
		
		
		product.pDate2 = result+"��"+product.getPlaceP();
	
		return product.pDate2;
	}
		
		
		public boolean checkMyProduct(String key) {
			boolean flag = false;
			try {
				for(String p: main.Iam.SallList) {
					if(key.equals(p)) {
						flag=true;
					}		
				}
			}catch(NullPointerException e){}
			
			return flag;
		}
		
		
		
		public boolean checkwish(String key) {
			boolean flag = false;
			try {
				for(String p: main.Iam.WishList) {
					if(key.equals(p)) {
						flag=true;
					}
					
				}
			}catch(NullPointerException e){}
			
			return flag;
		}
//	
		
	

}





