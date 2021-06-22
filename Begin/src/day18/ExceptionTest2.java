package day18;
/*발생된 예외를 try~catch절로 처리하되
 * for루프 안쪽에서 감싸서 처리해보기*/
public class ExceptionTest2 {

	public static void main(String[] args) {

		try {
		for(int i=1;i<=5;i++) {
			
			int x= 50/(i-3);
			System.out.println("x: "+x);	
		
		}//for----
		}catch(ArithmeticException e) {
			System.out.println("연산 오류! 분모가 0이어선 안돼요!!");}
		System.out.println("The End");

	}//main()----------

}//////////////////
