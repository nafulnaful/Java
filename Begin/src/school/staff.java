package school;

import java.util.Scanner;

public class staff {
int no;
String name;
String dept;

public void setNo(int num) {
	no=num;
}
public void setName(String na) {
	name=na;
}
public void setDept(String de) {
	dept=de;
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
	System.out.println("사번");
	no=sc.nextInt();
	System.out.println("이름");
	name=sc.next();
	System.out.println("부서");
	dept=sc.next();
}

public void showInfo() {
System.out.println("---학생 정보---");
System.out.println("사 번: "+no);
System.out.println("이 름: "+name);
System.out.println("부 서: "+dept);
}
}//////////////
