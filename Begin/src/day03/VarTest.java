package day03;

class VarTest 
{
	static boolean x;//��������-Ŭ��������
	int b;//��������-�ν��Ͻ�(��ü) ����
			//���������� ���� �Ҵ����� ������ ����Ʈ���� �Ҵ�ȴ�.
			/*
			  byte: 0, short: 0, int: 0, long: 0L
			  float: 0.0f, double:0.0
			  char: '\u0000', boolean: false
			  ������(String): null
			*/

	public static void main(String[] args) 
	{
		float a=0;//���� ���� (��������: main�޼ҵ� �ȿ����� ��� ������)
		//���������� �ݵ�� �ʱ�ȭ�� �� �� ����ؾ� �Ѵ�.
		System.out.println("a="+a);
		//System.out.println("b="+b);
		VarTest v=new VarTest();//�ν��Ͻ�
		System.out.println("v.b="+v.b);
		System.out.println("VarTest.x="+VarTest.x);
	}

	public void test()
	{
		System.out.println("b="+b);
		//System.out.println("a="+a);	[x]

	}
}
