package day04;

import java.util.Scanner;

class Iftest

{
	public static void main(String[] args) 
	{
		System.out.println("1. 조건문 if문---------");
		/*
		[1]
		if(조건식){
			실행할 문장
			}
		*/
		int a=-5;
		if (a>2)
		{
			System.out.println(a+"는 2보다 큽니다.");
		}//if문에 하나만 명령문이 있는경우{}를 지워도 괜찮다
		System.out.println("***************");
		/*
		[2]
		if(저건식){
			실행문1;
		}else{
			실행문2;
		}
		*/
		Scanner sc=new Scanner(System.in);
		//int num=sc.nextInt();
		float b=sc.nextFloat();
		System.out.println("b: "+b);
		//b값이 양수면"양수입니다", 음수면 "음수입니다"를 출력하는 문장 작성하기
		if(b>0){
			System.out.println(b+"는 양수입니다.");
			System.out.println("***********");
		}else{
			System.out.println(b+"는 0이거나 음수입니다.");
			System.out.println("@@@@@@@@@@@");
		}
	}
}
