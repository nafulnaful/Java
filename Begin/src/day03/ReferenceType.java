package day03;

import java.util.Date;//���⼭ ������ ���ڴٰ� �ؾ��� Date�� ��밡��
public class ReferenceType

{
	public static void main(String[] args) 
	{
		/*������
			1) Ŭ������
			2) �������̽���
			3) �迭
			- �������� �ݵ�� new�����ڷ� ��ü�� ������ ����ؾ� �Ѵ�.
			  �׷��� String ���� �ʹ� ���� ����ϱ� ������
			  �⺻�ڷ��� ó�� ���ڿ����� ���� �Ҵ��ϵ��� ����Ѵ�.
		*/
		Date d=new Date();//������
		System.out.println(d);
		int a=10; //�⺻�ڷ����� literal(��)�� ���� �Ҵ�

		Object o =new Object();
		System.out.println(o);

		String s = new String("Hello");
		System.out.println(s);

		String s2="Hi";
		System.out.println(s2);

		int b=20;
		System.out.println(a+b+"<=��");//���ڿ�->���ڿ��� �ٲ� [������ �տ������� ������]
		System.out.println("��=>"+(a+b));//���ڿ�->���ڿ�[x]���ڿ��� ���� �׷��� ()�� �ؼ� ���� ����ϰ� �Ѵ�.
	}
}