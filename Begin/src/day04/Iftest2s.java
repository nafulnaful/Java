package day04;

import java.util.Scanner;
class Iftest2 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("������ �Է��ϼ���=>");
		int num=sc.nextInt();
		//�Է¹��� �� num�� ¦���̸� "Even", Ȧ���̸� "Odd"�� ����ϼ���
		if(num%2==0){
			System.out.println(num+"�� Even");
		}else{
			
			System.out.println(num+"�� Odd");
		System.out.println("The End~~~");
		}
		/*���� ������ ���׿����ڷ� �ٲ㺸����.
			��������=(���ǽ�)? ��1:��2;
		*/
		String str=(num%2==0)?"¦��": "Ȧ��";
		System.out.println(str);

		System.out.println((num%2==0)?"even":"odd");
	}
}
