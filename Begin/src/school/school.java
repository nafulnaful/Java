package school;

import java.util.Scanner;

import school.student;

public class school {

	student students[]=new student[3];
	teacher teachers[]=new teacher[3];
	staff staffs[] = new staff[3];
	int count1;
	public static void menu() {
	      System.out.println("*****123�л���� ���α׷� v1.1*****");
	      System.out.println("1. ��   ��");
	      System.out.println("2. ��   ��");
	      System.out.println("3. ��   �� (�л� �˻�-�й����� �˻�)");
	      System.out.println("4. ��   �� (�л� ����)");
	      System.out.println("5. ��   �� (���� �˻�-�̸����� �˻�)");
	      System.out.println("9. ��   ��");
	      System.out.println("***************************");
	      System.out.println("�޴� ��ȣ�� �Է��ϼ��� =>");
	      System.out.println("***************************");
	   }
	   
	   public static void subMenu() {
	      System.out.println("******21321 ��   ��********");
	      System.out.println("1. �л� ���");
	      System.out.println("2. ���� ���");
	      System.out.println("3. ���� ���");
	      System.out.println("4. ���� �޴�");
	      System.out.println("**********************");
	      System.out.println("�޴� ��ȣ�� �Է��ϼ��� =>");
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
					   System.out.println("��� �Ұ�");
					   return;
				   	}
				    student st=new student();
				    st.input();
				    students[count1]=st;
				    count1++;
				    System.out.println("����� �ο���"+count1+"�� �Դϴ�.");
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
			  		System.out.println("�ùٸ� ���ڸ� �Է��ϼ��� �ù߳��");
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
