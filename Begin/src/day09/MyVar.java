package day09;
//생성자 구성하기
public class MyVar {
	
		   String str;//null들어감
	static double PI;
	
	static {
		//static initializer는 메모리에 가장 먼저 올라간다. main()보다도 먼저 올라간다.
		PI=3.14;
		System.out.println("---static 블럭 호출됨---");
	}
	
	public MyVar() {
		str="안녕 MyVar~";
	}
	public static void main(String[] args) {
		System.out.println("---main()메소드-----------");
		//[1] MyVar의 str변수 값을 출력하기
		MyVar mv=new MyVar();
		System.out.println("mv.str="+mv.str);//static이 안붙으면 객체 생성해주고 부를 때도 객체 형태로
		
		//[2] PI도 출력하기
		System.out.println(MyVar.PI);//이건 객체가 아닌가?
		
		//[3] MyVar의 str변수 값을 변경해보기
		mv.str="잘가 MyVar~";
		System.out.println("mv.str="+mv.str);
		
		MyVar mv2=new MyVar();
		System.out.println("mv2.str: "+mv2.str);
		System.out.println("mv.str="+mv.str);

		mv.PI=500;
		System.out.println("mv.PI: "+mv.PI);
		System.out.println("mv2.PI: "+mv2.PI);
		//static변수는 객체들마다 공유한다. 따라서 다른 객체에서 값을 변경하면, 모든 객체가 그 변경된 값을
		//사용하게 된다.
		System.out.println("MyVar.PI: "+MyVar.PI);
	}

}
