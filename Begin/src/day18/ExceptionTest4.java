package day18;
/*여러 개의 예외가 발생할 경우
 * try절은 1개 catch절은 여러 개 올 수 있다.
 * try{
 * }catch(A a){
 * }catch(B b){
 * }finally{
 * 		finally블럭은 반드시 한번은 수행하는 블럭이다.
 * 		앞에 return문이 있더라도 반드시 수행하고 제어권을 넘긴다.
 * 		단 예외가 있다. 시스템 종료 코드가 앞에 있을 경우에는 수행되지 않는다.
 * }
 * 이때 주의 사항.
 * Exception이 부모 자식의 상속관계가 있을 경우
 * 자식예외를 먼저 catch하고 부모 예외를 나중에 catch해야 한다.*/
import javax.swing.*;
public class ExceptionTest4 {
	
	public static void main(String[] args) {
		try {
	String numStr=JOptionPane.showInputDialog("정수를 입력하세요");
	System.out.println("numStr: "+numStr);
	//문자열을 정수로 변환하기
	int num = Integer.parseInt(numStr);
	
	int x=50/num;
	System.out.println("X: "+x);
	
	String str=null;
	System.out.println(str.toUpperCase());
	}catch(ArithmeticException e){
		System.out.println("정수 0값을 제외한 다른 정수를 입력하세요");
		System.exit(-1); //시스템 종료
	}catch(NumberFormatException e){
		System.out.println("정수 값을 입력하세요.");
		return;
	}catch(Exception e) {//부모- 자식보다 나중에 잡아야한다.
		System.out.println("기타 알 수 없는 예외 발생: "+e);
	}finally{
		System.out.println("---반드시 수행해야 할 코드---");
	}
	System.out.println("The End");
	
}
}
