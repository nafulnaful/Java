package ui;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.ImageDB;
import data.ProductsDB;




/*처음  Mini_ItemBox.setBounds(x,y, 164, 95);  
		초기값 x = 17        y = 16		
		증감값 x  += 192     y += 121   
*/
public class Mini_ItemBox extends JPanel{
	
	public productDetailsPanel d;
	public ProductsDB product;
	public ImageDB img;
	MainPanel main;
	
	public Mini_ItemBox (ProductsDB product,MainPanel main) {
		this.main=main;
		this.product=product;
		
		img = main.iDB.get(product.key);
		
		
		
		setBounds(17, 16, 164, 95);
		setLayout(null);
	
		
		JLabel lb_img = new JLabel(img.mimg);
		JPanel can = new JPanel();
		JLabel ln_name = new JLabel(product.getNameP());
		JLabel ln_price = new JLabel(product.getPriceP());
		
		ln_name.setBounds(78, 15, 80, 28);
		lb_img.setBounds(6, 17, 60, 60);
		ln_price.setBounds(78, 50, 80, 28);
		
		can.setBounds(6, 89, 152, 1);
		
		
		
		can.setBackground(Color.LIGHT_GRAY);
		
		
		add(lb_img);
		add(ln_name);
		add(can);
		add(ln_price);
		
		
		
		this.addMouseListener(new MouseAdapter() {
		
			@Override
				public void mousePressed(MouseEvent e) {
					d = new productDetailsPanel(main,product);
					
					
					main.detailP=d;
					main.pC.add("detail",main.detailP);
					main.card.show(main.pC, "detail");
					main.detailP.updateUI();
				
			}
		
		});
		
	}
}