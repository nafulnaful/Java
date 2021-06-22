package day17;

interface MyInter{
	void foo();//public abstract가 자동으로 붙는다.
}////////////////
interface YourInter{
	String STR="HI INTERFACE";//상수니까
	//public static final이 자동으로 붙는다.
	String bar();
	
}
/*인터페이스를 상속받을 때는 implements로 상속받으며,
 * 여러 개의 인터페이스를 상속받을 수 있다.(다중상속)*/
class MyClass implements MyInter , YourInter{//concrete class(제대로 구성한 클래스)
	public void foo() {
		System.out.println("foo()~~~~~");
	}
	public String bar() {
		return "bar()##";//반환타입이니까 문자라도 반환해야한다.
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
		//MyInter mi=new Myinter();
		MyInter mi=new MyClass();
		mi.foo();
		String str=((YourInter)mi).bar();
		//bar()=>YourInter의 것. MyInter차입으로는 접근 불가
		System.out.println(str);
		
		MyClass mc=new MyClass();
		mc.foo();
		System.out.println(mc.bar());
		
		//YourInter타입의 변수를 선언하고 MyClass객체를 생성한 후에
		//foo(), bar(), STR 도 출력하기
		YourInter yi = new MyClass();
		((MyInter)yi).foo();
		System.out.println(yi.bar());
		System.out.println(MyClass.STR);
		System.out.println(YourInter.STR);
	}

}
