package day05;

import java.util.Scanner;
class  switchTest
{
	public static void main(String[] args) 
	{
		/*switch (변수|수식)=> 변수나 수식은 int형 이하의 자료형(byte, short, char) 이거나 String이어야 함
		{
		case 값1: 실행문1; break;
		case 값2: 실행문2; break;
		case 값3: 실행문3; break;
		default: 실행문4
		}
		주의] 변수나 수식의 결과값과 case의 값의 자료형이 같아야 한다.
		*/
		System.out.println("정수를 입력하세요=>");
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
