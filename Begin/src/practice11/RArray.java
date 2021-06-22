package practice11;
import java.util.Scanner;
public class RArray {

	public static void main(String[] args) {
		//배열(Array)
		/*선언
		 * 메모리 할당
		 * 초기화
		 * */
		
		
		//1선언
		int arr[];
		//2메모리 할당
		arr=new int[3];
		//3초기화
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		
		//1선언+메모리할당
		int brr[]=new int[3];
		brr[0]=1;
		brr[1]=2;
		brr[2]=3;
		
		//출력을 해보자
		for(int i=0;i<brr.length;i++) {
			System.out.println(brr[i]);
		}
		//1선언+2메모리할당+3초기화
		char crr[]= {'J','a','v','a','~'};
		
		for(int k=0;k<crr.length;k++){
			System.out.print(crr[k]);
		}
		
		/*[1] float유형을 저장할 1차원 배열을 선언하고 크기는 5로 주기
		저장할 값: -16.1, 200.5, 55, 'Z', 3e+3
		 *    그런 뒤 for루프 이용해 저장된 값들 출력하기
		 *    이 값들의 합계값도 출력하기
		 *    */
		float fl[]= {16.1F,200.5F,55,'Z',3e+3f};
		
		for(int v=0;v<fl.length;v++) {
			System.out.println(fl[v]);
		}
			/*[2] String유형을 저장할 배열 생성하세요.
			 * 	  크기와 저장할 값은 맘대로
			 * 	  반복문 돌려서 출력하되, 모두 대문자로 바꿔서 출력해보기
			 *      
			 * public String toUpperCase():모두 대문자로 변환
			 * public String toLowerCase():모두 소문자로 변환
			 * public char charAt(int i):인덱스 i번째의 문자를 한개  
			 * 							 추출해서 반환함.
			 * */
			
		String st[]= {"av","bv","cv","dv","ev"};
		
		for(int n=0;n<fl.length;n++) {
			System.out.println(st[n].toUpperCase());
			System.out.println(st[n].toLowerCase());
			System.out.println(st[n].charAt(1));
		}
		
		/*참조 관계를 이용해서 x,y에 저장된 값을 서로 바꾼 뒤에 
		 * for루프로 x,y에 저장된 값을 출력하세요*/
		int x[]= {10,20,30};
		int y[]= {100,200,300};
		int tmp[] ; // X
		tmp=x;
		y=x;
		tmp=y;
		
		for(int m=0;m<tmp.length;m++) {
			System.out.println(x[m]);
			System.out.println(y[m]);
			
		}
		}//main--------------------
			
		

	}//class------------------------


