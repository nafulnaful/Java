package day07;

public class MathTest2 {

	public static void main(String[] args) {
		//java.lang.Tath의 random()메소드 활용
		//public static double random(): 0.0<= r <1.0 사이의 임의의 실수를 반환
		
		//[1] 0<= r2 <10 사이의 임의의 정수를 발생시켜 출력하기
		int r2=(int)(Math.random()*10);
		System.out.println(r2);
		
		//[2]5<= r3 ,15 사이의 임의의 정수를 발생시켜 출력하기
		int r3=(int)(Math.random()*10+5);
		System.out.println(r3);

		/*int r=(int)(Math.random()*범위 + 시작되는 수)
		 * 
		 * 
		 * */
		
		//[3] 33<= r4 <65 사이의 정수값 발생시켜 출력
		int r4=(int)(Math.random()*32 + 33);
		System.out.println(r4);
		
		//[4] 랜덤한 알파벳 대문자를 아래와 같은 형태로 출력하세요
		/*		F C D O K
		 * 		Z I M S W
		 * 		M Q R A K
		 * */
		
				for(int i=1;i<4;i++) {
					for(int k=1;k<6;k++) {
						char c=(char)((Math.random()*26 + 'A'));
						System.out.print(c+"\t");
										}
						System.out.println();
									}
	}

}
