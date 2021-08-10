//6/23[1]
package javachat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class JTextPaneDemo extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JTextPane tp;//�ؽ�Ʈ���ε� ���� �ִ�.
	StyledDocument doc;//JTextPane���� ��
	
	

	public JTextPaneDemo() {
		super("::JTextPaneDemo::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		tp=new JTextPane();
		p.add(new JScrollPane(tp), "Center");//��ũ�ѹٸ� ����
		tp.setText("����ũ�� �������� 2020 �����౸�����Ǵ�ȸ(���� ���� 2020) 16���� �ö���. 22�� B�� ������ ���(�����ϰ� �ĸ��� ��Ÿ���)���� ���þƸ� 4��1�� ���� 1�� 2�з� �� 2���� �� ���̴�. ���⿡�� �̳� �ɶ��带 2��0���� ������ 3�� �������� �� 1���� �ߴ�.\r\n"
				+ "\r\n"
				+ "����ũ�� �ռ� �ɶ���, ���⿡���� ���� ���� �ٶ��� �� �������� �ӹ��� �־���. ������ ������ �� ������ �Ͼ��. ����� �ŵ� ����ũ�� �ɶ���, ���þƿ� ������ 1�� 2�а� �ƴ�. �� ���� ��� ������ ���� ���� ��� ���Ƿ� ������ ���ȴ�. ����ũ(+2)�� �ɶ���(0), ���þ�(-2)�� �ռ� 2���� �ö󼹴�. �ɶ���� �ٸ� �� ��� ����� ���� 16���࿡ ���� ���ɼ��� �ִ�.\r\n"
				+ "\r\n"
				+ "������ ��� ���� ��ü ��Ÿ�� ������ ���λ�� ù �� ��⸦ ���� 16�� ��ʸ�Ʈ�� ���� ���� ����ũ�� ó���̴�. ���� 2004(8��) ���� 17�� ���� ���� ���׸� ����� ����ũ�� 27�� A�� 2�� ���Ͻ��� 8�� ������ ���� �ݵ��Ѵ�.");

		//1. ���� �� ���
		doc=tp.getStyledDocument();
		
		//2.SimpleAttributeSet��ü�� �����ؼ� �� ��ü�� ��Ÿ�� �Ӽ��� �ο��Ѵ�.
		//----> SytleConstantsŬ������ static�޼ҵ带 ���ؼ� ��Ÿ�� �Ӽ��� �����Ѵ�.
		SimpleAttributeSet attr=new SimpleAttributeSet();
		StyleConstants.setFontFamily(attr, "�ü�ü");//��ü
		StyleConstants.setFontSize(attr, 28);//����ũ��
		
		//3.���� �𵨿� �ش� �Ӽ��� �����Ų��.
		//	-setCharacterAttributes(): ���� Ư��(��Ʈ, �����, ����, ���ڻ�...)
		//	-setParagraphAttributes():���� Ư��(��������, �鿩����, ���� ���� ����....)
		doc.setCharacterAttributes(0, 30, attr, true);//0~30�ڱ��� attr���� (true->������ ��Ʈ�� ����ڴ�)
		
		
		attr=new SimpleAttributeSet();
		StyleConstants.setUnderline(attr, true);//���� ����
		StyleConstants.setItalic(attr,  true);//���Ÿ�ü
		StyleConstants.setForeground(attr, Color.magenta);//���ڻ�
		StyleConstants.setBackground(attr, Color.yellow);//����
		
		doc.setCharacterAttributes(30, 20, attr, true);
		
		//���� Ư��
		attr=new SimpleAttributeSet();
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);//������ ����
		doc.setParagraphAttributes(80, 100, attr, true);
		
		//tp.append()[x] tp���� append�� ������
		//���� ���� ���ڿ��� �߰�
		//�������� Ŀ�� ��ġ �˾Ƴ���
		int caretPos = doc.getEndPosition().getOffset()-1;//getEndPosition�� ������ ��ü���� getOffset�ؼ� int���� �޴´�.
		
		tp.setCaretPosition(caretPos);//���� ���� Ŀ���� ��ġ��Ų��.
		
		attr=new SimpleAttributeSet();
		StyleConstants.setFontSize(attr, 30);
		StyleConstants.setForeground(attr, Color.cyan);
		
		//���ڿ� ����->�޼��� �߰��Ҷ� ����Ѵ�.
		try {
			doc.insertString(caretPos, "\r\n�̸� ����....\r\n", attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		//�ؽ�Ʈ ���ο� �� ����
		String str="\r\n[Happ��]\r\n";
		ImageIcon icon=new ImageIcon("src/images/icon1.png");//����η�
		
		JLabel lb=new JLabel(str, icon, JLabel.CENTER);
		
		attr=new SimpleAttributeSet();
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
		
		caretPos=doc.getEndPosition().getOffset()-1;
		tp.setCaretPosition(caretPos);
		tp.insertComponent(lb);//jlabel�� ���۳�Ʈ �̴ϱ�
		
		doc.setParagraphAttributes(caretPos, str.length(), attr, true);
		
		
		
		
		p.setBackground(Color.white);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------

	public static void main(String[] args) {
		JTextPaneDemo my = new JTextPaneDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}