package day07;
import java.util.Scanner;

public class NumberGame {
	public static void a() {
		System.out.println("�� ���� ���� �Է��ϼ���~~");
	}
	
	public static void b() {
		System.out.println("�� ū ���� �Է��ϼ���~~");
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int com=(int)(Math.random()*100+1);
	
		//1. ������ ������ �߻���Ű�� (1<= num <=100)
		int count=0;
		while(true) {
			if(count>=7) {
				System.out.println("����!! ���� �õ� Ƚ���� 7������ �����մϴ�.");
				break;
			}
			//2. �ݺ����� ���鼭 ������ �Է¹ޱ�
			System.out.println("1~100������ �������� �Է��ϼ���.");
			int num=sc.nextInt();
			count++;//���ӽõ� Ƚ��
			if(num==com) {
				System.out.println("����!! ������ϴ�^^");
				break;
			}else if(num>com) {
				System.out.println("�� ���� ���� �Է��ϼ���");
			}else {
				System.out.println("�� ū ���� �Է��ϼ���");
			}
		}
		System.out.println("���� �õ� Ƚ��: "+count);
		//3. �Է¹��� ���� ������ ���ؼ� �޽��� ���
		
		//4. ������ ����ٸ� �ݺ��� ��� �� "����!! �õ�Ƚ�� "���
			
		
		for(int x=1;x<31;x++) {
			if(x%10==0) {
				System.out.print("����,");
			}else if(x%5==0){
				System.out.print("����,");
		}else {
				System.out.print(x+", ");
			}
		}
	}//main

}//class
