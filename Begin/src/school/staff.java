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
	System.out.println("���");
	no=sc.nextInt();
	System.out.println("�̸�");
	name=sc.next();
	System.out.println("�μ�");
	dept=sc.next();
}

public void showInfo() {
System.out.println("---�л� ����---");
System.out.println("�� ��: "+no);
System.out.println("�� ��: "+name);
System.out.println("�� ��: "+dept);
}
}//////////////
