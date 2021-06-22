package day10;
/**구인구직 프로그램
 * JobKorea => 프로그램 진입 클래스
 * 1. 구직자 정보 등록, 출력, 검색, 수정, 삭제...
 * 2. 회사 정보 등록,출력,수정, 삭제, 검색
 * CRUD 기능을 가져야 함
 * 	Create : 등록
 *  Read   : 조회(검색, 출력)
 *  Update : 수정
 *  Delete : 삭제
 * */
import java.util.Scanner;
public class JobKorea {
	
	public static void menu() {
		System.out.println("****JobKorea v1.1******");
		System.out.println("1. 구직자 등록");
		System.out.println("2. 회 사 등록");
		System.out.println("3. 구직자 출력");
		System.out.println("4. 회 사 출력");
		System.out.println("5. 구직자 검색(이름으로)");
		System.out.println("6. 회사 검색(이름으로)");
		System.out.println("9. 종    료");
		System.out.println("************************");
		System.out.println("메뉴 번호를 입력하세요=>");
		System.out.println("************************");
	}//menu()------------------------

	public static void main(String[] args) {
		// 1. menu()호출하기
		
		//2. 스캐너 생성해서 메뉴번호 입력받기

	}

}
