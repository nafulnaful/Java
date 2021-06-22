package day09;
/*하나의 자바파일 안에 여러 개 클래스를 구성할 경우
 * 반드시 public속성은 하나의 클래스에만 붙여야한다.
 * */

public class MyCar {
	String color;//인스턴스 변수
	int capa;
	
	//생성자를 구성하고 생성자 안에서 인스턴스 변수들의 초기값을 부여하세요.
	public MyCar() {
		color="white";
		capa=2000;
	}//MyCar class End
	
}
class HyundaiCar{
	String spec;
	int cc;
	//생성자 구성해서 인스턴스 변수 초기값 주기
	public HyundaiCar() {
		spec="소나타";
		cc=3000;
		
	}
}//HyundaiCar class End
	