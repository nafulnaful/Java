//6/14[2]
package io.day1;
import java.io.*;
/*[�ǽ�] Ű����� �Է¹��� ������ ���� �ֿܼ� ����غ���.
 * -----------------------------------------
 * ������ �ҽ� : Ű����   ============>��� ��Ʈ��(System.in)
 * �����͸����� :���� �ܼ� ============>��� ��Ʈ��(System.out)
 * [1] System.in
 * - InputStreamŸ��
 * - 1byte��� ��Ʈ��
 * - Ű����� ��� ����
 * [2] System.out
 * - PrintStreamŸ��
 * - 1byte ��� ��Ʈ��
 * - �ְܼ� ��� ����
 * */

public class InputStreamTest2 {

	public static void main(String[] args) 
		throws IOException
		{
		System.out.println("�Է��ϼ���=>");
		int input=0;
		int count=0;
		while((input=System.in.read())!=-1) {
			//Ctrl+c(�������� ���) or Ctrl+D(������) �� ������ -1�� ��ȯ�Ѵ�.
			//System.out.print((char)input);//�̷��� �ϸ� �ƽ�ŵ�ڵ尪�����µ� �ȳ����� �ϴ� ��(char)�� ���� ����
			System.out.write(input);//write�� ���ָ� ����ȯ�� ���� �ʾƵ� �ȴ�. read -> write
			count++;
		}
		System.out.println("===============================");
		System.out.println(count+"bytes����");
		System.out.println("===============================");
		//input=13,10�� enter���̴�
		}

}
