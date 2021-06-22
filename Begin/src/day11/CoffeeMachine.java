package day11;
/*캡슐화(Encapsulation)
 * 1) 멤버변수 앞에 private 접근지정자를 붙인다.
 * 2) 캡슐화된 멤버변수에 접근할 수 있는ㄴ 메소드를 public으로 구성한다.
 * ==> setter/getter
 * */
public class CoffeeMachine {
	private int coffee; //인스턴스변수는 객체 생성 해야지 가능
	private int sugar;  
	private long cream;
			
	//setter--매개변수를 받아들이고 반환타입은 없게 구성
	public void setCoffee(int c) {
		coffee=c;
	}
	
	public void setSugar(int s) {
		sugar=s;
	}
	
	public void setCream(long c) {
		cream=c;
	}
	
	//getter--매개변수는 x, 반환타입이 있도록 구성
	public int getCoffee() {
		return coffee;
	}
	
	public int getSugar() {
		return sugar;
	}
	
	public long getCream() {
		return cream;
	}
	
}////////////////
