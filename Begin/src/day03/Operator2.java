package day03;

import java.util.Scanner;
class Operator2 
{
	public static void main(String[] args) 
	{
		System.out.println("3.�� ������--------");
		/*
		1) < : ������?
		2) <=: �۰ų� ������?
		3) > : ū��?
		4) =>: ũ�ų� ������?
		5) ==: ������?
		6) !=: �ٸ���?
		*/
		Scanner sc=new Scanner(System.in);
		System.out.println("������ �Է��ϼ���=>");
		int num=sc.nextInt();//������ �Է¹޾� num������ �����Ѵ�.
		System.out.println("num: "+num);

		if(num>0)
		{
			System.out.println("����Դϴ�");
		}else if(num==0){
			System.out.println("zore�Դϴ�");
		}else if(num<0){
			System.out.println("�����Դϴ�");
		}

		//�Է��� ���� 50���� ũ�ų� ������ "@@@"���
		//�׷��� ������ "###"����ϴ� ������ �ۼ��ϼ���

		if(num>=50)
		{
			System.out.println("@@@");
		}else{
			System.out.println("###");
		}
	}
}
