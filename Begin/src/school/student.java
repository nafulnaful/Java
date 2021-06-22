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
		System.out.println("학번");
		no=sc.nextInt();
		System.out.println("이름");
		name=sc.next();
		System.out.println("학급");
		className=sc.next();
	}
	
	public void showInfo() {
		System.out.println("---학생 정보---");
		System.out.println("번 번: "+no);
		System.out.println("이 름: "+name);
		System.out.println("학 급: "+className);
	}
}
