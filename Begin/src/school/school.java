package school;

import java.util.Scanner;

import school.student;

public class school {

	student students[]=new student[3];
	teacher teachers[]=new teacher[3];
	staff staffs[] = new staff[3];
	int count1;
	public static void menu() {
	      System.out.println("*****123학사관리 프로그램 v1.1*****");
	      System.out.println("1. 등   록");
	      System.out.println("2. 출   력");
	      System.out.println("3. 검   색 (학생 검색-학번으로 검색)");
	      System.out.println("4. 삭   제 (학생 삭제)");
	      System.out.println("5. 검   색 (교사 검색-이름으로 검색)");
	      System.out.println("9. 종   료");
	      System.out.println("***************************");
	      System.out.println("메뉴 번호를 입력하세요 =>");
	      System.out.println("***************************");
	   }
	   
	   public static void subMenu() {
	      System.out.println("******21321 등   록********");
	      System.out.println("1. 학생 등록");
	      System.out.println("2. 교사 등록");
	      System.out.println("3. 직원 등록");
	      System.out.println("4. 상위 메뉴");
	      System.out.println("**********************");
	      System.out.println("메뉴 번호를 입력하세요 =>");
	      System.out.println("**********************");
	   }
	   
	   public void register() {
		   Scanner sc=new Scanner(System.in);
		   while(true) {
			   school.subMenu();
			   int nm = sc.nextInt();

			   switch(nm) {
			   case 1 :
				   if(count1>=students.length) {
					   System.out.println("등록 불가");
					   return;
				   	}
				    student st=new student();
				    st.input();
				    students[count1]=st;
				    count1++;
				    System.out.println("등록한 인원은"+count1+"명 입니다.");
				    break;
			   case 4 :
				   return;
			   }
		   }
	   }
	   
	   public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
		  school sch=new school();
		  int nm=0;
		  
		  do {
			  sch.menu();
			  nm=sc.nextInt();
			  if((1<nm||nm>9) && nm!=9) {
			  		System.out.println("올바른 숫자를 입력하세요 시발년아");
			  		continue;
			  }
			  switch(nm){  	
			  	case 1 : 
			  		sch.register();
				    break;
			  }
		  }while(nm!=9);
	      System.out.println("Bye Bye~~");
	   }
}
