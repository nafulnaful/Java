//6/14[4]
package io.day1;
import java.io.*;
/*[�ǽ�] ������ �о ���� �ֿܼ� ����غ���
 * ----------------------------------
 * ������ �ҽ�: ����===>��彺Ʈ�� (FileInputStream)
 * 					int read()
 * 					int read(byte[] d)
 * �����͸�����: �ܼ�===>��彺Ʈ�� (System.out)
 * */
public class FIStreamTest {

	public static void main(String[] args) 
	throws FileNotFoundException//try catch ��ƾ� ������ �̰ɷ� ����(�̰� ����)
	,IOException//read�Ҷ� ����� �Ѵ�.
	{
		String fileName="C:/MyJAva/Workspace/Advance/src/io/day1/InputStreamTest.java";//�����ͼҽ��� �Ǵ� ��(�����η� ���� �� �׷��ʿ�� ����)
		
		//���ϰ� ��� ����
		FileInputStream fis=new FileInputStream(fileName);
		PrintStream ps=System.out;
		int input=0, count=0;
		while((input=fis.read())!=-1) {
			//������ ���� �����ϸ� -1�� ��ȯ�Ѵ�.
			ps.write(input);
			count++;
		}
		ps.println(count+"bytes�а� ��");
		fis.close();
		ps.close();
		

	}

}
