package day04;

import java.util.Scanner;
/*
[3] ���� if~else if��
	 if(���ǽ�1){
		���๮1
	 }else if(���ǹ�2){
		���๮2
	 }else if(���ǹ�3){
		���๮3
	}else{
		���๮4		
	}

*/

class  Iftest3
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);


		System.out.println("Java���� =>");
		float java=sc.nextFloat();

		//html���� �Է�=>
		System.out.println("HTML���� =>");
		float html=sc.nextFloat();

		//c���� �Է�
		System.out.println("C���� =>");
		float c=sc.nextFloat();
		float sum=java+html+c;
		float avg=sum/3;
		//[2] ��������� ���� ������ ����ϼ���
      /*
         100 ~ 90 : A
         80����: B
         70����: C
         60   : D
         �׿�  : F
      */
	  char hak=' ';//�ȿ� ' '����� ��������Ѵ�.
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
		  System.out.println("�Է¿���!!-������ 0~100�� ���̾�� �ؿ�.")
		  return;//�̰� ������ �Ʒ� ������ �������� �ʰ� ���⼭�� main()�޼ҵ带 ȣ���� ������ ���ư���.
	  }*/

		System.out.println("--------------------");
		System.out.println("Java\tHTml\tC");
		System.out.println("--------------------");
		System.out.println(java+"\t"+html+"\t"+c);
		System.out.println("--------------------");
		System.out.println("�հ� ����: "+sum+"��");
		System.out.println("�հ� ����: "+avg+"��");
		System.out.println("��    ��: "+hak+"��");
		System.out.println("--------------------");


		/*
		--------------
		Java	HIML	c
		99.1	88.3	77.56
		-----------------------
		�԰�����:   ��
		�������:   ��
		
		*/
	}
}
