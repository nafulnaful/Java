package day09;
/*3. 메소드(method):방법 즉 기능을 가지고 있는 것
 * 			(1) non-static 메소드 : 인스턴스 메소드 ==>"객체명.메소드명()"   ex)sc.nextInt()
 * 			(2) static 메소드 : 클래스 메소드	   ==>"클래스명.메소드명()" ex)Math.random()
 * 		-구성하는 방법
 * 			접근지정자(access modifier) [static(modifier)] 반환타입 메소드명([매개변수1,....])
 * 			{
 * 				기능 구현
 * 			}
 * 			
 * 		-호출하는 방법(사용방법)
 * */
public class OurDemo {
	
	public OurDemo() {//생성자
		
	}
	//사용자 정의 메소드
	public void sayHello(String name) {//인스턴스 메소드
		System.out.println("Hello ~~"+name+"님!!");
	}
	public static void sayHi(String name) {//클래스 메소드
		System.out.println("Hi ~~"+name+"~~");
	}
	
	public void showStar() {
		System.out.println("★★★★★");
	}
	public static void showSharp() {
		System.out.println("######");
	}
	public void showSnail(int row, int col) {
		//매개변수를 받아들이는 메소드
		for(int i=0;i<row;i++) {
			for(int k=0;k<col;k++) {
				System.out.print("@");
			}//for
			System.out.println();
		}//for
		
	}
	/////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {//메소드
	OurDemo.sayHi("김수미");
	OurDemo.sayHi("Tom");
	
	OurDemo od=new OurDemo();
	od.sayHello("박철수");
	od.sayHello("Susan");
	
	//showStar()
	OurDemo od2=new OurDemo();
	od2.showStar();
	od.showStar();
	
	//ShowSharp()
	OurDemo.showSharp();
	
	//showSnail()
	OurDemo od3=new OurDemo();
	od3.showSnail(5,7);

	}

}
