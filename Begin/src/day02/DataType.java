package day02;

public class DataType
{
	public static void main(String[] args)
	{
		//a: 변수(variable, field, property, attribute)-값을 저장하고 있는 데이터
		//변수는 소문자,명사형으로 준다
		//변수 이른은 숫자로 시작하면 안된다.
		//특수문자 사용 불가(#,&,%,@)
		//but _,$는 사용 가능하다
		int a=45;//정수 int: 정수값을 저장할거야(자료유형)
		double b=12.3;//실수 double : 실수값을 저장할거야
		//int 1x=1 // [x]
		int x1=1;
		//int x&y=100;
		int x_y=100;
		int 국어=87;//하지만 영어로 대부분 쓴다


		System.out.println("a="+a);
		//문자열에 +연산자를 붙이면 문자열 결합이 일어남
		System.out.println("b="+b);

		int korScore=99;//두개의 단어로 만들려면 카멜표기법으로 대문자로 써야한다.
		int eng_score=88;//_은 케밥표기법인데 자바에서는 안된다

		System.out.println(a+b);
		System.out.println(a*b);
		System.out.println(a-b);
		System.out.println(a/b);
	}
}	