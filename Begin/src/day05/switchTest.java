package day05;

import java.util.Scanner;
class  switchTest
{
	public static void main(String[] args) 
	{
		/*switch (����|����)=> ������ ������ int�� ������ �ڷ���(byte, short, char) �̰ų� String�̾�� ��
		{
		case ��1: ���๮1; break;
		case ��2: ���๮2; break;
		case ��3: ���๮3; break;
		default: ���๮4
		}
		����] ������ ������ ������� case�� ���� �ڷ����� ���ƾ� �Ѵ�.
		*/
		System.out.println("������ �Է��ϼ���=>");
		Scanner sc=new Scanner(System.in);
		//int a=sc.nextInt();
		//long a = sc.nextLong();//long, float, double [x]
		String a=sc.next();
		switch(a){
			case "10": System.out.println("***"); break;
			case "20": System.out.println("###"); break;
			case "30": System.out.println("@@@"); break;
			default: System.out.println("Bye~");



		}
	}
}