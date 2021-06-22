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
			{new Integer(1),"홍길동","영업부","SALESMAN"},
			{new Integer(2),"김길동","판매부","CLERK"},
			{new Integer(3),"이철수","기획부","MANAGER"},
			{new Integer(4),"이서엉","노무부","ANALYST"}
	};
		String[] header= {"사번","사원면","부서명","담당업무"};
		
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
		
		//View와 Model연결
		table.setModel(model);
		
		table.setRowHeight(26);
		table.setSelectionBackground(Color.yellow);
		table.setSelectionForeground(Color.red);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------

	public static void main(String[] args) {
		JTableDemo my = new JTableDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}