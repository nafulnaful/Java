//6/16[3]
package io.day3;
import java.io.*;
/*Ű���� �Է¹޾Ƽ� ���Ͽ� �������.
 * �����ͼҽ�: Ű���� (System.in)-1byte==>InputStreamReader
 * �����͸�����: ���� (FileWriter)-2byte
 * 
 * */
public class FileWriterTest {

	public static void main(String[] args) 
	throws IOException
	{
		System.out.println("�Է��ϼ���. �Է��� ������ result.txt�� ����˴ϴ�.");
		String file="C:/MyJava/WorkSpace/Advance/Result.txt";
		
		//Ű����� ���� ��Ʈ�� ����
		InputStreamReader ir=new InputStreamReader(System.in);
		//file�� ���� ��Ʈ�� ����
		FileWriter fw=new FileWriter(file, true);//true�� �ָ� �����̱� ����
		
		//�ݺ��� ���鼭 Ű���� �Է¹ް� ���Ͽ� ����ϱ�
		System.out.println("�Է��ϼ���");
		int n=0;
		//�ް��ǿ� ��Ƽ� �а� ���� �ڵ�� �ٲ㺸��
		char[] data=new char[300];
		while((n=ir.read(data))!=-1) {
			fw.write(data,0,n);
			fw.flush();
		}
		
		//close
		fw.close();
		ir.close();
		System.in.close();
		System.out.close();
		
	}

}
