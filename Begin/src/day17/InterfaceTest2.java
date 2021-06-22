package day17;
interface Inter1{
	void a();
	int b();
}////////////////////
interface Inter2{
	double PI=3.14;
}///////////////
interface Inter3{
	void c();
}/////////////////
abstract class AbsClass{
	abstract void d();
}/////////
/*MyDemo가 AbsClass와 Inter1, Inter2, Inter3를 상속받도록 하세요
 * 그런 뒤 메소드 오버라이드 하세요
 * */
class MyDemo extends AbsClass implements Inter1, Inter2, Inter3
{ 
	public void a() {
		System.out.println("a()");
	}
	public int b() {
		return 1;
	}
	public void c() {
		System.out.println("c()");
	}
	void d() {
		
	}
	}/////////////////////
public class InterfaceTest2 {

	public static void main(String[] args) {
		System.out.println("1.----------------");
		//MyDemo타입 선언, Mydemo객체 생성한 후 a(),.......호출하기
		MyDemo md=new MyDemo();
		md.a();
		System.out.println(md.b());
		md.c();
		md.d();
		
		System.out.println("2.----------------");
		//AbsClass타입 선언, MyDemo객체 생성후 각 메소드 호출하기
		AbsClass ac=new MyDemo();
		ac.d();
		((MyDemo)ac).a();
		//ac.b();
		
		//ac.c();
		System.out.println("3.----------------");
		//Inter1타입 선언, MyDemo객체 생성후 각 메소드 호출하기
		Inter1 im=new MyDemo();
		im.a();
		System.out.println(im.b()*3);
//		im.c();
//		im.d();
		System.out.println("4.----------");
		System.out.println("4.----------------");
		//Inter2타입 선언, MyDemo객체 생성후 각 메소드 호출하기
		//PI값도 출력하기
		Inter2 mi2=new MyDemo();
		/*mi2.a();
		mi2.b();
		mi2.c();
		mi2.d();*/
		System.out.println(Inter2.PI);
		System.out.println(MyDemo.PI);
	}

}////////////////////
