package day09;

public class integerClassTest {

	public static int parseInt(String a) {
		return (int)(a);
	}
	public static void main(String[] args) {
		String num1="2030";
		String num2="1122";
		//�ջ갪 ����ϱ�
		System.out.println(num1+num2);//���ڿ� ����
		//���ڿ��� ���������� ��ȯ�ϴ� ������ �ʿ���
		//java.lang.Integer Ŭ���� ���
		//static int MAX_VALUE: ���� ������ �ִ밪�� ��� �ִ� ���
		//static int MAX_VALUE: 		 �ּҰ�
		//static int parseInt(String s): ���ڿ��� ���������� ��ȯ���ִ� �޼ҵ�
		
		//MAX_VALUE MIN_VALUE�� ����ϱ�
		
		System.out.println(Integer.MAX_VALUE);//2^31-1
		System.out.println(Integer.MIN_VALUE);//-2^31-1
		
		//parseInt()�̿��ؼ� ���ڿ��� ������ ��ȯ�� �� �հ谪 ���ϱ�
		
	}

}
