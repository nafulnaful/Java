package day05;

import java.util.Scanner;
class SwitchTest2 
{
	public static void main(String[] args) 
	{
		System.out.println("���� �Է��ϼ���[1~12��] =>");
		Scanner sc=new Scanner(System.in);
		int month=sc.nextInt();
		System.out.println(month+"��");
		if(month<1||month>12)
			{
			System.out.println("1~12���� ���� �Է��ؾ� �ؿ�");
			}
		/*
		31�� : 1,3,5,7,8,10,12
		30�� : 4,6,9,11
		28�� : 2
		
		switch~case�� �̿��ؼ� �ش� ���� �ϼ��� ����ϼ��ˤ�.
		"1���� 31�ϱ��� �־��"
		*/
		int days=30;
			switch(month)
			{
				case 4:
				case 6:
				case 9:
				case 11: days=30; break;
				case 2: days=28; break;
				default: days=31;
			}
			System.out.println(month+"���� "+days+"�ϱ��� �־��");
	}
}