//6/14 [3]
package io.day1;
import java.io.*;
/*Ű���� �Է�, �ֿܼ� ���
 * 1byte������ �̵��ϴ� ���� �ƴ϶� byte�迭�� ��Ƽ� �а� ����������.
 * => �ް��ǿ� ��� �̵���Ű��
 * */
public class InputStreamTest3 {

	public static void main(String[] args) 
	throws IOException
	{
		//�ް��� �����
		byte[] data=new byte[6];
		int input=0, count=0, total=0;
		System.out.println("�Է�=>");
		while((input=System.in.read(data))!=-1) {//data�� �������ν� �ް����� ��������� �Է��ϸ�
			//�Է¹��� �����ʹ� data�迭�� ����.
			//System.out.write(input);//[x]
			System.out.write(data,0,input);//0�������� ���� �ް� ���������� ��������
			//�ް��� ��� �ް����� write�ؾ� ��
			//���⼭ input�������� �ް��ǿ� ��� �ް��� ������ ������ ����
			count++; //�ݺ��� Ƚ��
			//System.out.println("input="+input); �̰� �ް� Ƚ���� �˱����� ������ Ȯ�������ϱ� �ּ�
			total+=input;
 		}
		System.out.println("------------------------------");
		System.out.println(total+"bytes ����");
		System.out.println("------------------------------");
		
		System.in.close();//���۵��� �ݾ��ִ� ��Ȱ ������ ������ϳ� �ý����� ������ ��ܼ� �׳� ���߾���
		System.out.close();
	}

}
