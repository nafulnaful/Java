package day04;

import java.util.Scanner;
/*
[3] 다중 if~else if문
	 if(조건식1){
		실행문1
	 }else if(조건문2){
		실행문2
	 }else if(조건문3){
		실행문3
	}else{
		실행문4		
	}

*/

class  Iftest3
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);


		System.out.println("Java점수 =>");
		float java=sc.nextFloat();

		//html점수 입력=>
		System.out.println("HTML점수 =>");
		float html=sc.nextFloat();

		//c점수 입력
		System.out.println("C점수 =>");
		float c=sc.nextFloat();
		float sum=java+html+c;
		float avg=sum/3;
		//[2] 평균점수에 따라 학점을 출력하세요
      /*
         100 ~ 90 : A
         80점대: B
         70점대: C
         60   : D
         그외  : F
      */
	  char hak=' ';//안에 ' '띄어쓰기라도 적어놔야한다.
	  if(avg>=90){
		  hak='A';
	  }else if(avg>=80){
		  hak='B';
	  }else if(avg>=70){
		  hak='C';
	  }else if(avg>=60){
		  hak='D';
	  }else{
		  hak='F';
	  }

	  /*char hak=' ';
	  if(avg>=80 && avg <90){
		  hak='B';
	  }else if(avg>=90 $$ avg<100){
		  hak='A';
	  }else if(avg>=70 $$ avg<80){
		  hak='C';
	  }else if(avg>=60 $$ avg<70){
		  hak='D';
	  }else if(avg<60 $$ avg>=0){
		  hak='F';
	  }else{
		  System.out.println("입력오류!!-점수는 0~100점 사이어야 해요.")
		  return;//이걸 넣으면 아래 문장은 실행하지 않고 여기서는 main()메소드를 호출한 쪽으로 돌아간다.
	  }*/

		System.out.println("--------------------");
		System.out.println("Java\tHTml\tC");
		System.out.println("--------------------");
		System.out.println(java+"\t"+html+"\t"+c);
		System.out.println("--------------------");
		System.out.println("합계 점수: "+sum+"점");
		System.out.println("합계 점수: "+avg+"점");
		System.out.println("학    점: "+hak+"점");
		System.out.println("--------------------");


		/*
		--------------
		Java	HIML	c
		99.1	88.3	77.56
		-----------------------
		함계점수:   점
		평균점수:   점
		
		*/
	}
}
