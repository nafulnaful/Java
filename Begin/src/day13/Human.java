package day13;
//부모클래스: Superclass, Base class
public class Human {

	String name;
	int height;
	
	/*public Human() {//기본 생성자이다.
		this("아무개",155);
	}*/
	
	//생성자를 1개라도 구성하면 컴파일러가 제공하던 디폴트 생성자는 사라진다.
	//1개도 구성하지 않으면 디폴트 값으로 보여준다.
	public Human(String name, int height) {
		this.name = name;
		this.height = height;
	}
	
	public String showInfo() {
		String str="이름: "+name+"\n";
		str+="키 : "+height+"\n";
		return str;
	}
}
