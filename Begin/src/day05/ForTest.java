package day05;

class ForTest 
{
	public static void main(String[] args) 
	{
		/*
			for������
			for(�ʱ�ȭ;���ǽ�;������)
			{
				�ݺ� ������ ����
			}
			���ǽ��� true�̸� �ݺ� ������ ������ �����Ѵ�.
			false�� ���� �ݺ����� �����.
		
		*/
		for (int i=1;i<=5;i++ )//i�� scope�� for���� ����
		{
			System.out.println("Hello World : "+i);
		}
		System.out.println("---The End-----");

		int a=5;//a�� scope�� ����� �������� main�� ������
		for (;a>0 ;a-- )
		{
			System.out.println("hi:"+a);
		}
		System.out.println("---The End-----"+a);
			
		for (; ; )
		{
			System.out.println("���� ���� ���ϴ�~~~");
		}
	}
}
