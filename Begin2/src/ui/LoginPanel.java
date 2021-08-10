package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import data.UserDB;


public class LoginPanel extends JPanel{
	
	ImageIcon bgIcon;
	JPanel p=new JPanel();
	public JTextField tfId;
	public JPasswordField tfPwd;
	public JButton btLogin,btJoin;
	MainPanel mp;
	
	public LoginPanel(MainPanel frame) {
		this.mp=frame;
		
		setBackground(Color.white);
		bgIcon=new ImageIcon("images/back.jpg");
		add(p);
		p.setLayout(new GridLayout(0,1,10,10));
		tfId=new JTextField(20);
		tfPwd=new JPasswordField(20);
		btLogin=new JButton("�α���");
		btJoin=new JButton("ȸ������");
		
		ImageIcon Main_img = new ImageIcon("images/mark.jpg");
		Image img3 = Main_img.getImage();
		
		Image changeImg = img3.getScaledInstance(250, 60, Image.SCALE_SMOOTH);
		
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel mi = new JLabel(changeIcon);
		mi.setBackground(Color.white);
		mi.setLocation(0, 0);
		mi.setSize(250, 60);
		p.add(mi);



		
		p.add(tfId);
		p.add(tfPwd);
		p.add(btLogin);
		p.add(btJoin);
		p.setOpaque(false);//�����ϰ�
		TitledBorder tb1=null, tb2=null;
		
		LineBorder lnb=new LineBorder(Color.black);//6.03���� ����
		tfId.setBorder(tb1=new TitledBorder(lnb,"���̵�"));//6.03���� ����
		tfPwd.setBorder(tb2=new TitledBorder(lnb,"��й�ȣ"));//6.03���� ����
		
		tfId.setForeground(Color.black);
		tfPwd.setForeground(Color.black);
		btLogin.setBackground(Color.black);
		btLogin.setForeground(Color.white);
		btJoin.setBackground(Color.black);
		btJoin.setForeground(Color.white);
		tfId.setOpaque(false);
		tfPwd.setOpaque(false);
		//btLogin.setOpaque(false);
	}//������---------------------
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(mp.pC, message);
	}
	/**�α��� ó���� �ϴ� �޼ҵ�*/
	public void loginCheck() {
		//mp.setTitle("loginCheck");
		//1. tfId�� �Է��� �� �ޱ�
		//2. tfPwd�� �Է��� �� �ޱ�
		String id=tfId.getText();
		char[] pass=tfPwd.getPassword();
		String pwd=new String(pass);
		
		//��ȿ�� ���� �ƴ� ��� üũ=>��ȿ�� üũ
		//String�� trim()�޼ҵ�: ���ڿ� �� ���� ������ ��������
		if(id==null || pwd==null || id.trim().equals("")||pwd.trim().equals("")) {
			showMsg("���̵�,��й�ȣ�� �Է��ؾ� �ؿ�!!");
			return;
		}
		id=id.trim();
		pwd=pwd.trim();
				
		boolean isExist=mp.userTable.containsKey(id);
		//���̵� �����ϴ� üũ
		if(!isExist) {
			showMsg("���� ID�Դϴ�. �ٽ� �Է��ϼ���");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}
		
		//���̵� �´� ���=> ��� üũ
		UserDB tmpUserDB=mp.userTable.get(id);
		String tmpPwd=tmpUserDB.getPwd();
		if(!pwd.equals(tmpPwd)) {
			showMsg("��й�ȣ�� ��ġ���� �ʾƿ�");
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();
			return;
		}
		
		showMsg(id+"�� ȯ���մϴ�.");
		mp.setTitle(id+"�� �α��� ��...");
		mp.isLogin=true;
		
		
		
		mp.Iam = tmpUserDB;
		mp.userTable.put(mp.Iam.getUserid(), mp.Iam);  //string �����׽�Ʈ 
		
		if(mp.isLogin==true) {
			mp.lbMy.setText("�� ����");			
		}
		mp.card.show(mp.pC, "home");
	}//-------------------
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgIcon.getImage(),0,0,this.getWidth(),this.getHeight(),this);
		
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(60,20,20,20);
	}

}//////////////////////////////////
