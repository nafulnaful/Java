package day24;
/*(8)*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyGui extends JFrame {

	JPanel p = new JPanel();
	Canvas can;
	JButton bt;

	public MyGui() {
		super("::MyGui::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);

		can= new Canvas();
		can.setSize(200,200);
		can.setBackground(Color.green);
		p.add(can);
		
		bt=new JButton(new ImageIcon("images/img5.png"));
		p.add(bt);
		
		MyGuiEventHandler handler=new MyGuiEventHandler(this);
		bt.addActionListener(handler);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//»ý¼ºÀÚ------

	public static void main(String[] args) {
		MyGui my = new MyGui();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}