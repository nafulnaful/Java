package day09;
//������ �����ϼ���.
/*2.�������
 * (1) �ν��Ͻ� ���� (non-static ����): "��ü��.����" ������ ����
 * (2) Ŭ���� ���� (static ����)	  : "Ŭ������.����" ������ ����
 * 			==> static ==> ��ü�鰣�� ������ �Ѵ�.
 * */
public class YourDemo {
		   int x=20; //�ν��Ͻ� ����
	static int y=30; //Ŭ���� ����

	public YourDemo() {
		
	}
	public static void main(String[] args) {
		//System.out.println("x: "+x);
		YourDemo yd=new YourDemo();
		System.out.println("yd.x="+yd.x);
		
		System.out.println("y: "+y);
		System.out.println("YourDemo.y="+YourDemo.y);//�����Ѵ� ���� ���ܺ���
		System.out.println("yd.y="+yd.y);
	}

}
