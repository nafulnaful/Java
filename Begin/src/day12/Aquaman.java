package day12;

public class Aquaman {

	String name;
	int height;
	double speed;
	//this() 이용해서 초기화
	public Aquaman() {
		this("지아쿠아",150,200);
		/*name="김아쿠아";
		height=150;
		speed=200;*/
	}
	
	public Aquaman(String name) {
		this(name,250,220);
	}
	
	public Aquaman(String name, int height) {
		this(name,height,220);
	}
	
	public Aquaman(String name, int height, int speed) {
		this.name=name;
		this.height=height;
		this.speed=speed;
	}
	
	public String showInfo() {
		String str="---아쿠아맨 정보---\n";
				str+="이름: "+name+"\n";
				str+="키: "+height+"\n";
				str+="스피드: "+speed+"\n";
			return str;
	}
}
