package day13;
//클래스를 상속받을 때는 extends라는 키워드를 이용한다.
//자식클래스: Sub class, Derived class
//상속 관계: "is a"관계가 성립되어야 한다.
//모든 class들은 기본적으로 java.lang.Object를 상속받고 있다.
//부모자식 관계가 있을 경우 자식 클래스의 생성자 안에서는 묵시적으로
//super()를 호출한다.
//super()==> 부모의 기본생성자를 호출
public class Superman extends Human {
	//Superman is a Human
	int power;
	
	public Superman() {
		super("슈퍼맨",168);
		//자식 클래스의 생성자에서는 묵시적으로 super()호출한다.
		//만약 부모에 디폴트 생성자가 없다면 오류가 나므로
		//명시적으로 super(인자)를 이용해서 부모 생성자를 호출하도록 한다.
		//반드시 생성자의 첫번째 라인에 위치해야 한다.
	}
	public Superman(String name, int height, int power) {
		super(name, height);
		//this.name=name;
		//this.height=height;
		this.power=power;
	}
	/*메소드 오버라이딩(Overriding):
	 * 부모의 메소드를 다시 정의해서 구성하는 것
	 *   - 규칙
     *     1) 메소드 이름은 부모의 것과 동일하게 구성한다.
     *     2) 매개변수의 데이터 타입과 갯수, 순서도 부모의 것과 같게 구성한다.
     *     3) 반환타입도 같아야 한다.
     *     4) 접근 지정자는 부모의 것과 동일하거나 더 넓은 범위로 지정한다.
     *     5) 예외는 부모의 것과 동일하거나 더 구체적인 예외를 발생시킨다.*/
	
	//1번 부모 처럼 같이해야함
	@Override
	public String showInfo() {
		//String str="이름 : "+name+"\n";
		//		str+="키 : "+height+"\n";
		String str=super.showInfo();//이름, 키
			str+="초능력 : "+power+"\n";
				return str;
	}
	public String showInfo(String title) {
		String str=title+"\n";
		str+=this.showInfo();//이름, 키, 초능력(위에 있는 this를 받는것)
		//str+="이름 : "+name+"\n";
		//str+="키 : "+height+"\n";
		//str+="초능력 : "+power+"\n";
		return str;
	}
	//showInfo()오버로딩 1개 더 해보기
	public String showInfo(int pw) {
		this.power+=pw;
		//String str="이름 : "+name+"\n";
		//str+="키 : "+height+"\n";
		String str=super.showInfo();//이름, 키
		str+=">>초능력 충전<<\n";
		str+="초능력 : "+power+"\n";
		return str;
	}
	public void showInfo(String title, int pw) {
		String str=this.showInfo(title);
		power+=pw;
		str+=">>초능력 충전<<<<";
		str+="초능력: "+power;
		System.out.println(str);
	}
	
}///////////////////////////
