package day05;

import java.util.Scanner;
class SwitchTest4
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Hello World---Cafe Menu-----------!");
		System.out.println("�Ƹ޸�ī��: 2000��");
		System.out.println("ī���,īǪġ��, ����������: 3500��");
		System.out.println("�������ֽ�: 4000��");
		System.out.println("----------------------------------");
		System.out.println("���� ���Ḧ �帱���?");
		String menu=sc.next();
		System.out.println("�� �� �帱���?");
		int qty=sc.nextInt();

		/* switch~case���� �̿��ؼ� �Ʒ��� ���� ����� ����ϼ���
		1. ������ ����: �Ƹ޸�ī��
		2. ���� : 2
		3. �ܰ� : 2000��
		4. �����Ѿ� : 4000��
		*/
		int price=1;

		switch(menu){
			case "�Ƹ޸�ī��":price=2000; break;//String��쿡�� ""�� �޴´�.
			case "�������ֽ�":price=4000; break;
			case "ī���":
			case "īǪġ��":
			case "����������":price=3500; break;
			default: System.out.println("�׷� �޴��� �����ϴ�.");
					return;

		}
		System.out.println("1. ������ ���� : "+menu);
		System.out.println("2. ���� : "+qty+"��");
		System.out.println("3. �ܰ� : "+price+"��");
		System.out.println("4. �����Ѿ� : "+(qty*price)+"��");
	}
}