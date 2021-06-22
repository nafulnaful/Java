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
		System.out.println("교번");
		no=sc.nextInt();
		System.out.println("이름");
		name=sc.next();
		System.out.println("과목");
		subject=sc.next();
	}
		
		public void showInfo() {
			System.out.println("---교사 정보---");
			System.out.println("교 번: "+no);
			System.out.println("이 름: "+name);
			System.out.println("과 목: "+subject);
		}
}///////////////
