package day01;

//�ܹ� �ּ�
/*���� �ּ�
:���� ���� �ּ� ó��
*/
/** ����ȭ �ּ�
:API������ ���鶧 ���
*/
//1. ��Ű�� ���� : package ��Ű���̸�;
//2. import�� : ������ ����� ���̺귯���� "��Ű����.Ŭ������"
//3. Ŭ���� ����: public class Ŭ�����̸� (�빮�ڷ� ����. ������)
//=> Ŭ�������� ���ϸ��� ���ƾ� �Ѵ�.
//package my.com;

//import java.lang.System;
//java.lang��Ű���� import���� �����ص� �ڵ����� import�� ���ش�.
import java.util.Date;

public class Hello
{
	public static void main(String[] args)
	{
		System.out.println("Hello World~");
		System.out.print("�ȳ��ϼ���?");
		System.out.println("�ݰ����ϴ�.");
		System.out.println("Java�� ���������� ����� Ȱ����\n����SW �� �������� �缺����");
		//\n: �����(escape����) => ����(�ٹٲ� ����)
		Date d=new Date();
		System.out.println(d.toString());

	}

}
/*���� ��� ������
cd c:\MyJava\Begin\day01 �� ��� �̵�
javac Hello.java <=������ (�������� �����)
java Hello <=���� 
*/