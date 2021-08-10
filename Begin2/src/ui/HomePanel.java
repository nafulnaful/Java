package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;   
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import function.Handler;


public class HomePanel extends JPanel { 
	
	//{        North      
	
	public JPanel SearchPanel;
	public JTextField tf_SearchPanel;
	public JButton bt_SearchPanel;
	public int ItemY = 5;                 //  복붙   
	
	//    }
	
	
	
	
	public JPanel contentsBox;
	 MainPanel mp;
	
	
	
	public HomePanel(MainPanel mp) {
		this.mp=mp;
		// setBounds(100, 100, 400, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.white);
		setLayout(new BorderLayout(0, 0));			
	
		
		//  {    North
		
	    SearchPanel = new JPanel();
	    SearchPanel.setLayout(new GridLayout(0, 2, 0, 0));
		SearchPanel.setBackground(Color.white);
		tf_SearchPanel = new JTextField();
		tf_SearchPanel.setColumns(10);
		
		bt_SearchPanel = new JButton("검색");
		bt_SearchPanel.setBackground(Color.black);
		bt_SearchPanel.setForeground(Color.white);
		SearchPanel.add(tf_SearchPanel);
		SearchPanel.add(bt_SearchPanel);
		tf_SearchPanel.setBorder(new LineBorder(Color.black));
		
		
		//   }

		
		
		
		
		//   {     Center
		
		contentsBox = new JPanel();
		
		contentsBox.setPreferredSize(new Dimension(400,2000));
		
		contentsBox.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		contentsBox.setLayout(null);
		contentsBox.setBackground(Color.white);
	

		
		
		JScrollPane scroll= new JScrollPane(contentsBox,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(400,2000));
		
		add(SearchPanel, BorderLayout.NORTH);
		
		
		add(scroll, BorderLayout.CENTER);
		
		
		
		
	}
	
//	@Override
//	public Insets getInsets() {
//		return new Insets(20,20,20,20);
//	}


}
