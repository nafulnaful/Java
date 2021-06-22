package day12;
/*생성자 오버로딩
 * -생성자를 다양하게 구성하여 객체를 생성할 때 다양한 초긱랎을 부여하도록 할 수 있다.*/
public class Superman {
	String name;
	int height;
	int power;
	
	//기본 생성자 구성하기 - default constructor
	public Superman() {
		this("아무개슈퍼맨",177,100);
		//this()는 자기자신의 생성자를 호출할 때 사용한다.
	}
	//매개변수 name=> 지역변수
			//멤버변수 name=> 인스턴스변수
			//지역변수와 전역변수가 동일한 이름을 가질 경우 지역변수를 우선시함
			//이럴 때 멤버변수를 구분하기 위해 멤버변수 앞에는 this를 붙인다.
			//this=> 자기자신의 인스턴스를 가리키는 keyword
	public Superman(String name) {//인자 생성자(매개변수를 받는 생성자)
		this(name,166,200);
	}
	public Superman(String name, int height) {
		this(name,height,300);
	}
	public Superman(String name, int height, int power) {//target: 여기서 초기화를 함(반드시 하나는 있어야한다)
		
		this.name=name;
		this.height=height;
		this.power=power;
	}
	
	public String showInfo() {
		String str="---슈퍼맨 정보---\n";
				str+="이름: "+name+"\n";
				str+="키: "+height+"\n";
				str+="초능력: "+power+"\n";
				return str;
	}
}//////////////////////////////////
