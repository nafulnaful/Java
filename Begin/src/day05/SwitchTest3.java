package day05;

import java.util.Scanner;
class  SwitchTest3
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println("연산자를 입력하세요[+,-,*,/,%] =>");
		char operation =(char)System.in.read();
		System.out.println(operation);

		Scanner sc=new Scanner(System.in);
		System.out.println("정수1=>");
		int a = sc.nextInt();

		System.out.println("정수2=>");
		int b = sc.nextInt();

		/*
		정수1, 정수2를 Scanner를 이용해서 입력 받은 뒤
		연산자에 따라 연산을 수행하고
		해당 수식을 출력하세요.
		
		1+3=4
		1*3=3 식으로
		switch~case문 이용할 것
		
		*/
		int result=0;
		switch(operation){
			case'+': result=a+b; break; //char 담는 것은''
			case'-': result=a-b; break;
			case'*': result=a*b; break;
			case'/': result=a/b; break;
			case'%': result=a%b; break;
			default : System.out.println("적절한 연산을 사용하세요.");
		}
		System.out.println(""+a+ operation + b+"="+result);//""를 넣어줘서 문자열로 만들어 계산을 할 수 없게 만든다.

	}
}
