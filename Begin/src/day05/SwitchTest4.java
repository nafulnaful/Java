package day05;

import java.util.Scanner;
class SwitchTest4
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Hello World---Cafe Menu-----------!");
		System.out.println("아메리카노: 2000원");
		System.out.println("카페라떼,카푸치노, 에스프레소: 3500원");
		System.out.println("생과일주스: 4000원");
		System.out.println("----------------------------------");
		System.out.println("무슨 음료를 드릴까요?");
		String menu=sc.next();
		System.out.println("몇 잔 드릴까요?");
		int qty=sc.nextInt();

		/* switch~case문을 이용해서 아래와 같은 결과를 출력하세요
		1. 선택한 음료: 아메리카노
		2. 수량 : 2
		3. 단가 : 2000원
		4. 결제총액 : 4000원
		*/
		int price=1;

		switch(menu){
			case "아메리카노":price=2000; break;//String경우에는 ""로 받는다.
			case "생과일주스":price=4000; break;
			case "카페라떼":
			case "카푸치노":
			case "에스프레소":price=3500; break;
			default: System.out.println("그런 메뉴는 없습니다.");
					return;

		}
		System.out.println("1. 선택한 음료 : "+menu);
		System.out.println("2. 수량 : "+qty+"개");
		System.out.println("3. 단가 : "+price+"원");
		System.out.println("4. 결제총액 : "+(qty*price)+"원");
	}
}
