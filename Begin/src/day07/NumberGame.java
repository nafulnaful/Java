package day07;
import java.util.Scanner;

public class NumberGame {
	public static void a() {
		System.out.println("더 작은 수를 입력하세요~~");
	}
	
	public static void b() {
		System.out.println("더 큰 수를 입력하세요~~");
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int com=(int)(Math.random()*100+1);
	
		//1. 랜덤한 정수값 발생시키기 (1<= num <=100)
		int count=0;
		while(true) {
			if(count>=7) {
				System.out.println("실패!! 게임 시도 횟수는 7번까지 가능합니다.");
				break;
			}
			//2. 반복문을 돌면서 정수값 입력받기
			System.out.println("1~100사이의 정수값을 입력하세요.");
			int num=sc.nextInt();
			count++;//게임시도 횟수
			if(num==com) {
				System.out.println("정답!! 맞췄습니다^^");
				break;
			}else if(num>com) {
				System.out.println("더 작은 값을 입력하세요");
			}else {
				System.out.println("더 큰 값을 입력하세요");
			}
		}
		System.out.println("게임 시도 횟수: "+count);
		//3. 입력받은 값과 정답을 비교해서 메시지 출력
		
		//4. 정답을 맞췄다면 반복문 벗어나 후 "정답!! 시도횟수 "출력
			
		
		for(int x=1;x<31;x++) {
			if(x%10==0) {
				System.out.print("찐콩,");
			}else if(x%5==0){
				System.out.print("땅콩,");
		}else {
				System.out.print(x+", ");
			}
		}
	}//main

}//class
