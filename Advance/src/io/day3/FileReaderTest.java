//6/16[2]
package io.day3;
import java.io.*;
import javax.swing.*;
/*FileReader
 * - 2byte ��� ��Ʈ��
 * -��彺Ʈ��(���ϰ� ��� ����)
 * [�ǽ�] ������ �о �ֿܼ� ���
 * 2byte��Ʈ�� ������ ��µ� 2����Ʈ ��� ��Ʈ���� ����ϴ� ���� ����.
 * ������ �ҽ�	 : ���� ===>��彺Ʈ��(FileReader)-2byte
 * ������ ������: �ܼ� ===>��彺Ʈ��(System.out)-1byte===>�긴����Ʈ��(OutputStreamWriter)
 * */
public class FileReaderTest {

	public static void main(String[] args)
	throws IOException{
		//src/io/day3/Dirlist.java
		String file=JOptionPane.showInputDialog("���� ���ϸ��� �Է��ϼ���");//�˾�â �߱�
		if(file==null) return;//�Է����� ������ out
		File f=new File(file);//���� ����
		System.out.println("���� ���� ũ��: "+f.length()+"bytes");//���� ũ�� �����ֱ�
		
		FileReader fr=new FileReader(f);//���ϸ���(2byte)�� ���� �־fr�� ����
		OutputStreamWriter ow=new OutputStreamWriter(System.out);//
		int n=0;
		char[] data=new char[1000];//2byte���� byteŸ���� �ƴ� charŸ������
		while((n=fr.read(data))!=-1) {
			ow.write(data,0,n);//data�� �������� 0���� n����
			ow.flush();
		}
		fr.close();
		ow.close();
	}

}
