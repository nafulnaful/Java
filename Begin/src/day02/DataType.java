package day02;

public class DataType
{
	public static void main(String[] args)
	{
		//a: ����(variable, field, property, attribute)-���� �����ϰ� �ִ� ������
		//������ �ҹ���,��������� �ش�
		//���� �̸��� ���ڷ� �����ϸ� �ȵȴ�.
		//Ư������ ��� �Ұ�(#,&,%,@)
		//but _,$�� ��� �����ϴ�
		int a=45;//���� int: �������� �����Ұž�(�ڷ�����)
		double b=12.3;//�Ǽ� double : �Ǽ����� �����Ұž�
		//int 1x=1 // [x]
		int x1=1;
		//int x&y=100;
		int x_y=100;
		int ����=87;//������ ����� ��κ� ����


		System.out.println("a="+a);
		//���ڿ��� +�����ڸ� ���̸� ���ڿ� ������ �Ͼ
		System.out.println("b="+b);

		int korScore=99;//�ΰ��� �ܾ�� ������� ī��ǥ������� �빮�ڷ� ����Ѵ�.
		int eng_score=88;//_�� �ɹ�ǥ����ε� �ڹٿ����� �ȵȴ�

		System.out.println(a+b);
		System.out.println(a*b);
		System.out.println(a-b);
		System.out.println(a/b);
	}
}	