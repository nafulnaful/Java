package day14;

public class Polymorphism2 {

	public static void main(String[] args) {
	//아래 결과를 예측해보기
		System.out.println("1.------------------");
		Super sp=new Super();
		System.out.println("sp.a: "+sp.a);//10
		System.out.println("sp.b: "+sp.b);//20
		sp.foo();//foo()**********
		
		System.out.println("2.-------------------");
		Sub sb=new Sub();
		System.out.println("sb.a: "+sb.a);//10
		System.out.println("sb.b: "+sb.b);//30
		System.out.println("sb.c: "+sb.c);//40
		sb.foo();//"foo()###"
		
		System.out.println("3.-------------------");
		Super ss=new Sub();
		System.out.println("ss.a: "+ss.a);//10
		System.out.println("ss.b: "+ss.b);//20
		//System.out.println("ss.c: "+ss.c);
		ss.foo();//"foo()###" override한 메소드가 있다면 override로 해줌
		
		//배열: 동족의 데이터만 저장 가능(부모, 자식은 동족의 데이터로 간주된다.)
		Super[] arr=new Super[3];
		arr[0]=sp;
		arr[1]=sb;
		arr[2]=ss;
		System.out.println("4.-----------------------------------");
		//반복문 돌면서 arr에 저장된 객체 들의 foo() 호출해보기
		for(int i=0;i<arr.length;i++) {
		System.out.println("a: "+arr[i].a);	
		System.out.println("b: "+arr[i].b);//배열을 Super타입으로 받았으니까  sub타입도 super로 변경	
		/*instanceof 연산자
		 * 참조변수 instanceof 클래스명 : 변수가 클래스의 객체면 true,아니면 false를
		 * 반환하는 연산자
		 * */
		if(arr[i] instanceof Sub) {
		System.out.println("c: "+((Sub)arr[i]).c);
		}
		arr[i].foo();
		}
		
	}//super타입이지만 sub타입에 들어가 있는 형태

}//////////////////////////
//접근지정자. public> protected > 생략형 > private
class Super{//부모 클래스
	int a=10;
	int b=20;
	
	void foo() {//생략형 접근지정자
		System.out.println("foo()**********");
	}
	
}////////////////

class Sub extends Super{//자식 클래스
	int b=30;
	int c=40;
	
	@Override
	protected void foo() {//접근범위가 같거나 커야한다
		System.out.println("foo()###");
	}
	
}/////////////////////