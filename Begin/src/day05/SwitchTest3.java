package day05;

import java.util.Scanner;
class  SwitchTest3
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println("�����ڸ� �Է��ϼ���[+,-,*,/,%] =>");
		char operation =(char)System.in.read();
		System.out.println(operation);

		Scanner sc=new Scanner(System.in);
		System.out.println("����1=>");
		int a = sc.nextInt();

		System.out.println("����2=>");
		int b = sc.nextInt();

		/*
		����1, ����2�� Scanner�� �̿��ؼ� �Է� ���� ��
		�����ڿ� ���� ������ �����ϰ�
		�ش� ������ ����ϼ���.
		
		1+3=4
		1*3=3 ������
		switch~case�� �̿��� ��
		
		*/
		int result=0;
		switch(operation){
			case'+': result=a+b; break; //char ��� ����''
			case'-': result=a-b; break;
			case'*': result=a*b; break;
			case'/': result=a/b; break;
			case'%': result=a%b; break;
			default : System.out.println("������ ������ ����ϼ���.");
		}
		System.out.println(""+a+ operation + b+"="+result);//""�� �־��༭ ���ڿ��� ����� ����� �� �� ���� �����.

	}
}
