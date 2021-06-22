package day11;

import java.util.Scanner;//Ctrl+Shift+O 자동 import

//import school.student;

public class School {
   
   Student students[]=new Student[3];
   Teacher teachers[]=new Teacher[3];
   Staff staffs[]=new Staff[3];
   int count1=0, count2=0, count3=0;
   
   public static void menu() {
      System.out.println("*****학사관리 프로그램 v1.1*****");
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
      System.out.println("****** 등   록********");
      System.out.println("1. 학생 등록");
      System.out.println("2. 교사 등록");
      System.out.println("3. 직원 등록");
      System.out.println("4. 상위 메뉴");
      System.out.println("**********************");
      System.out.println("메뉴 번호를 입력하세요 =>");
      System.out.println("**********************");
   }
   
   /**학생,교사,직원정보를 등록하는 메소드*/
   public void register() {
      Scanner sc=new Scanner(System.in);
      while(true) {
         School.subMenu();
   
         int num=sc.nextInt();
         if(num<1||num>4) {//유효성 체크
            System.out.println("입력 오류! 메뉴에 없는 번호에요");
            continue;
         }//if---
         switch(num) {
         case 1:
            if(count1>=students.length) {
               System.out.println("학생 정원 마감!!");
               continue;
            }
            Student st=new Student();
            st.input();
            students[count1]=st;
            count1++;
            System.out.println("학생 "+count1+"명 등록 완료!!");
            break;
         case 2:
            if(count2>=teachers.length) {
               System.out.println("교사 등록 마감!!");
               continue;
            }
            Teacher tc=new Teacher();
            tc.input();
            teachers[count2]=tc;
            count2++;
            System.out.println("교사 "+count2+"명 등록 완료!!");
            break;
         case 3:
            Staff sf=new Staff();
            sf.input();
            break;
         case 4:
            return;//register()를 호출한 쪽으로 돌아간다.
            //break;
         }//switch
         //4 ==> 상위 메뉴로 돌아가기
      }//while----
   }//-----------------------------------
   public void printAll() {
      //System.out.println("출력>>>");
      //1. 반복문 이용해서 모든 학생정보 출력하기
      for(int i=0;i<count1;i++) {
         students[i].showInfo();
      }
      
      //2. 모든 교사 정보 출력
      for(int i=0;i<count2;i++) {
         teachers[i].showInfo();
      }
      
      //3. 모든 직원 정보 출력
      for(int i=0;i<count3;i++) {
         staffs[i].showInfo();
      }
   }
   public void find() {
      Scanner sc=new Scanner(System.in);
      System.out.println("검색할 학생의 학번 입력>>>");
      int findNo=sc.nextInt();
      //반복문을 돌면서 students(배열)에 저장된 학생객체들의 학번과 검색하려는 학번이
      //동일한 사람이 있는지 찾는다.==> 있다면 해당 학생 정보를 출력
      boolean flag=false;
      for(int i=0;i<count1;i++) {
         Student s=students[i];
         if(findNo==s.getNo()) {
            flag=true;
            s.showInfo();
            break;
         }
      }
      if(flag==false) {
         System.out.println("검색한 학생은 존재하지 않습니다.");
      }
   }//-----------------------------------
   
   public void delete() {
	   Scanner sc=new Scanner(System.in);
      System.out.println("삭제할 학생의 학번 입력>>>");
      int delNo=sc.nextInt();
      boolean flag=false;
      for(int i=0;i<count1;i++) {
    	  Student s=students[i];
    	  if(s.getNo()==delNo) {
    		  flag=true;
    		  for(int j=i;j<count1-1;j++) {
    			  students[j]=students[j+1];
    		  }
    		  count1--;//삭제후 학생수 감소
    	  }
      }//for---
      if(flag) {
    	  System.out.println(delNo+"번 학생 정보를 삭제했습니다. 현재 등록된 학생수: "+count1);
      }else {
    	  System.out.println(delNo+"번 학생은 존재하지 않습니다.");
      }
   }//-------------------

   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      School sch=new School();
      int no=0;
      do {
         School.menu();//메인 메뉴
         no=sc.nextInt();
         //메뉴에 없는 번호=>"입력 오류! " 계속 반복 수행
         if((no<1 || no>4) && no!=9) {
            System.out.println("입력오류!! 메뉴에 없는 번호에요");
            continue;
         }
         switch(no) {
         case 1: //등록===> register()호출하기
            sch.register();
            break;
         case 2: //출력 ===> printAll()
            sch.printAll();
            break;
         case 3: //검색 ===> find()
            sch.find();
            break;
         case 4: //삭제 ===> delete()
            sch.delete();
            break;
         case 5://교사 검색(이름으로)==>findTeacher()
        	 sch.find();
        	 break;
         }
         
         
      }while(no!=9);
      System.out.println("Bye Bye~~");
   }

}