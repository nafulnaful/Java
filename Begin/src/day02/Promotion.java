package day02;

public class Promotion
{
	public static void main(String[] args)
	{
		/*promotion(자동형변환): 크기가 작은 유형에서 큰 유형으로 자동으로 형변환이 되는 것을 의미
		  casting(강제형변환): 크기가 큰 유형에서 작은 유형으로 형변환할 때 캐스팅 연산자()를 이용해서
		  					강제적으로 형변환해야 함.
		  byte < short < int < long | < float < double
		  		 char <
		*/
		byte a=55;
		float b=a;//promotion
		System.out.println("a="+a);
		System.out.println("b="+b);

		int x=1;
		long y=2;
		float z=x+y;//int이하로는 불가능 최소long
		System.out.println("z="+z);
		/*자바는 int이하의 자료형(byte, short, char)이 연산에 사용되면 자동으로 int형으로 형변환*/

		byte b1=10;
		byte b2=20;
		//byte b3=b1+b2 [x]
		int b3=b1+b2;//최소한 int
		System.out.println("b3="+b3);
		
		char c1='A';//65
		char c2='B';//66
		//char c3=c1+c2;
		int c3=c1+c2;
		System.out.println("c3="+c3);
		
		//반드시 byte로만 작성을 해야하는 경우=>강제 형변환을 실시=>(byte)(형변환할 내용)
		byte b4=(byte)(b1+b2);
		System.out.println("b4="+b4);
		System.out.println(c1+1);//66==>강제형변환 해보기

		System.out.println((char)(c1+1));
			
	}

}