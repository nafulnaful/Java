package day07;
import java.util.Scanner;
public class ReturnTest {
	public static void a() {
		System.out.println("##a()###1");
		b();
		Scanner sc=new Scanner(System.in);
		System.out.println("���� �Է�=>");
		int x=sc.nextInt();
		if(x==0) {
			return;//main�� �ƴϹǷ� ������ �ʴ´�.
		}
		System.out.println("a()�� ��~~~x: "+x);
	}
	
	public static void b() {
		System.out.println("@@b()@@@");
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(;;) {//���ѹݺ���
			System.out.println("-------Menu-----------");
			System.out.println("1. a()  2. b()  3. ����");
			System.out.println("----------------------");
			System.out.println("�޴� ��ȣ �Է�=>");
			System.out.println("----------------------");
			int no=sc.nextInt();
			if(no==1) {
				ReturnTest.a();//�̰� ����
			}else if(no==2) {
				b();
			}else if(no==3) {
				System.out.println("Bye Bye~~~");
				return;
			}
		}
	}//main---

}//class----
