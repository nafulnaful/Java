package day16test;

abstract public class Animal {
			
abstract void crySound();
abstract void getBaby(int num); 
	}///////////////


//한 페이지에 같이 담고 있으니까 public은 위에 하나만 받을수 있어서 밑에 class들은 쓰지 않는다.
//강아지
class Dog extends Animal
{
	public void crySound() {
		System.out.println("멍멍~~");
	}
	void getBaby(int n) {
		System.out.println(n+"마리의 새끼를 낳았어요~~");
	}
}//////////////////////

class Cat{
	public void crySound() {
		System.out.println("야옹 야옹~~");
	}
	public void getBaby(int n) {
		System.out.println(n+"마리의 새끼를 낳았어요~~");
	}
}//////////////////////

class Duck{
	public void crySound() {
		System.out.println("꽥 꽥~~");
	}
	public void getBaby(int n) {
		System.out.println(n+"개의 알을 낳았어요~~");
	}
}//////////////////////
