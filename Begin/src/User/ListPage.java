package User;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.table.*;


public class ListPage extends JPanel{
	
	JLabel lb;
	JTextArea ta;
	MainMemberFrame parent;
	
	JTable table;
	Object[][] userData= {{"","","",""}};
	String [] header= {"�̸�","���̵�","����ó","��й�ȣ"};
	DefaultTableModel model;
	
	public ListPage(MainMemberFrame frame) {
		this.parent = frame;
		setBackground(Color.lightGray);
		this.setLayout(new BorderLayout());
		lb=new JLabel(":::User List:::");
		add(lb,"North");
		//ta=new JTextArea();
		//add(new JScrollPane(ta),"Center");
		model=new DefaultTableModel(userData,header);
		table=new JTable(model);
		add(new JScrollPane(table),"Center");
		
	}//---------------------------
	
	public void showUserTable() {
		//�ؽ����̺� �ִ� �����͸� 2���� �迭�� ����
		//���̺�𵨿� �����ϰ�, JTable�� ���� ����
		Collection<User> cols=parent.userTable.values();
		if(cols==null) return;
		
		Iterator<User> it=cols.iterator();
		
		userData=new Object[parent.userTable.size()][4];
		
		for(int i=0;it.hasNext();i++) {
			User user=it.next();
			System.out.println("user>>>"+user);
			userData[i][0]=user.getName();
			userData[i][1]=user.getUserid();
			userData[i][2]=user.getTel();
			userData[i][3]=user.getPwd();
		}
		
		model.setDataVector(userData, header);
		table.setModel(model);
		table.setRowHeight(25);
		
		
	}//------------------------
	
	public void showUsers() {
		int size=parent.userTable.size();
		ta.setText("�̸�\t���̵�\t����ó\n");
		ta.append("=================================\n");		
		
		//userTable�� ����� User��ü�鸸 �����ؼ�
		//ta�� ȸ�� �̸�, ���̵�, ����ó����  append�غ���
		Collection<User> cols=parent.userTable.values();
		for(User user:cols) {
			ta.append(user.getName()+"\t"+user.getUserid()+"\t"+user.getTel()+"\n");
		}
		ta.append("=================================\n");
		ta.append("���� ��ϵ� ȸ����: "+size+"��\n");
	}//--------------------------
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,20,20);
	}

}//////////////////////////////////
