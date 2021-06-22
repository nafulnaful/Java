package day07;

public class MathTest {

	public static void main(String[] args) {
		// java.lang.Math클래스가 가지고 있는 field(전역변수)
		// public static final double PI
		// public static final double E
		// static변수==> 클래스변수라고 함.==> "클래스명.변수" 식으로 접근해야 한다.
		System.out.println(Math.PI);//3.141592653589793
		System.out.println(Math.E);//2.718281828459045
		//static int abs(int a):절대값을 구해 반환함 |-19|==>19   |19|=>19 //반환타입
		//static double ceil(double a): 올림값을 구해 반환함
		//static double floor(double a): 내림값을 구해 반환함
		//static double max(double a, double b): a,b값들중의 최대값을 구해 반환함
		//static double min(double a, double b): a,b값들중의 최소값을 구해 반환함
		//static long round(double a): 반올림값
		
		//static double random(): 임의의 실수값을 반환함
		//						0.0<= r <1.0 사이의 실수값
		int a=Math.abs(-19);
		System.out.println("-19의 절대값: "+a);
		double x=Math.ceil(11.0001);
		System.out.println("11.0001의 올림값: "+x);
		//11.0001의 내림값 출력하기
		double y=Math.floor(11.0001);
		System.out.println("11.0001의 내림값: "+y);
		//[1] 456.512의 반올림값 출력해보기
		long i=Math.round(456.512);
		System.out.println("456.512의 반올림값: "+i);
		//[2] -123.1, 345.6 중 최대값을 구해 출력하기
		double o=Math.max(-123.1, 345.6);
		System.out.println("-123.1과 345.6중 최대값: "+o);
		//[3] -123.1, 345.6 중 최소값을 구해 출력하기
		double p=Math.min(-123.1, 345.6);
		System.out.println("-123.1과 345.6중 최소값: "+p);
		
		double r=Math.random();
		System.out.println("r: "+r);
	}

}
