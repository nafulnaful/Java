package page;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import db.CarDB;
import db.UserDB;

public class CarClient implements Runnable {
	public Socket sock;
	private Thread listener;
	static final int PORT = 9999;
	private String host = "localhost";
	public ObjectOutputStream out;
	public ObjectInputStream in;
	public boolean isStop;
	page.JoinPage joinPage;
	page.MainFrame mainF;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public CarClient(MainFrame mainF) {
		this.mainF=mainF;
		try {//����
			sock = new Socket(host, PORT);
			System.err.println("Ŭ-���� ���� ����");
			
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			if(listener==null) {
			listener = new Thread(this);
			listener.start();
			}
		}catch(Exception e) {
			System.out.println("Ŭ-���� ����");
		}
	}

	@Override
	public void run() {
		Object obj;
		
		try {
			while((obj = in.readObject())!=null||!isStop) {
				//�����ڵ鷯 �ڵ��ȣ 600���� ������ list�� gui���� ����.
				if(obj instanceof ArrayList) {
					ArrayList<CarDB> list=(ArrayList<CarDB>) obj;
   					mainF.buyF.contentsBox.removeAll();
					mainF.cinfoF.contentsBox.removeAll();
					
					
					System.out.println(list);
					
					mainF.buyF.showItem(list);
					mainF.cinfoF.showItem(list);
					
//					mainF.infoF.showInfo(list);
//					mainF.infoF.clearReg();
					
					
					
				}
				if(obj instanceof Vector) {
					Vector<UserDB> list=(Vector<UserDB>) obj;
					mainF.ueditF.showInfo(list);
				
				}
				if(obj instanceof String) {
					String response =(String) obj;
					switch (response) {
					case "���ԿϷ�":{
						System.out.println("Ŭ���̾�Ʈ���� �Ѿ��");
						mainF.card.show(mainF.pCenter, "�α���");
						showMsg("ȸ������ ����");
					}break;
					case "���Խ���":{
						showMsg("ȸ������ ����");
					}break;
					case "�α��οϷ�":{
						showMsg("�α��� ����");
						mainF.card.show(mainF.pCenter, "��������");
						mainF.isLogin = true;
						mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α���.png"));
						mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_�������ż���.png"));
						mainF.lbLogin = new JLabel();
						clearReg();
					}break;
					case "�α��ν���":{
						showMsg("�α��� ����");
					}break;
					case "ȸ�����������Ϸ�":{
						showMsg("ȸ������ ���� �Ϸ�");
						mainF.card.show(mainF.pCenter, "����������");
						mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_��������������.png"));   
					}break;
					case "ȸ��Ż��Ϸ�":{
						mainF.card.show(mainF.pCenter, "�α���");
						mainF.isLogin=false;
						mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α��μ���.png"));    
						mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_����������.png"));
						showMsg("ȸ��Ż�� �Ϸ�");
					}break;
					case "������ϿϷ�":{
						showMsg("������ϼ���");
						
						mainF.card.show(mainF.pCenter,"��������");
						mainF.sellF.clearReg();
						mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_�������ż���.png"));
						mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
						
					}break;
					case "������Ͻ���":{
						showMsg("������Ͻ���");
					}break;
					case "���������Ϸ�":{
						System.out.println("īŬ ���������Ϸ�");
						showMsg("���������Ϸ�");
						mainF.card.show(mainF.pCenter,"��������");
						mainF.ceditF.clearReg();
						mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_�������ż���.png"));
						mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
					}break;
					case "������������":{
						showMsg("������������");
					}break;
					case "�����������":{
						showMsg("�����������");
					}break;
					case "�����ҷ�����Ϸ�":{
						System.out.println("�����ҷ�����Ϸ�");
						
					}break;
					case "���������Ϸ�":{
						showMsg("���������Ϸ�");
						mainF.infoF.clearReg();
					}break;
					case "������������":{
						showMsg("������������");
					}
					case "����������ϼ���":{
						
					}break;
					case "����������Ͻ���":{
						showMsg("����������Ͻ���");
					}
					}//switch----------------------------------
				}
			}
		} catch (Exception e) {
			System.out.println("Ŭ���̾�Ʈ run ����: "+e);
		}
	}

	private void clearReg() {
		mainF.loginF.tfId.setText("");
		mainF.loginF.tfPwd.setText("");
		mainF.loginF.tfId.requestFocus();
	}

	private void showMsg(String str) {
		JOptionPane.showMessageDialog(mainF,str);

	}
	
}