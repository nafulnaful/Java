package school;

import java.util.Scanner;

public class teacher {
	int no;
	String name;
	String subject;
	
	public void setNo(int num) {
		no=num;
	}
	public void setName(String na) {
		name=na;
	}
	public void setsubject(String sub) {
		subject=sub;
	}
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getSubject() {
		return subject;
	}
	
	public void input() {
		Scanner sc=new Scanner(System.in);
		System.out.println("����");
		no=sc.nextInt();
		System.out.println("�̸�");
		name=sc.next();
		System.out.println("����");
		subject=sc.next();
	}
		
		public void showInfo() {
			System.out.println("---���� ����---");
			System.out.println("�� ��: "+no);
			System.out.println("�� ��: "+name);
			System.out.println("�� ��: "+subject);
		}
}///////////////
