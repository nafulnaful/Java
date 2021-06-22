package FirstProject2;

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

	public BuyPage() {
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

	
	}// 생성자-------

	

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