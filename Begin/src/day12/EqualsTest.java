package day12;
import java.util.Scanner;
public class EqualsTest {
	//==:�⺻ �ڷ��������� "��"�� ���Ѵ�.
	//	 ������������ "�ּҰ�"�� ���Ѵ�.
	//���ڿ��� ����񱳸� �� ���� boolean equals(Object o)�� �̿��Ѵ�.
	//StringŬ������ equals()�� ���ڿ��� ������ ���Ѵ�.

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���� ���� �Է�=>");
		String animal =sc.next();
		
		//������=> "�۸�"
		//�����=> "�߿�"
		//�۾���=> "����"
	
		if(animal.equals("������")) {
			System.out.println("�۸�");
		}else if(animal.equals("�����")) {
			System.out.println("�߿�");
		}else if(animal.equals("�۾���")) {
			System.out.println("����");
		}else {
			System.out.println("�׷� ���� �����");
		}
	}

}
