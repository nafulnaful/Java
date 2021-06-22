package day11;
import java.util.Scanner;

public class Student {
		private int no;//학번
		private String name;//이름
		private String className;//학급
		
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
			System.out.println("학번=>");
			no=sc.nextInt();
			System.out.println("이름=>");
			name=sc.next();
			System.out.println("학급=>");
			className=sc.next();
		}
		
		public void showInfo() {
			System.out.println("---학생 정보---");
			System.out.println("학 번: "+no);
			System.out.println("이 름: "+name);
			System.out.println("학 급: "+className);
		}
}
