package day11;

import java.util.Scanner;

public class Teacher {
	int no;
	String name;
	String subject;
	
	public void setNo(int n) {
		no=n;
	}
	public void setName(String n) {
		name=n;
	}
	public void setSubject(String s) {
		subject=s;
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
		System.out.println("����=>");
		no=sc.nextInt();
		System.out.println("�̸�=>");
		name=sc.next();
		System.out.println("����=>");
		subject=sc.next();
	}
	
	public void showInfo() {
		System.out.println("---���� ����---");
		System.out.println("�� ��: "+no);
		System.out.println("�� ��: "+name);
		System.out.println("�� ��: "+subject);
	}
	
}
