package day05;

import java.util.Scanner;
class SwitchTest2 
{
	public static void main(String[] args) 
	{
		System.out.println("월을 입력하세요[1~12월] =>");
		Scanner sc=new Scanner(System.in);
		int month=sc.nextInt();
		System.out.println(month+"월");
		if(month<1||month>12)
			{
			System.out.println("1~12사이 값을 입력해야 해요");
			}
		/*
		31일 : 1,3,5,7,8,10,12
		30일 : 4,6,9,11
		28일 : 2
		
		switch~case문 이용해서 해당 월의 일수를 출력하세ㅛㅇ.
		"1월은 31일까지 있어요"
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
			System.out.println(month+"월은 "+days+"일까지 있어요");
	}
}
