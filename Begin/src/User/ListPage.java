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
	String [] header= {"이름","아이디","연락처","비밀번호"};
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
		//해시테이블에 있는 데이터를 2차원 배열로 만들어서
		//테이블모델에 전달하고, JTable의 모델을 설정
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
		ta.setText("이름\t아이디\t연락처\n");
		ta.append("=================================\n");		
		
		//userTable에 저장된 User객체들만 추출해서
		//ta에 회원 이름, 아이디, 연락처들을  append해보기
		Collection<User> cols=parent.userTable.values();
		for(User user:cols) {
			ta.append(user.getName()+"\t"+user.getUserid()+"\t"+user.getTel()+"\n");
		}
		ta.append("=================================\n");
		ta.append("현재 등록된 회원수: "+size+"명\n");
	}//--------------------------
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,20,20);
	}

}//////////////////////////////////
