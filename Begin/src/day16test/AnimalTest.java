package day16test;

public class AnimalTest {

	public static void main(String[] args) {
		String type=args[0];
		String num=args[1];
		int n=Integer.parseInt(num);//정수로 변환
		System.out.println("동물: "+type);
		System.out.println("몇마리(개): "+num);
		
		Animal a=null;
		if(type.equals("강아지")) {//==가 아닌 .equals()로 받는 이유는 args[0]가 강아지가 아니니까
			//Dog d=new Dog();
			//Dog.crySound();
			//Dog.getBaby(n);
			a=new Dog();
		}else if(type.equals("고양이")) {
			a=new Cat();
		}else if(type.equals("오리")) {
			a=new Duck();
		}else {
			System.out.println("그런 동물 안키워!!");
			return;
			}
		a.crySound();
		a.getBaby(n);
		}
}
