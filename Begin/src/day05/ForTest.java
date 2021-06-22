package day05;

class ForTest 
{
	public static void main(String[] args) 
	{
		/*
			for루프문
			for(초기화;조건식;증감식)
			{
				반복 실행할 문장
			}
			조건식이 true이면 반복 실행할 문장을 수행한다.
			false일 때는 반복문을 벗어난다.
		
		*/
		for (int i=1;i<=5;i++ )//i의 scope는 for루프 까지
		{
			System.out.println("Hello World : "+i);
		}
		System.out.println("---The End-----");

		int a=5;//a의 scope는 선언된 순간부터 main블럭 끝까지
		for (;a>0 ;a-- )
		{
			System.out.println("hi:"+a);
		}
		System.out.println("---The End-----"+a);
			
		for (; ; )
		{
			System.out.println("무한 루프 돕니다~~~");
		}
	}
}
