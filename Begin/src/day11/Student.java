package day11;
import java.util.Scanner;

public class Student {
		private int no;//�й�
		private String name;//�̸�
		private String className;//�б�
		
		//setter, getter
		public void setNo(int n) {
			no=n;
		}
		public void setName(String n) {
			name=n;
		}
		public void setClassName(String c) {
			className=c;
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
			System.out.println("�й�=>");
			no=sc.nextInt();
			System.out.println("�̸�=>");
			name=sc.next();
			System.out.println("�б�=>");
			className=sc.next();
		}
		
		public void showInfo() {
			System.out.println("---�л� ����---");
			System.out.println("�� ��: "+no);
			System.out.println("�� ��: "+name);
			System.out.println("�� ��: "+className);
		}
}
