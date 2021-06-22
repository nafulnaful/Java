package day03;

class VarTest 
{
	static boolean x;//전역변수-클래스변수
	int b;//전역변수-인스턴스(객체) 변수
			//전역변수는 값을 할당하지 않으면 디폴트값이 할당된다.
			/*
			  byte: 0, short: 0, int: 0, long: 0L
			  float: 0.0f, double:0.0
			  char: '\u0000', boolean: false
			  참조형(String): null
			*/

	public static void main(String[] args) 
	{
		float a=0;//변수 선언 (지역변수: main메소드 안에서만 사용 가능함)
		//지역변수는 반드시 초기화를 한 뒤 사용해야 한다.
		System.out.println("a="+a);
		//System.out.println("b="+b);
		VarTest v=new VarTest();//인스턴스
		System.out.println("v.b="+v.b);
		System.out.println("VarTest.x="+VarTest.x);
	}

	public void test()
	{
		System.out.println("b="+b);
		//System.out.println("a="+a);	[x]

	}
}
