package day03;

import java.util.Scanner;
class Operator2 
{
	public static void main(String[] args) 
	{
		System.out.println("3.비교 연산자--------");
		/*
		1) < : 작은가?
		2) <=: 작거나 같은가?
		3) > : 큰가?
		4) =>: 크거나 같은가?
		5) ==: 같은가?
		6) !=: 다른가?
		*/
		Scanner sc=new Scanner(System.in);
		System.out.println("정수를 입력하세요=>");
		int num=sc.nextInt();//정수를 입력받아 num변수에 전달한다.
		System.out.println("num: "+num);

		if(num>0)
		{
			System.out.println("양수입니다");
		}else if(num==0){
			System.out.println("zore입니다");
		}else if(num<0){
			System.out.println("읍수입니다");
		}

		//입력한 값이 50보다 크거나 같으면 "@@@"출력
		//그렇지 않으면 "###"출력하는 문장을 작성하세요

		if(num>=50)
		{
			System.out.println("@@@");
		}else{
			System.out.println("###");
		}
	}
}
