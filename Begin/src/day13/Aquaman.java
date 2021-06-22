package day13;
//Human상속 받은 뒤 speed추가, 생성자 2개 오버로딩하기
public class Aquaman extends Human {
	
	double speed;

	public Aquaman() {
		//super("인어왕자",192);
		//this.speed(123.12);
		this("인어왕자",192,123.12);
	}
	
	public Aquaman(String name, int height, double speed) {
		super(name, height);
		//this.name="김바다";
		//this.height=185;
		this.speed= speed;
	}
	
	//showInfo()오버라이드 하세요
	//@Override => annotation을 붙여주면, 컴파일 타임에 해당 메소드가
	//override 규칙에 맞는지 체크해서 위배될 경우 에러를 발생시킴
	@Override
	public String showInfo() {
		//String str="이름 : "+name+"\n";
		//		str+="키 : "+height+"\n";
		String str=super.showInfo();
				str+="스피드 : "+speed+"\n";
				return str;
	}
	
	//showInfo() 오버로드하기
	public String showInfo(String title) {
		String str=title+"\n";
		str+=this+showInfo();
		return str;	
	}
	
	
}////////////////////////
