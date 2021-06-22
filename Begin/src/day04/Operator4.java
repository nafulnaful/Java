package day04;

class Operator4 
{
	public static void main(String[] args) 
	{
		System.out.println("6. 조건 연산자(삼항 연산자)-----------");
		/*
			변수 선언문 = (조건식)? 값1: 값2;
			조건식이 true이면 변수의 값1을 대입하고
				  false이면 변수에 값2를 대입한다.
			이때 주의. 선언된 변수와 값1, 값2는 같은 자료형이어야 한다.
		*/
		int a=50, b=60;
		int c=(a>b)? a:b;
		System.out.println("c: "+c);

		String s=(a>b)?a+"":b+"";
		System.out.println("s: "+s);

		System.out.println("7. 할당 연산자 (연산후 대입연산자)-----------");
		int i=3;
		i+=2; //i=i+2
		System.out.println("i="+i);
		
		int j=9;
		j-=4;//j=j-4;
		System.out.println("j="+j);
		
		int k=7;
		k*=8; //k =k*8;
		System.out.println("k="+k);
		
		k/=3; //k =k/3;
		System.out.println("k="+k);

		k%=3; //k =k%3
		System.out.println("k="+k);

		int x=3; //0011
		x^=2;	 //0010
		// x = x^2
		System.out.println("x="+x);//1

		int y=5; //00000101
		y<<=1; //10
		System.out.println("y="+y);



	}
}
