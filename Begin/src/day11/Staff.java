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
		System.out.println("사번=>");
		no=sc.nextInt();
		System.out.println("이름=>");
		name=sc.next();
		System.out.println("부서=>");
		dept=sc.next();
	}
	
	public void showInfo() {
		System.out.println("---학생 정보---");
		System.out.println("사 번: "+no);
		System.out.println("이 름: "+name);
		System.out.println("부 서: "+dept);
	}
}
