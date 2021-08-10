package ui;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import function.*;
import data.*;
public class ProductsPanel extends JPanel {
	
				
	
	public JLabel lb;
	public JTextField tf_n, tf_price, tf_place, tf_info;
	public JButton btSell,btAdd;
	public JPanel pN,pC;
	public ImageIcon pimage=new ImageIcon("material-design-icons-1.0.0/Camera_icon-icons.com_55948.png");
	ProductsDB pdb=new ProductsDB();
	MainPanel main;	
	SetLabelUI slu=new SetLabelUI();
	
	public ProductsPanel(MainPanel main) {
		// 사용자가 창을 띄우고 하는 일을 저장하는 역할을 하는 클래스
		
		this.main = main;
		
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
		// 텍필 
		tf_n=new JTextField(20);
		tf_price=new JTextField(20);
		tf_place=new JTextField(20);
		tf_info=new JTextField(20);
		
		// 버튼 
	    btSell= new JButton(" 판매 등록 ");
	    btSell.setBackground(Color.black);
	    btSell.setForeground(Color.white);
	    
	    //판넬   
	    pC = new JPanel(new GridLayout(0,1,10,10 ));  
	    pN = new JPanel(new GridLayout(0,2,10,10 )); 
	    
	    add(pN,"North");
	    add(pC,"Center");
	    
	    lb=new JLabel("사진첨부",pimage,JLabel.CENTER);	    
	    
	    slu.setLabelUI(lb);
	    lb.setBorder(new LineBorder(Color.black));//6.03일자 차봄
	    pN.add(lb,"East");
	        
	  
	   
	    // 부착     (라벨 - 필드) * 4     
	    pC.add(tf_n);    
	    pC.add(tf_price);   
	    pC.add(tf_place);
	    pC.add(tf_info);
	    tfBorder(tf_n,"제목");
	    tfBorder(tf_price,"가격");
	    tfBorder(tf_place,"거래장소");
	    tfBorder(tf_info,"물품상세");
	    
	    pC.add(btSell);
	        
	    add( pC,"Center");   
		
	}
	
	
	
	public void tfBorder(JTextField t, String str) {
		LineBorder lnb=new LineBorder(Color.black);//6.03일자 차봄
		t.setBorder(new TitledBorder(lnb,str));//6.03일자 차봄
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,20,20);
	}

}
