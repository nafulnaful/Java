package day10;
import java.util.Scanner;
/**���ڸ��� �ۿ��� ����ϴ� ������ Ŭ���� -����ȭ �ּ�(javadoc�� �̿��� api���� ���� �� ���)
 * */
public class JobSeeker {
	//has a����
	String name;
	int age;
	String tel;
	//String [] career=new String[2];//���
	
//	public JobSeeker() {
//		//����Ʈ ������ 
//		name="ȫ�浿";
//		
//	}
	//����Ʈ �����ڴ� �����ڰ� �������� ������ �����Ϸ��� �˾Ƽ� �⺻ �����ڸ� �����Ѵ�.	
	
	
	/**������ ������ ����ϴ� �޼ҵ�*/
	public void showProfile() {
		System.out.println("---������ ����---");
		System.out.println("�� ��: "+name);
		System.out.println("�� ��: "+age);
		System.out.println("����ó: "+tel);
	}
	/**�������� �������,������ ���ڿ��� ��ȯ�ϴ� �޼ҵ�*/
	public String wantJob(String job, int pay) {
		String str="---"+name+"��-----\n";
			   str+="��� ����: "+job+"\n";
			   str+="��� ����: "+pay+"����\n";
		return str;	   
	}
	/**������ ������ �Է¹޴� �޼ҵ�*/
	public void input() {
		Scanner sc=new Scanner(System.in);
		System.out.print("�̸� �Է�=>");
		/*
		 * String nm=sc.next(); name=nm;
		 */
		name=sc.next();
		
		System.out.print("���� �Է�=>");
		age=sc.nextInt();
		
		System.out.print("����ó �Է�=>");
		tel =sc.next();
	}

}///////////////////////////////////////



