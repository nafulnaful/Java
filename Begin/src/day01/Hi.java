package day01;

public class Hi
{
	public static void main(String[] args)
	{
		System.out.println("----Escape 문자----");
		System.out.println(10/2);
		System.out.println(10*2);
		/* 제어문자 : 인쇄할 수 없거나 키보드로 표현할 수 없는 특별한 문자를 의미.
					역슬래시(\)와 한 개의 문자를 결합하여 작성한다.
				[1] \n : 개행.줄바꿈
				[2] \t : 수평 탭. 스크린 커서 위치를 다음 탭으로 옮긴다.
				[3] \r : 캐리지 리턴. 스크린 커서를 현재 줄의 처음으로 옮긴다.
				[4] \\ : 역슬래시 문자를 출력할 때 사용
				[5] \" : 큰따옴표 출력시 사용
				[6] \' : 홑따옴표 출력시 사용
		*/
		System.out.println("여기는 첫 째줄\n여기는 둘 째줄 입니다");
		System.out.println(); //줄바꿈
		System.out.println("-----------------------------");
		System.out.println("Java\tPython\tC");
		System.out.println("-----------------------------");
		System.out.println("99\t88\t77");
		System.out.println("-----------------------------");
		System.out.println("이번에는 캐리지 리턴을 써볼까요\r요");
		System.out.println("역슬래시(\\)");



	}


}