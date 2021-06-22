package day07;
import java.util.Scanner;
public class ReturnTest {
	public static void a() {
		System.out.println("##a()###1");
		b();
		Scanner sc=new Scanner(System.in);
		System.out.println("정수 입력=>");
		int x=sc.nextInt();
		if(x==0) {
			return;//main이 아니므로 끝나지 않는다.
		}
		System.out.println("a()의 끝~~~x: "+x);
	}
	
	public static void b() {
		System.out.println("@@b()@@@");
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(;;) {//무한반복문
			System.out.println("-------Menu-----------");
			System.out.println("1. a()  2. b()  3. 종료");
			System.out.println("----------------------");
			System.out.println("메뉴 번호 입력=>");
			System.out.println("----------------------");
			int no=sc.nextInt();
			if(no==1) {
				ReturnTest.a();//이게 정석
			}else if(no==2) {
				b();
			}else if(no==3) {
				System.out.println("Bye Bye~~~");
				return;
			}
		}
	}//main---

}//class----
