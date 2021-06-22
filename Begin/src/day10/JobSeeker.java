package day10;
import java.util.Scanner;
/**잡코리아 앱에서 사용하는 구직자 클래스 -문서화 주석(javadoc를 이용해 api문서 만들 때 사용)
 * */
public class JobSeeker {
	//has a관계
	String name;
	int age;
	String tel;
	//String [] career=new String[2];//경력
	
//	public JobSeeker() {
//		//디폴트 생성자 
//		name="홍길동";
//		
//	}
	//디폴트 생성자는 개발자가 구성하지 않으면 컴파일러가 알아서 기본 생성자를 제공한다.	
	
	
	/**구직자 정보를 출력하는 메소드*/
	public void showProfile() {
		System.out.println("---구직자 정보---");
		System.out.println("이 름: "+name);
		System.out.println("나 이: "+age);
		System.out.println("연락처: "+tel);
	}
	/**구직자의 희망직업,연봉을 문자열로 반환하는 메소드*/
	public String wantJob(String job, int pay) {
		String str="---"+name+"님-----\n";
			   str+="희망 직업: "+job+"\n";
			   str+="희망 연봉: "+pay+"만원\n";
		return str;	   
	}
	/**구직자 정보를 입력받는 메소드*/
	public void input() {
		Scanner sc=new Scanner(System.in);
		System.out.print("이름 입력=>");
		/*
		 * String nm=sc.next(); name=nm;
		 */
		name=sc.next();
		
		System.out.print("나이 입력=>");
		age=sc.nextInt();
		
		System.out.print("연락처 입력=>");
		tel =sc.next();
	}

}///////////////////////////////////////



