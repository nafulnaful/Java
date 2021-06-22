	 package day08;
	/* 배열(Array)
	 * - 같은 종류의 데이터들의 집합
	 * - 고정 크기. 해당 크기 내에서만 데이터 저장 가능
	 * - 범위를 넘어서면 오류남
	 * - 참조형
	 * 
	 * */
	public class ArrayTest {
	
		public static void main(String[] args) {
			//배열을 생성하는 방법
		/* 1)선언
		 * 2)메모리할당
		 * 3)초기화
		 * */
		System.out.println("1.----------------------");
		int arr[]; //1차원 배열선언
		//int [] arr; 가능
		
		//2.메모리할당
		arr = new int[3];
		
		//3.초기화
		//index는 0부터 (배열의 크기 -1)까지
		arr[0]=10; // <-- 첫번째 배열에 10
		arr[1]=20; // <-- 두번째 배열에 20 
		arr[2]=30; // <-- 세번째 배열에 30
		
		System.out.println("arr[0]="+arr[0]); // 첫번째 배열에 값을 출력
		System.out.println("arr[1]="+arr[1]); // 두번째 배열에 값을 출력
		System.out.println("arr[2]="+arr[2]); // 세번째 배열에 값을 출력
		//System.out.println("arr[3]="+arr[3]); [x]
		System.out.println("2.--------------------");
		
		//1.선언 +2.메모리할당, 3.초기화
		double brr[]=new double[4];
		System.out.println("brr[0]="+brr[0]); //0.0
		System.out.println("brr[3]="+brr[3]); //0.0
		
		brr[0]=100.45;
		brr[1]=0x12; //16진수=18.0
		brr[2]='A';
		brr[3]=450e-2; //4.5
		
		//배열의 크기: length속성을 이용하면 크기를 알 수 있다.
		System.out.println("brr.length="+brr.length);
		System.out.println("arr.length="+arr.length);
		//brr에 저장된 값을 for루프 이용해서 한꺼번에 출력해보세요
		for(int i=0;i<brr.length;i++) {
			System.out.println(brr[i]);	
		}
		System.out.println("3.-----------------------");
		//1+2+3 선언과 동시에 메모리 할당 및 초기화
		char ch[]= {'J','a','v','a','~'}; //1byte
		System.out.println("ch.length="+ch.length);
		
		//for루프 이용해서 ch에 저장된 값 출력
		for(int i=0;i<ch.length;i++) {
			System.out.print(ch[i]);
		}
		System.out.println();
		
		String[] str=new String[2];
		//str[0]
		System.out.println(str[0]);
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("문자열 입력하세요1=>");
		str[0]=sc.next();
		System.out.println("문자열 입력하세요2=>");
		str[1]=sc.next();
		//값 입력할 때 띄어쓰기x next는 공백 전까지만 입력됨.
		
		//str에 저장된 값을 for루프 이용해서 출력하세요
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		
		/*[1] float유형을 저장할 1차원 배열을 선언하고 크기는 5로 주기
		 *    저장할 값: -16.1, 200.5, 55, 'Z', 3e+3
		 *    그런 뒤 for루프 이용해 저장된 값들 출력하기
		 *    이 값들의 합계값도 출력하기
		 *    */
		float flt[] = {-16.1F, 200.5F, 55, 'Z', 3E+3F};
		/*
		flt[0]=-16.1F;
		flt[1]=200.5F;
		flt[2]=55;
		flt[3]='Z';
		flt[4]=3e+3F;
		*/
		
		float sum=0;
		for(int i=0;i<flt.length;i++) {
			System.out.println(flt[i]);
			sum+=flt[i];
		}
		System.out.println("sum="+sum);
		System.out.println("avg="+(sum/flt.length));
		
		/*[2] String유형을 저장할 배열 생성하세요.
		 * 	  크기와 저장할 값은 맘대로
		 * 	  반복문 돌려서 출력하되, 모두 대문자로 바꿔서 출력해보기
		 *      
		 * public String toUpperCase():모두 대문자로 변환
		 * public String toLowerCase():모두 소문자로 변환
		 * public char charAt(int i):인덱스 i번째의 문자를 한개  
		 * 							 추출해서 반환함.
		 * 
		 * */
		String[] srr=new String[4];
		srr[0]="Hello!";
		srr[1]=new String("Java ");
		srr[2]="new ";
		srr[3]="string";
		
		for(int i=0;i<srr.length;i++) {
			System.out.print(srr[i].toUpperCase());
			System.out.println(srr[i].toLowerCase());
			System.out.println(srr[i].charAt(0));
		}
		//static String valueOf(int i)	
		int n=256;
		System.out.println(n*2);
		//n을 문자열로 변환
		String s=n+"";
			System.out.println(s+0);
			
			String s2=String.valueOf(n);
			System.out.println(s2+0);
			
		
			
			
			
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
