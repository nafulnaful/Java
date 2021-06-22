package day22;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

//JTable ==> View
//DefaultTableModel==>Model

public class JTableDemo extends JFrame {

	JPanel p = new JPanel();
	
	Object[][] data= {
			{new Integer(1),"ȫ�浿","������","SALESMAN"},
			{new Integer(2),"��浿","�Ǹź�","CLERK"},
			{new Integer(3),"��ö��","��ȹ��","MANAGER"},
			{new Integer(4),"�̼���","�빫��","ANALYST"}
	};
		String[] header= {"���","�����","�μ���","������"};
		
		JTable table;//view
		DefaultTableModel model;//Model
	

	public JTableDemo() {
		super("::JTableDemo::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);

		p.setLayout(new GridLayout(1,0,10,10));
		
		table=new JTable();
		p.add(new JScrollPane(table));
		
		model=new DefaultTableModel(data, header);
		
		//View�� Model����
		table.setModel(model);
		
		table.setRowHeight(26);
		table.setSelectionBackground(Color.yellow);
		table.setSelectionForeground(Color.red);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------

	public static void main(String[] args) {
		JTableDemo my = new JTableDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}