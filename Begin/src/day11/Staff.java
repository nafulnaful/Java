package day11;

import java.util.Scanner;

public class Staff {
	int no;
	String name;
	String dept;
	
	public void setNo(int n) {
		no=n;
	}
	public void setName(String n) {
		name=n;
	}
	public void setDept(String d) {
		dept=d;
	}
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public void input() {
		Scanner sc=new Scanner(System.in);
		System.out.println("���=>");
		no=sc.nextInt();
		System.out.println("�̸�=>");
		name=sc.next();
		System.out.println("�μ�=>");
		dept=sc.next();
	}
	
	public void showInfo() {
		System.out.println("---�л� ����---");
		System.out.println("�� ��: "+no);
		System.out.println("�� ��: "+name);
		System.out.println("�� ��: "+dept);
	}
}
