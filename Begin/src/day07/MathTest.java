package day07;

public class MathTest {

	public static void main(String[] args) {
		// java.lang.MathŬ������ ������ �ִ� field(��������)
		// public static final double PI
		// public static final double E
		// static����==> Ŭ����������� ��.==> "Ŭ������.����" ������ �����ؾ� �Ѵ�.
		System.out.println(Math.PI);//3.141592653589793
		System.out.println(Math.E);//2.718281828459045
		//static int abs(int a):���밪�� ���� ��ȯ�� |-19|==>19   |19|=>19 //��ȯŸ��
		//static double ceil(double a): �ø����� ���� ��ȯ��
		//static double floor(double a): �������� ���� ��ȯ��
		//static double max(double a, double b): a,b�������� �ִ밪�� ���� ��ȯ��
		//static double min(double a, double b): a,b�������� �ּҰ��� ���� ��ȯ��
		//static long round(double a): �ݿø���
		
		//static double random(): ������ �Ǽ����� ��ȯ��
		//						0.0<= r <1.0 ������ �Ǽ���
		int a=Math.abs(-19);
		System.out.println("-19�� ���밪: "+a);
		double x=Math.ceil(11.0001);
		System.out.println("11.0001�� �ø���: "+x);
		//11.0001�� ������ ����ϱ�
		double y=Math.floor(11.0001);
		System.out.println("11.0001�� ������: "+y);
		//[1] 456.512�� �ݿø��� ����غ���
		long i=Math.round(456.512);
		System.out.println("456.512�� �ݿø���: "+i);
		//[2] -123.1, 345.6 �� �ִ밪�� ���� ����ϱ�
		double o=Math.max(-123.1, 345.6);
		System.out.println("-123.1�� 345.6�� �ִ밪: "+o);
		//[3] -123.1, 345.6 �� �ּҰ��� ���� ����ϱ�
		double p=Math.min(-123.1, 345.6);
		System.out.println("-123.1�� 345.6�� �ּҰ�: "+p);
		
		double r=Math.random();
		System.out.println("r: "+r);
	}

}
