package day12;
import java.util.Scanner;
public class EqualsTest {
	//==:기본 자료형에서는 "값"을 비교한다.
	//	 참조형에서는 "주소값"을 비교한다.
	//문자열의 내용비교를 할 때는 boolean equals(Object o)를 이용한다.
	//String클래스의 equals()는 문자열의 내용을 비교한다.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("동물 종류 입력=>");
		String animal =sc.next();
		
		//강아지=> "멍멍"
		//고양이=> "야옹"
		//송아지=> "음매"
	
		if(animal.equals("강아지")) {
			System.out.println("멍멍");
		}else if(animal.equals("고양이")) {
			System.out.println("야옹");
		}else if(animal.equals("송아지")) {
			System.out.println("음매");
		}else {
			System.out.println("그런 동물 없어요");
		}
	}

}
