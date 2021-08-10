package page;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import db.CarDAO;
import db.CarDB;
import exception.AuthenException;
import handler.BuyHandler;
import handler.EditHandler;
import jdk.nashorn.internal.runtime.ListAdapter;

public class BuyPage extends JPanel {

	MainFrame mainF;
	public Buy_itembox by;
	public Buy_info bi;
	JPanel pNorth = new JPanel(new GridLayout(0, 1));
	JPanel pCenter = new JPanel(new BorderLayout());
	JPanel pCenter_N = new JPanel(new FlowLayout());
	JPanel pCenter_C = new JPanel(new BorderLayout());

	public JLabel lbTop, lbSearch;
	public JTextField tfSearch;
	public JComboBox<String> cbSearch;
	public String[] search = { "�з�", "�귣���", "�𵨸�"};

	public JPanel contentsBox = new JPanel();

	// ���̺� ����
	String buy = "���ſϷ�";
	CarDB cdb = new CarDB();
	CarDAO cardao = new CarDAO();
	
	public BuyPage(MainFrame mainF) {
		this.mainF = mainF;
		setBackground(Color.white);
		setLayout(new BorderLayout());
		pCenter.setBackground(Color.white);

		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");
		pCenter.add(pCenter_N, "North");
		pCenter.add(pCenter_C, "Center");

		// ComboBox
		cbSearch = new JComboBox<>(search);
		pCenter_N.add(cbSearch);

		// TextField
		tfSearch = new JTextField(" ���ϴ� ������ �˻��غ�����!",18);
		pCenter_N.add(tfSearch);
		tfSearch.setForeground(Color.LIGHT_GRAY);

		// Label
		lbTop = new JLabel("", new ImageIcon("src/images/��ܹ�_��������.png"), JLabel.CENTER);
		lbSearch = new JLabel("", new ImageIcon("src/images/�˻�.png"), JLabel.CENTER);
		pNorth.add(lbTop);
		pCenter_N.add(lbSearch);

		by = new Buy_itembox(mainF);
		
		// Panel �ɼ�
		pNorth.setBackground(Color.white);
		pCenter_N.setBackground(Color.white);

		JScrollPane scroll = new JScrollPane(contentsBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(400, 700));
		contentsBox.setLayout(new GridLayout(0,1));
		//by.setBounds(0, y, 345, 200);

		pCenter_C.add(scroll, BorderLayout.CENTER);
		
		//�ڵ鷯
		BuyHandler handler=new BuyHandler(mainF);
		lbSearch.addMouseListener(handler);
		tfSearch.addMouseListener(handler);
		by.addMouseListener(handler);
		
		
//[GUI]//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}////
	@Override
	public Insets getInsets() {
		return new Insets(0, 10, 20, 10);
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