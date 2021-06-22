package day09;

public class integerClassTest {

	public static int parseInt(String a) {
		return (int)(a);
	}
	public static void main(String[] args) {
		String num1="2030";
		String num2="1122";
		//합산값 출력하기
		System.out.println(num1+num2);//문자열 결합
		//문자열을 정수형으로 변환하는 절차가 필요함
		//java.lang.Integer 클래스 사용
		//static int MAX_VALUE: 정수 유형의 최대값을 담고 있는 상수
		//static int MAX_VALUE: 		 최소값
		//static int parseInt(String s): 문자열을 정수형으로 변환해주는 메소드
		
		//MAX_VALUE MIN_VALUE값 출력하기
		
		System.out.println(Integer.MAX_VALUE);//2^31-1
		System.out.println(Integer.MIN_VALUE);//-2^31-1
		
		//parseInt()이용해서 문자열을 정수로 변환한 뒤 합계값 구하기
		
	}

}
