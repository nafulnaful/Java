package day16test;

abstract public class Animal {
			
abstract void crySound();
abstract void getBaby(int num); 
	}///////////////


//�� �������� ���� ��� �����ϱ� public�� ���� �ϳ��� ������ �־ �ؿ� class���� ���� �ʴ´�.
//������
class Dog extends Animal
{
	public void crySound() {
		System.out.println("�۸�~~");
	}
	void getBaby(int n) {
		System.out.println(n+"������ ������ ���Ҿ��~~");
	}
}//////////////////////

class Cat{
	public void crySound() {
		System.out.println("�߿� �߿�~~");
	}
	public void getBaby(int n) {
		System.out.println(n+"������ ������ ���Ҿ��~~");
	}
}//////////////////////

class Duck{
	public void crySound() {
		System.out.println("�� ��~~");
	}
	public void getBaby(int n) {
		System.out.println(n+"���� ���� ���Ҿ��~~");
	}
}//////////////////////
