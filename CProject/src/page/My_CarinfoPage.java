package page;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import db.CarDAO;
import db.CarDB;
import exception.AuthenException;
import handler.EditHandler;
import jdk.nashorn.internal.runtime.ListAdapter;

public class My_CarinfoPage extends JPanel {

	MainFrame mainF;
	
	public Buy_itembox by;
	public Buy_info bi;
	JPanel pNorth = new JPanel(new GridLayout(0, 1));
	JPanel pCenter = new JPanel(new BorderLayout());
	JPanel pCenter_N = new JPanel(new FlowLayout());
	JPanel pCenter_C = new JPanel(new BorderLayout());

	public JLabel lbTop;

	public JPanel contentsBox = new JPanel();

	// ���̺� ����
	String buy = "���ſϷ�";
	CarDB cdb = new CarDB();
	CarDAO cardao = new CarDAO();
	
	public My_CarinfoPage(MainFrame mainF ) {
		this.mainF = mainF;
		setBackground(Color.white);
		setLayout(new BorderLayout());
		pCenter.setBackground(Color.white);

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");


		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/��ܹ�_���������ȸ.png"), JLabel.CENTER);
		pNorth.add(lbTop);

		by = new Buy_itembox(mainF);
		
		// Panel �ɼ�
		pNorth.setBackground(new Color(162, 108, 254));

		JScrollPane scroll = new JScrollPane(contentsBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(400, 700));
		contentsBox.setLayout(new GridLayout(0,1));
		
		pCenter.add(scroll, BorderLayout.CENTER);

//[GUI]//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}////
	@Override
	public Insets getInsets() {
		return new Insets(0, 10, 20, 10);
	}
	
	public void regCar() {
		String id=mainF.mypageF.lbWelcome.getText();
		String no=mainF.mypageF.lbWelcome.getText();
		System.out.println(id);
		CarDB cdb=new CarDB(500,id,no);
		System.out.println("regCar: "+cdb.getCode()+"||"+cdb.getCarId());
		
		mainF.sellF.Response(cdb);
	}
	
	int y = 0;

	// Center �� ���� label ����
	public void setLabelMyCarUI(JLabel lb) {
		lb.setOpaque(true);
		lb.setBackground(Color.white);
		lb.setHorizontalTextPosition(JLabel.CENTER);// �ؽ�Ʈ�� ��ġ�� �߾�����
		lb.setVerticalTextPosition(JLabel.BOTTOM);// �ؽ�Ʈ�� ��ġ ������
		lb.setBorder(new EtchedBorder(EtchedBorder.RAISED));// �󺧿� �׵θ� �־���
		lb.setMaximumSize(getMaximumSize());
	}

	public void showItem(ArrayList<CarDB> list) {
		
		if(list==null) {
			System.out.println("list null");
			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
		
			Buy_itembox by = new Buy_itembox(mainF);
			by.lbNo.setText(list.get(i).getCarNo());
			by.lbBrand.setText(list.get(i).getCarBrand());
			by.lbModel.setText(list.get(i).getCarModel());
			by.lbYear.setText(list.get(i).getCarYear());
			by.lbAcc.setText(list.get(i).getCarAcc());
			by.lbKm.setText(list.get(i).getCarKm());
			by.lbPr.setText(list.get(i).getCarPrice());
			by.lbImg.setIcon(new ImageIcon(list.get(i).getCarImg()));
			by.setBounds(0, y, 345, 200);
			contentsBox.add(by);
			y += 200;
		}
		
		contentsBox.updateUI();
		contentsBox.validate();
		

	}
	//#����Ȯ��
	public void removeItem(ArrayList<CarDB> list) {
		ArrayList<CarDAO> cararr = new ArrayList<CarDAO>();
		if(cararr.size()>0) {
			if(cararr.size()==0) return;
			list = null;
		}
		list.clear();
	}

}