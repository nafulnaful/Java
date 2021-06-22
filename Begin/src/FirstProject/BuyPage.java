package FirstProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class BuyPage extends JPanel {

	MainFrame mainF;
	JPanel pNorth = new JPanel(new GridLayout(0, 1));
	JPanel pCenter = new JPanel(new GridLayout(1, 0, 10, 10));
	JPanel pSouth = new JPanel(new FlowLayout());
	JLabel lbWelcome, lbUserInfo, lbCarInfo, lbTalk, lbLogout;

	JLabel lbTop;

	JLabel lbBuy, lbEdit, lbDel;
	JPanel pSouth_W, pSouth_C, pSouth_E;

	// 차 정보등록된 값을 일단 테이블로 표시 해보자
	JTable table;
	Object[][] carData = { { "", "", "", "", "" } };
	String[] header = { "브랜드명", "모델명", "거주지역", "구매일자", "주행거리" };
	DefaultTableModel model;

	public BuyPage(final MainFrame mainF) {
		this.mainF = mainF;
		setBackground(Color.white);
		setLayout(new BorderLayout());
		pCenter.setBackground(Color.white);
		// Panel
		add(pNorth, "North");
		add(pCenter, "Center");
		add(pSouth, "South");

		// Label
		lbTop = new JLabel("", new ImageIcon("./pj_img/상단바_내차구매.png"), JLabel.CENTER);
		lbBuy = new JLabel("", new ImageIcon("./pj_img/구매_구매.png"), JLabel.CENTER);
		lbEdit = new JLabel("", new ImageIcon("./pj_img/구매_수정.png"), JLabel.CENTER);
		lbDel = new JLabel("", new ImageIcon("./pj_img/구매_삭제.png"), JLabel.CENTER);
		pNorth.add(lbTop);

		// Button
		pSouth.add(lbBuy);
		pSouth.add(lbEdit);
		pSouth.add(lbDel);

		// Panel 옵션
		pNorth.setBackground(Color.white);
		pSouth.setBackground(Color.white);
		model = new DefaultTableModel(carData, header);
		table = new JTable(model);
		pCenter.add(new JScrollPane(table));

		/** table이벤트 (구매) */
		lbBuy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int yes_no = JOptionPane.showConfirmDialog(pCenter, "구매 하시겠습니까?", "구매 확인 창", JOptionPane.CANCEL_OPTION);
				if (yes_no == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(pCenter, "구매 신청이 완료 되었습니다.");
					int row = table.getSelectedRow();
					if (row == -1)return;
					model.removeRow(row);
					mainF.carVector.remove(row);
					return;
				}
			}
		});

		/** table이벤트 (수정) */
		lbEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int yes_no = JOptionPane.showConfirmDialog(pCenter, "정보를 수정 하시겠습니까?", "수정 확인 창",
						JOptionPane.CANCEL_OPTION);
				if (yes_no == JOptionPane.YES_OPTION) {
					String yes_pwd = JOptionPane.showInputDialog(pCenter, "비밀번호를 입력하세요.");
					int row = table.getSelectedRow();
					if (row == -1)return;
					Car c = mainF.carVector.get(row);
					if (yes_pwd.equals(c.getPwd())) {
			    		if(row==-1)return;
			    		mainF.card.show(mainF.pCenter, "내차팔기");
			    		table.getValueAt(row,0);
			    		String str[] = new String[5]; 
			    		for(int i =0; i<5; i++) {
			    			str[i] = (String) table.getValueAt(row,i);
			    		}
			    		model.removeRow(row);
			    		mainF.carVector.remove(row);
			    		mainF.sellF.update(str);
			    		mainF.sellF.updateUI();
			    		super.mouseClicked(e);
					} else {
						JOptionPane.showMessageDialog(pCenter, "비밀번호가 일치하지 않습니다.");
						return;
					}
				}
			}
		});

		/** table이벤트 (삭제) */
		lbDel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int yes_no = JOptionPane.showConfirmDialog(pCenter, "정말 삭제 하시겠습니까?", "삭제 확인 창",
						JOptionPane.CANCEL_OPTION);
				if (yes_no == JOptionPane.YES_OPTION) {
					String yes_pwd = JOptionPane.showInputDialog(pCenter, "비밀번호를 입력하세요.");
					int row = table.getSelectedRow();
					Car c = mainF.carVector.get(row);
					if (yes_pwd.equals(c.getPwd())) {
						JOptionPane.showMessageDialog(pCenter, "차량이 삭제되었습니다.");
						if (row == -1)return;
						model.removeRow(row);
						mainF.carVector.remove(row);
						mainF.setTitle("현재 등록된 자동차 수: " + mainF.carVector.size());
					} else {
						JOptionPane.showMessageDialog(pCenter, "비밀번호가 일치하지 않습니다.");
						return;
					}

				}
			}

		});

	}// 생성자-------

	// Vector 테이블에 저장된 값 보여주기
	public void showCarTable() {

		Iterator<Car> it = mainF.carVector.iterator();
		if (it == null)
			return;
		carData = new Object[mainF.carVector.size()][6];

		for (int i = 0; it.hasNext(); i++) {
			Car car = it.next();
			carData[i][0] = car.getBrand();
			carData[i][1] = car.getModel();
			carData[i][2] = car.getLocal();
			carData[i][3] = car.getBuydate();
			carData[i][4] = car.getDriven();
		}
		model.setDataVector(carData, header);
		table.setModel(model);
		table.setRowHeight(25);

	}////

	@Override
	public Insets getInsets() {
		return new Insets(0, 10, 20, 10);
	}

	// Center 차 구매 label 설정
	public void setLabelMyCarUI(JLabel lb) {
		lb.setOpaque(true);
		lb.setBackground(Color.white);
		lb.setHorizontalTextPosition(JLabel.CENTER);// 텍스트의 위치를 중앙으로
		lb.setVerticalTextPosition(JLabel.BOTTOM);// 텍스트의 위치 밑으로
		lb.setBorder(new EtchedBorder(EtchedBorder.RAISED));// 라벨에 테두리 넣어줌
		lb.setMaximumSize(getMaximumSize());
	}
}