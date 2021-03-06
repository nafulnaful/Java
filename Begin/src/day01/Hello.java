package day01;

//단문 주석
/*복문 주석
:여러 라인 주석 처리
*/
/** 문서화 주석
:API문서를 만들때 사용
*/
//1. 패키지 선언문 : package 패키지이름;
//2. import문 : 가져다 사용할 라이브러리의 "패키지명.클래스명"
//3. 클래스 선언문: public class 클래스이름 (대문자로 시작. 명사형)
//=> 클래스명과 파일명이 같아야 한다.
//package my.com;

//import java.lang.System;
//java.lang패키지는 import문을 생략해도 자동으로 import를 해준다.
import java.util.Date;

public class Hello
{
	public static void main(String[] args)
	{
		System.out.println("Hello World~");
		System.out.print("안녕하세요?");
		System.out.println("반갑습니다.");
		System.out.println("Java와 디지털융합 기술을 활용한\n응용SW 및 웹개발자 양성과정");
		//\n: 제어문자(escape문자) => 개행(줄바꿈 문자)
		Date d=new Date();
		System.out.println(d.toString());

	}

}
/*도스 열어서 컴파일
cd c:\MyJava\Begin\day01 로 경로 이동
javac Hello.java <=컴파일 (오류나면 디버깅)
java Hello <=실행 
*/