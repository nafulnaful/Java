//6/15[8]
package io.day2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/* [�ǽ�]
 * [1] copy��ư�� ���� �׼��̺�Ʈ ó�� 
 * [2]
 * FileInputStream/FileOutputStream
 * BufferedInputStream/BufferedOutputStream
 * ���� Ȱ���ؼ�
 * ���������� �������Ϸ� ī���� �ڿ�
 * [3]JLabel�� �ش� �̹��������� ��Ÿ������ ó���غ���.
 * 
 * [4] ����ٿ� ī�ǵǴ� �ۼ�Ƽ���� �Բ� �����Ű���� ó��
 * */

public class ImageCopyGui extends JFrame
implements Runnable{

	JPanel p = new JPanel(new GridLayout(2,1));
	JPanel p2 =new JPanel(new GridLayout(4,1,10,10));
	
	JTextField tfSource, tfTarget;
	JButton btCopy;
	JProgressBar bar;
	JLabel lb;
	
	FileInputStream fis;
	BufferedInputStream bis;
	
	FileOutputStream fos;
	BufferedOutputStream bos;

	public ImageCopyGui() {
		super("::ImageCopyGui::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		//��� �ǳ�
		tfSource=new JTextField();
		tfTarget=new JTextField();
		btCopy=new JButton("Copy");
		bar=new JProgressBar();
		
		p2.add(tfSource);
		p2.add(tfTarget);
		p2.add(btCopy);
		p2.add(bar);
		
		bar.setStringPainted(true);//???????????????????????????????????????????
		
		//Ÿ��Ʋ �ֱ�
		tfSource.setBorder(new TitledBorder("::���� ����::"));
		tfTarget.setBorder(new TitledBorder("::���� ����::"));
		
		btCopy.addActionListener(e ->{
			//������ ���� �� ����
			Thread tr=new Thread(this);
			tr.start();
			
		});//ī�ǹ�ư�� �׼Ǹ�����
		
		
		
		//�ϴ� �ǳ�
		p.add(p2);
		lb=new JLabel("NO IMAGE",JLabel.CENTER);
		p.add(new JScrollPane(lb));//new JScrollPane()�̰� ��ũ�ѹٰ� ����� ���ش�

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------
	
	public void run() {
		try {
		fileCopy();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	synchronized public void fileCopy() throws IOException {//synchronized�� �����尡 ���������� �ѹ��� �ϳ����� �۵��ϰ� �Ѵ�.
		//tfSource, tfTarget�� �Է��� �� ������
		String f1=tfSource.getText();
		String f2=tfTarget.getText();
		
		if(f1==null||f2==null||f1.trim().isEmpty()||f2.trim().isEmpty()){//isEmpty ���ڿ�
		JOptionPane.showMessageDialog(this,"�������ϸ�, �������ϸ��� ��� �Է��ϼ���");
		tfSource.requestFocus();
		return;
		}//���� �������� �ʾ����� �ɷ��ֱ� ���� �ȳ���
		
		//���������� ũ�⸦ �˾Ƴ���.
		//bar�� �ִ밪�� ��������(FileŬ������ length()) ũ��� ����
		File file1=new File(f1);
		long fsize=file1.length();//������ ũ�� �����ֱ�
		setTitle("�������� ũ��: "+fsize+"bytes");
		
		bar.setMaximum((int)fsize);//�ٿ� �ƽø� ���� �־��ֱ�
		//���α׷������� �ִ밪�� ���� ũ��� ����
		
		//��Ʈ�� ����
		fis=new FileInputStream(file1);
		bis=new BufferedInputStream(fis);
		
		fos=new FileOutputStream(f2);
		bos=new BufferedOutputStream(fos);
		
		//�ݺ��� ���鼭 �а� ���� ����Ʈ �� ��ŭ bar�� ���� setting
		int n=0, count=0;
		while((n=bis.read())!=-1) {
			bos.write(n);
			bos.flush();
			count++;//���� ����Ʈ��
			bar.setValue(count);
		}
		bos.close(); fos.close();
		bis.close(); fis.close();
		
		//�ؿ� �̹����� �������� �����
		lb.setIcon(new ImageIcon(f2));
		lb.setText("");
	}

	public static void main(String[] args) {
		ImageCopyGui my = new ImageCopyGui();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}