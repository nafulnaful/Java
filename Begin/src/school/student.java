package school;
import java.util.Scanner;

public class student {
	private int no;
	private String name;
	private String className;
	
	public void setNo(int num) {
		no=num;
	}
	public void setName(String na)
	{
		name=na;
	}
	public void setClassName(String cn) {
		className=cn;
	}
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getClassName() {
		return className;
	}
	
	public void input() {
		Scanner sc=new Scanner(System.in);
		System.out.println("�й�");
		no=sc.nextInt();
		System.out.println("�̸�");
		name=sc.next();
		System.out.println("�б�");
		className=sc.next();
	}
	
	public void showInfo() {
		System.out.println("---�л� ����---");
		System.out.println("�� ��: "+no);
		System.out.println("�� ��: "+name);
		System.out.println("�� ��: "+className);
	}
}
