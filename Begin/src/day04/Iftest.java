package day04;

import java.util.Scanner;

class Iftest

{
	public static void main(String[] args) 
	{
		System.out.println("1. ���ǹ� if��---------");
		/*
		[1]
		if(���ǽ�){
			������ ����
			}
		*/
		int a=-5;
		if (a>2)
		{
			System.out.println(a+"�� 2���� Ů�ϴ�.");
		}//if���� �ϳ��� ��ɹ��� �ִ°��{}�� ������ ������
		System.out.println("***************");
		/*
		[2]
		if(���ǽ�){
			���๮1;
		}else{
			���๮2;
		}
		*/
		Scanner sc=new Scanner(System.in);
		//int num=sc.nextInt();
		float b=sc.nextFloat();
		System.out.println("b: "+b);
		//b���� �����"����Դϴ�", ������ "�����Դϴ�"�� ����ϴ� ���� �ۼ��ϱ�
		if(b>0){
			System.out.println(b+"�� ����Դϴ�.");
			System.out.println("***********");
		}else{
			System.out.println(b+"�� 0�̰ų� �����Դϴ�.");
			System.out.println("@@@@@@@@@@@");
		}
	}
}
