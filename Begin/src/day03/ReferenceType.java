package day03;

import java.util.Date;//여기서 가져다 쓰겠다고 해야지 Date를 사용가능
public class ReferenceType

{
	public static void main(String[] args) 
	{
		/*참조형
			1) 클래스형
			2) 인터페이스형
			3) 배열
			- 참조형은 반드시 new연산자로 객체를 생성해 사용해야 한다.
			  그러나 String 경우는 너무 자주 사용하기 때문에
			  기본자료형 처럼 문자열값을 직접 할당하도록 허용한다.
		*/
		Date d=new Date();//참조형
		System.out.println(d);
		int a=10; //기본자료형은 literal(값)을 직접 할당

		Object o =new Object();
		System.out.println(o);

		String s = new String("Hello");
		System.out.println(s);

		String s2="Hi";
		System.out.println(s2);

		int b=20;
		System.out.println(a+b+"<=합");//숫자열->문자열로 바뀜 [순서가 앞에서부터 시작함]
		System.out.println("합=>"+(a+b));//문자열->숫자열[x]문자열로 나옴 그래서 ()를 해서 먼저 계산하게 한다.
	}
}
