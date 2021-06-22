package day10;
/*구인구직 프로그램
 * - 추상화 실습
 * 	1) 관련된 객체 추출
 * 		- 구직자, 회사, 헤드헌터...
 *  2) 클래스로 옮긴다
 *  	-속성 (3개 이상)
 *  	-행동양식 (2개 이상)
 *  3) JobApp의 main()메소드에서 객체 생성해서 테스트 해보기
 * */
public class JobApp {

	public static void main(String[] args) {
		//JobSeeker객체 2개 생성한 뒤에 속성값을 주세요
		JobSeeker j1=new JobSeeker();
		JobSeeker j2=new JobSeeker();
		JobSeeker j3=j2;
		
//		System.out.println(j1);
//		System.out.println(j2);
//		System.out.println(j3);
		
		j1.showProfile();
		
		j1.name="김구직";
		j1.age=22;
		j1.tel="010-1111-2222";
		j1.showProfile();
		
		j2.name="박인비";
		j2.age=23;
		j2.tel="010-3333-4444";
		j2.showProfile();
		
		//프로필을 출력해보세요
		String a=j1.wantJob("웹개발자", 5000);
		System.out.println(a);
		
		//희망직업, 연봉 출력해보
		System.out.println(j2.wantJob("프로골퍼", 1000));
		
		j3.showProfile();
		
		JobSeeker j4=new JobSeeker();
		j4.input();
		j4.showProfile();
		

	}

}
