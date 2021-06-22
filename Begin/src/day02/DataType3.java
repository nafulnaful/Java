package day02;

public class DataType3 
{
	public static void main(String[] args) 
	{
		System.out.println("2. 실수형---------------");
		//float (4) < double (8)
		//float: 단정밀도, 소수점 이하 7자리
		//double: 배정밀도, 소수점 이하 15~16자리 (디폴트)
		float f1=1.234f;
		System.out.println(f1);
		//float형은 부동소수점일 경우 반드시 접미사 F를 붙여야 한다.
		//그렇지 않으면 double로 인식한다.
		float f2=-32;//프로모션 : 작은타입이 큰타입으로 바뀌는것
		System.out.println(f2);
		float f3=0123;
		System.out.println("f3="+f3);

		float f4=.454f;
		System.out.println("f4="+f4);

		float f5=789e-2f;//789*10^-2//double 과학적 지수(e)를 사용하면 무조건 double로 잡힌다.
		System.out.println("f5="+f5);

		float f6=789e+2f;
		System.out.println("f6="+f6);

		double d1=753.123;//실수형의 default
		double d2=1.234d;
		double d3=0.45E-7;
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);

		System.out.println("3. 문자형 ---------");
		//char (2byte) : 0 ~ 2^16 -1 (0 ~ 65535) 모든 국가의 언어 표현 가능
		//				유니코드 체계를 사용한다.
		char c1='A';//문자형(primitive type)
//		char c2='AB';[x]
		String str="AB";//문자열(reference type)
		char c2='家';
		char c3='\uff57';//유니코드
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
		System.out.println("str="+str);
		System.out.println(c1+1);//66
		//char유형은 연산에 사용이 되면 자동으로 int형으로 형변환이 일어난다.(promotion)


		System.out.println("4. 논리형 ---------");
		//boolean(1) : true, false값만 갖는다. 소문자로 해야 함
		//				자바의 논리형은 0이나 1로 호환되지 않는다.
		boolean bool=true;
		boolean bool2=2<1;
		System.out.println("bool="+bool);
		System.out.println("bool2="+bool2);
	}
}
