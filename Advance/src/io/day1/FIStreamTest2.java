//6/14[5]
package io.day1;
import java.io.*;

import javax.swing.JOptionPane;
/*[�ǽ�] ������ �о ���� �ֿܼ� ����غ���
 * ----------------------------------
 * ������ �ҽ�: ����===>��彺Ʈ�� (FileInputStream)
 * 					int read()
 * 					int read(byte[] d)
 * �����͸�����: �ܼ�===>��彺Ʈ�� (System.out)
 * */
public class FIStreamTest2 {

	public static void main(String[] args) 
	throws FileNotFoundException//try catch ��ƾ� ������ �̰ɷ� ����(�̰� ����)
	,IOException//read�Ҷ� ����� �Ѵ�.
	{
		//String fileName="C:/MyJAva/Workspace/Advance/src/io/day1/InputStreamTest.java";//�����ͼҽ��� �Ǵ� ��(�����η� ���� �� �׷��ʿ�� ����(�������� �Ҷ� ���� �ȳ��� �ҷ���)
		String fileName=JOptionPane.showInputDialog("���ϸ��� �Է��ϼ���");
		
		//���ϰ� ��� ����
		FileInputStream fis=new FileInputStream(fileName);
		PrintStream ps=System.out;
		
		int input=0, count=0, total=0;
		//���� �����͸� �ް���(�迭)�� ��Ƽ� �а� ������.
		byte[] buf=new byte[1100];
		System.out.println("�Է��ϼ���=>");
		while((input=fis.read(buf))!=-1) {
			ps.write(buf,0,input);
			count++;
			total+=input;
		}
		ps.println(total+"bytes");
		ps.println(count+"�� �ݺ���");
		
		
		System.in.close();
		System.out.close();
		
		fis.close();
		ps.close();
		

	}

}
