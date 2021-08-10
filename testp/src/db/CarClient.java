package db;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import page.MainFrame;

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
	db.CarDAO cardao=new CarDAO();
	public String myId;
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
			listener = new Thread(this);
			listener.start();
		}catch(Exception e) {
			System.out.println("Ŭ-���� ����");
		}
	}

	@Override
	public void run() {
		Object obj;
		try {
			while((obj = in.readObject())!=null||!isStop) {
				if(obj instanceof String) {
					String response =(String) obj;
					switch (response) {
					case "���ԿϷ�":{
						System.out.println("Ŭ���̾�Ʈ���� �Ѿ��");
						mainF.card.show(mainF.pCenter, "�α���");
						showMsg("ȸ������ ����");
						joinPage.lbDone.setEnabled(true);
					}break;
					case "���Խ���":{
						showMsg("ȸ������ ����");
						
					}break;
					case "�α��οϷ�":{
						System.out.println("Ŭ���̾�Ʈ���� �Ѿ�ͼ� �α��� ����");
						myId = mainF.loginF.tfId.getText();
						showMsg("�α��� ����");
						
						mainF.isLogin = true;
						mainF.card.show(mainF.pCenter, "��������");
//						mainF.mypageF.lbWelcome.setText(id);

//						ArrayList<CarDB> list=cardao.selectCar();
//			 			mainF.buyF.showItem(list);
						clearReg();
//						mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α���.png"));
//						mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_�������ż���.png"));
//						mainF.lbLogin = new JLabel();
					}break;
					case "�α��ν���":{
						showMsg("�α��� ����");
					}break;
					case "������ϿϷ�":{
						System.out.println("Ŭ���̾�Ʈ���� �Ѿ�ͼ� ������� �Ϸ�");
						showMsg("������ϼ���");
					}
					case "������Ͻ���":{
						System.out.println("Ŭ���̾�Ʈ���� �Ѿ�ͼ� ������� ����");
						showMsg("������ϺҰ�");
					}
					}//switch----------------------------------
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void clearReg() {
		mainF.loginF.tfId.setText("");
		mainF.loginF.tfPwd.setText("");
		mainF.loginF.tfId.requestFocus();
	}

	private void showMsg(String str) {
		JOptionPane.showMessageDialog(null, str, str, 0);

	}
	
}
