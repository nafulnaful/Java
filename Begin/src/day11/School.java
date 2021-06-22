package day11;

import java.util.Scanner;//Ctrl+Shift+O �ڵ� import

//import school.student;

public class School {
   
   Student students[]=new Student[3];
   Teacher teachers[]=new Teacher[3];
   Staff staffs[]=new Staff[3];
   int count1=0, count2=0, count3=0;
   
   public static void menu() {
      System.out.println("*****�л���� ���α׷� v1.1*****");
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
      System.out.println("****** ��   ��********");
      System.out.println("1. �л� ���");
      System.out.println("2. ���� ���");
      System.out.println("3. ���� ���");
      System.out.println("4. ���� �޴�");
      System.out.println("**********************");
      System.out.println("�޴� ��ȣ�� �Է��ϼ��� =>");
      System.out.println("**********************");
   }
   
   /**�л�,����,���������� ����ϴ� �޼ҵ�*/
   public void register() {
      Scanner sc=new Scanner(System.in);
      while(true) {
         School.subMenu();
   
         int num=sc.nextInt();
         if(num<1||num>4) {//��ȿ�� üũ
            System.out.println("�Է� ����! �޴��� ���� ��ȣ����");
            continue;
         }//if---
         switch(num) {
         case 1:
            if(count1>=students.length) {
               System.out.println("�л� ���� ����!!");
               continue;
            }
            Student st=new Student();
            st.input();
            students[count1]=st;
            count1++;
            System.out.println("�л� "+count1+"�� ��� �Ϸ�!!");
            break;
         case 2:
            if(count2>=teachers.length) {
               System.out.println("���� ��� ����!!");
               continue;
            }
            Teacher tc=new Teacher();
            tc.input();
            teachers[count2]=tc;
            count2++;
            System.out.println("���� "+count2+"�� ��� �Ϸ�!!");
            break;
         case 3:
            Staff sf=new Staff();
            sf.input();
            break;
         case 4:
            return;//register()�� ȣ���� ������ ���ư���.
            //break;
         }//switch
         //4 ==> ���� �޴��� ���ư���
      }//while----
   }//-----------------------------------
   public void printAll() {
      //System.out.println("���>>>");
      //1. �ݺ��� �̿��ؼ� ��� �л����� ����ϱ�
      for(int i=0;i<count1;i++) {
         students[i].showInfo();
      }
      
      //2. ��� ���� ���� ���
      for(int i=0;i<count2;i++) {
         teachers[i].showInfo();
      }
      
      //3. ��� ���� ���� ���
      for(int i=0;i<count3;i++) {
         staffs[i].showInfo();
      }
   }
   public void find() {
      Scanner sc=new Scanner(System.in);
      System.out.println("�˻��� �л��� �й� �Է�>>>");
      int findNo=sc.nextInt();
      //�ݺ����� ���鼭 students(�迭)�� ����� �л���ü���� �й��� �˻��Ϸ��� �й���
      //������ ����� �ִ��� ã�´�.==> �ִٸ� �ش� �л� ������ ���
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
         System.out.println("�˻��� �л��� �������� �ʽ��ϴ�.");
      }
   }//-----------------------------------
   
   public void delete() {
	   Scanner sc=new Scanner(System.in);
      System.out.println("������ �л��� �й� �Է�>>>");
      int delNo=sc.nextInt();
      boolean flag=false;
      for(int i=0;i<count1;i++) {
    	  Student s=students[i];
    	  if(s.getNo()==delNo) {
    		  flag=true;
    		  for(int j=i;j<count1-1;j++) {
    			  students[j]=students[j+1];
    		  }
    		  count1--;//������ �л��� ����
    	  }
      }//for---
      if(flag) {
    	  System.out.println(delNo+"�� �л� ������ �����߽��ϴ�. ���� ��ϵ� �л���: "+count1);
      }else {
    	  System.out.println(delNo+"�� �л��� �������� �ʽ��ϴ�.");
      }
   }//-------------------

   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      School sch=new School();
      int no=0;
      do {
         School.menu();//���� �޴�
         no=sc.nextInt();
         //�޴��� ���� ��ȣ=>"�Է� ����! " ��� �ݺ� ����
         if((no<1 || no>4) && no!=9) {
            System.out.println("�Է¿���!! �޴��� ���� ��ȣ����");
            continue;
         }
         switch(no) {
         case 1: //���===> register()ȣ���ϱ�
            sch.register();
            break;
         case 2: //��� ===> printAll()
            sch.printAll();
            break;
         case 3: //�˻� ===> find()
            sch.find();
            break;
         case 4: //���� ===> delete()
            sch.delete();
            break;
         case 5://���� �˻�(�̸�����)==>findTeacher()
        	 sch.find();
        	 break;
         }
         
         
      }while(no!=9);
      System.out.println("Bye Bye~~");
   }

}