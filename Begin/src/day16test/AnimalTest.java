package day16test;

public class AnimalTest {

	public static void main(String[] args) {
		String type=args[0];
		String num=args[1];
		int n=Integer.parseInt(num);//������ ��ȯ
		System.out.println("����: "+type);
		System.out.println("���(��): "+num);
		
		Animal a=null;
		if(type.equals("������")) {//==�� �ƴ� .equals()�� �޴� ������ args[0]�� �������� �ƴϴϱ�
			//Dog d=new Dog();
			//Dog.crySound();
			//Dog.getBaby(n);
			a=new Dog();
		}else if(type.equals("�����")) {
			a=new Cat();
		}else if(type.equals("����")) {
			a=new Duck();
		}else {
			System.out.println("�׷� ���� ��Ű��!!");
			return;
			}
		a.crySound();
		a.getBaby(n);
		}
}
