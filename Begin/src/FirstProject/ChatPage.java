package FirstProject;


import java.io.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;




public class ChatPage extends JFrame{
	
	JPanel p=new JPanel();
	JPanel pC;
	JTextField tf;
	JButton bt;
	JList<String> lst;
	Vector<String> chtV;
	DefaultListModel<String> model;

	public ChatPage() {
		super("Chat");

		Container cp= this.getContentPane();
		cp.add(p,"Center");
		p.setBackground(Color.WHITE);
		p.setLayout(new BorderLayout());
		
		chtV=new Vector<>();
		
		lst=new JList<>(chtV);
		
		p.add(lst,"Center");
		
		pC=new JPanel();
		p.add(pC,"South");
		
		tf = new JTextField(20);
		bt = new JButton("입력");
		
		lst.setBorder(new TitledBorder(":: 1:1 채팅 문의; ::"));
		
		pC.add(tf); pC.add(bt);
		
		model=new DefaultListModel<>();
		
		lst.setModel(model);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=tf.getText();
				tf.setText("");
				chtV.add(str);
				model.addElement(str);
				tf.requestFocus();
				
			}
		});
	}
	
	 public Insets getInsets() {
	      return new Insets(40, 30, 10, 30);
	   }
	
	public static void main(String[] args) {
		ChatPage cp=new ChatPage();
		cp.setSize(400, 400);
		cp.setVisible(true);
	} 	

}
