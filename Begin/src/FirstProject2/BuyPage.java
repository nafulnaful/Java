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

	// �� ������ϵ� ���� �ϴ� ���̺�� ǥ�� �غ���
	JTable table;
	Object[][] carData = { { "", "", "", "", "" } };
	String[] header = { "�귣���", "�𵨸�", "��������", "��������", "����Ÿ�" };
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
		lbTop = new JLabel("", new ImageIcon("./pj_img/��ܹ�_��������.png"), JLabel.CENTER);
		lbBuy = new JLabel("", new ImageIcon("./pj_img/����_����.png"), JLabel.CENTER);
		lbEdit = new JLabel("", new ImageIcon("./pj_img/����_����.png"), JLabel.CENTER);
		lbDel = new JLabel("", new ImageIcon("./pj_img/����_����.png"), JLabel.CENTER);
		pNorth.add(lbTop);

		// Button
		pSouth.add(lbBuy);
		pSouth.add(lbEdit);
		pSouth.add(lbDel);

		// Panel �ɼ�
		pNorth.setBackground(Color.white);
		pSouth.setBackground(Color.white);
		model = new DefaultTableModel(carData, header);
		table = new JTable(model);
		pCenter.add(new JScrollPane(table));

	
	}// ������-------

	

	@Override
	public Insets getInsets() {
		return new Insets(0, 10, 20, 10);
	}

	// Center �� ���� label ����
	public void setLabelMyCarUI(JLabel lb) {
		lb.setOpaque(true);
		lb.setBackground(Color.white);
		lb.setHorizontalTextPosition(JLabel.CENTER);// �ؽ�Ʈ�� ��ġ�� �߾�����
		lb.setVerticalTextPosition(JLabel.BOTTOM);// �ؽ�Ʈ�� ��ġ ������
		lb.setBorder(new EtchedBorder(EtchedBorder.RAISED));// �󺧿� �׵θ� �־���
		lb.setMaximumSize(getMaximumSize());
	}
}