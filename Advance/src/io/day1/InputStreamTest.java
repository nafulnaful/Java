//6/14[1]
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

public class InputStreamTest {

	public static void main(String[] args) 
		throws IOException
		{
		System.out.println("�Է��ϼ���=>");
		int input=0;
		int count=0;
		while(true) {
			input=System.in.read();//Ű���� �Է��� �޴´�.
			//����ڰ� �Է¤��� ���� ���������� ��ȯ�Ѵ�.
			count++;
			if(input=='x'||input=='X') break;
			System.out.println("input="+input);
			}//while----
		System.out.println("===============================");
		System.out.println(count+"bytes����");
		System.out.println("===============================");
		//input=13,10�� enter���̴�
		}

}
