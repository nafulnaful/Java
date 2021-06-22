package day04;

import java.util.Scanner;
class Iftest2 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("정수를 입력하세요=>");
		int num=sc.nextInt();
		//입력받은 값 num이 짝수이면 "Even", 홀수이면 "Odd"를 출력하세요
		if(num%2==0){
			System.out.println(num+"은 Even");
		}else{
			
			System.out.println(num+"은 Odd");
		System.out.println("The End~~~");
		}
		/*위의 문장을 삼항연산자로 바꿔보세요.
			변수선언문=(조건식)? 값1:값2;
		*/
		String str=(num%2==0)?"짝수": "홀수";
		System.out.println(str);

		System.out.println((num%2==0)?"even":"odd");
	}
}
