package day11;
/*ĸ��ȭ(Encapsulation)
 * 1) ������� �տ� private ���������ڸ� ���δ�.
 * 2) ĸ��ȭ�� ��������� ������ �� �ִ¤� �޼ҵ带 public���� �����Ѵ�.
 * ==> setter/getter
 * */
public class CoffeeMachine {
	private int coffee; //�ν��Ͻ������� ��ü ���� �ؾ��� ����
	private int sugar;  
	private long cream;
			
	//setter--�Ű������� �޾Ƶ��̰� ��ȯŸ���� ���� ����
	public void setCoffee(int c) {
		coffee=c;
	}
	
	public void setSugar(int s) {
		sugar=s;
	}
	
	public void setCream(long c) {
		cream=c;
	}
	
	//getter--�Ű������� x, ��ȯŸ���� �ֵ��� ����
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
